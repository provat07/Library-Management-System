import java.util.ArrayList;
import java.util.Scanner;

class Book {
    String title;
    String author;
    int id;
    boolean isAvailable;

    Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }
}

public class LibraryManagementSystem {
    static ArrayList<Book> books = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        addSampleBooks();

        int choice;
        do {
            System.out.println("\n--- Library Management System ---");
            System.out.println("1. View all books");
            System.out.println("2. Issue a book");
            System.out.println("3. Return a book");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> viewBooks();
                case 2 -> issueBook();
                case 3 -> returnBook();
                case 4 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 4);
    }

    static void addSampleBooks() {
        books.add(new Book(1, "Java Basics", "Author A"));
        books.add(new Book(2, "Python for Beginners", "Author B"));
        books.add(new Book(3, "Data Structures", "Author C"));
    }

    static void viewBooks() {
        System.out.println("\nAvailable Books:");
        for (Book book : books) {
            System.out.println(book.id + ". " + book.title + " by " + book.author +
                               " | " + (book.isAvailable ? "Available" : "Issued"));
        }
    }

    static void issueBook() {
        System.out.print("Enter book ID to issue: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        for (Book book : books) {
            if (book.id == id) {
                if (book.isAvailable) {
                    book.isAvailable = false;
                    System.out.println("Book issued successfully!");
                } else {
                    System.out.println("Book is already issued.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    static void returnBook() {
        System.out.print("Enter book ID to return: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        for (Book book : books) {
            if (book.id == id) {
                if (!book.isAvailable) {
                    book.isAvailable = true;
                    System.out.println("Book returned successfully!");
                } else {
                    System.out.println("Book was not issued.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }
}
