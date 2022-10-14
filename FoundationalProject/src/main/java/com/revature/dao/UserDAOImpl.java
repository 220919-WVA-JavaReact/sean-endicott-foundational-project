package com.revature.dao;

import com.revature.models.User;
import com.revature.util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {


    @Override
    public User getByUsername(String username) {

        User user = new User();

        Connection conn = ConnectionUtil.getConnection();
            String sql = "Select * FROM users WHERE username = ?";

            try {
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, username);
                ResultSet rs = stmt.executeQuery();

                if( rs.next()){

                    int id = rs.getInt("id");
                    String first = rs.getString("first");
                    String last = rs.getString("last");
                    boolean manager = rs.getBoolean("manager");
                    String receivedUsername = rs.getString("username");
                    String password = rs.getString("password");

                    user = new User(id, first, last, manager, username, password);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        return user;
    }





    @Override
    public User createUser(String first, String last, String username, String password) {
        User user = new User();
        try (Connection conn = ConnectionUtil.getConnection()){
            String sql = "INSERT INTO users (first, last, manager, username, password) VALUES (?,?,?,?,?) RETURNING *";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, first);
            stmt.setString(2, last);
            stmt.setBoolean(3, false);
            stmt.setString(4, username);
            stmt.setString(5, password);
            ResultSet rs;

            rs = stmt.executeQuery();
            if(rs.next()) {
                int receivedId = rs.getInt("id");
                String receivedFirst = rs.getString("first");
                String receivedLast = rs.getString("last");
                boolean receivedManager = rs.getBoolean("manager");
                String receivedUsername = rs.getString("username");
                String receivedPassword = rs.getString("password");

                user = new User(receivedId, receivedFirst, receivedLast, receivedManager, receivedUsername, receivedPassword);
            }

        } catch (SQLException e) {
            System.out.println("Invalid username");
            //e.printStackTrace();
        }

        return user;
    }







    @Override
    public List<User> getAllUsers() {

        Connection conn = ConnectionUtil.getConnection();
        List<User> users = new ArrayList<>();
        Statement stmt = null;

        try {
            stmt = conn.createStatement();
            String sql = "SELECT * FROM users";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String first = rs.getString("first");
                String last = rs.getString("last");
                boolean manager = rs.getBoolean("manager");
                String username = rs.getString("username");
                String password = rs.getString("password");

                User user = new User(id, first, last, manager, username, password);
                users.add(user);
            }
        }catch (SQLException e){
                e.printStackTrace();
            }

        return users;
    }
}
