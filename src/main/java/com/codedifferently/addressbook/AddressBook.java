package com.codedifferently.addressbook;

import com.codedifferently.addressbook.exceptions.AddressBookPersonNotFoundException;
import com.codedifferently.database.MySQLDatabase;
import com.codedifferently.database.exceptions.DatabaseCouldNotSaveException;
import com.codedifferently.person.Person;

import java.util.List;
import java.util.logging.Logger;

public class AddressBook {
    private static final Logger logger = Logger.getGlobal();
    private Person owner;
    private List<Person> people;
    private MySQLDatabase dataBase;

    public AddressBook(Person owner, MySQLDatabase database){
        this.owner = owner;
        this.dataBase = database;
        this.people = database.getAllPeople();
    }

    public void addPerson(Person person){
        this.people.add(person);
        saveAll();
        //this.people.remove(person); Adding people is not working once we have one person on our database //// TODO: 1/8/21 Should we remove person after saving?
    }

    public void removePerson(Person person){
        logger.info("Removing person " + person.getFirstName());
        this.people.remove(person);
        /**
         * Todo :: update database;
         */
    }
    public Person getPersonByEmail(String email) throws AddressBookPersonNotFoundException {
        return people.stream()
                .filter(person -> person.getEmail().equals(email))
                .findFirst()
                .orElseThrow(AddressBookPersonNotFoundException::new);
    }

    public List<Person> getAllPeople(){
        return people;
    }

    public Boolean saveAll(){
        try {
            dataBase.saveAllPeople(people);
            people.forEach(nm -> System.out.println(nm.toString()));
            return true;
        } catch (DatabaseCouldNotSaveException e) {
           logger.info("Failed To Save AT SAVEALL() IN ADDRESSBOOK");
            return false;
        }

    }

}
