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
        boolean running = true;
        while(running) {

            System.out.println("Enter 1 -> to login.\nEnter 2 -> to register user.\nEnter 3 -> to quit");
            Scanner sc = new Scanner(System.in);
            String choice = sc.nextLine();
            User loggedInUser = null;

            if (choice.equals("1")) {
                loggedInUser = us.login();
            } else if (choice.equals("2")) {

                if(loggedInUser != us.register()){
                    System.out.println("1-> re-enter username\n2-> exit");
                    String subChoice = sc.nextLine();
                    switch(subChoice){
                        case "1":
                            loggedInUser = us.register();
                            break;
                        case "2":
                            running = false;
                            break;
                    }
                }
            } else if(choice.equals ("3")){
                running = false;
            } else {
                System.out.println("Invalid entry");
            }

            while (loggedInUser != null) {
                if (!loggedInUser.isManager()) {
                    System.out.println("Enter 1 to submit a new reimbursement ticket. Enter 2 to view your submitted tickets. Enter 3 to logout");
                    String subChoice = sc.nextLine();

                    switch (subChoice) {
                        case "1":
                            ts.createTicket(loggedInUser);
                            break;
                        case "2":
                            ts.getMyTickets(loggedInUser);
                            break;
                        case "3":
                            loggedInUser = null;
                            break;
                        default:
                            System.out.println("Invalid input");
                            break;
                    }
                }
            else if (loggedInUser.isManager()){
                System.out.println("Enter 1. to view all tickets. 2. view tickets by id ");
                String subChoice = sc.nextLine();
                TicketService ts = null;

                switch(subChoice){
                    case "1":
                        ts.getAllTickets();
                        break;
                    case "2":
                        ts.getTicketById();
                        break;

                }
            }
            }

        }
    }
}