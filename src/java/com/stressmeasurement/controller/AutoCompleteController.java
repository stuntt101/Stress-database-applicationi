/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stressmeasurement.controller;

import com.google.gson.Gson;
import com.stressmeasurement.service.StressMeasurementService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LQwabe
 */
public class AutoCompleteController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("application/json");
        try {
             String term = request.getParameter("term");
            //System.out.println("Data from ajax call " + term);
            StressMeasurementService stressMeasurementService = new StressMeasurementService();
            List<String> list = stressMeasurementService.searchByMethod(term);
            
            

            String searchList = new Gson().toJson(list);
            response.getWriter().write(searchList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
