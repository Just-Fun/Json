package ua.com.serzh.phonebook;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import ua.com.serzh.entities.Contact;
import ua.com.serzh.entities.User;

import java.io.File;
import java.io.IOException;

/**
 * Created by Serzh on 11/4/16.
 */
public class ContactToJson {

    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();

        //For testing
        Contact contact = createContactTest();

        try {
            File file = new File("src/main/resources/jsonTestM.txt");
            //display name only
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, contact);

/*            //Convert object to JSON string
            String jsonInString = mapper.writeValueAsString(contact);
            System.out.println(jsonInString);*/

            //Convert object to JSON string and pretty print
            String jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(contact);
            System.out.println(jsonInString);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static Contact createContactTest() {

        User user = new User( "Serzh",  "first");
//        User user = new User(1, "Serzh", "first");
        user.setUserId(1);

        String surname = "Joli";
        String name = "Angelina";
        String patronymic = "Petrovna";
        String mobileNumber = "+380664563345";
        String homePhone = "+380444563345";
        String address = "Kyiv, Sviatkova 15";
        String email = "joli@.gmail.com";

        Contact contact = new Contact(
                surname, name, patronymic, mobileNumber, homePhone, address, email, user.getUserId());

        contact.setContactId(1);

        return contact;
    }
}