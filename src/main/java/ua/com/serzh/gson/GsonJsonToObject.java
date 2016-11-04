package ua.com.serzh.gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Map;

/**
 * Created by Serzh on 11/4/16.
 */
public class GsonJsonToObject {

    public static void main(String[] args) {

        Gson gson = new Gson();

        try (Reader reader = new FileReader("src/main/resources/jsonGson.txt")) {

            // Convert JSON to Java Object
            Staff staff = gson.fromJson(reader, Staff.class);
            System.out.println(staff.getName());

//            Convert a JSON Array to a List, using TypeToken
            String json = "[{\"name\":\"mkyong\"}, {\"name\":\"laplap\"}]";
            List<Staff> list = gson.fromJson(json, new TypeToken<List<Staff>>(){}.getType());
            list.forEach(x -> System.out.println(x.getName()));

            System.out.println();
//            Convert a JSON to a Map
            String json2 = "{\"name\":\"mkyong\", \"age\":33}";
            Map<String, Object> map = gson.fromJson(json2, new TypeToken<Map<String, Object>>(){}.getType());
            map.forEach((x,y)-> System.out.println("key : " + x + " , value : " + y));

            // Convert JSON to JsonElement, and later to String
            /*JsonElement json = gson.fromJson(reader, JsonElement.class);
            String jsonInString = gson.toJson(json);
            System.out.println(jsonInString);*/

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}