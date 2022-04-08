import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[100];
        createArr(arr);
        Scanner scan= new Scanner(System.in);
        System.out.print("enter a num: ");
        int num = scan.nextInt();
        if (isHereOrIllegal(arr,num)){
            System.out.println("Yeah we found it and it is : "+num);
        }
        else
            throw new ArrayIndexOutOfBoundsException("Out Of Bounds");
    }
    public static boolean isHereOrIllegal(int[] arr,int num){
        for (int j : arr) {
            if (j == num || num<0) {
                return true;
            }
        }
        return false;
    }
    public static void createArr(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random()*1000000);
        }
    }

}
