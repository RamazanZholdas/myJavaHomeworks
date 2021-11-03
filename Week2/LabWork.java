package com.company;

import java.util.Scanner;

public class LabWork {
    public static void main(String[] args) {
        String carName = new String("Car");
        int maxSpeed = 900;
        int x=1,y=1;
        System.out.println(x+y);
        int z=x+y;
        System.out.println(z);
        int a,b,c;
        int d = 9;
        float fl = 8.9f;
        char letter = 'A';
        String anotherWord = "Hello IITU";
        /*
        There are 2 types data in java, first is primitive, second is non-primitive,
        1)int, float, double, boolean, char and etc. all of this belong to
        primitive type of data
        2)String, array and others belong to non-primitive
         */
        double db = 3.14;
        int ye = (int) db;
        Scanner scan = new Scanner(System.in);
        System.out.println("What's ur name? ");
        String name = scan.nextLine();
        System.out.println("Hello " + name);
        System.out.println("Enter a 2 number pls:");
        int first = scan.nextInt(),second = scan.nextInt();
        System.out.println(first+second);
        System.out.println(first-second);
        System.out.println(first*second);
        System.out.println(first/second);
    }
}
