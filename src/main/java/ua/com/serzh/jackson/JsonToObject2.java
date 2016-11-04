package ua.com.serzh.jackson;

import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import com.fasterxml.jackson.core.type.TypeReference;
import org.codehaus.jackson.map.ObjectMapper;
//import com.fasterxml.jackson.databind.ObjectMapper;
import org.codehaus.jackson.map.type.TypeFactory;
import ua.com.serzh.entities.Contact;
import ua.com.serzh.entities.User;
import ua.com.serzh.gson.Staff;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by Serzh on 11/4/16.
 */
public class JsonToObject2 {
    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();

        try {
            // Convert JSON string from file to Object
            File file = new File("src/main/resources/User.txt");
            User user = mapper.readValue(file, User.class);
//            System.out.println(user.getContacts());

            // Convert JSON string to Object
  /*          String jsonInString = getJsonInString();
            User user1 = mapper.readValue(jsonInString, User.class);
            System.out.println(user1);*/

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getJsonInString() {
        String jsonInString = "{\n" +
                "  \"userId\" : 1,\n" +
                "  \"name\" : \"Serzh\",\n" +
                "  \"password\" : \"first\",\n" +
                "  \"contacts\" : [ {\n" +
                "    \"contactId\" : 1,\n" +
                "    \"surname\" : \"Joli\",\n" +
                "    \"name\" : \"Angelina\",\n" +
                "    \"patronymic\" : \"Petrovna\",\n" +
                "    \"mobileNumber\" : \"+380664563345\",\n" +
                "    \"homePhone\" : \"+380444563345\",\n" +
                "    \"address\" : \"Kyiv, Sviatkova 15\",\n" +
                "    \"email\" : \"joli@.gmail.com\",\n" +
                "    \"userId\" : 1\n" +
                "  }, {\n" +
                "    \"contactId\" : 1,\n" +
                "    \"surname\" : \"Joli\",\n" +
                "    \"name\" : \"Angelina\",\n" +
                "    \"patronymic\" : \"Petrovna\",\n" +
                "    \"mobileNumber\" : \"+380664563345\",\n" +
                "    \"homePhone\" : \"+380444563345\",\n" +
                "    \"address\" : \"Kyiv, Sviatkova 15\",\n" +
                "    \"email\" : \"joli@.gmail.com\",\n" +
                "    \"userId\" : 1\n" +
                "  } ]\n" +
                "}";
        return jsonInString;
    }

}
