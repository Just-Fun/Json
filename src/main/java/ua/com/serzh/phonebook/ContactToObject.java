package ua.com.serzh.phonebook;

import org.codehaus.jackson.map.ObjectMapper;
import ua.com.serzh.entities.Contact;

import java.io.File;
import java.io.IOException;

/**
 * Created by Serzh on 11/4/16.
 */
public class ContactToObject {
    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();

        try {
            // Convert JSON string from file to Object
            File file = new File("src/main/resources/jsonTestM.txt");
            Contact contact = mapper.readValue(file, Contact.class);
            System.out.println(contact);

            // Convert JSON string to Object
            String jsonInString = "{\n" +
                    "  \"contactId\" : 1,\n" +
                    "  \"surname\" : \"Joli\",\n" +
                    "  \"name\" : \"Angelina\",\n" +
                    "  \"patronymic\" : \"Petrovna\",\n" +
                    "  \"mobileNumber\" : \"+380664563345\",\n" +
                    "  \"homePhone\" : \"+380444563345\",\n" +
                    "  \"address\" : \"Kyiv, Sviatkova 15\",\n" +
                    "  \"email\" : \"joli@.gmail.com\",\n" +
                    "  \"userId\" : 1\n" +
                    "}";
            Contact contact1 = mapper.readValue(jsonInString, Contact.class);
            System.out.println(contact1);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
