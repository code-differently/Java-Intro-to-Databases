package com.codedifferently.addressbook;

import com.codedifferently.database.DataBase;
import com.codedifferently.person.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class AddressBook {
    private static final Logger logger = Logger.getGlobal();
    private Person owner;
    private List<Person> people;
    private DataBase dataBase;

    public AddressBook(DataBase dataBase) {
        this.dataBase = dataBase;
        people = new ArrayList<>();
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public void addPerson(Person person) {
        this.people.add(person);
        logger.info("Added " + person.getFirstName());
        logger.info("We Have " + this.people.size() + " People.");
    }

    public void removePerson(Person person) {
        this.people.remove(person);
    }

    public Person getPersonByEmail(String email) {
        return people.stream()
                .filter(person -> person.getEmail().equals(email))
                .findFirst()
                .orElseThrow(NullPointerException::new);
    }

    public List<Person> getAllPeople() {
        return people;
    }

    public boolean saveAll() {
        //if() return true;
        return false;
    }

}
