package com.revature.models;

import java.util.Objects;

public class Ticket {
    private int id;
    private float amount;
    private String description;
    private String status;
    private int userId;
    //Ticket ticket;

    public Ticket(int id, float amount, String description, String status, int userId){
        this.id = id;
        this.amount = amount;
        this.description = description;
        this.status = status;
        this.userId = userId;
    }

    public Ticket(int id) {
        this.id = id;
    }

    public Ticket(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return id == ticket.id && Float.compare(ticket.amount, amount) == 0 && userId == ticket.userId && Objects.equals(description, ticket.description) && Objects.equals(status, ticket.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, description, status, userId);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", userId=" + userId +
                '}';
    }
}
