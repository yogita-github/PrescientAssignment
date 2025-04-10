package com.demo.service;

import com.demo.beans.Account;
import com.demo.beans.SavingsAccount;
import com.demo.beans.CurrentAccount;
import com.demo.dao.AccountDao;
import com.demo.dao.AccountDaoImpl;
import java.util.Scanner;

public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao = new AccountDaoImpl();
    private Scanner sc = new Scanner(System.in);

    public void createAccount() {
        System.out.println("Select Account Type: 1. Savings  2. Current");
        int choice = sc.nextInt();
        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();

        Account newAccount;
        if (choice == 1) {
            System.out.print("Enter Interest Rate: ");
            double rate = sc.nextDouble();
            newAccount = new SavingsAccount(balance, rate);
        } else if (choice == 2) {
            System.out.print("Enter Overdraft Limit: ");
            double limit = sc.nextDouble();
            newAccount = new CurrentAccount(balance, limit);
        } else {
            System.out.println("Invalid choice.");
            return;
        }

        accountDao.addAccount(newAccount);
        System.out.println("Account created successfully! Your Account Number is: " + newAccount.getAccountNumber());
    }

    public void depositMoney() {
        System.out.print("Enter Account Number: ");
        String accNumber = sc.next();
        Account acc = accountDao.findAccount(accNumber);

        if (acc != null) {
            System.out.print("Enter Amount to Deposit: ");
            double amount = sc.nextDouble();
            acc.deposit(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    public void withdrawMoney() {
        System.out.print("Enter Account Number: ");
        String accNumber = sc.next();
        Account acc = accountDao.findAccount(accNumber);

        if (acc != null) {
            System.out.print("Enter Amount to Withdraw: ");
            double amount = sc.nextDouble();
            acc.withdraw(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    public void checkBalance() {
        System.out.print("Enter Account Number: ");
        String accNumber = sc.next();
        Account acc = accountDao.findAccount(accNumber);

        if (acc != null) {
            System.out.println("Balance: " + acc.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }

    public void displayAccounts() {
        for (Account acc : accountDao.getAllAccounts()) {
            System.out.println(acc);
        }
    }
}

