package com.codedifferently.database;

import com.codedifferently.person.Person;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class PersonTest {
    Map<String, String> personMap;
    Person person;

    @Before
    public void setUp() throws Exception {
         personMap = new HashMap<>();
         personMap.put("firstName", "Matt");
         personMap.put("lastName", "Werth");
         personMap.put("email", "matthewwerth@gmail.com");
         personMap.put("age", "33");
         person = new Person(personMap);
    }

    @Test
    public void getFirstName() {
        String actual = person.getFirstName();
        String expected = "Matt";
        System.out.println(actual);

        Assert.assertEquals("Get The First Name: ", expected, actual);
    }

    @Test
    public void setFirstName() {
        person.setFirstName("Marty");
        String actual = person.getFirstName();
        String expected = "Marty";
        System.out.println(actual);

        Assert.assertEquals("Set The First Name: ", expected, actual);
    }

    @Test
    public void getLastName() {
        String actual = person.getLastName();
        String expected = "Werth";
        System.out.println(actual);

        Assert.assertEquals("Get The Last Name: ",expected, actual);
    }

    @Test
    public void setLastName() {
        person.setLastName("Wyler");
        String actual = person.getLastName();
        String expected = "Wyler";
        System.out.println(actual);

        Assert.assertEquals("Set The Last Name: ", expected, actual);
    }

    @Test
    public void getAge() {
        Integer actual = person.getAge();
        Integer expected = 33;
        System.out.println(actual);

        Assert.assertEquals("Get Age: ", expected, actual);
    }

    @Test
    public void setAge() {
        person.setAge(31);
        Integer actual = person.getAge();
        Integer expected = 31;
        System.out.println(actual);

        Assert.assertEquals("Set Age: ", expected, actual);
    }

    @Test
    public void getEmail() {
        String actual = person.getEmail();
        String expected = "matthewwerth@gmail.com";
        System.out.println(actual);

        Assert.assertEquals("Get Email: ", expected, actual);
    }

    @Test
    public void setEmail() {
        person.setEmail("test@gmail.com");
        String actual = person.getEmail();
        String expected = "test@gmail.com";
        System.out.println(actual);

        Assert.assertEquals("Set Email: ", expected, actual);
    }
}