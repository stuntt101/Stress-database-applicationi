
import Jama.Matrix;
import com.stressmeasurement.entity.StressMeasurement;
import com.stressmeasurement.service.StressMeasurementService;
import com.stressmeasurement.service.StressCalculation;
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
public class Test {

    public static void main(String[] args) {
        Matrix matrixA = new Matrix(new double[][]{
            {12.4800, -1.8800, -6.7000},
            {-1.8800, 26.7000, 4.3200},
            {-6.7000, 4.3200, 21.2000}}
        );
        DoubleMatrix matrixB = new DoubleMatrix(new double[][]{
            {12.4800, -1.8800, -6.7000},
            {-1.8800, 26.7000, 4.3200},
            {-6.7000, 4.3200, 21.2000}}
        );
        
        DoubleMatrix matrixC = new DoubleMatrix(new double[][]{
            {12.4800,  -6.7000},
            {-6.7000,  21.2000}}
        );
        Matrix matrixD = new Matrix(new double[][]{
            {12.4800,  -6.7000},
            {-6.7000,  21.2000}}
        );

        StressCalculation compute = new StressCalculation();

        System.out.println("Principal EigenValues" + compute.getPrincipalEigenvalues(matrixC));
        System.out.println("S1=" + compute.getPrincipalEigenvalues(matrixB).get(2));
         System.out.println("S2=" + compute.getPrincipalEigenvalues(matrixB).get(1));
          System.out.println("S3=" + compute.getPrincipalEigenvalues(matrixB).get(0));
         
       // System.out.println("#");
        //System.out.println("BSH1  " + compute.getBearings(matrixD));
        //System.out.println("Bearing and dips" + compute.getBearingAndDips(matrixA));
    }
}
