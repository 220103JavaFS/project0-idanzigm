package com.revature.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
    public static Connection connectToDB() throws SQLException {
        try {
            Class.forName(("org.postgresql.Driver"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = "jdbc:postgresql://javafs220103-ianbankprogram.ciyu53ax0jha.us-east-1.rds.amazonaws.com:5432/postgres";
        String sqlUsername = "postgres";
        String sqlPassword = System.getenv("password"); //System.getenv("var-name");

        return DriverManager.getConnection(url, sqlUsername, sqlPassword);
    }

//        public static void main(String[] args){
//        try{
//            connectToDB();
//            System.out.println("Connection successful");
//        }catch (SQLException e){
//            System.out.println("Connection failed");
//            e.printStackTrace();
//        }
//    }
}
