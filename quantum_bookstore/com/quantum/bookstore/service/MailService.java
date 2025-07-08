package com.quantum.bookstore.service;

import com.quantum.bookstore.model.EBook;

public class MailService {
    public void send(EBook book, int quantity, String email) {
        System.out.printf("Emailing %d x '%s' (%s) to %s%n",
            quantity, book.getTitle(), book.getFileFormat(), email);
    }
}
