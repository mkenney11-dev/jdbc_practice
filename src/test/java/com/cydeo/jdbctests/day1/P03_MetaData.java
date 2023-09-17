package com.cydeo.jdbctests.day1;

import org.junit.jupiter.api.Test;

import java.sql.*;

public class P03_MetaData {
    String dbURL = "jdbc:oracle:thin:@52.91.202.28:1521:XE";
    String dbUsername = "hr";
    String dbPassword = "hr";

    @Test
    public void task1() throws SQLException {

        Connection conn = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
        Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = statement.executeQuery("select *FROM EMPLOYEES");


        //DatabaseMetaData
        DatabaseMetaData dbMetaData = conn.getMetaData();

        System.out.println(dbMetaData.getUserName());
        System.out.println(dbMetaData.getDatabaseProductName());
        System.out.println(dbMetaData.getDatabaseProductVersion());
        System.out.println(dbMetaData.getDriverName());


        //ResultSetMetaData
        ResultSetMetaData rsmd = rs.getMetaData();

        //how many columns do we have currently
        int columnCount = rsmd.getColumnCount();
        System.out.println(columnCount);

        //get the column name
        System.out.println(rsmd.getColumnName(2));

        //print all column names dynamically

        System.out.println("-------------Column Names ---------------");
        for (int i = 1; i < columnCount; i++) {
            System.out.println(rsmd.getColumnName(i));
        }

        /*
        ResultSet --> Holding table data
            rs.next()--> iterates each row dynamically (with while loop)
            rs.getString(columnIndex) --> used to retrieve data itself
            rs.getString(columnName) --> used to retrieve data itself

        ResultSetMetaData--> holds table information(ColumnNames - ColumnCount)
            rsmd.getColumnCount()--> returns how many columns we have
            rsmd.getColumnName() --> returns column names specified by index

         */

        //Write a code that prints a whole tables information for every query
        //Column Name - Column value
        //EMPLOYEE_ID - 100
        //FIRST_NAME - Steven

        System.out.println("-------------------PRINT ALL DATA DYNAMICALLY---------------------");

        //iterate through each row
        while(rs.next()){
            //everything here will happen for each row
            //this loop will iterate through the amount of columns that are present in the table for each row. Once we run out of columns
            //then the loop will exit, and move back to the next iteration of the while loop
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(rsmd.getColumnName(i) + " - "+ rs.getString(i));
            }
        }

        //Map<String,Object> rowMap = new HashMap<>();
        //to insert information --> rowMap.put("FIRST_NAME", "Steven")
        //                          rowMap.put("LAST_NAME". "KING")
        //                          rowMap.put("SALARY", 24000)




        rs.close();
        statement.close();
        conn.close();
    }
}
