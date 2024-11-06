package strategy;

import model.Book;

import java.util.Comparator;
import java.util.List;

public class SortByAuthor implements SortStrategy {
    @Override
    public void sort(List<Book> books) {
        books.sort(Comparator.comparing(Book::getAuthor));
    }
}
