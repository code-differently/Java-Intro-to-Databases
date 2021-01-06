package com.codedifferently.database;

import java.util.ArrayList;
import java.util.List;

public class AddressBook {
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
