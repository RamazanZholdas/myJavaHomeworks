package com.company;

import java.util.*;
/*
LAB 6
Zholdas Ramazan from IT IS - 1913R
 */
public class Test {
    public static void main(String[] args) {
       boolean globalLock = true;
       while (globalLock){
           SystemIn2 halykBank = new SystemIn2();
           List<String> nameList = new LinkedList<>();
           List<String> lastNameList = new LinkedList<>();
           Scanner s = new Scanner(System.in);
           System.out.println("This is a simulation here you can create people and register them in Halykbank");
           int choice1;
           boolean lock = true;
           while (lock){
               System.out.println("1)Create person \n" +
                       "2)Register person to bank \n" +
                       "3)Get into the bank system \n" +
                       "4)Show everyone\n" +
                       "You can chose one of this option");
               choice1 = s.nextInt();
               switch (choice1){
                   case 1:
                       s.nextLine();
                       System.out.println("Set name: ");
                       String name = s.nextLine();
                       System.out.println("Set last name: ");
                       String lastName = s.nextLine();
                       nameList.add(name);
                       lastNameList.add(lastName);
                       break;
                   case 2:
                       if(nameList.size() == 0){
                           System.out.println("There is no people");
                           break;
                       }
                       System.out.println("People list:");
                       for(int i = 0, j = 1; i < nameList.size(); i++, j++){
                           System.out.println(j + ")" + nameList.get(i) + " " + lastNameList.get(i));
                       }
                       System.out.println("Pls, choose one of them to register: ");
                       int choice2 = s.nextInt();
                       choice2--;
                       s.nextLine();
                       System.out.println("Pls create a password to him/her: ");
                       String password = s.nextLine();
                       //String[] nameAndLastName = people.get(--choice2).split(" ");
                       new SystemIn2(nameList.get(choice2),lastNameList.get(choice2),password);
                       break;
                   case 3:
                       lock = false;
                       break;
                   case 4:
                       if(nameList.size() == 0){
                           System.out.println("There is no people");
                           break;
                       }
                       else {
                           System.out.println("List of people: ");
                           for(int i = 0, j = 1; i < nameList.size(); i++, j++){
                               System.out.println(j + ")" + nameList.get(i) + " " + lastNameList.get(i));
                           }
                       }
                       System.out.println("");
                       break;
                   default:
                       System.out.println("Invalid input");
                       break;
               }
           }
           lock = true;
           while (lock){
               s.nextLine();
               System.out.println("First of all you have to log in");
               System.out.println("Pls write ur name: ");
               String name = s.nextLine();
               System.out.println("Pls write ur last name: ");
               String lastName = s.nextLine();
               System.out.println("Pls write ur password");
               String password = s.nextLine();
               if(halykBank.logIn(name,lastName,password)){
                   System.out.println("Congratulations your login and password is right");
                   lock = false;
               }
               else{
                   System.out.println("You should try again because login or password is not correct! ");
               }
           }
           int choice3;
           lock = true;
           while (lock){
               System.out.println("Welcome to the bank system here you can perform operations: \n" +
                       "1)Check balance \n" +
                       "2)Withdraw \n" +
                       "3)Deposit \n" +
                       "4)Transaction \n" +
                       "5)Change password \n" +
                       "6)Log out \n" +
                       "7)Press this if you wanna end this program");
               choice3 = s.nextInt();
               s.nextLine();
               switch (choice3){
                   case 1:
                       System.out.println(halykBank.checkBalance() + "$");
                       break;
                   case 2:
                       System.out.println("How much money you wanna withdraw: ");
                       double money = s.nextDouble();
                       s.nextLine();
                       halykBank.withdraw(money);
                       break;
                   case 3:
                       System.out.println("How much money you wanna deposit: ");
                       double money2 = s.nextDouble();
                       s.nextLine();
                       halykBank.deposit(money2);
                       break;
                   case 4:
                       System.out.println("Write a card number: ");
                       int cardNumberForTrans = s.nextInt();
                       s.nextLine();
                       System.out.println("Write amount of money that u wanna send");
                       double money3 = s.nextDouble();
                       s.nextLine();
                       halykBank.transaction(cardNumberForTrans,money3);
                       break;
                   case 5:
                       System.out.println("To change a password you should write an old password");
                       String oldPassword = s.nextLine();
                       System.out.println("And also type a new password");
                       String newPassword = s.nextLine();
                       halykBank.changePassword(oldPassword,newPassword);
                       break;
                   case 6:
                       System.out.println("Are u sure? anyway it's gonna log out but if i ask you about this it looks more polite");
                       s.nextLine();
                       halykBank.logOutAHere();
                       lock = false;
                       break;
                   case 7:
                       globalLock = false;
                       lock = false;
                   default:
                       System.out.println("Invalid input");
                       break;
               }
           }
       }
        System.out.println("The End");
    }
}

class SystemIn2{
    private static List<Boolean> logOut = new LinkedList<>();
    private static List<String> name = new LinkedList<>();
    private static List<String> lastName = new LinkedList<>();
    private static List<String> password = new LinkedList<>();
    private static List<Integer> cardNumber = new LinkedList();
    private static List<Double> cash = new LinkedList<>();
    private static int personCounter = 0;
    private static int cardNumberGenerator = 1000;
    private static double balance = 100.0;

    SystemIn2(){

    }

    SystemIn2(String nameForDataBase,String lastNameForDataBase, String passwordForDataBase){
        name.add(nameForDataBase);
        lastName.add(lastNameForDataBase);
        password.add(passwordForDataBase);
        logOut.add(false);
        cardNumber.add(cardNumberGenerator);
        cash.add(balance);
        System.out.println("Hello " + name.get(personCounter) + " " + lastName.get(personCounter) + "\n" +
                "Ur card Number is: " + cardNumber.get(personCounter) + "\n" +
                "Ur balance: " + cash.get(personCounter) + "$");
        personCounter++;
        cardNumberGenerator++;
        System.out.println("Created from test");
    }


    boolean logIn(String nameCheck, String lastNameCheck, String passwordCheck){
        if(name.contains(nameCheck) && lastName.contains(lastNameCheck) && password.contains(passwordCheck)){
            for(int i = 0,saver; i < personCounter; i++){
                if(name.get(i).equals(nameCheck) && lastName.get(i).equals(lastNameCheck) && password.get(i).equals(passwordCheck)){
                    logOut.set(i,true);
                    return true;
                }
            }
        }
        return false;
    }

    double checkBalance(){
        int i = 0;
        for(Boolean x : logOut){
            if(x){
                return cash.get(i);
            }
            i++;
        }
        return 0;
    }

    void withdraw(double withdrawCash){
        int i = 0;
        for(Boolean x : logOut){
            if(x){
                double money = cash.get(i);
                if(money < withdrawCash){
                    System.out.println("Not enough money");
                }
                cash.set(i,money - withdrawCash);
                System.out.println("Operation executed successfully");
                return;
            }
            i++;
        }
    }

    void deposit(double depositCash){
        int i = 0;
        for(Boolean x : logOut){
            if(x){
                double money = cash.get(i);
                cash.set(i,money + depositCash);
                System.out.println("Operation executed successfully");
                return;
            }
            i++;
        }
    }

    void transaction(int cardNumberTrans2, double amounOfCash){
        if(cardNumber.contains(cardNumberTrans2)) {
            int i = 0,j = 0;
            for (Boolean x : logOut) {
                if (x) {
                    withdraw(amounOfCash);
                    for(int x1 : cardNumber){
                        if(x1 == cardNumberTrans2){
                            double money = cash.get(j);
                            cash.set(j,money + amounOfCash);
                            System.out.println("Operation done successfully");
                            return;
                        }
                        j++;
                    }
                }
                i++;
            }
        }
        System.out.println("Operation failed because this card number is not exist");
    }

    void changePassword(String oldPassword, String newPassword){
        int i = 0;
        for(Boolean x : logOut){
            if(x){
                if(password.get(i).equals(oldPassword)){
                    password.set(i,newPassword);
                    return;
                }
                else {
                    System.out.println("Old password is not correct");
                    return;
                }
            }
            i++;
        }
    }

    void logOutAHere(){
        int i = 0;
        for(Boolean x : logOut){
            if(x){
                logOut.set(i,false);
                return;
            }
            i++;
        }
    }
}