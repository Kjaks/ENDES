import java.io.*;
import java.util.*;

class Contact implements Serializable {
    private String name;
    private String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Phone Number: " + phoneNumber;
    }
}

class Phonebook implements Serializable {
    private List<Contact> contacts;

    public Phonebook() {
        contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void deleteContact(String name) {
        contacts.removeIf(contact -> contact.getName().equalsIgnoreCase(name));
    }

    public void displayPhonebook() {
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }

    public void savePhonebook(String filePath) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            outputStream.writeObject(this);
            System.out.println("Phonebook saved successfully.");
        } catch (IOException e) {
            System.out.println("Failed to save phonebook: " + e.getMessage());
        }
    }

    public static Phonebook loadPhonebook(String filePath) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filePath))) {
            return (Phonebook) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Failed to load phonebook: " + e.getMessage());
            return new Phonebook();
        }
    }
}


