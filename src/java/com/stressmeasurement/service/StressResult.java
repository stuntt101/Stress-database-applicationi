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
import org.jblas.ComplexDouble;
import org.jblas.ComplexDoubleMatrix;
import org.jblas.DoubleMatrix;
import org.jblas.Eigen;

/**
 *
 * @author LQwabe
 */
public class StressResult {

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
        }
        //it returns Principal Eigen Values in the  order of [S3, S2, S1]
        return EigenValuesList;
    }

    /**
     * Computes the Principal eigenvectors of a given matrix
     *
     * @param matrix matrix in which eigenvectors are computed
     * @return Principal eigenvectors list in the same order as the eigenvalues
     */
    public List<Double> getPrincipalEigenvectors(DoubleMatrix matrix) {

        List<Double> EigenVectorList = new ArrayList<Double>();// initialize a list to store eigenvectors
        ComplexDoubleMatrix eigenvectors = Eigen.eigenvectors(matrix)[0];// compute eigenvectors
        for (ComplexDouble eigenvector : eigenvectors.toArray()) {

            Double value = Double.parseDouble(String.format("%.4f ", eigenvector.abs()));
            EigenVectorList.add(value);
        }
        //it returns Principal Eigen Vectors in the  order of [n3x, n3y, n3z,n2x, n2y, n2z,n1x, n1y, n1z]
        return EigenVectorList;
    }

    /**
     * Computes an index in the array the largest eigenvalue belongs to so that
     * we can look it up in the array we get from eigenvectors
     *
     * @param matrix matrix in which eigenvalue index is computed
     * @return an index
     */
    public int getMaxIndex(DoubleMatrix matrix) {
        ComplexDouble[] doubleMatrix = Eigen.eigenvalues(matrix).toArray();
        int maxIndex = 0;
        for (int i = 0; i < doubleMatrix.length; i++) {
            double newnumber = doubleMatrix[i].abs();
            if ((newnumber > doubleMatrix[maxIndex].abs())) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public List<Double> getEigenvector(ComplexDoubleMatrix eigenvector, int columnId) {
        ComplexDoubleMatrix column = eigenvector.getColumn(columnId);
        List<Double> values = new ArrayList<Double>();
        for (ComplexDouble value : column.toArray()) {
            values.add(value.abs());
        }
        return values;
    }

    public List<Double> getBearingAndDips(Matrix matrix) {
        Double bs1, bs2, bs3, dips1, dips2, dips3;
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

        List<Double> BEARINGS_AND_DIPS = new ArrayList<Double>();// initialize a list to store bearings and dips
        List<Double> EigenvectorList = new ArrayList<Double>();
        EigenvectorList.add(n3x);
        EigenvectorList.add(n3y);
        EigenvectorList.add(n3z);
        EigenvectorList.add(n2x);
        EigenvectorList.add(n2y);
        EigenvectorList.add(n2z);
        EigenvectorList.add(n1x);
        EigenvectorList.add(n1y);
        EigenvectorList.add(n1z);

        //calculate bearings using the  formula:
        //bearing = (Math.atan2(nx,nz) * 180) / Math.PI;
        bs3 = (Math.atan2(EigenvectorList.get(0), EigenvectorList.get(2)) * 180) / Math.PI;
        bs2 = (Math.atan2(EigenvectorList.get(3), EigenvectorList.get(5)) * 180) / Math.PI;
        bs1 = (Math.atan2(EigenvectorList.get(6), EigenvectorList.get(8)) * 180) / Math.PI;

        //calculate dips using the  formula:
        //dips=(Math.asin(ny) * 180) / Math.PI;
        dips3 = -(Math.asin(EigenvectorList.get(1)) * 180) / Math.PI;
        dips2 = -(Math.asin(EigenvectorList.get(4)) * 180) / Math.PI;
        dips1 = -(Math.asin(EigenvectorList.get(7)) * 180) / Math.PI;
        if (bs3 < 0.0) {
            bs3 = bs3 + 180;
            dips3 = -dips3;
        }
        if (bs2 < 0.0) {
            bs2 = bs2 + 180;
            dips2 = -dips2;
        }
        if (bs1 < 0.0) {
            bs1 = bs1 + 180;
            dips1 = -dips1;
        }
        //add bearings to the listbs3.
        BEARINGS_AND_DIPS.add(Double.parseDouble(String.format("%.0f", bs3)));
        BEARINGS_AND_DIPS.add(Double.parseDouble(String.format("%.0f", bs2)));
        BEARINGS_AND_DIPS.add(Double.parseDouble(String.format("%.0f", bs1)));
        
        //add bearings to the list
        BEARINGS_AND_DIPS.add(Double.parseDouble(String.format("%.0f", dips3)));
        BEARINGS_AND_DIPS.add(Double.parseDouble(String.format("%.0f", dips2)));
        BEARINGS_AND_DIPS.add(Double.parseDouble(String.format("%.0f", dips1)));
       
        
        //it returns Principal Eigen Vectors in the  order of [bs3, bs2, bs1,dips3,dips2,dips1]
        return BEARINGS_AND_DIPS;
    }
}
