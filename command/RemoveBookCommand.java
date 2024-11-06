package command;

import facade.LibraryFacade;

public class RemoveBookCommand implements Command {
    private final LibraryFacade facade;
    private final String title;

    public RemoveBookCommand(LibraryFacade facade, String title) {
        this.facade = facade;
        this.title = title;
    }

    @Override
    public void execute() {
        facade.removeBook(title);
    }
}
