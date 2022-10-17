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
        //main menu-----------------------------------------------------------------------
        boolean running = true;
        while(running) {
            System.out.println("Enter\n1-> to login.\n2-> to register user.\n3-> to quit");
            Scanner sc = new Scanner(System.in);
            String choice = sc.nextLine();
            User loggedInUser = null;
            if (choice.equals("1")) {
                loggedInUser = us.login();

            }
            else if (choice.equals("2")) {
                    if(loggedInUser != us.register()){
                        System.out.println("1-> re-enter user info\n2-> exit\n3-> to continue");
                        String subChoice = sc.nextLine();
                        switch(subChoice){
                            case "1":
                                loggedInUser = us.register();
                                break;
                            case "2":
                                running = false;
                                break;
                            case "3":
                                continue;
                        }
                    }
            }
            else if(choice.equals ("3")){
                running = false;
            }
            else {
                System.out.println("Invalid entry");
            }
            while (loggedInUser != null) {
                if (!loggedInUser.isManager()) {
                    System.out.println("Enter\n1-> to submit a new reimbursement ticket.\n2-> to view your submitted tickets.\n3-> search by ticket type.\n4-> manager functions\n5-> to logout");
                    String subChoice = sc.nextLine();
                    switch (subChoice) {
                        case "1":
                            ts.createTicket(loggedInUser);
                            break;
                        case "2":
                            ts.getMyTickets(loggedInUser);
                            break;
                        case "3":
                            ts.getTicketByType();
                            break;
                        case "4":
                if (loggedInUser.isManager()){
                    System.out.println("Enter\n1-> to view all tickets.\n2-> view by id\n3-> view by type");
                    String mngChoice = sc.nextLine();
                    TicketService ts = null;
                    switch(mngChoice){
                        case "1":
                            ts.getAllTickets();
                            break;
                        case "2":
                            ts.getTicketById();
                            break;
                    }
                }

                        case "5":
                            loggedInUser = null;
                            break;
                        default:
                            System.out.println("Invalid input");
                            break;
                    }
                }
//            else if (loggedInUser.isManager()){
//                System.out.println("Enter 1. to view all tickets.\n2-> view by id\n3-> view by type");
//                String subChoice = sc.nextLine();
//                TicketService ts = null;
//                switch(subChoice){
//                    case "1":
//                        ts.getAllTickets();
//                        break;
//                    case "2":
//                        ts.getTicketById();
//                        break;
//                }
//            }
            }

        }
    }
}