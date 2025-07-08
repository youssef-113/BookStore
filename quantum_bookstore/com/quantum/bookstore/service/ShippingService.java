package com.quantum.bookstore.service;

import com.quantum.bookstore.model.PaperBook;

public class ShippingService {
    public void ship(PaperBook book, int quantity, String address) {
        System.out.printf("Shipping %d x '%s' to %s%n",
            quantity, book.getTitle(), address);
    }
}
