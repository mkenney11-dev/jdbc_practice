package com.cydeo.jdbctests.day2;

import com.cydeo.jdbctests.utility.DB_Util;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.sql.*;

public class P03_Library_Test {


        //create conneciton to MySQL Database
        String url = "jdbc:mysql://34.230.35.214:3306/library2";
        String username = "library2_client";
        String password = "6s2LQQTjBcGFfDhY";



    @Test
    public void task1(){
        DB_Util.createConnection(url, username, password);


       DB_Util.runQuery("select count(*) from books");

        String booksCount = DB_Util.getFirstRowFirstColumn();
        System.out.println(booksCount);



        DB_Util.destroy();

    }



}
