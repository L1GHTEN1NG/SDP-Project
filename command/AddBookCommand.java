package command;

import facade.LibraryFacade;
import model.LibraryItem;

public class AddBookCommand implements Command {
    private final LibraryFacade facade;
    private final LibraryItem book;

    public AddBookCommand(LibraryFacade facade, LibraryItem book) {
        this.facade = facade;
        this.book = book;
    }

    @Override
    public void execute() {
        facade.addBook(book);
    }
}
