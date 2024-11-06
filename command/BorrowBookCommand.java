package command;

import facade.LibraryFacade;

public class BorrowBookCommand implements Command {
    private final LibraryFacade facade;
    private final String title;

    public BorrowBookCommand(LibraryFacade facade, String title) {
        this.facade = facade;
        this.title = title;
    }

    @Override
    public void execute() {
        facade.borrowBook(title);
    }
}
