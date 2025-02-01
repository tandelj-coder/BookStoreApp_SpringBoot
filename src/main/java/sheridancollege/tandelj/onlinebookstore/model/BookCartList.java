package sheridancollege.tandelj.onlinebookstore.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class BookCartList {
    private final List<Book> cartItems = new ArrayList<>();

    public void addToCart(Book book) {
        cartItems.add(book);
    }

    public double calculateTotal() {
        return cartItems.stream().mapToDouble(Book::getBookPrice).sum();
    }
}