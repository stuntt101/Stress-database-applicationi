/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stressmeasurement.controller;

import com.stressmeasurement.entity.StressMeasurement;
import com.stressmeasurement.service.StressMeasurementService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LQwabe
 */
public class StressMeasurementController extends HttpServlet {

    private static final String VIEW_AND_VERIFY = "/verify.jsp";
     private static final String ADMIN_MEASUREMENT_LIST="/measurementList_ad.jsp";
    private static final long serialVersionUID = 1L;
    private final StressMeasurementService service;

    public StressMeasurementController() {
        super();
        service = new StressMeasurementService();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String forward = "";
            String action = request.getParameter("action");

            if (action.equalsIgnoreCase("view_and_verify")) {

                forward = VIEW_AND_VERIFY;
                Integer smId = Integer.parseInt(request.getParameter("smId"));

                StressMeasurement stressMeasurement = service.getStressMeasurementById(smId);
                request.setAttribute("stressMeasurement", stressMeasurement);

            }
            if (action.equalsIgnoreCase("verify")) {
                forward = ADMIN_MEASUREMENT_LIST;
                Integer smId = Integer.parseInt(request.getParameter("smId"));
                String verified = "Yes";
                StressMeasurement stressMeasurement = service.getStressMeasurementById(smId);
                stressMeasurement.setVerified(verified);
                service.updateStressMeasurement(stressMeasurement);
                request.setAttribute("verified", "verified");

            }
            if (action.equalsIgnoreCase("cancel")) {
                forward = ADMIN_MEASUREMENT_LIST;
            }
            RequestDispatcher view = request.getRequestDispatcher(forward);
            view.forward(request, response);
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
