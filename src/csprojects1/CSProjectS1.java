/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csprojects1;
import java.lang.Math;

/**
 *
 * @author chriskye
 */
public class CSProjectS1 {

    /**
     * @param args the command line arguments
     */
    //Feature Engineering
    //Matrix Mult function
    public static double[][] mult(double[][] x, double[][] y) {
        double[][] res = new double[x.length][y[0].length];
        for (int i = 0; i < x.length; i++) { //loop over rows of x
            for (int j = 0; j < x[0].length; j++) { //loop over column in each row of x
                double rowsum = 0.0;
                int k;
                for (k = 0; k < y[0].length; k++){ //loop over columns of y
                    rowsum += x[i][j]*y[j][k];
                }
                res[i][k] = rowsum;
            }
        }
        return res;
    }
    
    public static double[][] mult2(double[][] x, double[][] y) {
        double[][] res = new double[x.length][y[0].length];
        for(int i=0;i<x.length;i++){    
            for(int j = 0; i < y[0].length;j++) {
                res[i][j] = 0;
                for (int k=0;k<x[0].length;k++) {
                    res[i][j] += x[i][k]*y[k][j];
                }
            }
        }
        return res;
    }
    
    //Sigmoid hypothesis function
    public static double hypo(double[][] x, double[][] theta) {
        double[][] inner = mult(x, theta);
        double sigmoidHypo = 1/(1+Math.exp(inner[0][0]));
        return sigmoidHypo;
    }
    //Cost function
    //Gradient Descent
    //
    public static void main(String[] args) {
        // TODO code application logic here
        double[][] a = {
            {1,2,3},
        };
        double[][] b = {
            {4},
            {5},
            {6}
        };
        
        System.out.print(mult2(a,b));
        
        
    }
    
}
