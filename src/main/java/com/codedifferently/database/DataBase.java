package com.codedifferently.database;
import com.codedifferently.database.exceptions.DatabaseCouldNotSaveException;
import com.codedifferently.person.Person;

import java.util.List;

public interface Database {
    void savePerson(Person person) throws DatabaseCouldNotSaveException;
    void saveAllPeople(List<Person> people) throws DatabaseCouldNotSaveException;
    List<Person> getAllPeople();
}
