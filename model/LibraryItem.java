package model;

public abstract class LibraryItem {
    private final String title;
    private boolean isAvailable;

    public LibraryItem(String title) {
        this.title = title;
        this.isAvailable = true;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public abstract void displayDetails();
}
