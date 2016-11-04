package ua.com.serzh.entities;

import java.util.List;

/**
 * Created by Serzh on 10/25/16.
 */
public class User {
    private Integer userId;
    private String name;
    private String password;

    private List<Contact> contacts;


    public User() {
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }


    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
