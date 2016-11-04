package ua.com.serzh.jackson;

import ua.com.serzh.entities.CreateUserForTest;
import ua.com.serzh.entities.User;

import java.util.ArrayList;
import java.util.List;

//import org.springframework.stereotype.Component;

/**
 * Created by Serzh on 11/4/16.
 */
//@Component
public class PhoneBook {

    private String name = "phoneBook";
    private  List<User> users;

    public PhoneBook() {
    }

    public PhoneBook( List<User> users) {
        this.users = users;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public  List<User> getUsers() {
        return users;
    }

    public  void setUsers(List<User> users) {
        this.users = users;
    }

    {
        /*users = new ArrayList();
        users.add(CreateUserForTest.createUser1());
        users.add(CreateUserForTest.createUser2());*/
    }

    /**
     * Returns list of customers from dummy database.
     *
     * @return list of customers
     */
    public List list() {
        return users;
    }

    /**
     * Return customer object for given id from dummy database. If customer is
     * not found for id, returns null.
     *
     * @param id customer id
     * @return customer object for given id
     */
    public User get(Integer id) {

        for (User c : users) {
            if (c.getUserId().equals(id)) {
                return c;
            }
        }
        return null;
    }

    /**
     * Create new customer in dummy database. Updates the id and insert new
     * customer in list.
     *
     * @param user User object
     * @return customer object with updated id
     */
    public User create(User user) {
        user.setUserId(users.size() + 1);
        users.add(user);
        return user;
    }

    /**
     * Delete the customer object from dummy database. If customer not found for
     * given id, returns null.
     *
     * @param id the customer id
     * @return id of deleted customer object
     */
    public Integer delete(Integer id) {

        for (User c : users) {
            if (c.getUserId().equals(id)) {
                users.remove(c);
                return id;
            }
        }
        return null;
    }

    /**
     * Update the user object for given id in dummy database. If customer
     * not exists, returns null
     *
     * @param id the user id
     * @param user
     * @return user object with id
     */
//    TODO use it for Contact too
    public User update(Integer id, User user) {

        for (User c : users) {
            if (c.getUserId().equals(id)) {
                user.setUserId(c.getUserId());
                users.remove(c);
                users.add(user);
                return user;
            }
        }
        return null;
    }
}