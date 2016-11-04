package ua.com.serzh.phonebookDivide;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.IOException;

/**
 * Created by Serzh on 11/4/16.
 */
public class ObjectToJSONDiv {

    public static void main(String[] args) {

    }

    public static void writeJsonToFile(PhoneBook phoneBook) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            File file = new File("src/main/resources/user.json");
            // write phoneBook to File(JSON)
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, phoneBook);

            //Convert object to JSON string and pretty print
            String jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(phoneBook);
            System.out.println(jsonInString);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}