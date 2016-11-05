package ua.com.serzh.phonebookDivide;

import org.codehaus.jackson.map.ObjectMapper;
import ua.com.serzh.entities.User;

import java.util.List;

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
        writeToFile(userStore);
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

//        System.out.println("id: " + user.getUserId() + ", name: " + user.getName() + ", password: " + user.getPassword());


    }

/*    private ContactStore getObjectFromFile(String pathName) {
        ObjectMapper mapper = new ObjectMapper();
        ContactStore contactDao = null;

        try {
            File file = new File(pathName);
            contactDao = mapper.readValue(file, ContactStore.class);
            return contactDao;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contactDao;
    }*/

/*    private UserStore getPhoneBookFromFile(ObjectMapper mapper, String pathName) {
        UserStore phoneBook = null;
        try {
            File file = new File(pathName);
            phoneBook = mapper.readValue(file, UserStore.class);
            return phoneBook;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return phoneBook;
    }*/

    private static void writeToFile(UserStore phoneBook) {
        MapperObjectJson.writeJsonToFile(phoneBook, pathName);
    }
}
