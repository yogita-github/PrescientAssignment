package com.demo.beans;
import java.io.Serializable;

public class Book implements Serializable {
    private static final long serialVersionUID = 1L;
    private static long counter = 1000;

    private long isbn;
    private String title;
    private String author;
    private boolean available;

    public Book(String title, String author) {
        this.isbn = counter++;
        this.title = title;
        this.author = author;
        this.available = true;
    }

    public long getISBN() { return isbn; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }

    @Override
    public String toString() {
        return "ISBN: " + isbn + ", Title: " + title + ", Author: " + author + ", Available: " + available;
    }
}

