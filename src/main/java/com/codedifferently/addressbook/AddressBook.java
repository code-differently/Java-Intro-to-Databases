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
    private MySQLDatabase mySQLDatabase;

    public AddressBook(Person owner, MySQLDatabase mySQLDatabase) {
        this.owner = owner;
        this.mySQLDatabase = mySQLDatabase;
        this.people = mySQLDatabase.getAllPeople(); //// TODO: 1/8/21 Get All People Function Through Database
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public void addPerson(Person person) {
        this.people.add(person);
        saveAll();
        logger.info("Added " + person.toString());
    }

    public void removePerson(Person person) {
        this.people.remove(person); //// TODO: 1/8/21 Remove Person From Database
        logger.info("Removed " + person.toString());
    }

    public Person getPersonByEmail(String email) throws AddressBookPersonNotFoundException {
        return people.stream()
                .filter(person -> person.getEmail().equals(email))
                .findFirst()
                .orElseThrow(AddressBookPersonNotFoundException::new);
    }

    public List<Person> getAllPeople() {
        return people;
    }

    public boolean saveAll(){
        try {
            mySQLDatabase.saveAllPeople(people);
            return true;
        } catch (DatabaseCouldNotSaveException ex) {
            logger.info(ex.getMessage());
        };
        return false;
    }

}
