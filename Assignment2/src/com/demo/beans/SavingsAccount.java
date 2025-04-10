package com.demo.beans;

public class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(double balance, double interestRate) {
        super(balance);
        this.interestRate = interestRate;
    }

    public void addInterest() {
        double interest = balance * (interestRate / 100);
        deposit(interest);
        System.out.println("Interest added: " + interest);
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
            return true;
        } else {
            System.out.println("Insufficient balance or invalid amount.");
            return false;
        }
    }

    @Override
    public String toString() {
        return "SavingsAccount{" +
                "accountNumber='" + getAccountNumber() + '\'' +
                ", balance=" + getBalance() +
                ", interestRate=" + interestRate +
                '}';
    }
}
