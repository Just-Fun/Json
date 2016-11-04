package ua.com.serzh.jackson;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;
import ua.com.serzh.entities.User;

/**
 * Created by Serzh on 11/4/16.
 */
public class JSONToObject {
    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();

        try {
            // Convert JSON string from file to Object
            File file = new File("src/main/resources/jsonTest.txt");
            User user = mapper.readValue(file, User.class);
            System.out.println(user);

            // Convert JSON string to Object
            String jsonInString = "{\n" +
                    "    \"userId\": 1,\n" +
                    "    \"name\": \"AppShah\",\n" +
                    "    \"password\": \"pass\"\n" +
                    "}";
            User user1 = mapper.readValue(jsonInString, User.class);
            System.out.println(user1);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
