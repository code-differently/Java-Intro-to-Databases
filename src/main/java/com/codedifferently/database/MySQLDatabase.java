package com.codedifferently.database;

import com.codedifferently.database.exceptions.DatabaseCouldNotSaveException;
import com.codedifferently.person.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class MySQLDatabase implements Database {
    private static final Logger logger = Logger.getGlobal();
    private Connection connection;

    private void getConnection() throws DataBaseConnectionException {
        try {
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/addressbook?createDatabaseIfNotExist=true&useSSL=false", "developer01", "pass");
            connection.setAutoCommit(false);
            logger.info("Successful Connection");
        }
        catch (Exception e) {
            logger.warning(e.getMessage());
            throw new DataBaseConnectionException();
        }
    }

    public MySQLDatabase() throws DataBaseConnectionException {
        getConnection();
    }

    public List<Person> getAllPeople() { //// TODO: 1/8/21 Return an ArrayList Of Person for AddressBook, pull from db
        List<Person> people = new ArrayList<>();
        try {
            String sql = "SELECT * FROM PERSON";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                Map<String, String> rawData = new HashMap<>();
                String id = resultSet.getString("id");
                rawData.put("firstName", resultSet.getString("first_name"));
                rawData.put("lastName", resultSet.getString("last_name"));
                rawData.put("email", resultSet.getString("email"));
                rawData.put("age", resultSet.getString("age"));
                Person person = new Person(id, rawData);
                people.add(person);
            }
        }
        catch (SQLException sqlException){
            logger.info(sqlException.getMessage());
        }
        return people;
    }

    @Override
    public void savePerson(Person person) throws DatabaseCouldNotSaveException {
        try {
            String sqlInsert = String.format("INSERT INTO PERSON (id,first_name,last_name,email,age) VALUES ('%s','%s','%s','%s','%d')",
                    person.getId(),
                    person.getFirstName(),
                    person.getLastName(),
                    person.getEmail(),
                    person.getAge());
            Statement statement = connection.createStatement();
            statement.execute(sqlInsert);
        }
        catch (SQLException sqlException){
            throw new DatabaseCouldNotSaveException();
        }
    }

    public void saveAllPeople(List<Person> people) throws DatabaseCouldNotSaveException {
        try {
            String sqlInsert = "INSERT INTO PERSON(id,first_name,last_name,email,age) VALUES (?,?,?,?,?)";
            PreparedStatement peopleStmt = connection.prepareStatement(sqlInsert);
            for (Person person : people) {
                peopleStmt.setString(1, person.getId());
                peopleStmt.setString(2, person.getFirstName());
                peopleStmt.setString(3, person.getLastName());
                peopleStmt.setString(4, person.getEmail());
                peopleStmt.setInt(5, person.getAge());
                peopleStmt.addBatch();
                logger.info("Saving " + person.getFirstName());
            }
            peopleStmt.executeBatch();
            connection.commit();
        }
        catch (Exception dbcns){
            throw new DatabaseCouldNotSaveException();
        }
    }
}
