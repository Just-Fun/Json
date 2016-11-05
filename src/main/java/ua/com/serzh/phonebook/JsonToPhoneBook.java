package ua.com.serzh.phonebook;

import org.codehaus.jackson.map.ObjectMapper;
import ua.com.serzh.entities.User;
import ua.com.serzh.phonebookDivide.MapperObjectJson;
import ua.com.serzh.phonebookDivide.UserStore;

import java.io.File;
import java.io.IOException;
import java.util.List;

//import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by Serzh on 11/4/16.
 */
public class JsonToPhoneBook {

    static String pathName = "src/main/resources/UserTest.json";

    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();
        JsonToPhoneBook jsonToPhoneBook = new JsonToPhoneBook();

        // Convert JSON string from file to Object
        UserStore phoneBook = jsonToPhoneBook.getPhoneBookFromFile(mapper, pathName);
        System.out.println("UserStore.name: " + phoneBook.getName());

//            List<Contact> contacts = user.getContacts();
        List<User> users = phoneBook.getUsers();
        for (User user : users) {
            System.out.println("id: " + user.getUserId() + ", name: " + user.getName() + ", password: " + user.getPassword());

            System.out.println("--------------------------------");
        }

        writeToFile(phoneBook);
    }

    private UserStore getPhoneBookFromFile(ObjectMapper mapper, String pathName) {
        UserStore phoneBook = null;

        try {
            File file = new File(pathName);
            phoneBook = mapper.readValue(file, UserStore.class);
            return phoneBook;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return phoneBook;
    }

    private static void writeToFile(UserStore phoneBook) {
        MapperObjectJson.writeJsonToFile(phoneBook, pathName);
    }
}
