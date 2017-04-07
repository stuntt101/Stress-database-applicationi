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
      int N = 3;

      // create a symmetric positive definite matrix
      //Matrix A = Matrix.random(N, N);
      
       double[][] vals = {{12.48, -1.88, -6.7},
                          {-1.88, 26.7, 4.32},
                          {-6.7, 4.32, 21.2}};
       
       
           
       
      // create a symmetric positive definite matrix
      Matrix A = new Matrix(vals);
      A = A.transpose().times(A);

      // compute the spectral decomposition
      EigenvalueDecomposition e = A.eig();
      Matrix V = e.getV();
      Matrix D = e.getD();

      System.out.print("A =");
      A.print(9, 6);
      System.out.print("D =");
      D.print(9, 6);
      System.out.print("V =");
      V.print(9, 6);

      // check that V is orthogonal
      System.out.print("||V * V^T - I|| = ");
      System.out.println(V.times(V.transpose()).minus(Matrix.identity(N, N)).normInf());

      // check that A V = D V
      System.out.print("||AV - DV|| = ");
      System.out.println(A.times(V).minus(V.times(D)).normInf());
      
      
   }

}