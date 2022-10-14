package com.revature.dao;

import com.revature.models.Ticket;

import com.revature.models.User;
import com.revature.util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TicketDAOImpl implements TicketDAO {


    @Override
    public Ticket createTicket(float amount, String description, User user) {
        System.out.println("Creating Ticket");
        Ticket ticket = new Ticket();
            try (Connection conn = ConnectionUtil.getConnection()){
                String sql = "INSERT INTO tickets ( amount, description, user_id) VALUES (?,?,?)RETURNING *";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setFloat(1, amount);
                stmt.setString(2, description);
                stmt.setInt(3, user.getId());
                ResultSet rs;
                if((rs = stmt.executeQuery()) != null){
                    rs.next();
                    int receivedId = rs.getInt("id");
                    float receivedAmount = rs.getFloat("amount");
                    String receivedDescription = rs.getString("description");
                    String status = rs.getString("status");
                    int user_id = rs.getInt("user_id");
                    ticket = new Ticket(receivedId, receivedAmount, receivedDescription, status, user_id );
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println(" Unable to create ticket");
            }
        return ticket;
    }
    @Override
    public List<Ticket> getMyTickets(int user_id) {
        List<Ticket> myTickets = new ArrayList<>();
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "SELECT * FROM tickets WHERE user_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, user_id);
            ResultSet rs;
            if((rs = stmt.executeQuery()) != null){
                while (rs.next()) {
                    int receivedId = rs.getInt("id");
                    float receivedAmount = rs.getFloat("amount");
                    String receivedDescription = rs.getString("description");
                    String status = rs.getString("status");
                    int id = rs.getInt("user_id");
                    Ticket ticket = new Ticket(receivedId, receivedAmount, receivedDescription, status, id);
                    myTickets.add(ticket);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return myTickets;
    }









    //--------------------------------------------------------------------------------------------------------------
    @Override
    public List<Ticket> getAllTickets() {
        Connection conn = ConnectionUtil.getConnection();
        List<Ticket> tickets = new ArrayList<>();


        try {
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM tickets";
            ResultSet rs = stmt.executeQuery(sql);
            //List<Ticket> tickets = new ArrayList<>();

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

    @Override
    public List<Ticket> getTicketByUserId(int user_id) {
        return null;
    }

    @Override
    public List<Ticket> getTicketByType(String type) {
        return null;
    }


//    @Override
//    public List<Ticket> getTicketByUserId(int user_id) {
//
//        List<Ticket> ticketsById = new ArrayList<>();
//
//        try (Connection conn = ConnectionUtil.getConnection()){
//            String sql = "SELECT * FROM tickets WHERE user_id = ?";
//            PreparedStatement stmt = conn.prepareStatement(sql);
//            stmt.setInt(1, user_id);
//
//            ResultSet rs;
//            if((rs = stmt.executeQuery()) != null){
//                rs.next();
//            }
//
//            while (rs.next()) {
//                int id = rs.getInt("id");
//                float amount = rs.getFloat("amount");
//                String description = rs.getString("description");
//                String status = rs.getString("status");
//                int receivedUser_id = rs.getInt("user_id");
//
//                Ticket ticket = new Ticket(id, amount, description, status, user_id);
//                ticketsById.add(ticket);
//
//            }
//        }catch (SQLException e){
//            e.printStackTrace();
//        }
//
//        return ticketsById ;
//    }
}