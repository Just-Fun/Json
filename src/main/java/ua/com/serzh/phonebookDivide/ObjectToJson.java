package ua.com.serzh.phonebookDivide;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.IOException;

/**
 * Created by Serzh on 11/4/16.
 */
public class ObjectToJson {

    public static void main(String[] args) {
    }

    public static void writeJsonToFile(Object object, String pathName) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            File file = new File(pathName);
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, object);

            //Convert object to JSON string and pretty print
            String jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
            System.out.println(jsonInString);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}