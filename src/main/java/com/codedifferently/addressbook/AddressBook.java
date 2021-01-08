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
        logger.info("Adding new person " + person.getFirstName());
        this.people.add(person);
        saveAll();
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
            return true;
        } catch (DatabaseCouldNotSaveException e) {
            return false;
        }

    }

}
