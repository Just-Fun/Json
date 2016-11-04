package ua.com.serzh.phonebookDivide;

import ua.com.serzh.entities.User;

import java.util.List;

//import org.springframework.stereotype.Component;

/**
 * Created by Serzh on 11/4/16.
 */
//@Component
public class PhoneBook {

    private String name = "users";
    int countId;
    private  List<User> users;

    public PhoneBook() {
    }

    public int getCountId() {
        return countId;
    }

    public void setCountId(int countId) {
        this.countId = countId;
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

    public List list() {
        return users;
    }

    public User get(Integer id) {

        for (User c : users) {
            if (c.getUserId().equals(id)) {
                return c;
            }
        }
        return null;
    }

    public Integer delete(Integer id) {

        for (User user : users) {
            if (user.getUserId().equals(id)) {
                users.remove(user);
                return id;
            }
        }
        return null;
    }

//    TODO use it for Contact too
    public User update(Integer id, User userNew) {

        for (User userOld : users) {
            if (userOld.getUserId().equals(id)) {
                userNew.setUserId(userOld.getUserId());
                users.remove(userOld);
                users.add(userNew);
                return userNew;
            }
        }
        return null;
    }

    public User addUser(User user) {
        int id = getCountId();
        user.setUserId(id);
        setCountId(++id);
        users.add(user);
        return user;
    }

   public User searchByNameAndPassword(String name, String password){
       for (User user : users) {
           if (user.getName().equals(name) && user.getPassword().equals(password)) {
               return user;
           }
       }
       return null;
   }

    public User searchByName(String name){
        for (User user : users) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }
}