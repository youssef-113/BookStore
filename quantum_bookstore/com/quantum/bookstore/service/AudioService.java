package com.quantum.bookstore.service;

import com.quantum.bookstore.model.AudioBook;

public class AudioService {
    public void stream(AudioBook book, int quantity, String email) {
        System.out.printf("Delivering %d x '%s' (%s) to %s%n",
            quantity, book.getTitle(), book.getAudioFormat(), email);
    }
}
