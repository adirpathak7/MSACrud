/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.it.clientapp.doctor;

import jakarta.inject.Inject;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Doctor Appointment</title>");
            out.println("</head>");
            out.println("<body>");

            out.println("<h1>Search Doctors by Specialization</h1>");

            out.println("<form method='post' action='ExampleServlet'>");
            out.println("Select Specialization: ");
            out.println("<select name='specialization'>");
            out.println("<option value=''>-- Select --</option>");
            out.println("<option value='Cardiology'>Cardiology</option>");
            out.println("<option value='Neurology'>Neurology</option>");
            out.println("<option value='Orthopedics'>Orthopedics</option>");
            out.println("<option value='Pediatrics'>Pediatrics</option>");
            out.println("<option value='Dermatology'>Dermatology</option>");
            out.println("</select>");
            out.println("<input type='submit' value='Search'>");
            out.println("</form><br><br>");

            String specialization = request.getParameter("specialization");
            Response res;

            if (specialization != null && !specialization.trim().isEmpty()) {
                res = serviceInterface.searchBySpecialization(specialization);
                out.println("<h2>Filtered Doctors for: " + specialization + "</h2>");
            } else {
                res = serviceInterface.getAllDoctors();
                out.println("<h2>All Doctors</h2>");
            }

            if (res != null && res.hasEntity()) {
                List<?> doctors = res.readEntity(List.class);

                if (doctors != null && !doctors.isEmpty()) {
                    out.println("<table border='1'>");
                    out.println("<tr><th>ID</th><th>Name</th><th>Address</th><th>Specialization</th><th>From</th><th>To</th></tr>");

                    for (Object obj : doctors) {
                        Map<?, ?> doc = (Map<?, ?>) obj;
                        out.println("<tr>");
                        out.println("<td>" + doc.get("doctorId") + "</td>");
                        out.println("<td>" + doc.get("doctorName") + "</td>");
                        out.println("<td>" + doc.get("address") + "</td>");
                        out.println("<td>" + doc.get("specialization") + "</td>");
                        out.println("<td>" + doc.get("fromTime") + "</td>");
                        out.println("<td>" + doc.get("toTime") + "</td>");
                        out.println("</tr>");
                    }

                    out.println("</table>");
                } else {
                    out.println("<h4>No doctors found.</h4>");
                }
            } else {
                out.println("<h4>No data received from server.</h4>");
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
