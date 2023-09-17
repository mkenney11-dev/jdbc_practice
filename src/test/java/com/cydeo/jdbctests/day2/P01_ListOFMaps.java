package com.cydeo.jdbctests.day2;

import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P01_ListOFMaps {

    String dbURL = "jdbc:oracle:thin:@52.91.202.28:1521:XE";
    String dbUsername = "hr";
    String dbPassword = "hr";

    @Test
    public void task1() {
        Map<String, Object> rowMap1 = new HashMap<>();
        System.out.println("-------------ROW MAP 1---------------");
        rowMap1.put("FIRST_NAME", "Steven");
        rowMap1.put("LAST_NAME", "King");
        rowMap1.put("SALARY", 24000);

        System.out.println(rowMap1);

        Map<String, Object> rowMap2 = new HashMap<>();
        System.out.println("-------------ROW MAP 2---------------");
        rowMap2.put("FIRST_NAME", "Neena");
        rowMap2.put("LAST_NAME", "Kochhar");
        rowMap2.put("SALARY", 17000);

        System.out.println(rowMap2);

        System.out.println("--------------------------------------");

        //we use an arraylist here becuase its the only collection type that can store a list within a list
        List<Map<String, Object>> dataList = new ArrayList<>();

        // we will put each of the rowMaps into the list

        dataList.add(rowMap1);
        dataList.add(rowMap2);

        System.out.println(dataList);


        //this line allows us to obtain a specific data item from the list
        // first input is the index of the element of the list it belongs to, then you input the key
        System.out.println(dataList.get(0).get("LAST_NAME")); //returns King


    }


    @Test
    public void task2() throws SQLException {

        Connection conn = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
        Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = statement.executeQuery("select FIRST_NAME, LAST_NAME, SALARY FROM EMPLOYEES WHERE ROWNUM <6");

        ResultSetMetaData rsmd = rs.getMetaData();
        rs.next();//we need to move to first row to fill the rowMap1
        Map<String, Object> rowMap1 = new HashMap<>();

        System.out.println("-------------ROW MAP 1---------------");
        rowMap1.put(rsmd.getColumnName(1), rs.getString(1));
        rowMap1.put(rsmd.getColumnName(2), rs.getString(2));
        rowMap1.put(rsmd.getColumnName(3), rs.getString(3));

        System.out.println(rowMap1);

        rs.next();
        Map<String, Object> rowMap2 = new HashMap<>();
        System.out.println("-------------ROW MAP 2---------------");
        rowMap2.put(rsmd.getColumnName(1), rs.getString(1));
        rowMap2.put(rsmd.getColumnName(2), rs.getString(2));
        rowMap2.put(rsmd.getColumnName(3), rs.getString(3));

        System.out.println(rowMap2);


        rs.next();
        Map<String, Object> rowMap3 = new HashMap<>();
        System.out.println("-------------ROW MAP 3---------------");
        rowMap3.put(rsmd.getColumnName(1), rs.getString(1));
        rowMap3.put(rsmd.getColumnName(2), rs.getString(2));
        rowMap3.put(rsmd.getColumnName(3), rs.getString(3));

        System.out.println(rowMap3);
        System.out.println("------------------------");

        List<Map<String, Object>> dataList = new ArrayList<>();

        dataList.add(rowMap1);
        dataList.add(rowMap2);
        dataList.add(rowMap3);

        System.out.println(dataList);

        System.out.println(dataList.get(0).get("LAST_NAME")); //returns King


        rs.close();
        statement.close();
        conn.close();
    }

    @Test
    public void task3() throws SQLException {


        Connection conn = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
        Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = statement.executeQuery("select FIRST_NAME, LAST_NAME, SALARY FROM EMPLOYEES");

        //create rsmd to get column name and count
        ResultSetMetaData rsmd = rs.getMetaData();


        //create your list of maps to keep information
        List<Map<String, Object>> dataList = new ArrayList<>();

        //how many columns do we have?
        int columnCount = rsmd.getColumnCount();

        //iterate through each row
        while (rs.next()) {
            //create an empty map to hold one row of information
            //every time this loop is iterated through it will create a new map for each row
            Map<String, Object> rowMap = new HashMap<>();

            //this inner loop will iterate through each column dynamically to fill the map
            for (int i = 1; i <= columnCount; i++) {
                //key = column name, value = column value
                rowMap.put(rsmd.getColumnName(i), rs.getString(i));
            }

            //add the row of information to the list before it iterates through the next row
            dataList.add(rowMap);

        }

        //this will print each row Map
        for (Map<String, Object> eachRow : dataList) {
            System.out.println(eachRow);
        }


        rs.close();
        statement.close();
        conn.close();

    }


}
