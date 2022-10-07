package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

    private static Connection conn = null;

    private ConnectionUtil(){

    }

    public static Connection getConnection(){
        try {
            if(conn != null && !conn.isClosed()){
                System.out.println("Use a previously made connection");
                return conn;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

//        String url = System.getenv("url");
//        String username = System.getenv("username");
//        String password = System.getenv("password");
        String url = "jdbc:postgresql://database-1.czycuryzlbsz.us-east-1.rds.amazonaws.com:5432/postgres";
        String username = "postgres";
        String password = "Chesapeake13";
        //String password = "D2RqNuqhWGnzXL";

        try {
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Established connection to database");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;

    }

}
