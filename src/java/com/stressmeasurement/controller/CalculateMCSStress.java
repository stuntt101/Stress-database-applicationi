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
public class CalculateMCSStress extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        StressCalculation calculate = new StressCalculation();
        StressMeasurement stressMeasurement = new StressMeasurement();

        Double Sxx, Syy, Szz, Sxy, Syz, Szx;
        Double BS1, BS2, BS3, DIPS1, DIPS2, DIPS3, SH1, SH3;
        Integer BSH1;

        //Double Sx,Sy,Sz,sxy,syz,szx;
        double S1, S2, S3;
        float converted_S1, converted_S2, converted_S3, converted_SH1, converted_SH3, K1, K3, Kx, Kz;

        String sx1 = request.getParameter("sx1");
        String sy1 = request.getParameter("sy1");
        String sz1 = request.getParameter("sz1");
        String sxy1 = request.getParameter("sxy1");
        String syz1 = request.getParameter("syz1");
        String szx1 = request.getParameter("szx1");

        Double Sx = Double.parseDouble(sx1);
        Double Sy = Double.parseDouble(sy1);
        Double Sz = Double.parseDouble(sz1);
        Double sxy = Double.parseDouble(sxy1);
        Double syz = Double.parseDouble(syz1);
        Double szx = Double.parseDouble(szx1);
        Sxx = Sx;
        Syy = Sy;
        Szz = Sz;
        Sxy = sxy;
        Syz = syz;
        Szx = szx;

//        Sxx = 21.2;
//        Syy = 12.48;
//        Szz = 26.7;
//        Sxy = -6.7;
//        Syz = -1.88;
//        Szx = 4.32;
//        Double Sx = new Double(Sxx);
//        Double Sy = new Double(Syy);
//        Double Sz = new Double(Szz);
//        Double sxy = new Double(Sxy);
//        Double syz = new Double(Syz);
//        Double szx = new Double(Szx);
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
            {Sxx, Sxy},
            {Sxy, Syy}}
        );
        Matrix matrixD = new Matrix(new double[][]{
            {Sxx, Sxy},
            {Sxy, Syy}}
        );

        List<Double> PrincipalEigenvalues = calculate.getPrincipalEigenvalues(matrixB);
        List<Double> HorizontalEigenvalues = calculate.getPrincipalEigenvalues(matrixC);
        List<Double> BEARINGS_AND_DIPS = calculate.getMCSBearingAndDips(matrixA);
        BSH1 = calculate.getMCSBearing(matrixD);

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
        K1 = converted_SH1 / (float) (double) Szz;
        K3 = converted_SH3 / (float) (double) Szz;
        Kx = (float) (double) Syy / (float) (double) Szz;
        Kz = (float) (double) Sxx / (float) (double) Szz;

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
