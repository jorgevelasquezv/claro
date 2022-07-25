package co.com.claro.controllers.servlets;

import co.com.claro.entity.Equipment;
import co.com.claro.repositories.EquipmentRepositoryImpl;
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
import java.math.BigDecimal;
import java.util.List;

@WebServlet("/equipment")
public class EquipmentServlet extends HttpServlet {
//
//    @Inject
//    private EquipmentRepositoryImpl equipmentService;
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Long id = req.getParameter("id") != null ? Long.valueOf(req.getParameter("id")) : null;
//        String name = req.getParameter("name");
//        String brand = req.getParameter("brand");
//        BigDecimal price = req.getParameter("price") != null ? new BigDecimal(req.getParameter("price")) : null;
//        Long quantity = req.getParameter("quantity") != null ? Long.valueOf(req.getParameter("quantity")) : null;
//
//        PrintWriter out = resp.getWriter();
//        JSONObject body = new JSONObject();
//
//        if (name == null && brand == null && price == null && id == null && quantity == null){
//            List<Equipment> equipments = equipmentService.findAll();
//            equipments.forEach(equipment -> {
//                JSONObject eq = new JSONObject();
//                Field[] eqFields = Equipment.class.getDeclaredFields();
//                for (Field field: eqFields ) {
//                    field.setAccessible(true);
//                    try {
//                        eq.put(field.getName(), field.get(equipment));
//                    } catch (IllegalAccessException e) {
//                        throw new RuntimeException(e);
//                    }
//                }
//                body.put("equipment" + body.length(), eq);
//            }
//            );
//        }else{
//            Equipment equipment = Equipment.builder().id(id).name(name).brand(brand).price(price).quantity(quantity).build();
//            equipment = equipmentService.find(equipment);
//
//            JSONObject eq = new JSONObject();
//            Field[] eqFields = Equipment.class.getDeclaredFields();
//
//            for (Field field: eqFields ) {
//                field.setAccessible(true);
//                try {
//                    eq.put(field.getName(), field.get(equipment));
//                } catch (IllegalAccessException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//            body.put("equipment", eq);
//        }
//
//        out.println(body);
//    }
}
