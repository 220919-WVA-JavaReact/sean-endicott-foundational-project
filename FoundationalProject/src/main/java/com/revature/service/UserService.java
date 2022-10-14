package com.revature.service;

import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImpl;
import com.revature.models.User;

import java.util.List;
import java.util.Scanner;

public class UserService {

    UserDAO ud = new UserDAOImpl();
    Scanner sc = new Scanner(System.in);




    public User login() {
        System.out.println("Enter username");
        String username = sc.nextLine();
        System.out.println("Enter password");
        String password = sc.nextLine();

        User user = ud.getByUsername(username);

        if (user.getPassword().equals(password)) {
            System.out.println("Logged in");
            System.out.println(user);
            return user;
        } else {
            System.out.println("Invalid login");
            return null;
        }
    }



    public User register() {

        System.out.println("Enter first name");
        String first = sc.nextLine();
        System.out.println("Enter last name");
        String last = sc.nextLine();
        System.out.println("Enter username");
        String username = sc.nextLine();
        System.out.println("Enter password");
        String password = sc.nextLine();

        User user = ud.createUser(first, last, username, password);
        return user;
    }






    public void getAllUsers(){
        System.out.println("Using the database to return all user objects");

        List<User> userList = ud.getAllUsers();


        for(User user: userList){
            System.out.println(user);
        }
    }
}
