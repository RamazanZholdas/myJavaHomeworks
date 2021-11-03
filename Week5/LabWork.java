package com.company;

import java.util.*;
/*
LAB 5
Zholdas Ramazan from IT IS - 1913R
 */

public class LabWork {
    public static void main(String[] args) {
        /*
        #1
         */
        Scanner s = new Scanner(System.in);
        int[] FirstArray = new int[5];
        for(int i = 0; i < FirstArray.length; i++){
            FirstArray[i] = 5 + (int) (Math.random() * ((100 - 10) + 1));
        }
        System.out.println("This is ur current array: " + Arrays.toString(FirstArray));
        System.out.println("Pls input ur target: ");
        int target = s.nextInt();
        System.out.println(Arrays.toString(ProblemSolver.targetNumbarVan(FirstArray,target)));
        /*
        #2
         */
        System.out.println("Input a number: ");
        int palindrome = s.nextInt();
        System.out.println(ProblemSolver.palindromFinder(palindrome));
        /*
        #3
         */
    }
}


class ProblemSolver{
    public static int[] targetNumbarVan(int[] arr,int target){
        int[] answer = new int[2];
        for(int i = 0; i < arr.length - 1; i++){
            if(arr[i] + arr[i+1] == target){
                answer[0] = i;
                answer[1] = i + 1;
                break;
            }
        }
        if(answer[0] == 0 && answer[1] == 0){
            return null;
        }
        else{
            return answer;
        }
    }

    public static boolean palindromFinder(int num){
        int counter = 0;
        if(num < 0){
            return false;
        }
        int duplicat = num,duplicat2 = num;
        while (duplicat > 0){
            duplicat /= 10;
            counter++;
        }
        String result = "";
        int i = counter;
        while (i > 0){
            result += num%10;
            num /= 10;
            i--;
        }
        return Integer.parseInt(result) == duplicat2;
    }
}