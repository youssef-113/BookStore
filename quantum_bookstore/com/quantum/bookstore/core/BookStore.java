package com.quantum.bookstore.core;

import com.quantum.bookstore.model.Book;
import java.util.HashMap;
import java.util.Map;

public class BookStore {
    private final Map<String, Book> inventory = new HashMap<>();

    public void addStock(Book book) {
        inventory.put(book.getIsbn(), book);
    }

    public Book findByIsbn(String isbn) {
        return inventory.get(isbn);
    }

    public double buyBook(String isbn) {
        Book book = findByIsbn(isbn);
        if (book == null) {
            throw new IllegalArgumentException("Book not found: " + isbn);
        }
        return book.getPrice();
    }
}
