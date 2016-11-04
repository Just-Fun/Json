package ua.com.serzh.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Serzh on 11/4/16.
 */
public class CreateUserForTest {

    public static User createUser1() {
        User user = new User("Luchano", "first");
        user.setUserId(1);

        Contact contact1 = createContactTest(user);
        Contact contact2 = createContactTest2(user);

        List<Contact> contacts = new ArrayList<>();
        contacts.add(contact1);
        contacts.add(contact2);

        user.setContacts(contacts);

        return user;
    }

    public static User createUser2() {
        User user = new User("Domingo", "second");
        user.setUserId(1);

        Contact contact1 = createContactTest(user);
        contact1.setSurname("Soprano");
        Contact contact2 = createContactTest2(user);
        contact2.setSurname("Alt");

        List<Contact> contacts = new ArrayList<>();
        contacts.add(contact1);
        contacts.add(contact2);

        user.setContacts(contacts);

        return user;
    }

    private static Contact createContactTest(User user) {

/*        User user = new User( "Serzh",  "first");
//        User user = new User(1, "Serzh", "first");
        user.setUserId(1);*/

        String surname = "Joli";
        String name = "Angelina";
        String patronymic = "Petrovna";
        String mobileNumber = "+380664563345";
        String homePhone = "+380444563345";
        String address = "Kyiv, Sviatkova 15";
        String email = "joli@.gmail.com";

        Contact contact = new Contact(
                surname, name, patronymic, mobileNumber, homePhone, address, email, user.getUserId());

        contact.setContactId(1);

        return contact;
    }

    private static Contact createContactTest2(User user) {

        String surname = "Joli2";
        String name = "Angelina2";
        String patronymic = "Petrovna2";
        String mobileNumber = "+380664563346";
        String homePhone = "+380444563346";
        String address = "Kyiv, Sviatkova 16";
        String email = "joli2@.gmail.com";

        Contact contact = new Contact(
                surname, name, patronymic, mobileNumber, homePhone, address, email, user.getUserId());

        contact.setContactId(2);

        return contact;
    }
}
