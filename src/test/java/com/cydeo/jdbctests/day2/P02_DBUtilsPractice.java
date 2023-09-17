package com.cydeo.jdbctests.day2;

import com.cydeo.jdbctests.utility.DB_Util;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class P02_DBUtilsPractice {

    @Test
    public void task1(){

        //create a connection
        DB_Util.createConnection();

        //run query

        DB_Util.runQuery("select first_name, last_name, salary from employees");

        System.out.println("GET FIRST ROW/ FIRST COLUMN");
        //get result
        System.out.println(DB_Util.getFirstRowFirstColumn());

        System.out.println("---------GET ALL COLUMN NAMES------------");
        System.out.println(DB_Util.getAllColumnNamesAsList());

        System.out.println("------------GET ALL FIRST NAMES--------------");
        System.out.println(DB_Util.getColumnDataAsList(1));

        System.out.println("-------------GET NUMBER OF ROWS---------------");
        System.out.println(DB_Util.getRowCount());

        System.out.println("-----------GET SPECIFIC ROW INFO");
        System.out.println("-----------ROWMAP-------------");
        System.out.println(DB_Util.getRowMap(2));
        System.out.println("--------------LIST-----------");
        System.out.println(DB_Util.getRowDataAsList(2));

        System.out.println("---------------GET ALL DATA AS A LIST OF MAPS-------------------");
        List<Map<String, String>> allRowAsListOfMap = DB_Util.getAllRowAsListOfMap();

        for (Map<String, String> rowmap : allRowAsListOfMap) {
            System.out.println(rowmap);
        }


        //close connection
        DB_Util.destroy();
    }
}
