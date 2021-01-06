package com.codedifferently.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Logger;

public class DataBase {
    private static final Logger logger = Logger.getGlobal();
    private Connection connection;

    private void getConnection() throws DataBaseConnectionException {
        try{
            Connection connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/cdDb?createDatabaseIfNotExist=true&useSSL=false", "developer01", "pass");
            connection.setAutoCommit(false);
            logger.info("Successful Connection");
        }catch (Exception e) {
            logger.warning(e.getMessage());
            throw new DataBaseConnectionException();
        }
    }

    public DataBase() throws DataBaseConnectionException {
        getConnection();
    }
}
