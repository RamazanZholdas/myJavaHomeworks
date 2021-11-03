package com.company;

import java.util.*;

/*
LAB 8 Zholdas Ramazan from IT IS - 1913
 */

public class LabWork {
    public static void main(String[] args){
        System.out.println("Task 1:");
        List<Integer> list1 = new LinkedList<>();
        List<Integer> list2 = new LinkedList<>();
        list1.add(2);
        list1.add(4);
        list1.add(3);
        list2.add(5);
        list2.add(6);
        list2.add(4);
        System.out.println(ProblemSolver4Lab8.firstTask(list1,list2));
        System.out.println("Task 2:");
        List<Integer> list3 = new LinkedList<>();
        List<Integer> list4 = new LinkedList<>();
        list3.add(1);
        list3.add(2);
        list3.add(4);
        list4.add(1);
        list4.add(3);
        list4.add(4);
        System.out.println(ProblemSolver4Lab8.secondTask(list3,list4));
        System.out.println("Task 3:");
        List<Integer> arr1 = new LinkedList<>();
        arr1.add(1);
        arr1.add(0);
        arr1.add(-1);
        arr1.add(0);
        arr1.add(-2);
        arr1.add(2);
        System.out.println(ProblemSolver4Lab8.thirdTask(arr1,0));
    }
}

class ProblemSolver4Lab8{
    static List<Integer> firstTask(List<Integer> list1, List<Integer> list2){
        Collections.reverse(list1);
        Collections.reverse(list2);
        StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder();
        StringBuilder num3 = new StringBuilder();
        for(int x : list1){
            num1.append(x);
        }
        for (int x : list2){
            num2.append(x);
        }
        num3.append(Integer.parseInt(num1.toString()) + Integer.parseInt(num2.toString()));
        char[] arr = num3.reverse().toString().toCharArray();
        List<Integer> arr2 = new LinkedList<>();
        for(char x : arr){
            arr2.add(Integer.parseInt(Character.toString(x)));
        }
        return arr2;
    }

    static List<Integer> secondTask(List<Integer> list1, List<Integer> list2){
        List<Integer> arr = new LinkedList<>(list1);
        arr.addAll(list2);
        Collections.sort(arr);
        return arr;
    }

    static List<String> thirdTask(List<Integer> arr1, int target){
        List<String> answer = new LinkedList<>();
        for(int i = 0; i < arr1.size(); i++){
            for(int j = 0; j < arr1.size(); j++){
                for (int k = 0; k < arr1.size(); k++){
                    for(int l = 0; l < arr1.size(); l++){
                        if(arr1.get(i) + arr1.get(j) + arr1.get(k) + arr1.get(l) == target){
                            if(i != j && i != k && i != l && j != l && j != k && l != k){
                                int[] arr = new int[4];
                                arr[0] = arr1.get(i);
                                arr[1] = arr1.get(j);
                                arr[2] = arr1.get(k);
                                arr[3] = arr1.get(l);
                                Arrays.sort(arr);
                                if(!answer.contains(Arrays.toString(arr))){
                                    answer.add(Arrays.toString(arr));
                                }
                            }
                        }
                    }
                }
            }
        }
        return answer;
    }
}




