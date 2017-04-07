
import Jama.Matrix;
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
public class NewClass {

    public static void main(String[] args) {
        Matrix matrixA = new Matrix(new double[][]{
            {12.4800, -1.8800, -6.7000},
            {-1.8800, 26.7000, 4.3200},
            {-6.7000, 4.3200, 21.2000}}
        );

        Matrix matrix;
        matrix = new Matrix(new double[][]{
            {32.6, 1.1, -10.7},
            {1.1, 58.7, -11.1},
            {-10.7, -11.1,1.6 }}
        );

        // DoubleMatrix matrixB = new DoubleMatrix((List<Double>) matrix);
        DoubleMatrix matrixB = new DoubleMatrix(new double[][]{
            {32.6, 1.1, -10.7},
            {1.1, 58.7, -11.1},
            {-10.7, -11.1,1.6 }}
        );
        
        
         Matrix matrix2;
        matrix2 = new Matrix(new double[][]{
            {38.8, -4.3},
            {-4.3, 5.5}}
            
        );


        StressCalculation compute = new StressCalculation();
        List<Double> BEARINGS_AND_DIPS = compute.getDCSBearingAndDips(matrix);

        System.out.println("S1=" + compute.getPrincipalEigenvalues(matrixB).get(2));
        System.out.println("S2=" + compute.getPrincipalEigenvalues(matrixB).get(1));
        System.out.println("S3=" + compute.getPrincipalEigenvalues(matrixB).get(0));

        System.out.println(" BS1 = " + BEARINGS_AND_DIPS.get(2));
        System.out.println("BS2 = " + BEARINGS_AND_DIPS.get(1));
        System.out.println(" BS3 =" + BEARINGS_AND_DIPS.get(0));

        System.out.println(" DIPS1 = " + BEARINGS_AND_DIPS.get(5));

        System.out.println(" DIPS2 =" + BEARINGS_AND_DIPS.get(4));
        System.out.println(" DIPS3 =" + BEARINGS_AND_DIPS.get(3));
        
         System.out.println(" horizontal =" + compute.getHorizontalEigenvectors(matrix2));

        // System.out.println("Bearing and dips" + compute.getEUNBearingAndDips(matrix));
    }

}
