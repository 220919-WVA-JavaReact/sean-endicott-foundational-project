package com.revature.models;

import java.util.Objects;

public class User {

    private int id;
    private String first;
    private String last;
    private boolean manager;
    private String username;
    private String password;

    public User(int id, String first, String last, boolean manager, String username, String password) {
        this.id = id;
        this.first = first;
        this.last = last;
        this.manager = manager;
        this.username = username;
        this.password = password;
    }

    public User(String first, String last, boolean manager, String username, String password) {
        this.first = first;
        this.last = last;
        this.manager = manager;
        this.username = username;
        this.password = password;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public boolean isManager() {
        return manager;
    }

    public void setManager(boolean manager) {
        this.manager = manager;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(first, user.first) && Objects.equals(last, user.last) && Objects.equals(manager, user.manager) && Objects.equals(username, user.username) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, first, last, manager, username, password);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", first='" + first + '\'' +
                ", last='" + last + '\'' +
                ", manager='" + manager + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
