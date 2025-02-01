package sheridancollege.tandelj.onlinebookstore.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class BookList {
    private final List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }
}