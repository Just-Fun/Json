package ua.com.serzh.phonebookDivide;

import org.codehaus.jackson.map.ObjectMapper;
import ua.com.serzh.entities.User;

import java.util.List;

import static ua.com.serzh.phonebookDivide.MapperObjectJson.writeJsonToFile;

//import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by Serzh on 11/4/16.
 */
public class UserDaoJSON {

    static String pathName = "src/main/resources/users.json";

    UserStore userStore;

    public UserDaoJSON() {
        String mappingClassName = UserStore.class.getName();
        userStore = (UserStore) MapperObjectJson.getObjectFromFile(pathName, userStore, mappingClassName);
        if (userStore == null) {
            userStore = new UserStore();
        }
    }

    public void addUser(User user) {
        userStore.addUser(user);
        writeJsonToFile(userStore, pathName);
    }

    public User searchByNameAndPassword(String name, String password) {
        return userStore.searchByNameAndPassword(name, password);
    }

    public User searchByName(String name) {
        return userStore.searchByName(name);
    }

    public static void main(String[] args) {

        UserDaoJSON userDaoJSON = new UserDaoJSON();

        User userNew = CreateEntity.createUser1();
        userNew.setName("ShwartzFIve");

        userDaoJSON.addUser(userNew);
    }
}
