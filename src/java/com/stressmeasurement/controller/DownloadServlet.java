/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stressmeasurement.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.stressmeasurement.entity.StressMeasurement;
import com.stressmeasurement.service.StressMeasurementService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LQwabe
 */
public class DownloadServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

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
        String action = request.getParameter("action");
        StressMeasurementService service = new StressMeasurementService();

        if (action.equalsIgnoreCase("download")) {

            Integer smId = Integer.parseInt(request.getParameter("smId"));
            StressMeasurement stressMeasurement = service.getStressMeasurementById(smId);
            String mimeType = stressMeasurement.getFileUploadedType();
            String file_uploaded = "";

            if (mimeType.contains("pdf")) {
                
                file_uploaded = "Supporting_File" + smId + ".pdf";
            }
            if (mimeType.contains("png")) {
                
                file_uploaded = "Supporting_File" + smId + ".png";
            }
            if (mimeType.contains("jpg") || mimeType.contains("jpeg")) {
                
                file_uploaded = "Supporting_File" + smId + ".jpg";
            }
            if (mimeType.contains("gif")) {
                
                file_uploaded = "Supporting_File" + smId + ".gif";
            }
            if (mimeType.contains("spreadsheet") || mimeType.contains("sheet")) {

                file_uploaded = "Supporting_File" + smId + ".xlsx";
            }
            if (mimeType.contains("ms-excel")) {

                file_uploaded = "Supporting_File" + smId + ".xls";
            }
            if (mimeType.contains("wordprocessingml")) {

                file_uploaded = "Supporting_File" + smId + ".docx";
            }
            if (mimeType.contains("msword")) {

                file_uploaded = "Supporting_File" + smId + ".doc";
            }

            if (mimeType.contains("presentationml") || mimeType.contains("presentation")) {

                file_uploaded = "Supporting_File" + smId + ".pptx";
            }
            if (mimeType.contains("ms-powerpoint")) {

                file_uploaded = "Supporting_File" + smId + ".ppt";
            }

            if (mimeType.contains("csv")) {

                file_uploaded = "Supporting_File" + smId + ".csv";
            }

            response.setContentType(mimeType);

            response.setHeader("Content-Disposition", "attachment;     filename=\"" + file_uploaded + "\"");

            ServletOutputStream sos;
            sos = response.getOutputStream();

            sos.write(stressMeasurement.getFileUploaded());
            sos.flush();
            sos.close();
        }
        if (action.equalsIgnoreCase("ad_download")) {

            Integer smId = Integer.parseInt(request.getParameter("smId"));
            StressMeasurement stressMeasurement = service.getStressMeasurementById(smId);
            String mimeType = stressMeasurement.getFileUploadedType();
            String file_uploaded = "";

            if (mimeType.contains("pdf")) {
                file_uploaded = "Supporting_File" + smId + ".pdf";

            }
            if (mimeType.contains("png")) {
                file_uploaded = "Supporting_File" + smId + ".png";

            }
            if (mimeType.contains("jpg") || mimeType.contains("jpeg")) {
                file_uploaded = "Supporting_File" + smId + ".jpg";

            }
            if (mimeType.contains("gif")) {
                file_uploaded = "Supporting_File" + smId + ".gif";

            }
            if (mimeType.contains("spreadsheet") || mimeType.contains("sheet")) {
                file_uploaded = "Supporting_File" + smId + ".xlsx";
            }
            if (mimeType.contains("ms-excel")) {
                file_uploaded = "Supporting_File" + smId + ".xls";
            }
            if (mimeType.contains("wordprocessingml")) {
                file_uploaded = "Supporting_File" + smId + ".docx";
            }
            if (mimeType.contains("msword")) {

                file_uploaded = "Supporting_File" + smId + ".doc";
            }

            if (mimeType.contains("presentationml") || mimeType.contains("presentation")) {

                file_uploaded = "Supporting_File" + smId + ".pptx";
            }
            if (mimeType.contains("ms-powerpoint")) {

                file_uploaded = "Supporting_File" + smId + ".ppt";
            }

            if (mimeType.contains("csv")) {

                file_uploaded = "Supporting_File" + smId + ".csv";
            }

            response.setContentType(mimeType);

            response.setHeader("Content-Disposition", "attachment;     filename=\"" + file_uploaded + "\"");

            ServletOutputStream sos;
            sos = response.getOutputStream();

            sos.write(stressMeasurement.getFileUploaded());
            sos.flush();
            sos.close();
        }
        if (action.equalsIgnoreCase("us_download")) {

            Integer smId = Integer.parseInt(request.getParameter("smId"));
            StressMeasurement stressMeasurement = service.getStressMeasurementById(smId);
            String mimeType = stressMeasurement.getFileUploadedType();
            String file_uploaded = "";

            if (mimeType.contains("pdf")) {
                file_uploaded = "Supporting_File" + smId + ".pdf";

            }
            if (mimeType.contains("png")) {
                file_uploaded = "Supporting_File" + smId + ".png";

            }
            if (mimeType.contains("jpg") || mimeType.contains("jpeg")) {
                file_uploaded = "Supporting_File" + smId + ".jpg";

            }
            if (mimeType.contains("gif")) {

                file_uploaded = "Supporting_File" + smId + ".gif";

            }
            if (mimeType.contains("spreadsheet") || mimeType.contains("sheet")) {

                file_uploaded = "Supporting_File" + smId + ".xlsx";
            }
            if (mimeType.contains("ms-excel")) {

                file_uploaded = "Supporting_File" + smId + ".xls";
            }
            if (mimeType.contains("wordprocessingml")) {

                file_uploaded = "Supporting_File" + smId + ".docx";
            }
            if (mimeType.contains("msword")) {

                file_uploaded = "Supporting_File" + smId + ".doc";
            }

            if (mimeType.contains("presentationml") || mimeType.contains("presentation")) {

                file_uploaded = "Supporting_File" + smId + ".pptx";
            }
            if (mimeType.contains("ms-powerpoint")) {

                file_uploaded = "Supporting_File" + smId + ".ppt";
            }

            if (mimeType.contains("csv")) {

                file_uploaded = "Supporting_File" + smId + ".csv";
            }

            response.setContentType(mimeType);

            response.setHeader("Content-Disposition", "attachment;     filename=\"" + file_uploaded + "\"");

            ServletOutputStream sos;
            sos = response.getOutputStream();

            sos.write(stressMeasurement.getFileUploaded());
            sos.flush();
            sos.close();
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
