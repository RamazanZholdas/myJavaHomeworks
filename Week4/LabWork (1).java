package com.company;

import java.util.*;
/*
LAB 4
Zholdas Ramazan from IT IS - 1913R
 */

public class LabWork {
    public static void main(String[] args) {
        /*
        #1
         */
        Scanner s = new Scanner(System.in);
        int[] FirstArray = new int[10];
        for(int i = 0; i < FirstArray.length; i++){
            FirstArray[i] = 5 + (int) (Math.random() * ((100 - 10) + 1));
        }
        System.out.println("This is ur current array: " + Arrays.toString(FirstArray));
        for(int i = FirstArray.length-1; i > 0 ; i--) {
            for (int j = 0; j < i; j++) {
                if (FirstArray[j] > FirstArray[j + 1]) {
                    int x = FirstArray[j];
                    FirstArray[j] = FirstArray[j + 1];
                    FirstArray[j + 1] = x;
                }
            }
        }
        System.out.println("Array after buble sort: " + Arrays.toString(FirstArray));
        System.out.println("");
        /*
        #2
         */
        int[] SecondArray = new int[10];
        for(int i = 0; i < SecondArray.length; i++){
            SecondArray[i] = 5 + (int) (Math.random() * ((100 - 10) + 1));
        }
        System.out.println("This is ur current array: " + Arrays.toString(SecondArray));
        int sum = 0;
        for(int x : SecondArray){
            sum+=x;
        }
        System.out.println("This is the sum of array: " + sum);
        System.out.println("");
        /*
        #3
         */
        String carpet = "";
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                carpet += "-";
            }
            carpet += "\n";
        }
        System.out.println(carpet);
        System.out.println("");
        /*
        #4
         */
        int[] ThirdArray = new int[10];
        for(int i = 0; i < ThirdArray.length; i++){
            ThirdArray[i] = 5 + (int) (Math.random() * ((100 - 10) + 1));
        }
        System.out.println("This is ur current array: " + Arrays.toString(ThirdArray));
        double sum2 = 0;
        for(int x : ThirdArray){
            sum+=x;
        }
        System.out.println("This is the average sum of array: " + sum/ThirdArray.length);
        System.out.println("");
        /*
        #5
         */
        int[] FourthArray = new int[10];
        for(int i = 0; i < FourthArray.length; i++){
            FourthArray[i] = 5 + (int) (Math.random() * ((100 - 10) + 1));
        }
        System.out.println("This is ur current array: " + Arrays.toString(FourthArray));
        System.out.println("Pls input some value and program will find same value: ");
        int specificVariable = s.nextInt();
        boolean contain = false;
        for(int x : FourthArray){
            if(specificVariable == x){
                contain = true;
            }
        }
        if(contain){
            System.out.println("Yes, ur array contain this value ");
        }
        else {
            System.out.println("No, ur array dont have this value ");
        }
        System.out.println("");
        /*
        #6
         */
        int[] FifthArray = new int[10];
        for(int i = 0; i < FifthArray.length; i++){
            FifthArray[i] = 5 + (int) (Math.random() * ((100 - 10) + 1));
        }
        System.out.println("This is ur current array: " + Arrays.toString(FifthArray));
        System.out.println("Pls input some value and program will find the index of it: ");
        int hz = s.nextInt();
        int tryCounter = 0,saver = 101;
        for(int x : FifthArray){
            if(hz == x){
                saver = tryCounter;
            }
            tryCounter++;
        }
        if(saver == 101){
            System.out.println("There is no value");
        }
        else{
            System.out.println("Index of ur value is: " + saver);
        }
        /*
        #7
         */
        int[] SixthArray = new int[10];
        for(int i = 0; i < SixthArray.length; i++){
            SixthArray[i] = 5 + (int) (Math.random() * ((100 - 10) + 1));
        }
        System.out.println("This is ur current array: " + Arrays.toString(SixthArray));
        System.out.println("Input a value: ");
        int z = s.nextInt();
        System.out.println("Input an index of array(in range of 0 and 9) ");
        int index = s.nextInt();
        if(index < 0 && index > 10){
            System.out.println("Invalid input");
        }
        else{
            SixthArray[index] = z;
            System.out.println("Ur array: " + Arrays.toString(SixthArray));
        }
        System.out.println("");
        /*
        #8
         */
        int[] SeventhArray = new int[10];
        for(int i = 0; i < SeventhArray.length; i++){
            SeventhArray[i] = 5 + (int) (Math.random() * ((100 - 10) + 1));
        }
        System.out.println("This is ur current array: " + Arrays.toString(SeventhArray));
        int min = SeventhArray[0],max = SeventhArray[0];
        for(int x : SeventhArray){
            if(x < min) {
                min = x;
            }
            else if(x > max) {
                max = x;
            }
        }
        System.out.println("Ur max value: " + max + " " + "Ur min value: " + min);
        System.out.println("");
        /*
        #9
         */
        int[] EightArray = new int[10];
        for(int i = 0; i < EightArray.length; i++){
            EightArray[i] = 5 + (int) (Math.random() * ((100 - 10) + 1));
        }
        System.out.println("This is ur current array: " + Arrays.toString(EightArray));
        int[] replicant = new int[10];

        for(int i = EightArray.length - 1, j = 0; i >= 0; i--,j++){
            replicant[i] = EightArray[j];
        }
        System.out.println("This is ur reversed array: " + Arrays.toString(replicant));
        System.out.println("");
        /*
        #11
         */
        System.out.println("Input 3 number and program will find the smallest");
        int a1 = s.nextInt(),a2 = s.nextInt(),a3 = s.nextInt();
        System.out.println("The smallest number is: " + ProblemSolver.smallestNumber(a1,a2,a3));
        System.out.println("");
        /*
        #12
         */
        System.out.println("Pls input some string and programm will find vowels");
        String str = s.nextLine();
        System.out.println("There a " + ProblemSolver.VowelCounter(str) + " in ur string");
        System.out.println("");
        /*
        #13
         */
        System.out.println("input a 3 number and program will find the average of this 3");
        int b1 = s.nextInt(),b2 = s.nextInt(),b3 = s.nextInt();
        System.out.println("Average of this 3 is equal to: " + ProblemSolver.AverageFinder(b1,b2,b3));
        System.out.println("");
        /*
        #14
         */
        System.out.println("Pls input a int number and program will calculate the sum of digits of it");
        int digit = s.nextInt();
        System.out.println("Sum of digit is: " + ProblemSolver.DigitSum(Integer.toString(digit)));
        System.out.println("");
        /*
        #15
         */
        System.out.println("Pls input some sentence and my program will output the number of words");
        String sentence = s.nextLine();
        System.out.println("Number of words is equal to: " + ProblemSolver.WordCounter(sentence));

    }
}


class ProblemSolver{
    public static int smallestNumber(int a,int b,int c){
        if(a < b && a < c){
            return a;
        }
        else if(b < a && b < c){
            return b;
        }
        else{
            return c;
        }
    }

    public static int VowelCounter(String str){
        int vowelCounter = 0;
        for(char ch : str.toLowerCase().toCharArray()){
            if(ch == 'a' || ch == 'o' || ch == 'e' || ch == 'u' || ch == 'i' || ch == 'y'){
                vowelCounter++;
            }
        }
        return vowelCounter;
    }

    public static int AverageFinder(int a,int b,int c){
        return (a + b + c) / 3;
    }

    public static int DigitSum(String str){
        if(str.length() == 1){
            return Integer.parseInt(str);
        }
        else{
            int sum = 0;
            String[] strArr = str.split("");
            for(String x : strArr){
                sum += Integer.parseInt(x);
            }
            return sum;
        }
    }

    public static int WordCounter(String str){
        String[] strArr = str.split(" ");
        return strArr.length;
    }
}