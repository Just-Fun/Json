package ua.com.serzh.phonebook;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import ua.com.serzh.phonebookDivide.PhoneBook;

import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Serzh on 11/4/16.
 */
public class UserParseTest {
    //    private static final String filePath = "src/main/resources/User.txt";
    private static final String filePath = "src/main/resources/UserTest.json";

    public static void main(String[] args) {
        try (FileReader reader = new FileReader(filePath)) {
            JSONParser jsonParser = new JSONParser();
            JSONObject phoneBook = (JSONObject) jsonParser.parse(reader);

            PhoneBook phoneBook2 = (PhoneBook) jsonParser.parse(reader);

            // get a String from the JSON object
            String phoneBookName = (String) phoneBook.get("name");
            System.out.println("Object name is: " + phoneBookName);

            // get an array from the JSON object
            JSONArray users = (JSONArray) phoneBook.get("users");

            // take the elements of the json array
            for (int i = 0; i < users.size(); i++) {
                System.out.println("The " + i + " element of the array: " + users.get(i));
            }

            // take each value from the json array separately
            for (Object eachUser : users) {
                JSONObject user = (JSONObject) eachUser;

                Object name = user.get("name");
                Object password = user.get("password");
                System.out.println("User name: " + name + ", password: " + password +
                        "\nAnd contacts: " + user.get("contacts"));

                JSONArray contacts = (JSONArray) user.get("contacts");
                for (Object eachContact : contacts) {
                    JSONObject contact = (JSONObject) eachContact;
                    Object surname = contact.get("surname");
                    System.out.println("Contact surname: " + surname);
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}


/*            // get a number from the JSON object
            String password = (String) jsonObject.get("password");
            System.out.println("The password is: " + password);*/
