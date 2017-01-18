
import com.stressmeasurement.entity.StressMeasurement;
import com.stressmeasurement.service.StressMeasurementService;
import com.stressmeasurement.service.StressResult;
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
     DoubleMatrix matrix = new DoubleMatrix(new double[][]{
            {12.4800, -1.8800, -6.7000},
            {-1.8800, 26.7000, 4.3200},
            {-6.7000, 4.3200, 21.2000}}
        );
        
     StressResult compute =new StressResult();
     
     
     //System.out.println("Principal EigenValues"+compute.getPrincipalEigenValues(matrix));
    // System.out.println("#");
    // System.out.println("Principal EigenVectors"+compute.getPrincipalEigenVectors(matrix));
    //System.out.println("Principal EigenVectors"+compute.getPrincipalEigenVectors(matrix));
        

    }
}
