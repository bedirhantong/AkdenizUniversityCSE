package com.bedirhan.undergraduate.CSE102.CSE102L.Ex01;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Ex01_20200808033 {
    public static void main(String[] args) {
        // Do NOT edit here

        System.out.print("Enter dimensions of matrix to create: ");
        Scanner scanner = new Scanner(System.in);

        int m = scanner.nextInt();
        int n = scanner.nextInt();

        double[][] matrix = makeMatrix(m, n);

        System.out.println();
        printMatrix(matrix);
        System.out.println();

        Locate location1 = locateMax(matrix);
        System.out.println("maxValue: " + location1.maxValue + " is at (" + location1.row + ", " + location1.column + ")");

        System.out.println("-------------------------------------------------------");
        matrix = getMatrix(m, n);

        System.out.println();
        printMatrix(matrix);
        System.out.println();

        Locate location2 = locateMax(matrix);
        System.out.println("maxValue: " + location2.maxValue + " is at (" + location2.row + ", " + location2.column + ")");

    }

    public static Locate locateMax(double[][] matrix) {
        // Complete this method according to assignment
        double max = matrix[0][0];
        int maxRow = 0;
        int maxCol = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] > max){
                    max = matrix[i][j];
                    maxRow = i;
                    maxCol = j;
                }
            }
        }
        return new Locate(String.valueOf(max),String.valueOf(maxRow),String.valueOf(maxCol));
    }

    public static double[][] makeMatrix(int rows, int columns) {
        // Complete this method according to assignment
        double[][] arr = new double[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                arr[i][j] = ThreadLocalRandom.current().nextDouble(-5, 5 );
            }
        }
        return  arr;
    }

    public static double[][] getMatrix(int rows, int columns) {

        Scanner scanner = new Scanner(System.in);
        double[][] arr = new double[rows][columns];
        int counter = 1;
        for (int i = 0; i < rows; i++) {
            if (counter%10 == 1){
                if (counter == 11){
                    System.out.print("11th row: ");
                }
                else
                    System.out.print(counter+"st row: ");
            }
            else if ( counter%10 == 2){
                if ( counter == 12 ){
                    System.out.print("12th row: ");
                }
                else
                    System.out.print(counter+"nd row: ");
            }
            else if (counter%10 == 3){
                if (counter == 13){
                    System.out.print("13th row: ");
                }
                else
                    System.out.print(counter+"rd row: ");
            }
            else
                System.out.print(counter+"th row: ");
            for (int j = 0; j < columns; j++) {
                arr[i][j] = scanner.nextDouble();
            }
            counter++;
        }

        return arr;
    }

    public static void printMatrix(double[][] matrix) {
        // Complete this method according to assignment
        for (double[] doubles : matrix) {
            for (double aDouble : doubles) {
                System.out.print(String.format("%8.2f", aDouble));
            }
            System.out.println();
        }
    }
}

class Locate {
    public String maxValue;
    public String row;
    public String column;
    public Locate(String maxValue, String row, String column) {
        this.maxValue = maxValue;
        this.row = row;
        this.column = column;
    }


    // Complete this class according to assignment


}
