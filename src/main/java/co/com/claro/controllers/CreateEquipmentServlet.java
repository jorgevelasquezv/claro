package co.com.claro.controllers;

import co.com.claro.entity.Equipment;
import co.com.claro.services.EquipmentServiceImpl;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.primefaces.shaded.json.JSONObject;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

@WebServlet("/equipment/create")
public class CreateEquipmentServlet extends HttpServlet {

    @Inject
    private EquipmentServiceImpl equipmentService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String brand = req.getParameter("brand");
        BigDecimal price = new BigDecimal((req.getParameter("price")));
        Long quantity = Long.valueOf(req.getParameter("quantity"));

        Equipment equipment = Equipment.builder().name(name).brand(brand).price(price).quantity(quantity).build();

        equipmentService.save(equipment);

        PrintWriter out = resp.getWriter();

        JSONObject body = new JSONObject();

        body.put("id", equipment.getId());
        body.put("name", equipment.getName());
        body.put("brand", equipment.getBrand());
        body.put("price", equipment.getPrice());
        body.put("quantity", equipment.getQuantity());

        out.println(body);


    }
}
