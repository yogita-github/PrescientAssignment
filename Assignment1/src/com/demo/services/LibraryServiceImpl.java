package com.demo.services;

import com.demo.beans.Book;
import com.demo.beans.Member;
import com.demo.dao.LibraryDAO;
import com.demo.dao.LibraryDAOImpl;
import com.demo.services.LibraryService;

import java.util.*;

public class LibraryServiceImpl implements LibraryService {
    private List<Book> books;
    private Map<Long, Member> members;
    private LibraryDAO libraryDAO;
    private Scanner sc;

    public LibraryServiceImpl() {
        books = new ArrayList<>();
        members = new HashMap<>();
        libraryDAO = new LibraryDAOImpl();
        sc = new Scanner(System.in);
        libraryDAO.loadLibraryData(books, members);
    }

   
    public void addBook() {
        System.out.print("Enter book title: ");
        String title = sc.nextLine();
        System.out.print("Enter author name: ");
        String author = sc.nextLine();
        books.add(new Book(title, author));
        System.out.println("Book added successfully.");
    }


    public void removeBook(long isbn) {
        System.out.println("Available books before removal:");
        displayBooks();

        Book bookToRemove = null;
        for (Book book : books) {
            if (book.getISBN() == isbn) {
                bookToRemove = book;
                break;
            }
        }
        
        if (bookToRemove != null) {
            books.remove(bookToRemove);
            System.out.println("Book removed successfully.");
        } else {
            System.out.println("Error: Book not found!");
        }

    }



    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
        } else {
            books.forEach(System.out::println);
        }
    }

    public void addMember() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter member name: ");
        String name = sc.nextLine();
        
        Member member = new Member(name);
        members.put(member.getMemberID(), member);
        
        System.out.println("Member added successfully! Your Member ID is: " + member.getMemberID());
    }

    public void displayMembers() {
        if (members.isEmpty()) {
            System.out.println("No members found.");
        } else {
            System.out.println("List of Members:");
            members.values().forEach(System.out::println);
        }
    }


 
    public void borrowBook(long memberId, long isbn) {
        Member member = members.get(memberId);
        Book book = books.stream().filter(b -> b.getISBN() == isbn && b.isAvailable()).findFirst().orElse(null);

        if (member == null) {
            System.out.println("Error: Member not found!");
            return;
        }
        if (book == null) {
            System.out.println("Error: Book not available or does not exist.");
            return;
        }

        member.borrowBook(isbn);
        book.setAvailable(false);
        System.out.println("Success: " + member.getName() + " borrowed '" + book.getTitle() + "'.");
    }


 
    public void returnBook(long memberId, long isbn) {
        Member member = members.get(memberId);
        Book book = books.stream().filter(b -> b.getISBN() == isbn && !b.isAvailable()).findFirst().orElse(null);

        if (member == null) {
            System.out.println("Error: Member ID not found. Please check and try again.");
            return;
        }
        if (book == null) {
            System.out.println("Error: Either the book does not exist or it was not borrowed.");
            return;
        }

        member.returnBook(isbn);
        book.setAvailable(true);
        System.out.println(member.getName() + " successfully returned the book: " + book.getTitle());
    }


    public void saveLibraryData() {
        libraryDAO.saveLibraryData(books, members);
    }
}
