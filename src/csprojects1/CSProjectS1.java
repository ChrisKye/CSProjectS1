/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csprojects1;
import java.lang.Math;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author chriskye
 */
public class CSProjectS1 {
  
  public static double [][] readCSV(String fileName, int numRows, int numCols) {
      double[][] returnval = new double[numRows][numCols];
      try {
        Scanner scanner = new Scanner(new File(fileName));
        int currentRow = 0;
        while (scanner.hasNext()) {
            String[] temp = scanner.nextLine().split(",");
            System.out.println(temp[0]);
            for (int i = 0; i <numCols; i++) {
                returnval[currentRow][i] = Double.parseDouble(temp[i]);
            }
            currentRow++;
        }
        scanner.close();
      }
      catch(Exception e){
      System.out.println("Error doing stuff");
    }
      return returnval;
  }
  
  
  

    
    
    public static double[][] mult(double[][] x, double[][] y) {
        double[][] res = new double[x.length][y[0].length];
        for(int i=0; i < x.length; i++){    
            for(int j = 0; j < y[0].length;j++) {
                res[i][j] = 0;
                for (int k = 0; k < x[0].length; k++) {
                    res[i][j] += x[i][k]*y[k][j];
                }
            }
        }
        return res;
    }
    
    //Sigmoid hypothesis function
    public static double[][] hypo(double[][] X, double[][] theta) {
        double[][] inner = (mult(X, theta));
        double[][] sigmoidHypo = new double[X.length][1];
        for (int i = 0; i < X.length; i++) {
            sigmoidHypo[i][1] = 1/(1+Math.exp(inner[i][0]));
        }
        return sigmoidHypo;
    }
    //Cost function
    public static double cost(double[][] theta, double[][] h, double[][] y) {
        int m = h.length;
        double jcost = 0;
        for (int i = 0; i < m; i++) {
            jcost += y[i][0]*Math.log(h[i][0]) + (1-y[i][0])*Math.log(1-h[i][0]);
        }
        jcost = -jcost/m;
        
        return jcost;
    }
    //Gradient
    public static double grad(double[][] X, double [][] y, double[][] h, int thetIndex) {
        int m = y.length;
        double gradient = 0;
        for (int i = 0; i < m; i++) {
            gradient += (h[i][0] - y[i][0])*X[i][thetIndex];
        }
        gradient /= m;
        return gradient;
    }
    //Gradient Descent
    public static double[][] gradDesc(double[][] X, double[][] y, double[][] theta, double alpha, int num_iter) {
        int m = y.length;
        int n = theta.length;
        for (int i = 0; i < num_iter; i++) {
            double[][] h = hypo(X,theta);
            for (int j = 0; j < n; j++) {
                theta[j][0] -= alpha*grad(X,y,h,j);
            }
            double[][] h1 = hypo(X,theta);
            double cost = cost(theta, h1, y);
            System.out.print(cost);
        }
        return theta;
    }
    
    public static void predictor(double[][] X, double[][] theta, double[][] y) {
        int m = X.length;
        double[][] h = hypo(X, theta);
        double[] pred = new double[m];
        int correct = 0;
        for (int i = 0; i < m; i++) {
            if (h[i][0] >= 0.5) pred[i] = 1;
            else pred[i] = 0;
            if (pred[i] == y[i][0]) correct++;
        }
        System.out.println("Predicted " + correct + " cases, from " + m);
        System.out.println("Total Accuracy: " + correct/m);
    }
    
    
    //
    public static void main(String[] args) {
        // TODO code application logic here
        double[][] X = new double[100][2];
        double[][] y = new double[100][1];
        double[][] col1 = readCSV("test.csv", 10, 3);
       
//        for (int i = 0; i < 10; i++)
//        {
//          System.out.println(col1[i][0]);
//        }
        
        
    }
    
}
