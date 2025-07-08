package com.quantum.bookstore.model;

public class AudioBook extends Book {
    private final String audioFormat;
    private final int durationMinutes;

    public AudioBook(String isbn, String title, int year, double price, String author,
                     String audioFormat, int durationMinutes) {
        super(isbn, title, year, price, author);
        this.audioFormat    = audioFormat;
        this.durationMinutes = durationMinutes;
    }

    public String getAudioFormat()    { return audioFormat; }
    public int getDurationMinutes()   { return durationMinutes; }

    @Override
    public String toString() {
        return super.toString() +
               String.format(" – %s, %dmin", audioFormat, durationMinutes);
    }
}
