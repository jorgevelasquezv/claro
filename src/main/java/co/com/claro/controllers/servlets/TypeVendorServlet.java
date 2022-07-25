package co.com.claro.controllers.servlets;

import co.com.claro.entity.TypeVendor;
import co.com.claro.repositories.TypeVendorRepositoryImpl;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/type-vendor")
public class TypeVendorServlet extends HttpServlet {
//
//    @Inject
//    private TypeVendorRepositoryImpl typeVendorService;
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String type = req.getParameter("type");
//        TypeVendor typeVendor = TypeVendor.builder().type(type).build();
//        typeVendorService.save(typeVendor);
//
//        PrintWriter out = resp.getWriter();
//        out.println(typeVendor);
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        PrintWriter out = resp.getWriter();
//
//        if (req.getParameter("id") != null){
//            Long id = Long.valueOf(req.getParameter("id"));
//            TypeVendor typeVendor = TypeVendor.builder().id(id).build();
//            typeVendor = typeVendorService.find(typeVendor);
//            out.println(typeVendor);
//        }else{
//            List<TypeVendor> typeVendors = typeVendorService.findAll();
//            out.println(typeVendors);
//        }
//
//    }
}
