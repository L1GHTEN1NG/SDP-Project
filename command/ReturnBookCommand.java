package command;

import facade.LibraryFacade;

public class ReturnBookCommand implements Command {
    private final LibraryFacade facade;
    private final String title;

    public ReturnBookCommand(LibraryFacade facade, String title) {
        this.facade = facade;
        this.title = title;
    }

    @Override
    public void execute() {
        facade.returnBook(title);
    }
}
