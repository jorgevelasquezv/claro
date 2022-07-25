package co.com.claro.controllers.servlets;

import co.com.claro.entity.Client;
import co.com.claro.repositories.ClientRepositoryImpl;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/client")
public class ClientServlet extends HttpServlet {
//
//    @Inject
//    private ClientRepositoryImpl clientService;
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Long id = req.getParameter("id") != null  ?  Long.valueOf(req.getParameter("id")) : null;
//        String name = req.getParameter("name");
//        Long dni = req.getParameter("dni") != null ? Long.valueOf(req.getParameter("dni")) : null;
//
//        PrintWriter out = resp.getWriter();
//
//        if (id != null && name != null && dni != null){
//            Client client = Client.builder().id(id).name(name).dni(dni).build();
//            client = clientService.find(client);
//            out.println(client);
//        }else{
//            List<Client> clients = clientService.findAll();
//            out.println(clients);
//        }
//
//    }
}
