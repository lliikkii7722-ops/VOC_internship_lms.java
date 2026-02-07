package voc_internship_srp;
import java.time.LocalDate;



class Book {
    int id;
    String name;
    boolean issued = false;
    LocalDate issueDate = null;

    Book(int id, String name) {
        this.id = id;
        this.name = name;
    }
}