package vn.mila.example.dto;

import java.math.BigDecimal;

/**
 * Copyright by Intelin.
 * Creator: Nguyen Ngoc Chau
 * Date: 11/20/19
 * Time: 11:25 AM
 */
public class AccountInfo {

    private String accountNumber;
    private String cif;
    private BigDecimal balance;

    public String getAccountNumber() {
        return accountNumber;
    }

    public AccountInfo setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
        return this;
    }

    public String getCif() {
        return cif;
    }

    public AccountInfo setCif(String cif) {
        this.cif = cif;
        return this;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public AccountInfo setBalance(BigDecimal balance) {
        this.balance = balance;
        return this;
    }
}
