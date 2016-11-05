package ua.com.serzh.phonebookDivide;

import ua.com.serzh.entities.Contact;
import ua.com.serzh.entities.User;

import java.util.List;

import static ua.com.serzh.phonebookDivide.MapperObjectJson.writeJsonToFile;

/**
 * Created by Serzh on 11/4/16.
 */
public class ContactDaoJSON {

    ContactStore contactStore;

    static String pathName = "src/main/resources/contacts.json";

    public ContactDaoJSON() {
        String mappingClassName = ContactStore.class.getName();
        contactStore = (ContactStore) MapperObjectJson.getObjectFromFile(pathName, contactStore, mappingClassName);
        if (contactStore == null) {
            contactStore = new ContactStore();
        }
    }

    public Contact searchContactById(int contactId) {
        return contactStore.searchContactById(contactId);
    }

    void insertContact(Contact contact) {
        contactStore.insertContact(contact);
        writeJsonToFile(contactStore, pathName);
    }

    List<Contact> allUserContacts(int userId) {
        return contactStore.allUserContacts(userId);
    }

    void updateContact(Contact contactNew) {
        contactStore.updateContact(contactNew);
        writeJsonToFile(contactStore, pathName);
    }

    void deleteContact(Contact contactToDel) {
        contactStore.deleteContact(contactToDel);
        writeJsonToFile(contactStore, pathName);
    }

    List searchContactByAnyField(String searchQuery, Integer userId) {
        return contactStore.searchContactByAnyField(searchQuery, userId);
    }

    // Convert JSON string from file to Object


  /*  private static void writeJsonToFile(ContactStore contactStore) {
        MapperObjectJson.writeJsonToFile(contactStore, pathName);
    }
*/

    public static void main(String[] args) {
//        ContactDaoJSON contactDaoJSON = new ContactDaoJSON();

//        List<Contact> contacts = contactStore.getContacts();

/*        contacts.forEach(contact -> System.out.println("id: " + contact.getContactId() + " - " + contact.getSurname()));
        System.out.println("--------------------");*/

        //Test deleteContact
/*        Contact contact = contactDaoJSON.searchContactById(9);
        contactDaoJSON.deleteContact(contact);*/

        //Test searchContactById

       /* Class<ContactDaoJSON> contactStoreClass = ContactDaoJSON.class;
        System.out.println(contactStoreClass);

        String className = ContactDaoJSON.class.getName();
        System.out.println(className);

        try {
            Class<?> aClass = Class.forName(className);
            System.out.println(aClass);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/

  /*  ContactDaoJSON contactDaoJSON = new ContactDaoJSON();
     Contact contact = contactDaoJSON.searchContactById(10);
        contact.setSurname("AlpachinoTwoD");
        contact.setName("SomeTwoD");
        contactDaoJSON.updateContact(contact);*/

        //Test allUserContacts
      /*  List<Contact> list = contactDaoJSON.allUserContacts(2);
        list.forEach(contact -> System.out.println(contact.getSurname()))*/
        ;

        // Test searchContactById
       /* Contact contact = contactStore.searchContactById(2);
        System.out.println(contact.getSurname());*/

        // Test insertContact
        ContactDaoJSON contactDaoJSON = new ContactDaoJSON();
        User user = CreateEntity.createUser1();
        Contact contact = CreateEntity.createContact1(user);
        contact.setSurname("PavarottiTwo");
        contact.setName("LuchanoTwo");

       contactDaoJSON.insertContact(contact);

//        writeJsonToFile(contactStore);

        // Test searchContactByAnyField
//        List<Contact> joli = contactDaoJSON.searchContactByAnyField("Joli", 1);
   /*     List<Contact> joli = contactDaoJSON.searchContactByAnyField("luch", 1);

        for (Contact contact : joli) {
            System.out.println("id: " + contact.getContactId() + " - " + contact.getSurname());
        }*/

//      contactStore.deleteContact

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

//        writeJsonToFile(contactStore);
    }

}
