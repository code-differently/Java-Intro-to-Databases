package com.codedifferently.person;

import java.util.UUID;

public class Person {
    private String firstName;
    private String lastName;
    private Integer age;
    private String email;
    private String id;

    /**
     * Use this method to create Person Object
     * @param firstName
     * @param lastName
     * @param age
     * @param email
     */

    public Person(String firstName, String lastName, Integer age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.id = UUID.randomUUID().toString();
    }

    /**
     * Use this method to get Person Object from Database
     * @param firstName
     * @param lastName
     * @param age
     * @param email
     */

    public Person(String firstName, String lastName, Integer age, String email, String id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
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
