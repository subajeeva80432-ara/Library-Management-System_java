import java.util.Scanner;

class Library {
    int bookId;
    String bookName;
    boolean isIssued;

    Library(int id, String name) {
        bookId = id;
        bookName = name;
        isIssued = false;
    }

    void showBook() {
        System.out.println("Book ID   : " + bookId);
        System.out.println("Book Name : " + bookName);
        System.out.println("Issued    : " + isIssued);
    }

    void issueBook() {
        if (isIssued) {
            System.out.println("Book already issued");
        } else {
            isIssued = true;
            System.out.println("Book issued successfully");
        }
    }

    void returnBook() {
        if (!isIssued) {
            System.out.println("Book already in library");
        } else {
            isIssued = false;
            System.out.println("Book returned successfully");
        }
    }
}

public class Library_Management {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Library[] books = new Library[3];
        books[0] = new Library(101, "Java Programming");
        books[1] = new Library(102, "Python Basics");
        books[2] = new Library(103, "Data Structures");

        while (true) {
            System.out.println("Library Menu");
            System.out.println("1. Show Book Details");
            System.out.println("2. Issue Book");
            System.out.println("3. Return Book");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            if (choice == 4) {
                System.out.println("Library closed");
                break;
            }

            System.out.print("Enter Book ID: ");
            int id = sc.nextInt();

            Library selectedBook = null;

            for (int i = 0; i < books.length; i++) {
                if (books[i].bookId == id) {
                    selectedBook = books[i];
                    break;
                }
            }

            if (selectedBook == null) {
                System.out.println("Book not found");
                continue;
            }

            if (choice == 1) {
                selectedBook.showBook();
            } else if (choice == 2) {
                selectedBook.issueBook();
            } else if (choice == 3) {
                selectedBook.returnBook();
            } else {
                System.out.println("Invalid choice");
            }
        }

        sc.close();
    }
}
