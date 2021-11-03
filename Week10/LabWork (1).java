package com.company;

import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
Lab work 10 Zholdas Ramazan ITIS - 1913r
 */
public class LabWork {
    public static void main(String[] args) throws InterruptedException{
        //Task 1
        Scanner s = new Scanner(System.in);
        System.out.println("Welcome to laboratory work 10!");
        System.out.println("Pls input a number:");
        int number = s.nextInt();
        s.nextLine();
        Map<Integer, String> phoneKeyboard = new LinkedHashMap<>();
        phoneKeyboard.put(2,"abc");
        phoneKeyboard.put(3,"def");
        phoneKeyboard.put(4,"ghi");
        phoneKeyboard.put(5,"jkl");
        phoneKeyboard.put(6,"mno");
        phoneKeyboard.put(7,"pqrs");
        phoneKeyboard.put(8,"tuv");
        phoneKeyboard.put(9,"wxyz");
        List<Integer> arr = new LinkedList<>();
        for(int i = 0; i < Integer.toString(number).length(); i++){
            for (Map.Entry<Integer,String> entry : phoneKeyboard.entrySet()){
                if(entry.getKey() == Character.getNumericValue(Integer.toString(number).toCharArray()[i])){
                    arr.add(entry.getKey());
                }
            }
        }
        for(int i = 0; i < phoneKeyboard.get(arr.get(0)).length(); i++){
            for(int j = 0; j < phoneKeyboard.get(arr.get(1)).length(); j++){
                System.out.println(phoneKeyboard.get(arr.get(0)).charAt(i) + "" + phoneKeyboard.get(arr.get(1)).charAt(j));
            }
        }
        System.out.println("Task 1 is over");
        //Task 2
        Task2Execution task = new Task2Execution();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                task.firstThread();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                task.secondThread();
            }
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println("Task 2 is over");
    }
}

class Task2Execution{
    private void lotoForFirstTicket(){
        List<Integer> list = new LinkedList<>();
        boolean lock = true;
        for(int i = 0; i < 7; i++){
            list.add(1 + (int) (Math.random() * (91)));
        }
        while (lock) {
            if (list.size() == 0) {
                lock = false;
            }
            int random = 1 + (int) (Math.random() * (91));
            if(list.contains(random)){
                list.remove((Integer) random);
                System.out.println("Number " + random + " matches with number in the first ticket");
            }
        }
        System.out.println("First thread is over!");
    }

    private void lotoForSecondTicket(){
        List<Integer> list = new LinkedList<>();
        boolean lock = true;
        for(int i = 0; i < 7; i++){
            list.add(1 + (int) (Math.random() * (91)));
        }
        while (lock) {
            if (list.size() == 0) {
                lock = false;
            }
            int random = 1 + (int) (Math.random() * (91));
            if(list.contains(random)){
                list.remove((Integer) random);
                System.out.println("Number " + random + " matches with number in the second ticket");
            }
        }
        System.out.println("Second thread is over!");
    }

    public void firstThread(){
        lotoForFirstTicket();
    }

    public void secondThread(){
        lotoForSecondTicket();
    }
}



/*
CountDownLatch countDownLatch = new CountDownLatch(1);
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for(int i = 0; i < 2; i++){
            executorService.submit(new Task2(countDownLatch));
        }
        executorService.shutdown();
        countDownLatch.await();
        System.out.println("Task 2 is over!");

System.out.println("Welcome to laboratory work 10!");
        System.out.println("Pls input a number:");
        int number = s.nextInt();
        s.nextLine();
        Map<Integer, String> phoneKeyboard = new LinkedHashMap<>();
        phoneKeyboard.put(2,"abc");
        phoneKeyboard.put(3,"def");
        phoneKeyboard.put(4,"ghi");
        phoneKeyboard.put(5,"jkl");
        phoneKeyboard.put(6,"mno");
        phoneKeyboard.put(7,"pqrs");
        phoneKeyboard.put(8,"tuv");
        phoneKeyboard.put(9,"wxyz");
        List<Integer> arr = new LinkedList<>();
        for(int i = 0; i < Integer.toString(number).length(); i++){
            for (Map.Entry<Integer,String> entry : phoneKeyboard.entrySet()){
                if(entry.getKey() == Character.getNumericValue(Integer.toString(number).toCharArray()[i])){
                    arr.add(entry.getKey());
                }
            }
        }
        for(int i = 0; i < arr.stream().reduce((acc, b) -> acc * b).get(); i++){

        }

        private static int countDown1 = 7;
    private static int countDown2 = 7;
    private static Random random = new Random();
    private static Lock synchronazier = new ReentrantLock();

        static void ticketGenerator1(){
        synchronazier.lock();
        matcher1(random.nextInt(100));
        synchronazier.unlock();
    }

    static void ticketGenerator2(){
        synchronazier.lock();
        matcher2(random.nextInt(100));
        synchronazier.unlock();
    }

    static private void matcher1(int number){
        int generatedNumber = random.nextInt(100);
        if (number == generatedNumber) {
            countDown1--;
        }
    }

    static private void matcher2(int number){

    }
        */
