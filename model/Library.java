package model;

import strategy.SortStrategy;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private static Library instance;
    private final List<LibraryItem> itemsList;

    private Library() {
        itemsList = new ArrayList<>();
    }

    public static synchronized Library getInstance() {
        if (instance == null) {
            instance = new Library();
        }
        return instance;
    }

    public void addItem(LibraryItem item) {
        itemsList.add(item);
    }

    public void removeItem(String title) {
        itemsList.removeIf(item -> item.getTitle().equalsIgnoreCase(title));
    }

    public void availableItems(SortStrategy sortStrategy) {
        List<Book> books = new ArrayList<>();
        for (LibraryItem item : itemsList) {
            if (item instanceof Book && item.isAvailable()) {
                books.add((Book) item);
            }
        }
        sortStrategy.sort(books);
        System.out.println("Available Books:");
        for (Book book : books) {
            book.displayDetails();
        }
    }

    public void borrowItem(String title) {
        for (LibraryItem item : itemsList) {
            if (item.getTitle().equalsIgnoreCase(title) && item.isAvailable()) {
                item.setAvailable(false);
                System.out.println("You borrowed: " + title);
                return;
            }
        }
        System.out.println("Sorry, the book is unavailable right now.");
    }

    public void returnItem(String title) {
        for (LibraryItem item : itemsList) {
            if (item.getTitle().equalsIgnoreCase(title) && !item.isAvailable()) {
                item.setAvailable(true);
                System.out.println("You returned: " + title);
                return;
            }
        }
        System.out.println("The item was not borrowed from this library.");
    }
}
