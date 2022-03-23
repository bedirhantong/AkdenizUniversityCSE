package com.bedirhan.undergraduate.CSE101.CSE101L.lab02;

/**
 * @author Bedirhan Tonğ (20200808033)
 * @version 08.10.2021
 */

import java.util.Scanner;

public class Lab02_20200808033 {
    public static void main(String[] args) {
        System.out.println("----Rectangular Prizm----");
        Scanner inp= new Scanner(System.in);
        int volume,totalSurfaceArea,totalEdgeLength;

        System.out.print("Enter Length: ");
        int length = inp.nextInt();
        System.out.print("Enter width: ");
        int width = inp.nextInt();
        System.out.print("Enter height: ");
        int height= inp.nextInt();

        System.out.println("1-Calculate volume \n2-Calculate total surface area \n3-Calculate the total edge length");
        System.out.print("Choose an operation: ");
        int operation = inp.nextInt();
        if (operation == 1)
        {
            volume=height*length*width;
            System.out.println("Volume: "+volume);
        }
        else if ( operation == 2 )
        {
            totalSurfaceArea=2*( (width*length) + (width*height) + (length*height) );
            System.out.println("Total Surface Area : "+totalSurfaceArea);
        }

        else if ( operation == 3)
        {
            totalEdgeLength=4*( width+length+height );
            System.out.println("Total Edge Length: "+totalEdgeLength);
        }
        else
        {
            System.out.println("Invalid operation! Please try again later.");
        }

    }
}

