package ua.com.serzh.phonebookDivide;

import ua.com.serzh.entities.Contact;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Serzh on 11/4/16.
 */
public class ContactDaoImpl {
    private String name = "contacts";
    int countId;
    private List<Contact> contacts;
    // TODO serialized?

    public ContactDaoImpl() {
    }

    public ContactDaoImpl(String name, List<Contact> contacts) {
        this.name = name;
        this.contacts = contacts;
    }

    public int getCountId() {
        return countId;
    }

    public void setCountId(int countId) {
        this.countId = countId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }


    void insertContact(Contact contact) {
        int id = getCountId();
        contact.setContactId(id);
        setCountId(++id);
        contacts.add(contact);
    }

    Contact searchContactById(int contactId) {
        for (Contact contact : contacts) {
            if (contact.getContactId().equals(contactId)) {
                return contact;
            }
        }
        return null;
    }

    List<Contact> allUserContacts(int userId) {
        List<Contact> result = new ArrayList<>();
        for (Contact contact : contacts) {
            if (contact.getUserId().equals(userId)) {
                result.add(contact);
            }
        }
        return result;
    }

    void updateContact(Contact contactNew) {
        Integer id = contactNew.getContactId();
        for (Contact contactOld : contacts) {
            if (contactOld.getUserId().equals(id)) {
                contacts.remove(contactOld);
                contacts.add(contactNew);
                return;
            }
        }
    }

    void deleteContact(Contact contactToDel) {
        Integer id = contactToDel.getContactId();
        for (Contact contact : contacts) {
            if (contact.getContactId().equals(id)) {
                contacts.remove(contact);
                return;
            }
        }
    }

    List searchContactByAnyField(String searchQuery, Integer userId) {
        List<Contact> result = new ArrayList<>();

        label:
        for (Contact contact : contacts) {

            List<String> fields = new ArrayList<>();
            if (contact.getUserId().equals(userId)) {
                addFields(contact, fields);
            }

            for (String field : fields) {
                if (field.contains(searchQuery)) {
                    result.add(contact);
                    continue label;
                }
            }
        }
        return result;
    }

    private void addFields(Contact contact, List<String> fields) {
        fields.add(contact.getSurname());
        fields.add(contact.getName());
        fields.add(contact.getPatronymic());
        fields.add(contact.getMobileNumber());
        fields.add(contact.getHomePhone());
        fields.add(contact.getEmail());
        fields.add(contact.getAddress());
    }
}
