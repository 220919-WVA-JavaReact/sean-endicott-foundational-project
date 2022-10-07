package com.revature;

import com.revature.dao.TicketDAO;
import com.revature.models.User;
import com.revature.service.TicketService;
import com.revature.service.UserService;

import java.util.Scanner;

public class App {

    public static UserService us = new UserService();
    public static TicketService ts = new TicketService();






    public static void main(String[] args) {

        System.out.println("Enter 1 to login. Enter 2 to register user");
        Scanner sc = new Scanner(System.in);
        String choice = sc.nextLine();
        User loggedInUser = null;


        if(choice.equals("1")){
            loggedInUser = us.login();

        } else if (choice.equals("2")) {
            loggedInUser = us.register();
        }


       // while(loggedInUser != null){
            if(loggedInUser.isManager()) {
                System.out.println("Enter 1 to submit a new reimbursement ticket. Enter 2 to view a submitted ticket");
                String subChoice = sc.nextLine();

                switch (subChoice) {
                    case "1":
                        ts.createTicket(loggedInUser);
                        break;
                    case "2":
                        ts.getTicketByUserId();
                        break;
                    default:
                        System.out.println("Invalid input");
                }
            } else if (loggedInUser.isManager()){
                System.out.println("Enter 1. to view all tickets. 2. view tickets by id ");
                String subChoice = sc.nextLine();
                TicketService ts = null;

                switch(subChoice){
                    case "1":
                        ts.getAllTickets();
                        break;
                    case "2":
                        ts.getTicketByUserId();
                        break;

                }
            }
        //}


    }
}