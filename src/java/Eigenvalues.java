/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LQwabe
 */
import Jama.Matrix;
import Jama.EigenvalueDecomposition;

public class Eigenvalues {
   public static void main(String[] args) { 
      int N = 5;

      // create a symmetric positive definite matrix
      //Matrix A = Matrix.random(N, N);
      
       double[][] vals = {{12.48, -1.88, -6.7},
                          {-1.88, 26.7, 4.32},
                          {-6.7, 4.32, 21.2}};
       
       
           
       
      Matrix A = new Matrix(vals);
      
      Matrix V = new Matrix(new double[][]{
            {12.4800,  -6.7000},
            {-6.7000,  21.2000}}
        );
      
      V = V.transpose().times(V); 

      // compute the spectral decomposition
      EigenvalueDecomposition e = V.eig();
       V = e.getV().uminus();
      

      System.out.print("A =");
      V.print(9, 6);
      
      System.out.print("V =");
      V.print(9, 6);
      
      System.out.print("n2x =");
      Double n2x=V.get(0, 0);
      System.out.print(n2x);
      
      
   }

}