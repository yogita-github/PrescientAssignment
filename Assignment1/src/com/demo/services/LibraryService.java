package com.demo.services;

public interface LibraryService {
    void addBook();
    void removeBook(long isbn);
    void displayBooks();
    void addMember();
    void displayMembers();
    void borrowBook(long memberId, long isbn);
    void returnBook(long memberId, long isbn);
    void saveLibraryData();
}
