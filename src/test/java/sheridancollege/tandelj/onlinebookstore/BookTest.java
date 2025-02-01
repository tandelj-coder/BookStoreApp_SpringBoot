package sheridancollege.tandelj.onlinebookstore;

import org.junit.jupiter.api.Test;
import sheridancollege.tandelj.onlinebookstore.model.Book;
import sheridancollege.tandelj.onlinebookstore.model.BookList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookTest {
    @Test
    public void testAddBook() {
        BookList bookList = new BookList();
        Book book = new Book();
        book.setBookTitle("Introduction to Java");
        bookList.addBook(book);
        assertEquals(1, bookList.getBooks().size());
    }
}