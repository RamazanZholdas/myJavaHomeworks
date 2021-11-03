package com.company;

import java.util.*;
import java.util.concurrent.TimeUnit;

/*
LAB 7
Zholdas Ramazan from IT IS - 1913R
Attention rent time is 24 second!
And also all data of users will be shown in the end of this program
 */

public class LabWork {
    public static void main(String[] args){
        Library.standardBooksInLibrary();
        Scanner s = new Scanner(System.in);
        boolean globaloLock = true;
        System.out.println("This is simulation here you can create person and interact with library");
        while (globaloLock) {
            boolean lock = true;
            while (lock) {
                System.out.println("Welcome to my world! Here you have few options: \n" +
                        "1)Create and registrate person to the library \n" +
                        "2)Checkout all the books in library \n" +
                        "3)Add book to the library \n" +
                        "4)Find book \n" +
                        "5)Delete book \n" +
                        "6)Exit and interact with books as a person");
                int choice1 = s.nextInt();
                s.nextLine();
                switch (choice1) {
                    case 1:
                        System.out.println("Pls input name: ");
                        String name1 = s.nextLine();
                        System.out.println("Pls input sername: ");
                        String sername1 = s.nextLine();
                        Library.registratePerson(new Person(name1, sername1));
                        System.out.println("Congratulations, you have signed to the library!");
                        break;
                    case 2:
                        Library.getAllBooks();
                        break;
                    case 3:
                        System.out.println("Pls input book title: ");
                        String title1 = s.nextLine();
                        System.out.println("Pls input author name and sername: ");
                        String author1 = s.nextLine();
                        System.out.println("Pls input publish date of the book (Example: 01.01.2020)");
                        String publishDate = s.nextLine();
                        if (!publishDate.matches("\\d+\\.\\d+\\.\\d+")) {
                            System.out.println("Invalid publish date input! ");
                            break;
                        }
                        Library.addBooks(new Book(title1, author1, publishDate));
                        break;
                    case 4:
                        System.out.println("How do you wanna find book, by: \n" +
                                "1)Id\n" +
                                "2)Title");
                        int choice2 = s.nextInt();
                        s.nextLine();
                        switch (choice2) {
                            case 1:
                                System.out.println("Input id pls: ");
                                int id1 = s.nextInt();
                                s.nextLine();
                                Library.findById(id1);
                                break;
                            case 2:
                                System.out.println("Input title pls: ");
                                String title2 = s.nextLine();
                                Library.findBytitle(title2);
                                break;
                            default:
                                System.out.println("Invalid input");
                                break;
                        }
                        break;
                    case 5:
                        System.out.println("How do you wanna delete book, by: \n" +
                                "1)Id\n" +
                                "2)Title");
                        int choice3 = s.nextInt();
                        s.nextLine();
                        switch (choice3) {
                            case 1:
                                System.out.println("Input id pls: ");
                                int id2 = s.nextInt();
                                s.nextLine();
                                Library.deleteById(id2);
                                break;
                            case 2:
                                System.out.println("Input title pls: ");
                                String title3 = s.nextLine();
                                Library.deleteByTitle(title3);
                                break;
                            default:
                                System.out.println("Invalid input!");
                                break;
                        }
                        break;
                    case 6:
                        lock = false;
                        break;
                    default:
                        System.out.println("Invalid input");
                        break;
                }
            }
            System.out.println("Welcome to the library, First you have to identificate yourself");
            lock = true;
            while (lock) {
                System.out.println("Who are you? are you signed to the library?\n" +
                        "1)Yes \n" +
                        "2)No");
                int choice4 = s.nextInt();
                s.nextLine();
                switch (choice4) {
                    case 1:
                        System.out.println("Pls input ur name: ");
                        String name = s.nextLine();
                        System.out.println("Pls input ur lastname: ");
                        String lastName = s.nextLine();
                        if(Library.logIn(name,lastName)){
                            System.out.println("You are in the library base!");
                            lock = false;
                            break;
                        }
                        else {
                            System.out.println("You are not in the library database");
                            break;
                        }
                    case 2:
                        System.out.println("Pls input name: ");
                        String name1 = s.nextLine();
                        System.out.println("Pls input sername: ");
                        String sername1 = s.nextLine();
                        Library.registratePerson(new Person(name1, sername1));
                        if(Library.logIn(name1,sername1)){
                            System.out.println("Congratulations you have signed");
                            lock = false;
                            break;
                        }
                        else {
                            System.out.println("Error in program this statement must be unreachable");
                            break;
                        }
                    default:
                        System.out.println("Invalid input");
                        break;
                }
            }
            lock = true;
            while (lock) {
                System.out.println("1)Take book\n" +
                        "2)Find book \n" +
                        "3)Checkout all the books in library \n" +
                        "4)Check books that you have taken\n" +
                        "5)Exit library \n" +
                        "6)Exit program");
                int choice5 = s.nextInt();
                s.nextLine();
                switch (choice5) {
                    case 1:
                        Library.getAllBooks();
                        System.out.println("Which one you wanna take?\n" +
                                " Input title to get the book ");
                        String title1 = s.nextLine();
                        Library.takeBook(title1);
                        break;
                    case 2:
                        System.out.println("How do you wanna find book, by: \n" +
                                "1)Id\n" +
                                "2)Title");
                        int choice2 = s.nextInt();
                        s.nextLine();
                        switch (choice2) {
                            case 1:
                                System.out.println("Input id pls: ");
                                int id1 = s.nextInt();
                                s.nextLine();
                                Library.findById(id1);
                                break;
                            case 2:
                                System.out.println("Input title pls: ");
                                String title2 = s.nextLine();
                                Library.findBytitle(title2);
                                break;
                            default:
                                System.out.println("Invalid input");
                                break;
                        }
                        break;
                    case 3:
                        Library.getAllBooks();
                        break;
                    case 4:
                        Library.booksThatUserHaveTaken();
                        break;
                    case 5:
                        Library.logOutAHere();
                        lock = false;
                        break;
                    case 6:
                        globaloLock = false;
                        lock = false;
                        break;
                    default:
                        System.out.println("Invalid input");
                        break;
                }
            }
        }
        System.out.println("Here is all data that we have collected about our clients: ");
        Library.dataBase();
        System.out.println("The Program has finished!");
    }
}

class Person{
    private static int idGenerator4Book = 0;
    private static int idGenerator = 1;
    private String name;
    private String sername;
    private int id;
    private List<Book> listOfBooks = new LinkedList<>();

    Person(String name,String sername){
        this.name = name;
        this.sername = sername;
        this.id = idGenerator;
        idGenerator++;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", sername='" + sername + '\'' +
                ", listOfBooks:" + listOfBooks.toString() +
                '}';
    }

    public String getSername() {
        return sername;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public List<Book> getListOfBooks() {
        return listOfBooks;
    }

    public void rentBook(Book book){
        if(listOfBooks.size() == 6){
            System.out.println("You cannot take more than 5 books");
            return;
        }
        listOfBooks.add(book);
        new Timer(book).start();
    }


    class Timer extends Thread{
        private Book[] books = new Book[1];
        private int index;
        Timer(Book book){
            books[0] = book;
        }
        @Override
        public void run() {
            System.out.println("Wait 24 seconds to finish rent time");
            try {
                Thread.sleep(24000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Rent time is over!");
            listOfBooks.remove(books[0]);
            Library.addBooks(books[0]);
        }
    }
}

class Book{
    private static int idGenerator = 1;
    private String title;
    private String author;
    private String publishDate;
    private int id;

    Book(String title,String author,String publishDate){
        this.title = title;
        this.author = author;
        this.publishDate = publishDate;
        this.id = idGenerator;
        idGenerator++;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publishDate='" + publishDate + '\'' +
                '}';
    }
}

class Library{
    private static List<Book> booksInLibrary = new LinkedList<>();
    private static List<Person> registratedPersons = new LinkedList<>();
    private static List<Boolean> logOut = new LinkedList<>();
    private static int personCounter = 0;

    static void dataBase(){
        for(Person x : registratedPersons){
            System.out.println(x.toString());
        }
    }

    static void booksThatUserHaveTaken(){
        int counter = 0;
        for(Boolean x : logOut){
            if(x){
                System.out.println(registratedPersons.get(counter).getListOfBooks().toString());
                return;
            }
            counter++;
        }
    }

    static void takeBook(String title){
        int counter = 0;
        for(Boolean x : logOut){
            if(x){
                if(returnable(title) == null){
                    System.out.println("This book doesn't exist");
                    return;
                }
                registratedPersons.get(counter).rentBook(returnable(title));
                deleteByTitle(title);
                return;
            }
            counter++;
        }
    }

    static Book returnable(String title){
        for(Book x : booksInLibrary){
            if(x.getTitle().equals(title)){
                return x;
            }
        }
        return null;
    }

    static void logOutAHere(){
        for(Boolean x : logOut){
            x = false;
        }
    }

    static boolean logIn(String name, String lastName){
        for(int i = 0; i < personCounter; i++){
            for(Person x : registratedPersons){
                if(x.getName().equals(name) && x.getSername().equals(lastName)){
                    logOut.set(i,true);
                    return true;
                }
            }
        }
        return false;
    }

    static void addBooks(Book book){
        booksInLibrary.add(book);
    }

    static void registratePerson(Person person){
        personCounter++;
        logOut.add(false);
        registratedPersons.add(person);
    }

    static void deleteById(int id){
        int counter = 0;
        for(Book x : booksInLibrary){
            if(x.getId() == id){
                booksInLibrary.remove(counter);
                return;
            }
            counter++;
        }
    }

    static void deleteByTitle(String title){
        int counter = 0;
        for(Book x : booksInLibrary){
            if(x.getTitle().equals(title)){
                booksInLibrary.remove(counter);
                return;
            }
            counter++;
        }
    }

    static void findById(int id){
        for(Book x : booksInLibrary){
            if(x.getId() == id){
                System.out.println(x.toString());
                return;
            }
        }
        System.out.println("Haven't found");
    }

    static void findBytitle(String title){
        for(Book x : booksInLibrary){
            if(x.getTitle().equals(title)){
                System.out.println(x.toString());
                return;
            }
        }
        System.out.println("Haven't found");
    }

    static void getAllBooks(){
        for(Book x : booksInLibrary){
            System.out.println(x.toString());
        }
    }

    static void standardBooksInLibrary(){
        addBooks(new Book("1984","George Oruwell","8.06.1949"));
        addBooks(new Book("The little Prince","Antoine de Saint-Exupery","6.04.1943"));
        addBooks(new Book("MuMu","Ivan Turgeneev","02.03.1854"));
        addBooks(new Book("Dubrovski", "Aleksandr Pushkin","24.11.1841"));
        addBooks(new Book("The Adventures of Huckleberry Finn","Mark Twain","10.12.1883"));
    }
}

