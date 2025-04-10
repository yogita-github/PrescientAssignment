package com.demo.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Member implements Serializable {
    private static final long serialVersionUID = 1L;
    private static long counter = 2000;

    private long memberID;
    private String name;
    private List<Long> borrowedBooks;

    public Member(String name) {
        this.memberID = counter++;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public long getMemberID() { return memberID; }
    public String getName() { return name; }
    public List<Long> getBorrowedBooks() { return borrowedBooks; }

    public void borrowBook(long isbn) { borrowedBooks.add(isbn); }
    public void returnBook(long isbn) { borrowedBooks.remove(isbn); }

    @Override
    public String toString() {
        return "MemberID: " + memberID + ", Name: " + name + ", Borrowed Books: " + borrowedBooks;
    }
}
