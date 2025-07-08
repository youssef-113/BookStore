package com.quantum.bookstore.model;

public class PaperBook extends Book {
    private final int weightGrams;

    public PaperBook(String isbn, String title, int year, double price, String author, int weightGrams) {
        super(isbn, title, year, price, author);
        this.weightGrams = weightGrams;
    }

    public int getWeightGrams() { return weightGrams; }

    @Override
    public String toString() {
        return super.toString() + String.format(" – %dg", weightGrams);
    }
}
