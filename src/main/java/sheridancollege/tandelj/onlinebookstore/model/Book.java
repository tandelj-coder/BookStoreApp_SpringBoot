package sheridancollege.tandelj.onlinebookstore.model;

import lombok.Data;

@Data
public class Book {
    private String bookISBN;
    private String bookTitle;
    private String bookAuthor;
    private double bookPrice;
}