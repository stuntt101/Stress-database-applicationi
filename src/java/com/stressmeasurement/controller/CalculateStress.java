/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stressmeasurement.controller;

import Jama.Matrix;
import com.google.gson.Gson;
import com.stressmeasurement.entity.StressMeasurement;
import com.stressmeasurement.service.StressCalculation;
import com.stressmeasurement.service.StressMeasurementService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jblas.DoubleMatrix;

/**
 *
 * @author LQwabe
 */
public class CalculateStress extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        StressMeasurementService stressMeasurementService = new StressMeasurementService();
        StressCalculation calculate = new StressCalculation();
        StressMeasurement stressMeasurement = new StressMeasurement();
        List<StressMeasurement> list = new ArrayList<StressMeasurement>();
        Double Sxx, Syy, Szz, Sxy, Syz, Szx;
        
        double S1, S2, S3;
        float converted_S1, converted_S2,converted_S3;

        Double sx = Double.parseDouble(request.getParameter("sx"));
        Double sy = Double.parseDouble(request.getParameter("sy"));
        Double sz = Double.parseDouble(request.getParameter("sz"));
        Double sxy = Double.parseDouble(request.getParameter("sxy"));
        Double syz = Double.parseDouble(request.getParameter("syz"));
        Double szx = Double.parseDouble(request.getParameter("szx"));
        Sxx = sx;
        Syy = sy;
        Szz = sz;
        Sxy = sxy;
        Syz = syz;
        Szx = szx;
        
//        Sxx = 12.48;
//        Syy = 26.7;
//        Szz = 21.2;
//        Sxy = -1.88;
//        Syz = 4.32;
//        Szx = -6.7;

        Matrix matrixA = new Matrix(new double[][]{
            {Sxx, Sxy, Szx},
            {Sxy, Syy, Syz},
            {Szx, Syz, Szz}}
        );
        DoubleMatrix matrixB = new DoubleMatrix(new double[][]{
            {Sxx, Sxy, Szx},
            {Sxy, Syy, Syz},
            {Szx, Syz, Szz}}
        );

        DoubleMatrix matrixC = new DoubleMatrix(new double[][]{
            {Sxx, Szx},
            {Szx, Szz}}
        );
        Matrix matrixD = new Matrix(new double[][]{
            {Sxx, Szx},
            {Szx, Szz}}
        );
        
      
        List<Double> PrincipalEigenvalues =calculate.getPrincipalEigenvalues(matrixB);
        S1=PrincipalEigenvalues.get(2);
        S2=PrincipalEigenvalues.get(1);
        S3=PrincipalEigenvalues.get(0);
        
          converted_S1 = (float) S1;
          converted_S2 = (float) S2;
          converted_S3 = (float) S3;
          
          stressMeasurement.setS1(converted_S1);
          stressMeasurement.setS2(converted_S2);
          stressMeasurement.setS3(converted_S3);
          list.add(stressMeasurement);

        //Gson gson = new Gson();

        try {

            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().print(new Gson().toJson(stressMeasurement));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
