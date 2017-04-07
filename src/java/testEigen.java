
import java.util.Arrays;
import org.jblas.ComplexDoubleMatrix;
import org.jblas.DoubleMatrix;
import org.jblas.Eigen;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LQwabe
 */
public class testEigen {
    
     public static void main(String[] args) {
      DoubleMatrix mt = new DoubleMatrix(new double[][]{
            {1.6, -10.7, -11.1},
            {-10.7, 32.6, 1.1},
            {-11.1, 1.1, 58.7}}
        );
     
        // DoubleMatrix mt=new DoubleMatrix(src);
  DoubleMatrix covariance=mt.mmul(mt.transpose()).div(mt.columns);
  ComplexDoubleMatrix eigVal=Eigen.eigenvalues(covariance);
  ComplexDoubleMatrix[] eigVector=Eigen.eigenvectors(covariance);
  System.out.println(eigVal);
  System.out.println(Arrays.toString(eigVector));
  ComplexDoubleMatrix cvec=eigVector[0];
  for (int i=0; i < eigVal.length - 1; i++) {
    for (int j=0; j < eigVal.length - i - 1; j++) {
      double j1=eigVal.get(j).real();
      double j2=eigVal.get(j + 1).real();
      if (j2 > j1) {
        cvec.swapColumns(j,j + 1);
        eigVal.swapRows(j,j + 1);
      }
    }
  }
  cvec=cvec.transpose();
  System.out.println(cvec);
  DoubleMatrix mt2=cvec.getReal();
  mt2=mt2.getRange(0,1,0,mt2.columns);
  System.out.println(mt2.mmul(mt));
 // System.out.println(PCA.dimensionReduction(mt,1));
         
     
     
     }
    
}
