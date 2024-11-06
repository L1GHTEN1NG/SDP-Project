package view;

public class LibraryView {
    public void displayMenu(boolean isAdmin) {
        if (isAdmin) {
            System.out.println("Press 'A' to add a book, 'R' to remove a book, 'B' to borrow a book, 'T' to return a book, 'D' to display available books, or 'Q' to quit:");
        } else {
            System.out.println("Press 'B' to borrow a book, 'T' to return a book, 'D' to display available books, or 'Q' to quit:");
        }
    }

    public void promptForBookDetails() {
        System.out.println("Enter the details of the book:");
    }

    public void promptForMode() {
        System.out.println("Enter 'A' for Administrator mode or 'U' for User mode:");
    }

    public void displayInvalidInput() {
        System.out.println("Invalid input, please try again.");
    }

    public void displayExitMessage() {
        System.out.println("Exiting program.");
    }

    public void displayUnauthorizedMessage() {
        System.out.println("You are not authorized to perform this action.");
    }
}
