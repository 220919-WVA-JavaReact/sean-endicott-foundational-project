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
        float amount = sc.nextFloat();
        sc.nextLine();
        System.out.println("Enter description");
        String description = sc.nextLine();
        System.out.println("Enter reimbursement type");
        String type = sc.nextLine();
        System.out.println("ticket status pending");
        String status = sc.nextLine();

        Ticket ticket = td.createTicket(amount, description, type, status, user);
    }


    public void getMyTickets(User user){
        List<Ticket> tickets = td.getMyTickets(user.getId());
        for(Ticket ticket : tickets) {
            System.out.println(ticket);
        }
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


    public void getTicketById() {
            System.out.println("Enter user id to view tickets");
            int user_id = sc.nextInt();
            List<Ticket> ticketByUserIdList = td.getTicketByUserId(user_id);
            for(Ticket ticket : ticketByUserIdList ) {
                System.out.println(ticket);
            }
        }

    public void getTicketByType() {
        System.out.println("Enter ticket type to view tickets");
        int user_id = sc.nextInt();
        List<Ticket> ticketByUserIdList = td.getTicketByUserId(user_id);
        for (Ticket ticket : ticketByUserIdList) {
            System.out.println(ticket);
        }
    }

}
