import controller.LibraryController;

public class Main {
    public static void main(String[] args) {
        LibraryController controller = new LibraryController();

        // Load books from file
        String filePath = "src/books.json";
        controller.loadBooksFromFile(filePath);

        // Start the program
        controller.start();
    }
}
