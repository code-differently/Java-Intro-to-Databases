package com.codedifferently.database;

import junit.framework.TestCase;

public class AddressBookTest extends TestCase {
    AddressBook addressBook;
    DataBase dataBase;
    Person per1;
    Person per2;

    public void setUp() throws Exception {
        dataBase = new DataBase();
        addressBook = new AddressBook(dataBase);
        per1 = new Person("Matt", "Werth", 33, "matthewwerth@gmail.com");
        per2 = new Person("Laurie", "Werth", 33, "lauriewerth@gmail.com");
    }

    public void testGetOwner() {
        addressBook.setOwner(per1);
        System.out.println(addressBook.getOwner());
    }

    public void testSetOwner() {
    }

    public void testAddPerson() {
    }

    public void testRemovePerson() {
    }

    public void testGetPersonByEmail() {
    }

    public void testGetAllPeople() {
    }

    public void testSaveAll() {
    }
}