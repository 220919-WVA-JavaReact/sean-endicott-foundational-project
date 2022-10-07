package com.revature.dao;

import com.revature.models.Ticket;

import java.util.List;

public interface TicketDAO {

    boolean createTicket(int id, float amount, String description, int userId);

    List<Ticket> getAllTickets();

    List<Ticket> getTicketByUserId();

    boolean updateTicketStatus(Ticket ticket);


}
