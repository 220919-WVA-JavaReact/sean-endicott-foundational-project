package com.revature.service;

import com.revature.dao.TicketDAO;
import com.revature.dao.TicketDAOImpl;
import com.revature.models.Ticket;
import com.revature.models.User;

import java.util.List;
import java.util.Scanner;

public class TicketService {

    Scanner sc = new Scanner(System.in);

   TicketDAO td = new TicketDAOImpl();

    public void createTicket(User user){

        System.out.println("enter reimbursement amount");
        String amount = String.valueOf(Float.parseFloat(sc.nextLine()));
        System.out.println("Enter description");
        String description = sc.nextLine();

        //boolean successful = td.createTicket(amount, description, user);

    }


    public void viewTickets(User isManager) {
        System.out.println("viewing all tickets");
        td.getAllTickets();
    }


    public void setStatus(User isManager){
        System.out.println("Enter status as Pending, approved, denied");


    }

    public void getAllTickets() {
        System.out.println("viewing all tickets");

        List<Ticket> ticketList = td.getAllTickets();

        for(Ticket ticket: ticketList) {
            System.out.println(ticket);
        }
    }


    public void getTicketByUserId() {
            System.out.println("Enter username to view tickets");
            List<Ticket> ticketByUserIdList = td.getTicketByUserId();

            for(Ticket ticket: ticketByUserIdList){
                System.out.println(ticket);
            }

        }

}
