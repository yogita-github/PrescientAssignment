package com.demo.dao;

import com.demo.beans.Book;
import com.demo.beans.Member;
import com.demo.dao.LibraryDAO;

import java.io.*;
import java.util.List;
import java.util.Map;

public class LibraryDAOImpl implements LibraryDAO {
    private static final String FILE_NAME = "library_data.txt";


    public void saveLibraryData(List<Book> books, Map<Long, Member> members) {
        String fileName = "library_data.txt";
        File file = new File(fileName);

        try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
            writer.println("===== Library Data =====\n");

            writer.println("Books:");
            for (Book book : books) {
                writer.println("Title: " + book.getTitle() +
                               ", ISBN: " + book.getISBN() +
                               ", Available: " + (book.isAvailable() ? "Yes" : "No"));
            }

            writer.println("\nMembers:");
            for (Member member : members.values()) {
                writer.println("Name: " + member.getName() +
                               ", ID: " + member.getMemberID() +
                               ", Borrowed Books: " + member.getBorrowedBooks());
            }

            System.out.println("Library data saved successfully!");
            System.out.println("File saved at: " + file.getAbsolutePath()); 
        } catch (IOException e) {
            System.out.println("Error saving library data: " + e.getMessage());
        }
    }

    public void loadLibraryData(List<Book> books, Map<Long, Member> members) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            books.addAll((List<Book>) in.readObject());
            members.putAll((Map<Long, Member>) in.readObject());
            System.out.println("Library data loaded successfully!");
        } catch (EOFException e) {
            System.out.println("Library data file is empty, starting fresh.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No previous data found. Starting fresh.");
        }
    }
}
