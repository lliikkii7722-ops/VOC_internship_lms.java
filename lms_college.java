package voc_internship_srp;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
public class lms_college {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();

        while (true) {
            System.out.println("\n========= Library Menu =========");
            System.out.println("1. Add Book");
            System.out.println("2. Issue Book");
            System.out.println("3. Return Book");
            System.out.println("4. View Books");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();
            sc.nextLine(); // consume newline

            if (ch == 1) {
                System.out.print("Enter Book ID: ");
                int id = sc.nextInt();
                sc.nextLine(); // consume newline
                System.out.print("Enter Book Name: ");
                String name = sc.nextLine();
                Book b = new Book(id, name);
                books.add(b);
                System.out.println("\nBook added successfully!");
                System.out.println("ID: " + b.id + " | Name: " + b.name + " | Issued: No");

            } else if (ch == 2) {
                System.out.print("Enter Book ID to issue: ");
                int id = sc.nextInt();
                boolean found = false;
                for (Book b : books) {
                    if (b.id == id) {
                        if (!b.issued) {
                            b.issued = true;
                            b.issueDate = LocalDate.now();
                            System.out.println("\nBook issued successfully!");
                            System.out.println("ID: " + b.id + " | Name: " + b.name + " | Issued On: " + b.issueDate);
                        } else {
                            System.out.println("Book is already issued!");
                        }
                        found = true;
                        break;
                    }
                }
                if (!found) System.out.println("Book ID not found!");

            } else if (ch == 3) {
                System.out.print("Enter Book ID to return: ");
                int id = sc.nextInt();
                boolean found = false;
                for (Book b : books) {
                    if (b.id == id) {
                        if (b.issued) {
                            b.issued = false;
                            System.out.println("\nBook returned successfully!");
                            System.out.println("ID: " + b.id + " | Name: " + b.name + " | Was issued on: " + b.issueDate);
                            b.issueDate = null;
                        } else {
                            System.out.println("Book was not issued!");
                        }
                        found = true;
                        break;
                    }
                }
                if (!found) System.out.println("Book ID not found!");

            } else if (ch == 4) {
                System.out.println("\n===== Books in Library =====");
                System.out.printf("%-5s %-25s %-10s %-12s\n", "ID", "Name", "Issued", "Issue Date");
                System.out.println("------------------------------------------------------");
                for (Book b : books) {
                    String date = (b.issueDate != null) ? b.issueDate.toString() : "-";
                    String status = b.issued ? "Yes" : "No";
                    System.out.printf("%-5d %-25s %-10s %-12s\n", b.id, b.name, status, date);
                }

            } else if (ch == 5) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid choice! Try again.");
            }
        }

        sc.close();
    }
}