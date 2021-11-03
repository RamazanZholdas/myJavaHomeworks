package com.company;

import java.util.Scanner;
import java.math.*;

public class LabWork {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Are u ready? press enter if yes");
        String enter = s.nextLine();
        System.out.println("Enter a number");
        double first = s.nextDouble();
        if(first>=0){
            System.out.println("Positive");
        }
        else{
            System.out.println("Negative");
        }
        /*
        #2
         */
        System.out.println("Pls enter a 3 value: ");
        double second = s.nextDouble(),third = s.nextDouble(),fouth = s.nextDouble();
        if(second >= third && second >= fouth){
            System.out.println(second);
        }
        else if(third >= second && third >= fouth){
            System.out.println(third);
        }
        else{
            System.out.println(fouth);
        }
        /*
        #3
         */
        System.out.println("Input month: ");
        int month = s.nextInt();
        System.out.println("Input year");
        int year = s.nextInt();
        int maxDays;
        int feb = 28;
        if((year % 4 == 0 && (year % 100 != 0) ) || (year % 400 == 0)){
            feb++;
        }
        if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12){
            maxDays = 31;
        }
        else{
            maxDays= 30;
        }
        switch (month) {
            case 1:
                System.out.println("January " + year + " has " + maxDays +" days" );
                break;
            case 2:
                System.out.println("February " + year + " has " + feb +" days");
                break;
            case 3:
                System.out.println("March " + year + " has " + maxDays +" days" );
                break;
            case 4:
                System.out.println("April " + year + " has " + maxDays +" days" );
                break;
            case 5:
                System.out.println("May " + year + " has " + maxDays +" days" );
                break;
            case 6:
                System.out.println("June " + year + " has " + maxDays +" days" );
                break;
            case 7:
                System.out.println("July " + year + " has " + maxDays +" days" );
                break;
            case 8:
                System.out.println("August " + year + " has " + maxDays +" days" );
                break;
            case 9:
                System.out.println("September " + year + " has " + maxDays +" days" );
                break;
            case 10:
                System.out.println("October " + year + " has " + maxDays +" days" );
                break;
            case 11:
                System.out.println("November " + year + " has " + maxDays +" days" );
                break;
            case 12:
                System.out.println("December " + year + " has " + maxDays +" days" );
                break;
            default:
                System.out.println("Invalid Input");
                break;
        }
        /*
        #4
         */
        System.out.println("Pls input a, b, c for quadratic equations");
        double a = s.nextDouble(),b = s.nextDouble(),c = s.nextDouble(),D,x1,x2;
        if(Math.pow(b,2) - 4*a*c > 0){
            x1 = (-b + Math.sqrt(Math.pow(b,2) - 4*a*c)) / (2*a);
            x2 = (-b - Math.sqrt(Math.pow(b,2) - 4*a*c)) / (2*a);
            System.out.println("x1 = " + x1 + " \n " + "x2 = " + x2);
        }
        else if(Math.pow(b,2) - 4*a*c == 0){
            x1 = -b/ (2 * a);
            System.out.println("x = " + x1);
        }
        else{
            System.out.println("No roots");
        }
        /*
        #5
         */
        System.out.println("Enter a value: ");
        double var = s.nextDouble();
        if(var > 0){
            if(var > 1000000){
                System.out.println("Large Positive");
            }
            else{
                System.out.println("Positive");
            }
        }
        else if(var < 0){
            if(-var < 1){
                System.out.println("Small Negative");
            }
            else {
                System.out.println("Negative");
            }
        }
        else{
            System.out.println("zero");
        }
        /*
        #6
         */
        System.out.println("Enter a number of weekend");
        int day = s.nextInt();
        switch (day){
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            default:
                System.out.println("Indalid input");
                break;
        }
        /*
        #7
         */
        System.out.println("Pls enter a character: ");
        char letter = s.next().charAt(0);
        if((letter >= 65 && letter <= 90) || (letter >= 97 && letter <= 122)){
            Character.toLowerCase(letter);
            if(letter == 97 || letter == 101 || letter == 105 || letter == 111 || letter == 117 || letter == 121){
                System.out.println("Vowel");
            }
            else {
                System.out.println("Consonant");
            }
        }
        else{
            System.out.println("Invalid input");
        }
        /*
        #8
         */
        System.out.println("Pls enter a year: ");
        long yeara = s.nextLong();
        if((yeara % 4 == 0 && (yeara % 100 != 0) ) || (yeara % 400 == 0)){
            System.out.println(yeara + " is a leap year");
        }
        else {
            System.out.println(yeara + " is not a leap year");
        }
        /*
        #9
         */
        System.out.println("Input the number of terms");
        int term1 = s.nextInt();
        for(int i = 1; i <= term1; i++){
            System.out.println("Number is : " + i + " and cube of " + i + " is : " + Math.round(Math.pow(i,3)));
        }
        /*
        #10
         */
        System.out.print("Input number of terms is: ");
        int term = s.nextInt();
        for(int i = 1; i <= term; i++){
            System.out.println(2 * i - 1);
        }
        System.out.println("The Sum of odd Natural Number upto 5 terms is: "+Math.round(Math.pow(term,2)));
        System.out.println("Yoy have finally finished the lab. work");
    }
}
