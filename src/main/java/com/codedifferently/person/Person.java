package com.codedifferently.person;

import com.codedifferently.Main;

import java.util.Map;
import java.util.UUID;

public class Person {
    private String firstName;
    private String lastName;
    private Integer age;
    private String email;
    private String id;


    public Person(Map<String, String> personMap) { // This takes in an initial call to our constructor and recalls it adding an id number. Since we have an overloaded method, it now calls our second constructor.
        this(UUID.randomUUID().toString(), personMap);
    }

    public Person(String id, Map<String, String> personMap) {
        this.firstName = personMap.getOrDefault("firstName", "no value");
        this.lastName = personMap.getOrDefault("lastName", "no value");
        this.age = Integer.parseInt(personMap.getOrDefault("age", "0"));
        this.email = personMap.getOrDefault("email", "no value");
        this.id = id;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person: " +
                "First Name: '" + firstName + '\'' +
                ", Last Name: '" + lastName + '\'' +
                ", Age: '" + age +
                ", E-Mail: '" + email + '\'';
    }
}
