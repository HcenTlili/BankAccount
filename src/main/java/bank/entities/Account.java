package bank.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Account {
    private double balance;
    private List<Operation> operations;

    public Account() {
        balance = 0;
        operations = new ArrayList<Operation>();
    }

/**
     * Deposit method.
   
     */
    public void deposit(Double amount) {
        if (amount == null || amount <= 0) {
            throw new IllegalArgumentException("Invalid amount for deposit");
        }
        balance += amount;
        operations.add(new Operation(OperationType.DEPOSIT, LocalDate.now(), amount, balance));
    }

     /**
     * Withdraw from the account
     */
    public void withdraw(Double amount) {
        if (amount == null || amount <= 0 || amount > balance) {
            throw new IllegalArgumentException("withdrawal invalid");
        }
        balance -= amount;
        operations.add(new Operation(OperationType.WITHDRAWAL, LocalDate.now(), -amount, balance));
    }

    public double getBalance() {
        return balance;
    }
   
}
