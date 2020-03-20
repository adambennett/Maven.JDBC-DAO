package models;

import java.sql.*;

public class Transferer implements ITransfer{

    public static final String URL = "jdbc:mysql://localhost:3306/jdbcLab";
    public static final String USER = "tempUser";
    public static final String PASS = "Standard@Pass";

    public static Connection getConnection() {
        try {
            //DriverManager.registerDriver(new Driver());
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException | ClassNotFoundException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }
        //return null;
    }

    public int getId() {
        return 0;
    }
}
