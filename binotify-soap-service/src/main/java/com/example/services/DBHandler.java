package com.example.services;

import java.sql.*;

public class DBHandler {
    static final String dbDriver = "com.mysql.cj.jdbc.Driver";
    private Connection conn;
    private static String DB_URL = "jdbc:mysql://soap_db:3306/soap_db";
    private static String DB_Username = "root";
    private static String DB_Password = "password_root";

    public DBHandler() {
        try{
            Class.forName(dbDriver);
            System.out.println("Connecting to database...");
            this.conn = DriverManager.getConnection(DB_URL, DB_Username, DB_Password);
            System.out.println("Connected to database");
        }catch(Exception e) {
            e.printStackTrace();
            System.out.println("Error connecting to database");
        }
    }

    public Connection getConnection() {
        return this.conn;
    }

}
