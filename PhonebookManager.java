import java.util.*;

public class PhonebookManager {
    private static final String PHONEBOOK_FILE_PATH = "/home/karolis/Desktop/prueba/phonebook.dat";

    public static void main(String[] args) {
        Phonebook phonebook = Phonebook.loadPhonebook(PHONEBOOK_FILE_PATH);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Phonebook Management System");
            System.out.println("1. Add Contact");
            System.out.println("2. Delete Contact");
            System.out.println("3. Display Phonebook");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();
                    Contact contact = new Contact(name, phoneNumber);
                    phonebook.addContact(contact);
                    break;
                case 2:
                    System.out.print("Enter name to delete: ");
                    String nameToDelete = scanner.nextLine();
                    phonebook.deleteContact(nameToDelete);
                    break;
                case 3:
                    phonebook.displayPhonebook();
                    break;
                case 4:
                    phonebook.savePhonebook(PHONEBOOK_FILE_PATH);
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

//prueba