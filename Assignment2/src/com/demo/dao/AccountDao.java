package com.demo.dao;

import com.demo.beans.Account;
import java.util.List;

public interface AccountDao {
    void addAccount(Account account);
    Account findAccount(String accountNumber);
    List<Account> getAllAccounts();
}
