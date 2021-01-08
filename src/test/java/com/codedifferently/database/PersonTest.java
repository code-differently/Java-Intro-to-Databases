package com.codedifferently.database;

import com.codedifferently.person.Person;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PersonTest {
    Person person;

    @Before
    public void setUp() throws Exception {
         person = new Person("Matt", "Werth", 33, "matthewwerth@gmail.com");
    }

    @Test
    public void getFirstName() {
        String actual = person.getFirstName();
        String expected = "Matt";
        System.out.println(actual);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setFirstName() {
        person.setFirstName("Marty");
        String actual = person.getFirstName();
        String expected = "Marty";
        System.out.println(actual);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getLastName() {
        String actual = person.getLastName();
        String expected = "Werth";
        System.out.println(actual);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setLastName() {
        person.setLastName("Wyler");
        String actual = person.getLastName();
        String expected = "Wyler";
        System.out.println(actual);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAge() {
        Integer actual = person.getAge();
        Integer expected = 33;
        System.out.println(actual);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setAge() {
        person.setAge(31);
        Integer actual = person.getAge();
        Integer expected = 31;
        System.out.println(actual);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getEmail() {
        String actual = person.getEmail();
        String expected = "matthewwerth@gmail.com";
        System.out.println(actual);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setEmail() {
        person.setEmail("testThis@gmail.com");
        String actual = person.getEmail();
        String expected = "testThis@gmail.com";
        System.out.println(actual);

        Assert.assertEquals(expected, actual);
    }
}