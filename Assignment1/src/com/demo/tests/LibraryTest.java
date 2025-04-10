package com.demo.tests;

import com.demo.services.LibraryService;
import com.demo.services.LibraryServiceImpl;

import java.util.Scanner;

public class LibraryTest {
    public static void main(String[] args) {
        LibraryService library = new LibraryServiceImpl();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n 1. Add Book \n 2. Remove Book \n 3. Display Books\n 4. Add Member\n 5. Borrow Book \n 6. Return Book \n 7. Display Members \n 8. Save & Exit");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                	library.addBook();
                break;
                case 2:
                    System.out.print("Enter ISBN: ");
                    while (!sc.hasNextLong()) {
                        System.out.println("Invalid input. Please enter a valid ISBN number.");
                        sc.next();
                    }
                    long isbn = sc.nextLong();
                    sc.nextLine();
                    library.removeBook(isbn);
                    library.saveLibraryData();
                    break;
                case 3 :
                	library.displayBooks();
                break;
                case 4 :
                	library.addMember();
                break;
                case 5:
                    System.out.print("Enter Member ID: ");
                    while (!sc.hasNextLong()) {
                        System.out.println("Invalid input. Please enter a valid Member ID.");
                        sc.next();
                    }
                    long memberId = sc.nextLong();
                    
                    System.out.print("Enter ISBN of the book to borrow: ");
                    while (!sc.hasNextLong()) {
                        System.out.println("Invalid input. Please enter a valid ISBN.");
                        sc.next();
                    }
                    isbn = sc.nextLong();
                    
                    sc.nextLine(); 
                    library.borrowBook(memberId, isbn);
                    break;
                case 6:
                    System.out.print("Enter Member ID: ");
                    long returnMemberId = sc.nextLong();
                    System.out.print("Enter ISBN of the book to return: ");
                    long returnIsbn = sc.nextLong();
                    library.returnBook(returnMemberId, returnIsbn);
                    break;
                case 7: library.displayMembers(); 
                break;
                case 8: library.saveLibraryData(); System.out.println("Exiting..."); 
                break;
            }
        } while (choice != 8);
        sc.close();
    }
}
