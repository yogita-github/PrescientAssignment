package com.demo.beans;

import java.util.Random;

public abstract class Account {
    protected String accountNumber;
    protected double balance;

    public Account(double balance) {
        this.accountNumber = generateAccountNumber();
        this.balance = balance;
    }

    private String generateAccountNumber() {
        Random rand = new Random();
        return String.valueOf(100000 + rand.nextInt(900000));
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public abstract boolean withdraw(double amount);

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                '}';
    }
}

