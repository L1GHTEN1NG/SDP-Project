package controller;

import command.AddBookCommand;
import command.BorrowBookCommand;
import command.RemoveBookCommand;
import command.ReturnBookCommand;
import facade.LibraryFacade;
import factory.BookFactory;
import model.Book;
import strategy.SortByAuthor;
import strategy.SortByTitle;
import strategy.SortStrategy;
import view.LibraryView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class LibraryController {
    private final LibraryFacade facade;
    private final LibraryView view;
    private boolean isAdmin;

    public LibraryController() {
        this.facade = new LibraryFacade();
        this.view = new LibraryView();
    }

    public void loadBooksFromFile(String filePath) {
        try (FileReader reader = new FileReader(filePath)) {
            Gson gson = new Gson();
            Type listType = new TypeToken<List<Map<String, String>>>() {}.getType();
            List<Map<String, String>> booksData = gson.fromJson(reader, listType);

            for (Map<String, String> bookData : booksData) {
                String title = bookData.get("title");
                String author = bookData.get("author");
                Book book = BookFactory.createBook(title, author);
                new AddBookCommand(facade, book).execute();
            }
            System.out.println("Books loaded from file successfully.");
        } catch (IOException e) {
            System.err.println("Error reading books from file: " + e.getMessage());
        }
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        // Administrator mode selection
        view.promptForMode();
        String modeInput = scanner.nextLine();
        isAdmin = modeInput.equalsIgnoreCase("A");

        while (true) {
            view.displayMenu(isAdmin);
            String input = scanner.nextLine().toUpperCase();

            switch (input) {
                case "A" -> {
                    if (isAdmin) addBook();
                    else view.displayUnauthorizedMessage();
                }
                case "R" -> {
                    if (isAdmin) removeBook();
                    else view.displayUnauthorizedMessage();
                }
                case "B" -> borrowBook();
                case "T" -> returnBook();
                case "D" -> displayBooks();
                case "Q" -> {
                    view.displayExitMessage();
                    return;
                }
                default -> view.displayInvalidInput();
            }
        }
    }

    private void addBook() {
        view.promptForBookDetails();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();

        Book book = BookFactory.createBook(title, author);
        new AddBookCommand(facade, book).execute();
    }

    private void removeBook() {
        System.out.print("Enter the title of the book to remove: ");
        String title = new Scanner(System.in).nextLine();
        new RemoveBookCommand(facade, title).execute();
    }

    private void borrowBook() {
        System.out.print("Enter the title of the book to borrow: ");
        String title = new Scanner(System.in).nextLine();
        new BorrowBookCommand(facade, title).execute();
    }

    private void returnBook() {
        System.out.print("Enter the title of the book to return: ");
        String title = new Scanner(System.in).nextLine();
        new ReturnBookCommand(facade, title).execute();
    }

    private void displayBooks() {
        System.out.println("Choose sort order: (1) By Title, (2) By Author");
        int choice = new Scanner(System.in).nextInt();
        SortStrategy sortStrategy = choice == 2 ? new SortByAuthor() : new SortByTitle();
        facade.displayAvailableBooks(sortStrategy);
    }
}
