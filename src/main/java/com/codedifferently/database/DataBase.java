package com.codedifferently.database;

import com.codedifferently.person.Person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.logging.Logger;

public class DataBase {
    private static final Logger logger = Logger.getGlobal();
    private Connection connection;

    private void getConnection() throws DataBaseConnectionException {
        try {
            Connection connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/addressbook?createDatabaseIfNotExist=true&useSSL=false", "developer01", "pass");
            connection.setAutoCommit(false);
            logger.info("Successful Connection");
        }
        catch (Exception e) {
            logger.warning(e.getMessage());
            throw new DataBaseConnectionException();
        }
    }

    public DataBase() throws DataBaseConnectionException {
        getConnection();
    }

    public void insertPerson(Person person, String table) { //// TODO: 1/6/21 Maybe make an enum for the tableType
        try{
            String tableType = table.toUpperCase();
            String insert = "INSERT INTO " + tableType +" ('&s', '%s', '%s', '%s', %d)";
            Statement statement = connection.createStatement();
            statement.execute(String.format(insert, person.getId(), person.getFirstName(), person.getLastName(), person.getEmail(), person.getAge()));
            connection.commit();
        }
        catch(Exception e) {
            logger.warning(e.getMessage());
        }
    }

}
