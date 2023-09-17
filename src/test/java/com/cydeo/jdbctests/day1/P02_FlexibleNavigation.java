package com.cydeo.jdbctests.day1;

import org.junit.jupiter.api.Test;

import java.sql.*;

public class P02_FlexibleNavigation {

    String dbURL = "jdbc:oracle:thin:@52.91.202.28:1521:XE";
    String dbUsername = "hr";
    String dbPassword = "hr";

    @Test
    public void task1() throws SQLException {

        Connection conn = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
        Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = statement.executeQuery("select FIRST_NAME, LAST_NAME FROM EMPLOYEES");


        rs.next();
        System.out.println(rs.getString(1)+ " "+ rs.getString(2));

        rs.next();
        System.out.println(rs.getString(1)+ " "+ rs.getString(2));

        //to get the last in the table
        //last method
        /*
        ResultSet.TYPE_SCROLL_INSENSITIVE--> to flexibly navigate between rows
         ResultSet.CONCUR_READ_ONLY--> prevents updating the database information, makes it read only
         */
        rs.last();
        System.out.println(rs.getString(1)+ " "+ rs.getString(2));

        //how to find how many rows we have --> (last+ getRow)
        int rowNum = rs.getRow();
        System.out.println("rowNum = " + rowNum);

        System.out.println("----------------ABSOLUTE------------------");

        //to go directly to a specific row using the row number
        rs.absolute(46);
        System.out.println(rs.getString(1)+ " "+ rs.getString(2));

        System.out.println("---------------PREVIOUS-----------------");

        rs.previous();
        System.out.println(rs.getString(1)+ " "+ rs.getString(2));

        System.out.println("-------------------Whole Table----------------");
        //print the whole table
        rs.beforeFirst(); //this will reset us back to row 0/ default position
        while(rs.next()){
            System.out.println(rs.getString(1)+ " "+ rs.getString(2));
        }




        rs.close();
        statement.close();
        conn.close();

    }
}
