package strategy;

import model.Book;

import java.util.List;

public interface SortStrategy {
    void sort(List<Book> books);
}
