package model;

public class Book extends LibraryItem {
    private final String author;

    public Book(String title, String author) {
        super(title);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public void displayDetails() {
        System.out.println("Title: " + getTitle() + ", Author: " + author);
    }
}
