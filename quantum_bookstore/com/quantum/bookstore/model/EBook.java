package com.quantum.bookstore.model;

public class EBook extends Book {
    private final String fileFormat;
    private final int fileSizeMb;

    public EBook(String isbn, String title, int year, double price, String author, String fileFormat, int fileSizeMb) {
        super(isbn, title, year, price, author);
        this.fileFormat = fileFormat;
        this.fileSizeMb  = fileSizeMb;
    }

    public String getFileFormat() { return fileFormat; }
    public int getFileSizeMb()     { return fileSizeMb; }

    @Override
    public String toString() {
        return super.toString() + String.format(" – %s, %dMB", fileFormat, fileSizeMb);
    }
}
