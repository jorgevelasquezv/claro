package co.com.claro.controllers.servlets;

import co.com.claro.entity.*;
import co.com.claro.repositories.SaleRepositoryImpl;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.primefaces.shaded.json.JSONObject;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.List;

@WebServlet("/sale/find")
public class FindSaleServlet extends HttpServlet {
//
//    @Inject
//    private SaleRepositoryImpl saleService;
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Long id = req.getParameter("id") != null ? Long.valueOf(req.getParameter("id")) : null;
//        Long vendorId = req.getParameter("id_vendor") != null ? Long.valueOf(req.getParameter("id_vendor")) : null;
//        Long clientId = req.getParameter("id_client") != null ? Long.valueOf(req.getParameter("id_client")) : null;
//        Long equipmentId = req.getParameter("id_equipment") != null ? Long.valueOf(req.getParameter("id_equipment")) : null;
//
//        Vendor vendor = Vendor.builder().id(vendorId).build();
//        Client client = Client.builder().id(clientId).build();
//        Equipment equipment = Equipment.builder().id(equipmentId).build();
//
//        PrintWriter out = resp.getWriter();
//        JSONObject body = new JSONObject();
//
//        if (id == null && vendorId == null && clientId == null && equipmentId == null ){
//
//            List<Sale> sales = saleService.findAll();
//            sales.forEach(sale -> {
//                body.put("sale" + body.length(), createJson(sale));
//            });
//        }else {
//            Sale sale = Sale.builder().id(id).vendor(vendor).client(client).equipment(equipment).build();
//            sale = saleService.find(sale);
//            body.put("sale" + body.length(), createJson(sale));
//        }
//
//        out.println(body);
//    }
//
//    private JSONObject createJson(Object objet){
//        JSONObject s = new JSONObject();
//        Field[] fields = objet.getClass().getDeclaredFields();
//        for (Field field : fields ) {
//            field.setAccessible(true);
//            try {
//                if (field.get(objet).getClass().equals(Vendor.class) || field.get(objet).getClass().equals(Client.class)
//                        || field.get(objet).getClass().equals(Equipment.class) || field.get(objet).getClass().equals(TypeVendor.class))
//                {
//                    s.put(field.getName(), createJson(field.get(objet)));
//                }else{
//                    s.put(field.getName(), field.get(objet));
//                }
//            } catch (IllegalAccessException e) {
//                throw new RuntimeException(e);
//            }
//        }
//        return s;
//    }

}

