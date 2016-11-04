package ua.com.serzh.mkyong;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import ua.com.serzh.entities.User;

/**
 * Created by Serzh on 11/4/16.
 */
public class ObjectToJSON {
    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();

        //For testing
        User user = createDummyUser();

        try {
            //Convert object to JSON string and save into file directly
//            mapper.writeValue(new File("D:\\user.json"), user);
            File file = new File("src/main/resources/jsonTestM.txt");
//            mapper.writeValue(file, user);
            //            !!! writerWithDefaultPrettyPrinter() !!!
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, user);

            //Convert object to JSON string
            String jsonInString = mapper.writeValueAsString(user);
            System.out.println(jsonInString);

            //Convert object to JSON string and pretty print
//            !!! writerWithDefaultPrettyPrinter() !!!
            jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(user);
            System.out.println(jsonInString);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static User createDummyUser(){

        User user = new User();
        return user;

    }
}