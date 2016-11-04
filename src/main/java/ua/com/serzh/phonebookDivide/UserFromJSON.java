package ua.com.serzh.phonebookDivide;

import org.codehaus.jackson.map.ObjectMapper;
import ua.com.serzh.entities.User;

import java.io.File;
import java.io.IOException;
import java.util.List;

//import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by Serzh on 11/4/16.
 */
public class UserFromJSON {

    static String pathName = "src/main/resources/users.json";

    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();
        UserFromJSON jsonToPhoneBook = new UserFromJSON();

        // Convert JSON string from file to Object
        PhoneBook phoneBook = jsonToPhoneBook.getPhoneBookFromFile(mapper, pathName);
        System.out.println("PhoneBook.name: " + phoneBook.getName());

        List<User> users = phoneBook.getUsers();
        for (User user : users) {
            System.out.println("id: " + user.getUserId() + ", name: " + user.getName() + ", password: " + user.getPassword());
        }

        User userNew = CreateEntity.createUser1();
        userNew.setName("Shwartz");
        phoneBook.addUser(userNew);

        writeToFile(phoneBook);

        User user1 = phoneBook.searchByName("Shwartz");
        System.out.println(user1.getUserId());
        User user2 = phoneBook.searchByNameAndPassword("Shwartz", "first");
        System.out.println(user2.getUserId());

        User userDont = phoneBook.searchByNameAndPassword("Shwartz", "firstsrg");
        if (userDont == null) {
            System.out.println("Don't find...");
        }
    }

    private PhoneBook getPhoneBookFromFile(ObjectMapper mapper, String pathName) {
        PhoneBook phoneBook = null;
        try {
            File file = new File(pathName);
            phoneBook = mapper.readValue(file, PhoneBook.class);
            return phoneBook;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return phoneBook;
    }

    private static void writeToFile(PhoneBook phoneBook) {
        ObjectToJson.writeJsonToFile(phoneBook, pathName);
    }
}
