package com.codedifferently;

import com.codedifferently.addressbook.AddressBook;
import com.codedifferently.database.DataBase;
import com.codedifferently.database.DataBaseConnectionException;
import com.codedifferently.person.Person;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private DataBase dataBase;
    private AddressBook addressBook;
    private static Scanner scanner;
    private ArrayList<String> menu;

    public Main() throws DataBaseConnectionException {
        dataBase = new DataBase();
        scanner = new Scanner(System.in);
        addressBook = new AddressBook(dataBase);
        initMenuOption();
    }

    //// TODO: 1/6/21 can this make an owner and a Person? 
    public static Boolean createOwnerFromCommandLine() throws DataBaseConnectionException {

        Main main = new Main(); //// TODO: 1/6/21 Not sure this is right... how do I get database in here?

        System.out.println("Enter First Name Of Owner: ");
        String firstName = scanner.next();
        System.out.println("Enter Last Name: ");
        String lastName = scanner.next();
        System.out.println("Enter Age: ");
        Integer age = scanner.nextInt();
        System.out.println("Enter E-Mail Address: ");
        String email = scanner.next();

        Person owner = new Person(firstName, lastName, age, email);
        System.out.println(owner.toString());

        main.addressBook.setOwner(owner);

        return true;
    }

    public static void addPersonToDatabase(Person person) {
    }

    private void initMenuOption(){
        menu = new ArrayList<>();
        menu.add("Exit");
        menu.add("Set Owner");
        menu.add("Add Contact");
        menu.add("View All Contacts");
        menu.add("Update Contact Info");
        /**
         * Add your menu items here
         */
    }

    public Integer displayMenu(){
        int option = 0;
        for(int i = 0; i < menu.size(); i++){
            String menuOption = String.format("Press %d for %s", i, menu.get(i));
            System.out.println(menuOption);
        }
        option = scanner.nextInt();
        return option;
    }

    public static void main(String[] args) {
        try {
            Main main = new Main();

            //// TODO: 1/6/21  main.dataBase ?????

            Boolean endProgram = false;
            System.out.println("Welcome to address book");
            while (!endProgram) {
                /* Your code goes here */
                int menuOption = main.displayMenu();

                switch(menuOption){
                    case 0:
                        System.out.println("Goodbye!!");
                        endProgram = true;  // loop breaks when true;
                        break;
                    case 1:

                        if(Main.createOwnerFromCommandLine()) System.out.println("Successfully Added Owner!\n");
                        else System.out.println("Changes Not Saved.\n");

                        break;
                    case 2:
                        System.out.println("Enter Fist Name: ");
                        break;
                    case 3:
                        System.out.println("-- All Contacts --");
                    case 4:
                        System.out.println("Enter E-Mail Of Contact To Update: ");
                    default:
                        break;
                }
            }
        } catch (DataBaseConnectionException e) {
            System.out.println("Your database could not be connected to.");
        }
    }
}
