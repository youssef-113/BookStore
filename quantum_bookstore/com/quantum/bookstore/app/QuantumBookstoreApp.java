package com.quantum.bookstore.app;

import com.quantum.bookstore.core.BookStore;
import com.quantum.bookstore.model.*;
import com.quantum.bookstore.service.*;

public class QuantumBookstoreApp {
    public static void main(String[] args) {
        BookStore store = new BookStore();

        store.addStock(new PaperBook("978-1234567890", "Printed Title", 2024, 29.99, "Alice", 500));
        store.addStock(new EBook("978-9876543210", "E‑Book Title", 2023, 9.99, "Bob", "PDF", 5));
        store.addStock(new AudioBook("978-1111111111", "Audio Title", 2022, 14.99, "Carol", "MP3", 120));

        ShippingService shipping = new ShippingService();
        MailService    mail     = new MailService();
        AudioService   audio    = new AudioService();

        double paid;

        paid = store.buyBook("978-1234567890");
        shipping.ship((PaperBook) store.findByIsbn("978-1234567890"), 1, "123 Main St");

        paid = store.buyBook("978-9876543210");
        mail.send((EBook) store.findByIsbn("978-9876543210"), 2, "user@example.com");

        paid = store.buyBook("978-1111111111");
        audio.stream((AudioBook) store.findByIsbn("978-1111111111"), 1, "audiofan@example.com");

        System.out.printf("Total paid: $%.2f%n", paid);
    }
}
