package com.cydeo.jdbctests.day1;

import org.junit.jupiter.api.Test;

import java.sql.*;

public class P01_JDBCIntro {

    //CONNECTION STRING
    String dbURL = "jdbc:oracle:thin:@52.91.202.28:1521:XE";
    String dbUsername = "hr";
    String dbPassword = "hr";

    @Test
    public void task1() throws SQLException {

        Connection conn = DriverManager.getConnection(dbURL, dbUsername, dbPassword);

        //will help us to execute queries
        Statement statement = conn.createStatement();

        //ResultSet will store data after execution. It only stores data, not table info
        ResultSet rs = statement.executeQuery("select * from DEPARTMENTS where MANAGER_ID is not null");

        //10-administration-200-1700

        while(rs.next()){

            System.out.println(rs.getInt(1)+ " - "+ rs.getString(2)+ " - "+ rs.getString(3)+ " - "+ rs.getString(4));
        }


        System.out.println("----------------QUERY 2------------------");

        //Can we run another query in the same connection? -- YES

        rs = statement.executeQuery("select * from LOCATIONS");

        while(rs.next()){
            System.out.println(rs.getString(2)+" - "+ rs.getString(4));
        }



        //close connection
        rs.close();
        statement.close();
        conn.close();


    }
}
