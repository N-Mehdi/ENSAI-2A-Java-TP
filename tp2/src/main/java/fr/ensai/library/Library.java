package fr.ensai.library;

import java.util.List;
import java.util.ArrayList;

public class Library {
    private String name;
    private List<Book> books;

    public Library(String name){
        this.name = name;
        this.books = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public List<Book> getBooks() {
        return this.books;
    }

    public void addBook(Book b){
        this.books.add(b);
    }

    public void display() {
        if (books.isEmpty()){
            System.out.println("Library is empty");
        } else {
            for (Book b : this.books){
                System.out.println(b);
            }
        }
    }
}
