/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stressmeasurement.controller;

import com.stressmeasurement.entity.StressMeasurement;
import com.stressmeasurement.entity.User;
import com.stressmeasurement.service.StressMeasurementService;
import com.stressmeasurement.service.UserService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lungelo
 */
public class RegisterUser extends HttpServlet {

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

            String action = request.getParameter("action");
            if (action.equalsIgnoreCase("addUser")) {

                UserService userService = new UserService();
                User user = new User();
                //get parameters
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                String firstName = request.getParameter("firstName");
                String lastName = request.getParameter("lastName");
                String emailAddress = request.getParameter("emailAddress");
                String mineName = request.getParameter("mineName");
                Integer role = Integer.parseInt(request.getParameter("role"));
                //set user parameters
                user.setUsername(username);
                user.setPassword(password);
                user.setFirstname(firstName);
                user.setLastname(lastName);
                user.setEmailAddress(emailAddress);
                user.setMineName(mineName);
                user.setRole(role);

                boolean result = userService.addUser(user);

                if (result) {

                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('New user sucessfully added');");
                    out.println("location='list_users.jsp';");
                    out.println("</script>");

                } else {

                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('The user already exist');");
                    out.println("location='new_user.jsp';");
                    out.println("</script>");

                }

            }
            if (action.equalsIgnoreCase("edit")) {

                String username = request.getParameter("username");
                UserService userService = new UserService();
                User edituser = userService.getUserByUsername(username);
                request.setAttribute("edituser", edituser);
                RequestDispatcher view = request.getRequestDispatcher("/editUser.jsp");
                view.forward(request, response);

            }
            if (action.equalsIgnoreCase("delete")) {

                String username = request.getParameter("username");
                UserService userService = new UserService();
                User user = userService.getUserByUsername(username);

                StressMeasurementService stressMeasurementService = new StressMeasurementService();
                List<StressMeasurement> stressMeasurements = stressMeasurementService.getAllStressMeasurementsAddedBy(user);
                if (stressMeasurements.size() > 0) {

                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('The user you are trying to delete already added some stress Measurement record/s. Therefore cannot be deleted');");
                    out.println("location='list_users.jsp';");
                    out.println("</script>");

                }
                else if (user.getRole()==1) {

                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('The user you are trying to delete is an admin. Therefore cannot be deleted');");
                    out.println("location='list_users.jsp';");
                    out.println("</script>");

                }
                else {
                   userService.deleteUser(username);
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('User sucessfully deleted');");
                    out.println("location='list_users.jsp';");
                    out.println("</script>");

                }

            }
            if (action.equalsIgnoreCase("updateUser")) {

                UserService userService = new UserService();
                User user = new User();
                //get parameters
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                String firstName = request.getParameter("firstName");
                String lastName = request.getParameter("lastName");
                String emailAddress = request.getParameter("emailAddress");
                String mineName = request.getParameter("mineName");
                Integer role = Integer.parseInt(request.getParameter("role"));
                //set user parameters
                user.setUsername(username);
                user.setPassword(password);
                user.setFirstname(firstName);
                user.setLastname(lastName);
                user.setEmailAddress(emailAddress);
                user.setMineName(mineName);
                user.setRole(role);
                userService.updateUser(user);
                out.println("<script type=\"text/javascript\">");
                out.println("alert('User sucessfully updated');");
                out.println("location='list_users.jsp';");
                out.println("</script>");

            }
            if (action.equalsIgnoreCase("close")) {
                out.println("<script type=\"text/javascript\">");
                out.println("location='list_users.jsp';");
                out.println("</script>");

            }

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
