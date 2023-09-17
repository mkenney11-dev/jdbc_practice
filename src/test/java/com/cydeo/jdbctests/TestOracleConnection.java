package com.cydeo.jdbctests;

import java.sql.*;

public class TestOracleConnection {

    public static void main(String[] args) throws SQLException {

        //CONNECTION STRING
        String dbURL = "jdbc:oracle:thin:@52.91.202.28:1521:XE";
        String dbUsername = "hr";
        String dbPassword = "hr";

        //create connection
        //DriverManager class getConnection method will help to connect database
        Connection conn = DriverManager.getConnection(dbURL, dbUsername, dbPassword);

        //will help us to execute queries
        Statement statement = conn.createStatement();

        //ResultSet will store data after execution. It only stores data, not table info
        ResultSet rs = statement.executeQuery("select * from DEPARTMENTS");


        //getting data
        rs.next();
        System.out.println("-----------FIRST ROW------------");
        //pointer is in the first row currently

        //how to get data from first row:
        // rs.getInt(index)--> returns integer. Index starts from 1 in SQL, it refers to column position
        System.out.println(rs.getInt(1));
        //get the department name
        System.out.println(rs.getString(2));

        //same information we can get with columnLabel not column index
        System.out.println(rs.getInt("MANAGER_ID"));
        System.out.println(rs.getString("DEPARTMENT_NAME"));

        //get second row result in following format: 20 - Marketing

        System.out.println("-------------SECOND ROW----------------");
        rs.next();
        System.out.println(rs.getInt(1)+ " - "+ rs.getString("DEPARTMENT_NAME"));


        //What if we have 100 rows and we want to print the first and second column of each?
        while(rs.next()){

            System.out.println(rs.getInt(1)+ " - "+ rs.getString(2));
        }


        //close connection
        rs.close();
        statement.close();
        conn.close();



    }
}
