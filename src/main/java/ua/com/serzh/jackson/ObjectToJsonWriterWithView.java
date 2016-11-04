package ua.com.serzh.jackson;

import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import ua.com.serzh.entities.User;

/**
 * Created by Serzh on 11/4/16.
 */
public class ObjectToJsonWriterWithView {

    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();
        //By default all fields without explicit view definition are included, disable this
        mapper.configure(SerializationConfig.Feature.DEFAULT_VIEW_INCLUSION, false);

        //For testing
        User user = createDummyUser();

        try {
            //display name only
            String jsonInString = mapper.writerWithView(Views.NameOnly.class).writeValueAsString(user);
            System.out.println(jsonInString);

            //display namd ana age
            jsonInString = mapper.writerWithView(Views.AgeAndName.class).writeValueAsString(user);
            System.out.println(jsonInString);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static User createDummyUser() {
            User user = new User();
            return user;
    }
}