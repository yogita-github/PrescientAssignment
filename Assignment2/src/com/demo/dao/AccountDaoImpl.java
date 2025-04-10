package com.demo.dao;

import com.demo.beans.Account;
import java.util.ArrayList;
import java.util.List;

public class AccountDaoImpl implements AccountDao {
    private List<Account> accounts = new ArrayList<>();

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public Account findAccount(String accountNumber) {
        for (Account acc : accounts) {
            if (acc.getAccountNumber().equals(accountNumber)) {
                return acc;
            }
        }
        return null;
    }

    public List<Account> getAllAccounts() {
        return accounts;
    }
}
