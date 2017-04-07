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
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author LQwabe
 */
public class StressMeasurementController extends HttpServlet {

    private static final String VIEW_AND_VERIFY = "/verify.jsp";
    private static final String ADMIN_MEASUREMENT_LIST = "/measurementList_ad.jsp";
    private static final String HOME = "/measurementList.jsp";
    private static final String ADMIN_NOTIFICATIONS = "/ad_notifications.jsp";
    private static final String USER_NOTIFICATIONS = "us_notifications.jsp";
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
            throws ServletException, IOException, ParseException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
         ServletOutputStream sos;
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
            if (action.equalsIgnoreCase("download")) {

//               forward = HOME;
                Integer smId = Integer.parseInt(request.getParameter("smId"));

                StressMeasurement stressMeasurement = service.getStressMeasurementById(smId);
              //  byte[] bytes = stressMeasurement.getFileUploaded();
                //Blob blob = new javax.sql.rowset.serial.SerialBlob(bytes);

            response.setContentType("application/pdf");
            String file_uploaded = "Supporting_Doc" + smId + ".pdf";
            response.setContentLength(stressMeasurement.getFileUploaded().length);	
            response.setHeader("Content-Disposition", "attachment;     filename=\"" + file_uploaded + "\"");
               
                //sos = response.getOutputStream(); 
                BufferedOutputStream sos1 = new BufferedOutputStream(
                response.getOutputStream());
                sos1.write(stressMeasurement.getFileUploaded());
                sos1.flush();
                sos1.close();
                
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

                if (stressMeasurement.getVerified().equalsIgnoreCase(verified)) {
                    request.setAttribute("already_verified", "already_verified");

                } else {
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
                String recordReff = "Record Ref:" + "\t" + smId;
                String subject = request.getParameter("subject") + "\t" + recordReff;
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
            if (action.equalsIgnoreCase("resend")) {

                forward = USER_NOTIFICATIONS;
                StressMeasurementService stressMeasurementService = new StressMeasurementService();
                UserService userService = new UserService();
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

                String username = request.getParameter("username");
                User user = userService.getUserByUsername(username);
                Integer sm_id = Integer.parseInt(request.getParameter("smId"));
                String avg = request.getParameter("avg");
                String gg = request.getParameter("gg");
                String ig = request.getParameter("ig");
                String country = request.getParameter("country");
                String province = request.getParameter("province");
                String locality = request.getParameter("locality");
                String site = request.getParameter("site");
                String location = request.getParameter("location");
                float longitude = Float.parseFloat(request.getParameter("longitude"));
                float latitude = Float.parseFloat(request.getParameter("latitude"));
                Date date = format.parse(request.getParameter("date"));
                String method = request.getParameter("method");
                float depth = Float.parseFloat(request.getParameter("depth"));
                Integer bs1 = Integer.parseInt(request.getParameter("bs1"));
                Integer bs2 = Integer.parseInt(request.getParameter("bs2"));
                Integer bs3 = Integer.parseInt(request.getParameter("bs3"));
                Integer dips1 = Integer.parseInt(request.getParameter("dips1"));
                Integer dips2 = Integer.parseInt(request.getParameter("dips2"));
                Integer dips3 = Integer.parseInt(request.getParameter("dips3"));
                float s1 = Float.parseFloat(request.getParameter("s1"));
                float s2 = Float.parseFloat(request.getParameter("s2"));
                float s3 = Float.parseFloat(request.getParameter("s3"));
                float sob = Float.parseFloat(request.getParameter("sob"));
                float sx = Float.parseFloat(request.getParameter("sx"));
                float sy = Float.parseFloat(request.getParameter("sy"));
                float sz = Float.parseFloat(request.getParameter("sz"));
                float sxy = Float.parseFloat(request.getParameter("sxy"));
                float syz = Float.parseFloat(request.getParameter("syz"));
                float szx = Float.parseFloat(request.getParameter("szx"));
                float sh1 = Float.parseFloat(request.getParameter("sh1"));
                float sh3 = Float.parseFloat(request.getParameter("sh3"));
                Integer bsh1 = Integer.parseInt(request.getParameter("bsh1"));
                float k1 = Float.parseFloat(request.getParameter("k1"));
                float k3 = Float.parseFloat(request.getParameter("k3"));
                float kx = Float.parseFloat(request.getParameter("kx"));
                float kz = Float.parseFloat(request.getParameter("kz"));
                Integer no = Integer.parseInt(request.getParameter("no"));
                float e = Float.parseFloat(request.getParameter("e"));
                float pr = Float.parseFloat(request.getParameter("pr"));
                String rock = request.getParameter("rock");
                String seq = request.getParameter("seq");
                String reff = request.getParameter("reff");
                String notes = request.getParameter("notes");
                String bhb = request.getParameter("bhb");
                String bhd = request.getParameter("bhd");
                String verified = "No";

                StressMeasurement stressMeasurement = stressMeasurementService.getStressMeasurementById(sm_id);

                if (stressMeasurement.getVerified().equalsIgnoreCase("Yes")) {

                    request.setAttribute("isVerified", "isVerified");

                } else {

                    stressMeasurement.setAvg(avg);
                    stressMeasurement.setIg(ig);
                    stressMeasurement.setGg(gg);
                    stressMeasurement.setCountry(country);
                    stressMeasurement.setProvince(province);
                    stressMeasurement.setLocality(locality);
                    stressMeasurement.setSite(site);
                    stressMeasurement.setLocation(location);
                    stressMeasurement.setLongitude(longitude);
                    stressMeasurement.setLatitude(latitude);
                    stressMeasurement.setDate(date);
                    stressMeasurement.setMethod(method);
                    stressMeasurement.setDepth(depth);
                    stressMeasurement.setBs1(bs1);
                    stressMeasurement.setBs2(bs2);
                    stressMeasurement.setBs3(bs3);
                    stressMeasurement.setDips1(dips1);
                    stressMeasurement.setDips2(dips2);
                    stressMeasurement.setDips3(dips3);
                    stressMeasurement.setS1(s1);
                    stressMeasurement.setS2(s2);
                    stressMeasurement.setS3(s3);
                    stressMeasurement.setSob(sob);
                    stressMeasurement.setSx(sx);
                    stressMeasurement.setSy(sy);
                    stressMeasurement.setSz(sz);
                    stressMeasurement.setSxy(sxy);
                    stressMeasurement.setSyz(syz);
                    stressMeasurement.setSzx(szx);
                    stressMeasurement.setSh1(sh1);
                    stressMeasurement.setSh3(sh3);
                    stressMeasurement.setBsh1(bsh1);
                    stressMeasurement.setK1(k1);
                    stressMeasurement.setK3(k3);
                    stressMeasurement.setKx(kx);
                    stressMeasurement.setKz(kz);
                    stressMeasurement.setNo(no);
                    stressMeasurement.setE(e);
                    stressMeasurement.setPr(pr);
                    stressMeasurement.setRock(rock);
                    stressMeasurement.setSeq(seq);
                    stressMeasurement.setReff(reff);
                    stressMeasurement.setNotes(notes);
                    stressMeasurement.setBhb(bhb);
                    stressMeasurement.setBhd(bhd);
                    stressMeasurement.setAddedBy(user);
                    stressMeasurement.setVerified(verified);
                    stressMeasurementService.updateStressMeasurement(stressMeasurement);

                    NotificationService notificationService = new NotificationService();
                    Message message = new Message();

                    User senderId = user;
                    User recipientId = userService.getUserByUsername("admin");
                    String subject = "Updated record for the Record Reff:" + sm_id;

                    StringBuilder messageContent = new StringBuilder();
                    messageContent.append("Dear  Admin");
                    messageContent.append(System.getProperty("line.separator"));
                    messageContent.append("I have corrected the  record as requested " + "");
                    messageContent.append(System.getProperty("line.separator"));
                    messageContent.append("Kind regards  " + "");
                    messageContent.append(System.getProperty("line.separator"));
                    messageContent.append(" " + user.getFirstname() + "\t" + user.getLastname());
                    int flagSDeleted = 0;
                    int flagRDeleted = 0;
                    int flagRRead = 0;
                    Date sentDate = new Date();
                    StressMeasurement dataReffId = stressMeasurementService.getStressMeasurementById(sm_id);
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

                    request.setAttribute("updated", "updated");

                }

            }

            if (action.equalsIgnoreCase("cancel")) {
                forward = ADMIN_NOTIFICATIONS;
                 request.setAttribute("isCanceled", "isCanceled");
            }
            if (action.equalsIgnoreCase("us_cancel")) {
                forward = USER_NOTIFICATIONS;
                 request.setAttribute("isCanceled", "isCanceled");
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(StressMeasurementController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(StressMeasurementController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(StressMeasurementController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(StressMeasurementController.class.getName()).log(Level.SEVERE, null, ex);
        }

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
