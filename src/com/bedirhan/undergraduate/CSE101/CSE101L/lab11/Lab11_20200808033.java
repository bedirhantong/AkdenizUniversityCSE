package com.bedirhan.undergraduate.CSE101.CSE101L.lab11;

public class Lab11_20200808033 {
    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3},
                {6,5,4}
        };
        convert(arr);
    }

    public static void convert( int[][] arr){

        int w = 0;
        int x = arr.length-1;
        int y = 0;
        int z = arr[0].length-1;
        while(w <= x && y <= z){

            for (int i = w; i <= z; i++) {
                System.out.print(arr[w][i] + " ");
            }
            for (int i = w+1; i <= x; i++) {
                System.out.print(arr[i][z] + " ");
            }
            if(w+1 <= x){
                for (int i = z-1; i >= y; i--) {
                    System.out.print(arr[x][i] + " ");
                }
            }
            if(y+1 <= z){
                for (int i = x-1; i > w; i--) {
                    System.out.print(arr[i][y] + " ");
                }
            }
            w++;
            x--;
            y++;
            z--;
        }

    }
}

