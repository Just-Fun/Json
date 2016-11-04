package ua.com.serzh.phonebookDivide;

import org.codehaus.jackson.map.ObjectMapper;
import ua.com.serzh.entities.Contact;
import ua.com.serzh.entities.User;

import java.io.File;
import java.io.IOException;
import java.util.List;

//import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by Serzh on 11/4/16.
 */
public class ContactFromJSON {

    static String pathName = "src/main/resources/contacts.json";

    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();
        ContactFromJSON contactFromJSON = new ContactFromJSON();

        // Convert JSON string from file to Object
        ContactDaoImpl contactDao = contactFromJSON.getContactsFromFile(mapper, pathName);
        System.out.println("ContactDaoImpl.name: " + contactDao.getName());

        List<Contact> contacts = contactDao.getContacts();

        contacts.forEach(contact -> System.out.println("id: " + contact.getContactId() + " - " + contact.getSurname()));
        System.out.println("--------------------");

        //Test deleteContact
/*        Contact contact = contactDao.searchContactById(2);
        contactDao.deleteContact(contact);*/


        //Test searchContactById
       /* Contact contact = contactDao.searchContactById(2);
        contact.setSurname("AngelinaUpdated");
        contact.setName("JoliUpdated");
        contactDao.updateContact(contact);*/


        //Test allUserContacts
     /*   List<Contact> list = contactDao.allUserContacts(2);
        list.forEach(contact -> System.out.println(contact.getSurname()));*/

        // Test searchContactById
       /* Contact contact = contactDao.searchContactById(2);
        System.out.println(contact.getSurname());*/


        // Test insertContact
        User user = CreateEntity.createUser1();
        Contact contact = CreateEntity.createContact1(user);
        contact.setSurname("PavarottiNewOneT");
        contact.setName("LuchanoNewOneT");

       contactDao.insertContact(contact);

        writeToFile(contactDao);

        // Test searchContactByAnyField
    /*    List<Contact> joli = contactDao.searchContactByAnyField("Joli", 1);

        for (Contact contact : joli) {
            System.out.println("id: " + contact.getContactId() + " - " + contact.getSurname());
        }*/

//      contactDao.deleteContact

/*        for (Contact contact : contacts) {
            if (contact.getContactId() == 2) {
                contact.setSurname("Aniston");
            }
        }
        contacts.forEach(contact -> System.out.println("id: " + contact.getContactId() + " - " + contact.getSurname()));

        System.out.println("Change name........");

        for (Contact contact : contacts) {
            if (contact.getContactId() == 2) {
                contact.setSurname("JoliNew");
            }
        }
        contacts.forEach(contact -> System.out.println("id: " + contact.getContactId() + " - " + contact.getSurname()));

        System.out.println("--------------------------------");*/

//        writeToFile(contactDao);
    }

    private ContactDaoImpl getContactsFromFile(ObjectMapper mapper, String pathName) {
        ContactDaoImpl contactDao = null;

        try {
            File file = new File(pathName);
            contactDao = mapper.readValue(file, ContactDaoImpl.class);
            return contactDao;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contactDao;
    }

    private static void writeToFile(ContactDaoImpl contactDao) {
        ObjectToJson.writeJsonToFile(contactDao, pathName);
    }
}
