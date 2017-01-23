
import Jama.EigenvalueDecomposition;
import Jama.Matrix;
import com.stressmeasurement.service.StressCalculation;
import com.stressmeasurement.service.StressMeasurementService;
import java.util.ArrayList;
import java.util.List;
import org.jblas.DoubleMatrix;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LQwabe
 */
public class Test2 {
    
     public static void main(String[] args) {
     DoubleMatrix matrix = new DoubleMatrix(new double[][]{
            {12.48, -1.88, -6.70},
            {-1.88, 26.7, 4.32},
            {-6.70, 4.32, 21.2}}
        );
     
     StressMeasurementService serv = new StressMeasurementService();
     int max = serv.getMaxIndexOfRecord();
     
     
      Matrix matrix2 = new Matrix(new double[][]{
            {12.48, -1.88, -6.70},
            {-1.88, 26.7, 4.32},
            {-6.70, 4.32, 21.2}}
        );
      
      Double n3x, n3y, n3z, n2x, n2y, n2z, n1x, n1y, n1z;

        matrix2 = matrix2.transpose().times(matrix2);

        // compute the spectral decomposition
        EigenvalueDecomposition e = matrix2.eig();
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

        List<Integer> BEARINGS_AND_DIPS = new ArrayList<Integer>();// initialize a list to store bearings and dips
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

        
     StressCalculation compute =new StressCalculation();
     
     System.out.println("Bearings and Dips" +EigenvectorList);
     
      System.out.println("Index " +max);
     
        
        

    }
    
}
