package com.demo.test;

import com.demo.service.AccountService;
import com.demo.service.AccountServiceImpl;
import java.util.Scanner;

public class AccountTest {
    public static void main(String[] args) {
        AccountService accountService = new AccountServiceImpl();
        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Menu");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Display All Accounts");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    accountService.createAccount();
                    break;
                case 2:
                    accountService.depositMoney();
                    break;
                case 3:
                    accountService.withdrawMoney();
                    break;
                case 4:
                    accountService.checkBalance();
                    break;
                case 5:
                    accountService.displayAccounts();
                    break;
                case 6:
                    exit = true;
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
        sc.close();
    }
}
