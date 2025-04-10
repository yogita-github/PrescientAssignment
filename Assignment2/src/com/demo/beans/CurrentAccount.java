package com.demo.beans;

public class CurrentAccount extends Account {
    private double overdraftLimit;

    public CurrentAccount(double balance, double overdraftLimit) {
        super(balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount > 0 && (balance + overdraftLimit) >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
            return true;
        } else {
            System.out.println("Overdraft limit exceeded or invalid amount.");
            return false;
        }
    }

    @Override
    public String toString() {
        return "CurrentAccount{" +
                "accountNumber='" + getAccountNumber() + '\'' +
                ", balance=" + getBalance() +
                ", overdraftLimit=" + overdraftLimit +
                '}';
    }
}

