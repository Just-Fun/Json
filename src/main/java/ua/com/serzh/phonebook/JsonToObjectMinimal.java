package ua.com.serzh.phonebook;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;
import org.codehaus.jackson.map.ObjectMapper;
import ua.com.serzh.entities.Contact;
import ua.com.serzh.entities.User;

import java.io.*;
import java.util.List;

//import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by Serzh on 11/4/16.
 */
public class JsonToObjectMinimal {
    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();

        try (Reader reader = new FileReader("src/main/resources/User.txt")) {
            // Convert JSON string from file to Object
//            File file = new File("src/main/resources/User.txt");

            JsonObject jsonObject = JsonObject.readFrom(reader);
            JsonObject jsonObject1 = Json.parse(reader).asObject();
//            JsonArray jsonArray = JsonArray.readFrom(getJsonInString());

            String name = jsonObject.get( "name" ).asString();
            JsonArray contacts = jsonObject.get("contacts").asArray();// asLong(),
            System.out.println(name);
            System.out.println(contacts.size());


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
