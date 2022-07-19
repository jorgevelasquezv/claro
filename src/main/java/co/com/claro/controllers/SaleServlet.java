package co.com.claro.controllers;

import co.com.claro.entity.Client;
import co.com.claro.entity.Equipment;
import co.com.claro.entity.Sale;
import co.com.claro.entity.Vendor;
import co.com.claro.services.ClientServiceImpl;
import co.com.claro.services.EquipmentServiceImpl;
import co.com.claro.services.SaleServiceImpl;
import co.com.claro.services.VendorServiceImpl;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManagerFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/sale")
public class SaleServlet extends HttpServlet {

    @Inject
    private SaleServiceImpl saleService;

    @Inject
    private ClientServiceImpl clientService;

    @Inject
    private EquipmentServiceImpl equipmentService;

    @Inject
    private VendorServiceImpl vendorService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Vendor vendor = new Vendor();
        vendor.setId(req.getParameter("id_vendor") != null ? Long.parseLong(req.getParameter("id_vendor")) : null);
        vendor = vendorService.find(vendor);

        Equipment equipment = new Equipment();
        equipment.setId(req.getParameter("id_equipment") != null ? Long.valueOf(req.getParameter("id_equipment")) : null);
        equipment = equipmentService.find(equipment);

        Long quantity = Long.valueOf(req.getParameter("quantity"));

            Sale sale = null;
        if (equipment.getQuantity() > 0 ){
            quantity = equipment.getQuantity() - quantity;
            equipment.setQuantity(quantity);

            Client client = new Client();
            client.setName(req.getParameter("name_client"));
            client.setDni(Long.valueOf(req.getParameter("dni_client")));

            sale = Sale.builder().equipment(equipment).client(client).vendor(vendor).build();
            sale = saleService.save(sale);
            equipmentService.save(equipment);
        }


        PrintWriter out = resp.getWriter();
        out.println(sale);
    }


}
