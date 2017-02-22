/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stressmeasurement.service;

import Jama.EigenvalueDecomposition;
import Jama.Matrix;
import java.util.ArrayList;
import java.util.List;
import java.lang.Math;
import java.lang.*;
import java.util.Collections;
import org.jblas.ComplexDouble;
import org.jblas.ComplexDoubleMatrix;
import org.jblas.DoubleMatrix;
import org.jblas.Eigen;

/**
 *
 * @author LQwabe
 */
public class StressCalculation {

    /**
     * Computes the Principal eigenvalues of a given matrix
     *
     * @param matrix matrix in which eigenvalues are computed
     * @return Principal eigenvalues list in an ascending order
     */
    public List<Double> getPrincipalEigenvalues(DoubleMatrix matrix) {

        List<Double> EigenValuesList = new ArrayList<Double>();// initialize a list to store eigenvalues
        ComplexDoubleMatrix eigenvalues = Eigen.eigenvalues(matrix);// compute eigenvalues
        for (ComplexDouble eigenvalue : eigenvalues.toArray()) {
            Double value = Double.parseDouble(String.format("%.2f ", eigenvalue.abs()));
            EigenValuesList.add(value);
            Collections.sort(EigenValuesList);
        }
        //it returns Principal Eigen Values in the  order of [S3, S2, S1]
        return EigenValuesList;
    }

    /**
     * Computes the eigenvectors for principal stress of a given matrix
     *
     * @param matrix matrix in which eigenvectors are computed
     * @return returns Principal eigenvectors in the order of [n3x, n3y,
     * n3z,n2x, n2y, n2z,n1x, n1y, n1z]
     */
    public List<Double> getPrincipalEigenvectors(Matrix matrix) {
        List<Double> EigenvectorList = new ArrayList<Double>();

        Double n3x, n3y, n3z, n2x, n2y, n2z, n1x, n1y, n1z;
        matrix = matrix.transpose().times(matrix);
        // compute the spectral decomposition
        EigenvalueDecomposition e = matrix.eig();
        Matrix V = e.getV().uminus();
        n3x = V.get(0, 0);
        n3y = V.get(1, 0);
        n3z = V.get(2, 0);
        n2x = V.get(0, 1);
        n2y = V.get(1, 1);
        n2z = V.get(2, 1);
        n1x = V.get(0, 2);
        n1y = V.get(1, 2);
        n1z = V.get(2, 2);
        EigenvectorList.add(n3x);
        EigenvectorList.add(n3y);
        EigenvectorList.add(n3z);
        EigenvectorList.add(n2x);
        EigenvectorList.add(n2y);
        EigenvectorList.add(n2z);
        EigenvectorList.add(n1x);
        EigenvectorList.add(n1y);
        EigenvectorList.add(n1z);

        return EigenvectorList;
    }

    /**
     * Computes the eigenvectors for horizontal stress of a given matrix
     *
     * @param matrix matrix in which eigenvectors are computed
     * @return returns Principal eigenvectors in the order of [n3x, n3y,
     * n3z,n2x, n2y, n2z,n1x, n1y, n1z]
     */
    public List<Double> getHorizontalEigenvectors(Matrix matrix) {
        List<Double> EigenvectorList = new ArrayList<Double>();

        Double n2x, n2y, n1x, n1y;
        matrix = matrix.transpose().times(matrix);
        // compute the spectral decomposition
        EigenvalueDecomposition e = matrix.eig();
        Matrix V = e.getV().uminus();
        n2x = -V.get(0, 0);
        n2y = -V.get(1, 0);
        n1x = V.get(0, 1);
        n1y = V.get(1, 1);

        EigenvectorList.add(n2x);
        EigenvectorList.add(n2y);
        EigenvectorList.add(n1x);
        EigenvectorList.add(n1y);

        return EigenvectorList;
    }

    /**
     * Computes the bearing and dips of a given matrix
     *
     * @param matrix matrix in which bearing and dips are computed
     * @return bearing and dips list in the order of [bs3, bs2,
     * bs1,dips3,dips2,dips1]
     */
    public List<Double> getBearingAndDips(Matrix matrix) {
        Double BS1, BS2, BS3, DIPS1, DIPS2, DIPS3;
        List<Double> BEARINGS_AND_DIPS = new ArrayList<Double>();// initialize a list to store bearings and dips
        List<Double> EigenvectorList = getPrincipalEigenvectors(matrix);
        //calculate bearings using the  formula:
        //bearing = (Math.atan2(nx,nz) * 180) / Math.PI;
        BS3 = (Math.atan2(EigenvectorList.get(0), EigenvectorList.get(2)) * 180) / Math.PI;
        BS2 = (Math.atan2(EigenvectorList.get(3), EigenvectorList.get(5)) * 180) / Math.PI;
        BS1 = (Math.atan2(EigenvectorList.get(6), EigenvectorList.get(8)) * 180) / Math.PI;

        //calculate dips using the  formula:
        //dips=(Math.asin(ny) * 180) / Math.PI;
        DIPS3 = -(Math.asin(EigenvectorList.get(1)) * 180) / Math.PI;
        DIPS2 = -(Math.asin(EigenvectorList.get(4)) * 180) / Math.PI;
        DIPS1 = -(Math.asin(EigenvectorList.get(7)) * 180) / Math.PI;
        if (BS3 < 0.0) {
            BS3 = BS3 + 180;
            DIPS3 = -DIPS3;
        }
        if (BS2 < 0.0) {
            BS2 = BS2 + 180;
            DIPS2 = -DIPS2;
        }
        if (BS1 < 0.0) {
            BS1 = BS1 + 180;
            DIPS1 = -DIPS1;
        }
        //add bearings to the list.
        BEARINGS_AND_DIPS.add(Double.parseDouble(String.format("%.0f", BS3)));
        BEARINGS_AND_DIPS.add(Double.parseDouble(String.format("%.0f", BS2)));
        BEARINGS_AND_DIPS.add(Double.parseDouble(String.format("%.0f", BS1)));

        //add dips to the list
        BEARINGS_AND_DIPS.add(Double.parseDouble(String.format("%.0f", DIPS3)));
        BEARINGS_AND_DIPS.add(Double.parseDouble(String.format("%.0f", DIPS2)));
        BEARINGS_AND_DIPS.add(Double.parseDouble(String.format("%.0f", DIPS1)));

        return BEARINGS_AND_DIPS;
    }

    /**
     * Computes the bearing horizontal stress of a given matrix
     *
     * @param matrix matrix in which bearing is computed
     * @return bearing ,
     */
    public Integer getBearing(Matrix matrix) {
        Double BSH1;
        List<Double> EigenvectorList = getHorizontalEigenvectors(matrix);
        //calculate bearings using the  formula:
        //bearing = (Math.atan2(nx,nz) * 180) / Math.PI;
        BSH1 = (Math.atan2(EigenvectorList.get(2), EigenvectorList.get(3)) * 180) / Math.PI;

        if (BSH1 < 0.0) {
            BSH1 = BSH1 + 180;

        }
        BSH1 = Double.parseDouble(String.format("%.0f", BSH1));
        Integer bearing = Integer.valueOf(BSH1.intValue());
        return bearing;
    }
}
