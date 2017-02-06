/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stressmeasurement.controller;

import com.stressmeasurement.entity.Message;
import com.stressmeasurement.entity.StressMeasurement;
import com.stressmeasurement.entity.User;
import com.stressmeasurement.service.NotificationService;
import com.stressmeasurement.service.StressMeasurementService;
import com.stressmeasurement.service.UserService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
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
    private static final String ADMIN_MEASUREMENT_LIST = "/measurementList_ad.jsp";
    private static final String ADMIN_NOTIFICATIONS = "/ad_notifications.jsp";
    private static final String USER_NOTIFICATIONS="us_notifications.jsp";
    private static final long serialVersionUID = 1L;
    private final StressMeasurementService service;
    private final NotificationService notificationService;
    private final UserService userService;

    public StressMeasurementController() {
        super();
        service = new StressMeasurementService();
        notificationService = new NotificationService();
        userService = new UserService();
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
                Integer messageId = Integer.parseInt(request.getParameter("messageId"));
                Message message = notificationService.getMessageById(messageId);
                int flagRRead = 1;
                message.setFlagRRead(flagRRead);
                notificationService.updateMessage(message);
                String senderId = request.getParameter("senderId");
                User user = userService.getUserByUsername(senderId);

                StressMeasurement stressMeasurement = service.getStressMeasurementById(smId);
                request.setAttribute("stressMeasurement", stressMeasurement);
                request.setAttribute("user", user);

            }
            if (action.equalsIgnoreCase("deleteMessage")) {

                forward = ADMIN_NOTIFICATIONS;

                Integer messageId = Integer.parseInt(request.getParameter("messageId"));
                Message message = notificationService.getMessageById(messageId);

                int flagRDeleted = 1;
                message.setFlagRDeleted(flagRDeleted);
                notificationService.updateMessage(message);
                request.setAttribute("messsage_deleted", "messsage_deleted");

            }
            if (action.equalsIgnoreCase("us_deleteMessage")) {

                forward = USER_NOTIFICATIONS;

                Integer messageId = Integer.parseInt(request.getParameter("messageId"));
                Message message = notificationService.getMessageById(messageId);

                int flagRDeleted = 1;
                message.setFlagRDeleted(flagRDeleted);
                notificationService.updateMessage(message);
                request.setAttribute("us_messsage_deleted", "us_messsage_deleted");

            }
            if (action.equalsIgnoreCase("verify")) {
                forward = ADMIN_NOTIFICATIONS;
                Integer smId = Integer.parseInt(request.getParameter("smId"));
                String username = request.getParameter("username");
                String verified = "Yes";
                
                StressMeasurement stressMeasurement = service.getStressMeasurementById(smId);
                
                
                
                
                
                if(stressMeasurement.getVerified().equalsIgnoreCase(verified)){
                  request.setAttribute("already_verified", "already_verified");
                
                }else{
                  stressMeasurement.setVerified(verified);
                service.updateStressMeasurement(stressMeasurement);
                 UserService userService = new UserService();
                NotificationService notificationService = new NotificationService();
                Message message = new Message();
                User recipientId = userService.getUserByUsername(username);
                User senderId = userService.getUserByUsername("admin");
                String subject = "New Record" + "Reff:" + smId + "Approved";
                StringBuilder messageContent = new StringBuilder();
                
                
                
                messageContent.append("Dear" + recipientId.getFirstname() + "");
                messageContent.append(System.getProperty("line.separator"));
                messageContent.append("Your request to add new data approved: " + "");
                messageContent.append(System.getProperty("line.separator"));
                messageContent.append("Kind regards  " + "");
                messageContent.append(System.getProperty("line.separator"));
                messageContent.append("Admin  " + "");
                int flagSDeleted = 0;
                int flagRDeleted = 0;
                int flagRRead = 0;
                Date sentDate = new Date();
                StressMeasurement dataReffId = service.getStressMeasurementById(smId);
                message.setSenderId(senderId);
                message.setRecipientId(recipientId);
                message.setSubject(subject);
                message.setContent(messageContent.toString());
                message.setFlagRDeleted(flagRDeleted);
                message.setFlagSDeleted(flagSDeleted);
                message.setFlagRRead(flagRRead);
                message.setDataReffId(dataReffId);
                message.setSentDate(sentDate);
                notificationService.addMessage(message);
                request.setAttribute("verified", "verified");
}

               
            }
            if (action.equalsIgnoreCase("request_data_corrections")) {

                forward = ADMIN_NOTIFICATIONS;

                Message message = new Message();
                Integer smId = Integer.parseInt(request.getParameter("smId"));
                String recipientEmailAddress = request.getParameter("recipient");
                User senderId = userService.getUserByUsername("admin");
                User recipientId = userService.getUserByEmailAddress(recipientEmailAddress);
                String subject = request.getParameter("subject");
                String content = request.getParameter("content");
                int flagSDeleted = 0;
                int flagRDeleted = 0;
                int flagRRead = 0;
                Date sentDate = new Date();
                StressMeasurement dataReffId = service.getStressMeasurementById(smId);
                message.setSenderId(senderId);
                message.setRecipientId(recipientId);
                message.setSubject(subject);
                message.setContent(content);
                message.setFlagRDeleted(flagRDeleted);
                message.setFlagSDeleted(flagSDeleted);
                message.setFlagRRead(flagRRead);
                message.setDataReffId(dataReffId);
                message.setSentDate(sentDate);
                notificationService.addMessage(message);
                request.setAttribute("sent", "sent");

            }
            
            if (action.equalsIgnoreCase("cancel")) {
                forward = ADMIN_NOTIFICATIONS;
            }
            if (action.equalsIgnoreCase("us_canceL")) {
                forward = USER_NOTIFICATIONS;
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
