package co.com.claro.controllers.servlets;

import co.com.claro.entity.TypeVendor;
import co.com.claro.entity.Vendor;
import co.com.claro.repositories.TypeVendorRepositoryImpl;
import co.com.claro.repositories.VendorRepositoryImpl;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/vendor")
public class VendorServlet extends HttpServlet {
//
//    @Inject
//    private VendorRepositoryImpl vendorService;
//
//    @Inject
//    private TypeVendorRepositoryImpl typeVendorService;
//
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        PrintWriter out = resp.getWriter();
//        out.println(vendorService.findAll());
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Long id = Long.valueOf(req.getParameter("id_type"));
//        TypeVendor typeVendor = TypeVendor.builder().id(id).build();
//
//        typeVendor = typeVendorService.find(typeVendor);
//
//
//        Vendor vendor = new Vendor();
//        vendor.setName(req.getParameter("name"));
//        vendor.setDni(req.getParameter("dni"));
//        vendor.setCode(req.getParameter("code"));
//        vendor.setCity(req.getParameter("city"));
//        vendor.setTypeVendor(typeVendor);
//
//        vendor = vendorService.save(vendor);
//
//        PrintWriter out = resp.getWriter();
//        out.println(vendor);
//        out.println(typeVendor.toString());



////        out.println(req.getParameter("id_type"));
////        out.println(req.getParameter("name"));
////        out.println(req.getParameter("dni"));
////        out.println(req.getParameter("code"));
////        out.println(req.getParameter("city"));

//    }
}
