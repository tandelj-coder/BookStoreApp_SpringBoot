package sheridancollege.tandelj.onlinebookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sheridancollege.tandelj.onlinebookstore.model.Book;
import sheridancollege.tandelj.onlinebookstore.model.BookList;
import sheridancollege.tandelj.onlinebookstore.model.BookCartList;

@Controller
public class BookController {
    private final BookList bookList = new BookList();
    private final BookCartList bookCartList = new BookCartList();

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("message", "Welcome to Jigar's Online Book Store!");
        return "index";
    }

    @GetMapping("/available-books")
    public String availableBooks(Model model) {
        model.addAttribute("books", bookList.getBooks());
        return "available-books";
    }

    @PostMapping("/add-book")
    public String addBook(@RequestParam String title, @RequestParam String author, @RequestParam double price, Model model) {
        Book book = new Book();
        book.setBookISBN(String.valueOf((int) (Math.random() * 900000) + 100000));
        book.setBookTitle(title);
        book.setBookAuthor(author);
        book.setBookPrice(price);
        bookList.addBook(book);
        return "redirect:/available-books";
    }

    @GetMapping("/shopping-books")
    public String shoppingBooks(Model model) {
        model.addAttribute("books", bookList.getBooks());
        model.addAttribute("cartItemCount", bookCartList.getCartItems().size());
        return "shopping-books";
    }

    @PostMapping("/add-to-cart")
    public String addToCart(@RequestParam String isbn, Model model) {
        Book book = bookList.getBooks().stream()
                .filter(b -> b.getBookISBN().equals(isbn))
                .findFirst()
                .orElse(null);
        if (book != null) {
            bookCartList.addToCart(book);
        }
        return "redirect:/shopping-books";
    }

    @GetMapping("/checkout")
    public String checkout(Model model) {
        model.addAttribute("cartItems", bookCartList.getCartItems());
        model.addAttribute("total", bookCartList.calculateTotal());
        return "checkout";
    }
}