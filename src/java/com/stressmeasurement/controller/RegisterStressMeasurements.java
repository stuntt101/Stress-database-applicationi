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
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author LQwabe
 */
@MultipartConfig
public class RegisterStressMeasurements extends HttpServlet {

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
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet RegisterStressMeasurements</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet RegisterStressMeasurements at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
            StressMeasurementService stressMeasurementService = new StressMeasurementService();
            StressMeasurement stressMeasurement = new StressMeasurement();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

            HttpSession session = request.getSession(true);
            User user = (User) session.getAttribute("user");

            Integer sm_id = Integer.parseInt(request.getParameter("sm_id"));
            String ccs = "";

            String ccsValue = request.getParameter("ccs");
            if (ccsValue.equalsIgnoreCase("1")) {
                ccs = "Mine cordinate system";

                Integer bs1 = Integer.parseInt(request.getParameter("bs1_1"));
                Integer bs2 = Integer.parseInt(request.getParameter("bs2_1"));
                Integer bs3 = Integer.parseInt(request.getParameter("bs3_1"));
                Integer dips1 = Integer.parseInt(request.getParameter("dips1_1"));
                Integer dips2 = Integer.parseInt(request.getParameter("dips2_1"));
                Integer dips3 = Integer.parseInt(request.getParameter("dips3_1"));
                float s1 = Float.parseFloat(request.getParameter("s1_1"));
                float s2 = Float.parseFloat(request.getParameter("s2_1"));
                float s3 = Float.parseFloat(request.getParameter("s3_1"));
                float sx = Float.parseFloat(request.getParameter("sx1"));
                float sy = Float.parseFloat(request.getParameter("sy1"));
                float sz = Float.parseFloat(request.getParameter("sz1"));
                float sxy = Float.parseFloat(request.getParameter("sxy1"));
                float syz = Float.parseFloat(request.getParameter("syz1"));
                float szx = Float.parseFloat(request.getParameter("szx1"));
                float sh1 = Float.parseFloat(request.getParameter("sh1_1"));
                float sh3 = Float.parseFloat(request.getParameter("sh3_1"));
                Integer bsh1 = Integer.parseInt(request.getParameter("bsh1_1"));
                float k1 = Float.parseFloat(request.getParameter("k1_1"));
                float k3 = Float.parseFloat(request.getParameter("k3_1"));
                float kx = Float.parseFloat(request.getParameter("kx_1"));
                float kz = Float.parseFloat(request.getParameter("kz_1"));

                stressMeasurement.setBs1(bs1);
                stressMeasurement.setBs2(bs2);
                stressMeasurement.setBs3(bs3);
                stressMeasurement.setDips1(dips1);
                stressMeasurement.setDips2(dips2);
                stressMeasurement.setDips3(dips3);
                stressMeasurement.setS1(s1);
                stressMeasurement.setS2(s2);
                stressMeasurement.setS3(s3);
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

            } else {
                ccs = "Database cordinate system";
                Integer bs1 = Integer.parseInt(request.getParameter("bs1"));
                Integer bs2 = Integer.parseInt(request.getParameter("bs2"));
                Integer bs3 = Integer.parseInt(request.getParameter("bs3"));
                Integer dips1 = Integer.parseInt(request.getParameter("dips1"));
                Integer dips2 = Integer.parseInt(request.getParameter("dips2"));
                Integer dips3 = Integer.parseInt(request.getParameter("dips3"));
                float s1 = Float.parseFloat(request.getParameter("s1"));
                float s2 = Float.parseFloat(request.getParameter("s2"));
                float s3 = Float.parseFloat(request.getParameter("s3"));
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

                stressMeasurement.setBs1(bs1);
                stressMeasurement.setBs2(bs2);
                stressMeasurement.setBs3(bs3);
                stressMeasurement.setDips1(dips1);
                stressMeasurement.setDips2(dips2);
                stressMeasurement.setDips3(dips3);
                stressMeasurement.setS1(s1);
                stressMeasurement.setS2(s2);
                stressMeasurement.setS3(s3);
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
            }

            String avg = request.getParameter("avg") != null ? request.getParameter("avg") : "";
            String gg = request.getParameter("gg") != null ? request.getParameter("gg") : "";
            String ig = request.getParameter("ig") != null ? request.getParameter("ig") : "";
            String country = request.getParameter("country") != null ? request.getParameter("country") : "";
            String province = request.getParameter("province") != null ? request.getParameter("province") : "";
            String locality = request.getParameter("locality") != null ? request.getParameter("locality") : "";
            String site = request.getParameter("site") != null ? request.getParameter("site") : "";
            String location = request.getParameter("location") != null ? request.getParameter("location") : "";
            float longitude = Float.parseFloat(request.getParameter("longitude"));
            float latitude = Float.parseFloat(request.getParameter("latitude"));
            Date date = format.parse(request.getParameter("date"));
            String method = request.getParameter("method") != null ? request.getParameter("method") : "";
            float depth = Float.parseFloat(request.getParameter("depth"));
            float sob = Float.parseFloat(request.getParameter("sob"));
            Integer no = Integer.parseInt(request.getParameter("no"));
            float e = Float.parseFloat(request.getParameter("e"));
            float pr = Float.parseFloat(request.getParameter("pr"));
            String rock = request.getParameter("rock") != null ? request.getParameter("rock") : "";
            String seq = request.getParameter("seq") != null ? request.getParameter("seq") : "";
            String reff = request.getParameter("reff") != null ? request.getParameter("reff") : "";
            String notes = request.getParameter("notes") != null ? request.getParameter("notes") : "";
            String bhb = request.getParameter("bhb") != null ? request.getParameter("bhb") : "";
            String bhd = request.getParameter("bhd") != null ? request.getParameter("bhd") : "";

            String verified = "No";
            Part filePart = request.getPart("file_uploaded") != null ? request.getPart("file_uploaded") : null;
            InputStream pdfFileBytes = null;
            pdfFileBytes = filePart.getInputStream();

            byte[] bytes = null;
            String fileType = "";
            if (filePart != null && filePart.getSize() != 0) {

                bytes = new byte[pdfFileBytes.available()];
                pdfFileBytes.read(bytes);
                fileType = filePart.getContentType();

            }

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
            stressMeasurement.setSob(sob);
            stressMeasurement.setCcs(ccs);
            stressMeasurement.setNo(no);
            stressMeasurement.setE(e);
            stressMeasurement.setPr(pr);
            stressMeasurement.setRock(rock);
            stressMeasurement.setSeq(seq);
            stressMeasurement.setReff(reff);
            stressMeasurement.setFileUploaded(bytes);
            stressMeasurement.setFileUploadedType(fileType);
            stressMeasurement.setNotes(notes);
            stressMeasurement.setBhb(bhb);
            stressMeasurement.setBhd(bhd);
            stressMeasurement.setAddedBy(user);
            stressMeasurement.setVerified(verified);
            boolean result = stressMeasurementService.addStressMeasurement(stressMeasurement);

            if (result) {

                UserService userService = new UserService();
                NotificationService notificationService = new NotificationService();
                Message message = new Message();

                User senderId = user;
                User recipientId = userService.getUserByUsername("admin");
                String subject = "Request To Add New Record Reff:" + sm_id;

                StringBuilder messageContent = new StringBuilder();
                messageContent.append("Dear  Admin");
                messageContent.append(System.getProperty("line.separator"));
                messageContent.append("May you please add this new record " + "");
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

                out.println("<script type=\"text/javascript\">");
                out.println("alert('New stress Measurement record sucessfully added');");
                out.println("location='measurementList_us.jsp';");
                out.println("</script>");

            } else {

                out.println("<script type=\"text/javascript\">");
                out.println("alert('Stress Measurement record already exist');");
                out.println("location='newEntry.jsp';");
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(RegisterStressMeasurements.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(RegisterStressMeasurements.class.getName()).log(Level.SEVERE, null, ex);
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
