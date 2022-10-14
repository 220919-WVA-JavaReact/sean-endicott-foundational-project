package com.revature.dao;

import com.revature.models.Ticket;
import com.revature.models.User;

import java.util.List;

public interface TicketDAO {

    Ticket createTicket(float amount, String description, User user);

    List<Ticket> getMyTickets(int user_id);




    //-------------------------------------------------------------------------
    List<Ticket> getAllTickets();
//
//    List<Ticket> getTicketByUserId(int user_id);

    boolean updateTicketStatus(Ticket ticket);


    List<Ticket> getTicketByUserId(int user_id);


    List<Ticket> getTicketByType(String type);

}

