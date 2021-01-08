package com.codedifferently.database;

import com.codedifferently.addressbook.AddressBook;
import com.codedifferently.addressbook.exceptions.AddressBookPersonNotFoundException;
import com.codedifferently.person.Person;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;

import java.util.HashMap;
import java.util.Map;

public class AddressBookTest extends TestCase {
    AddressBook addressBook;
    Map<String, String> personMap;
    Person per1;

    @Before
    public void setUp() throws Exception {
        personMap = new HashMap<>();
        personMap.put("firstName", "Matt");
        personMap.put("lastName", "Werth");
        personMap.put("email", "matthewwerth@gmail.com");
        personMap.put("age", "33");
        per1 = new Person(personMap);
    }

    public void testSetAndGetOwner() {
        addressBook.setOwner(per1);
        String actual = addressBook.getOwner().getFirstName();
        String expected = "Matt";
        System.out.println(actual);
        Assert.assertEquals(expected, actual);
    }

    public void testAddPerson() throws AddressBookPersonNotFoundException {
        addressBook.addPerson(per1);
        String actual = addressBook.getPersonByEmail("lauriewerth@gmail.com").getFirstName();
        String expected = "Laurie";
        System.out.println(actual);

        Assert.assertEquals(expected, actual);
    }

    public void testRemovePerson() {
        addressBook.addPerson(per1);
        System.out.println("Removed " + addressBook.getAllPeople().get(0).getFirstName());
        addressBook.removePerson(per1);

        Integer actual = addressBook.getAllPeople().size();
        Integer expected = 0;
        Assert.assertEquals(expected, actual);
    }

    public void testGetPersonByEmail() throws AddressBookPersonNotFoundException {

        addressBook.addPerson(per1);
        String actual = addressBook.getPersonByEmail("matthewwerth@gmail.com").getFirstName();
        String expected = "Matt";
        System.out.println(actual);

        Assert.assertEquals(expected, actual);
    }

    public void testGetAllPeople() throws AddressBookPersonNotFoundException {
        addressBook.addPerson(per1);
        Person actual = addressBook.getAllPeople().get(0);
        Person expected = addressBook.getPersonByEmail("matthewwerth@gmail.com");

        System.out.println(actual);
        Assert.assertEquals(expected, actual);
    }

    public void testSaveAll() {
    }
}