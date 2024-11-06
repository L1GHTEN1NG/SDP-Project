package facade;

import model.Library;
import model.LibraryItem;
import strategy.SortStrategy;

public class LibraryFacade {
    private final Library library = Library.getInstance();

    public void addBook(LibraryItem item) {
        library.addItem(item);
    }

    public void removeBook(String title) {
        library.removeItem(title);
    }

    public void borrowBook(String title) {
        library.borrowItem(title);
    }

    public void returnBook(String title) {
        library.returnItem(title);
    }

    public void displayAvailableBooks(SortStrategy sortStrategy) {
        library.availableItems(sortStrategy);
    }
}
