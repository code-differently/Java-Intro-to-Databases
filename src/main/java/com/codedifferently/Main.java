package com.codedifferently;

import com.codedifferently.addressbook.AddressBook;
import com.codedifferently.addressbook.exceptions.AddressBookPersonNotFoundException;
import com.codedifferently.database.MySQLDatabase;
import com.codedifferently.database.DataBaseConnectionException;
import com.codedifferently.person.Person;

import java.util.*;


//// TODO: 1/8/21 We can add the first person, but after that it is no longer adding and it is having an error. We need to make sure that once the person
//// We should probably clear out the old person before trying to add another person.


public class Main {

    private final AddressBook addressBook;
    private static Scanner scanner;
    private ArrayList<String> menu;

    public Main() throws DataBaseConnectionException {
        MySQLDatabase mySQLDatabase = new MySQLDatabase();
        scanner = new Scanner(System.in);
        addressBook = new AddressBook(null, mySQLDatabase);
        initMenuOption();
    }

    private void initMenuOption(){
            menu = new ArrayList<>();
            menu.add("Exit");
            menu.add("Show All");
            menu.add("Add New");
            menu.add("Find by email");
            menu.add("Save All Contacts");
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

    public void displayAllPeople() {
        addressBook.getAllPeople().forEach(person -> System.out.println(person.toString()));
    }

    private String getStringOutPut(String msg){
        System.out.println(msg);
        return scanner.next();
    }


    public void createNewPerson(){
        Map<String, String> rawData = new HashMap<>();
        rawData.put("firstName", getStringOutPut("Please enter first name:"));
        rawData.put("lastName", getStringOutPut("Please enter last name:"));
        rawData.put("email", getStringOutPut("Please enter email:"));
        rawData.put("age", getStringOutPut("Please enter age:"));
        Person person = new Person(rawData);
        addressBook.addPerson(person);
    }

    public void findPerson(){
        String email = getStringOutPut("What email are you looking for?");
        try {
            Person person = addressBook.getPersonByEmail(email);
            displayPerson(person);
        } catch (AddressBookPersonNotFoundException e) {
            System.out.println("There is no user with the email :" + email);
        }
    }

    private void displayPerson(Person person){
        String output = String.format("%s %s %s %s %d", person.getId(), person.getFirstName(), person.getLastName(), person.getEmail(), person.getAge());
        System.out.println(output);
    }


    public static void main(String[] args) {
        try {
            Main main = new Main();
            Boolean endProgram = false;
            System.out.println("Welcome to address book");
            while (!endProgram) {
                int menuOption = main.displayMenu();
                switch(menuOption){
                    case 0:
                        System.out.println("Goodbye!!");
                        endProgram = true;
                        break;
                    case 1:
                        main.displayAllPeople();
                        break;
                    case 2:
                        main.createNewPerson();
                        break;
                    case 3:
                        main.findPerson();
                        break;
                    default:
                        System.out.println("I don't know that command");
                        break;
                }
            }
        }
        catch (DataBaseConnectionException e) {
            System.out.println("Your database could not be connected to.");
        }
    }
}
