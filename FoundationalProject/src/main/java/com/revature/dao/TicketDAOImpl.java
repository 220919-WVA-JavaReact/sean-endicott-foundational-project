package com.revature.dao;

import com.revature.models.Ticket;
import com.revature.util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TicketDAOImpl implements TicketDAO {


    @Override
    public boolean createTicket(int id, float amount, String description, int userId) {
        System.out.println("Creating Ticket");

        Ticket ticket = new Ticket();

        Connection conn = ConnectionUtil.getConnection();

            String sql = "INSERT INTO tickets VALUES (?,?,?)";

            try {
                PreparedStatement stmt = conn.prepareStatement(sql);

                stmt = conn.prepareStatement(sql);
                stmt.setFloat(1, amount);
                stmt.setString(2, description);
                stmt.setInt(3, userId);

                int rowsUpdated = stmt.executeUpdate();
                if(rowsUpdated == 1){
                    return true;
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }


        return false;
    }

    @Override
    public List<Ticket> getAllTickets() {
        Connection conn = ConnectionUtil.getConnection();
        List<Ticket> tickets = new ArrayList<>();
        Statement stmt = null;

        try {
            stmt = conn.createStatement();
            String sql = "SELECT * FROM tickets";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                float amount = rs.getFloat("amount");
                String description = rs.getString("description");
                String status = rs.getString("status");
                int user_id = rs.getInt("user_id");

                Ticket ticket = new Ticket(id, amount, description, status, user_id);
                tickets.add(ticket);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return tickets;
    }

    @Override
    public List<Ticket> getTicketByUserId() {
        Connection conn = ConnectionUtil.getConnection();
        List<Ticket> ticketsById = new ArrayList<>();
        Statement stmt = null;

        try {
            stmt = conn.createStatement();
            String sql = "SELECT * FROM tickets WHERE user_id = ?";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                float amount = rs.getFloat("amount");
                String description = rs.getString("description");
                String status = rs.getString("status");
                int user_id = rs.getInt("user_id");

                Ticket ticket = new Ticket(id, amount, description, status, user_id);
                ticketsById.add(ticket);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return ticketsById;
    }

    @Override
    public boolean updateTicketStatus(Ticket ticket) {

        Connection conn = ConnectionUtil.getConnection();
        String sql = "UPDATE tickets SET status = ? ";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt = conn.prepareStatement(sql);
            //stmt.setString(1, status);
            int rowsUpdated = stmt.executeUpdate();
            if(rowsUpdated == 1){
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return false;
    }
}

