package com.codedifferently.database;

import com.codedifferently.addressbook.AddressBook;
import com.codedifferently.person.Person;
import junit.framework.TestCase;
import org.junit.Assert;

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

    public void testSetAndGetOwner() {
        addressBook.setOwner(per1);
        String actual = addressBook.getOwner().getFirstName();
        String expected = "Matt";
        System.out.println(actual);
        Assert.assertEquals(expected, actual);
    }

    public void testAddPerson() {
        addressBook.addPerson(per2);
        String actual = addressBook.getPersonByEmail("lauriewerth@gmail.com").getFirstName();
        String expected = "Laurie";
        System.out.println(actual);

        Assert.assertEquals(expected, actual);
    }

    public void testRemovePerson() {
        addressBook.addPerson(per2);
        System.out.println("Removed " + addressBook.getAllPeople().get(0).getFirstName());
        addressBook.removePerson(per2);

        Integer actual = addressBook.getAllPeople().size();
        Integer expected = 0;
        Assert.assertEquals(expected, actual);
    }

    public void testGetPersonByEmail() {

        addressBook.addPerson(per2);
        String actual = addressBook.getPersonByEmail("lauriewerth@gmail.com").getFirstName();
        String expected = "Laurie";
        System.out.println(actual);

        Assert.assertEquals(expected, actual);
    }

    public void testGetAllPeople() {
        addressBook.addPerson(per2);
        Person actual = addressBook.getAllPeople().get(0);
        Person expected = addressBook.getPersonByEmail("lauriewerth@gmail.com");

        System.out.println(actual);
        Assert.assertEquals(expected, actual);
    }

    public void testSaveAll() {
    }
}