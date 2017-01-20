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
import java.text.DecimalFormat;
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

        StressCalculation calculate = new StressCalculation();
        StressMeasurement stressMeasurement = new StressMeasurement();

        Double Sxx, Syy, Szz, Sxy, Syz, Szx;
        Double BS1, BS2, BS3, DIPS1, DIPS2, DIPS3, SH1, SH3;
        Integer BSH1;

        double S1, S2, S3;
        float converted_S1, converted_S2, converted_S3, converted_SH1, converted_SH3, K1, K3, Kx, Kz;

        Double Sx = Double.parseDouble(request.getParameter("sx"));
        Double Sy = Double.parseDouble(request.getParameter("sy"));
        Double Sz = Double.parseDouble(request.getParameter("sz"));
        Double sxy = Double.parseDouble(request.getParameter("sxy"));
        Double syz = Double.parseDouble(request.getParameter("syz"));
        Double szx = Double.parseDouble(request.getParameter("szx"));
        Sxx = Sx;
        Syy = Sy;
        Szz = Sz;
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

        List<Double> PrincipalEigenvalues = calculate.getPrincipalEigenvalues(matrixB);
        List<Double> HorizontalEigenvalues = calculate.getPrincipalEigenvalues(matrixC);
        List<Double> BEARINGS_AND_DIPS = calculate.getBearingAndDips(matrixA);
        BSH1 = calculate.getBearing(matrixD);

        S3 = PrincipalEigenvalues.get(0);
        S2 = PrincipalEigenvalues.get(1);
        S1 = PrincipalEigenvalues.get(2);

        BS3 = BEARINGS_AND_DIPS.get(0);
        BS2 = BEARINGS_AND_DIPS.get(1);
        BS1 = BEARINGS_AND_DIPS.get(2);
        DIPS3 = BEARINGS_AND_DIPS.get(3);
        DIPS2 = BEARINGS_AND_DIPS.get(4);
        DIPS1 = BEARINGS_AND_DIPS.get(5);

        SH1 = HorizontalEigenvalues.get(1);
        SH3 = HorizontalEigenvalues.get(0);

        converted_S1 = (float) S1;
        converted_S2 = (float) S2;
        converted_S3 = (float) S3;
        converted_SH1 = (float) (double) SH1;
        converted_SH3 = (float) (double) SH3;

        //calculate k-ratios    
        K1 = converted_SH1 / (float) (double) Sy;
        K3 = converted_SH3 / (float) (double) Sy;
        Kx = (float) (double) Sx / (float) (double) Sy;
        Kz = (float) (double) Sz / (float) (double) Sy;

        //convert k-ratios  values into two decimal place
        DecimalFormat decimalFormat = new DecimalFormat("#.##");

        K1 = Float.valueOf(decimalFormat.format(K1));
        K3 = Float.valueOf(decimalFormat.format(K3));
        Kx = Float.valueOf(decimalFormat.format(Kx));
        Kz = Float.valueOf(decimalFormat.format(Kz));

        stressMeasurement.setS1(converted_S1);
        stressMeasurement.setS2(converted_S2);
        stressMeasurement.setS3(converted_S3);
        stressMeasurement.setBs1(BS1.intValue());
        stressMeasurement.setBs2(BS2.intValue());
        stressMeasurement.setBs3(BS3.intValue());
        stressMeasurement.setDips1(DIPS1.intValue());
        stressMeasurement.setDips2(DIPS2.intValue());
        stressMeasurement.setDips3(DIPS3.intValue());
        stressMeasurement.setBsh1(BSH1);
        stressMeasurement.setSh1(converted_SH1);
        stressMeasurement.setSh3(converted_SH3);
        stressMeasurement.setK1(K1);
        stressMeasurement.setK3(K3);
        stressMeasurement.setKx(Kx);
        stressMeasurement.setKz(Kz);

        try {
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().print(new Gson().toJson(stressMeasurement));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
