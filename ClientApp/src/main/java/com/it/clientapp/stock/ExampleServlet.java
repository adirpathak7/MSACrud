/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.it.clientapp.stock;

import com.it.clientapp.entity.Doctorsappointment;
import jakarta.inject.Inject;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Aditya Pathak R
 */
@WebServlet(name = "ExampleServlet", urlPatterns = {"/ExampleServlet"})
public class ExampleServlet extends HttpServlet {

    @Inject
    ServiceInterface serviceInterface;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ExampleServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Doctors " + serviceInterface.get() + "</h1>");

            Response res = serviceInterface.getAllDoctors();

            if (res.hasEntity()) {
                List list = res.readEntity(List.class);

                // for design
                out.println("<table border='1px' cellpadding='8'>");
                out.println("<tr>");
                out.println("<th>ID</th><th>Name</th><th>Address</th><th>Specialization</th><th>From</th><th>To</th>");
                out.println("</tr>");

                for (Object obj : list) {
                    Map map = (Map) obj;
                    out.println("<tr>");
                    out.println("<td>" + map.get("doctorId") + "</td>");
                    out.println("<td>" + map.get("doctorName") + "</td>");
                    out.println("<td>" + map.get("address") + "</td>");
                    out.println("<td>" + map.get("specialization") + "</td>");
                    out.println("<td>" + map.get("fromTime") + "</td>");
                    out.println("<td>" + map.get("toTime") + "</td>");
                    out.println("</tr>");
                }
                out.println("</table>");

                // you can do only this
//                out.println("<h2>Doctors: " + list.toString() + "</h2>");
            } else {
                out.println("<h4>No data found!</h4>");
            }

            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
