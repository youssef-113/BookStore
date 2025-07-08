package com.quantum.bookstore.model;

public abstract class Book {
    private final String isbn;
    private final String title;
    private final int year;
    private final double price;
    private final String author;

    protected Book(String isbn, String title, int year, double price, String author) {
        this.isbn = isbn;
        this.title = title;
        this.year = year;
        this.price = price;
        this.author = author;
    }

    public String getIsbn() { return isbn; }
    public String getTitle() { return title; }
    public int getYear()       { return year; }
    public double getPrice()   { return price; }
    public String getAuthor()  { return author; }

    @Override
    public String toString() {
        return String.format("%s by %s (%d) – $%.2f [ISBN: %s]",
            title, author, year, price, isbn);
    }
}
