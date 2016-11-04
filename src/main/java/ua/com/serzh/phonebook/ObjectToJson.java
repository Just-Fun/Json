package ua.com.serzh.phonebook;

import org.codehaus.jackson.map.ObjectMapper;
import ua.com.serzh.entities.CreateUserForTest;
import ua.com.serzh.entities.User;
import ua.com.serzh.jackson.PhoneBook;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Serzh on 11/4/16.
 */
public class ObjectToJson {

    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();

        PhoneBook phoneBook = new PhoneBook();
        User user1 = CreateUserForTest.createUser1();
        User user2 = CreateUserForTest.createUser2();
        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        phoneBook.setUsers(users);

        try {
//            File file = new File("src/main/resources/User.txt");
            File file = new File("src/main/resources/UserTest.json");
            //display name only
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, phoneBook);

/*            //Convert object to JSON string
            String jsonInString = mapper.writeValueAsString(contact);
            System.out.println(jsonInString);*/

            //Convert object to JSON string and pretty print
            String jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(user1);
            System.out.println(jsonInString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}