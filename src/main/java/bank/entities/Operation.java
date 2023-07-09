package bank.entities;

import java.time.LocalDate;

public class Operation {
    private OperationType type;
    private LocalDate date;
    private double amount;
    private double balance;

    public Operation(OperationType type, LocalDate date, double amount, double balance) {
        this.type = type;
        this.date = date;
        this.amount = amount;
        this.balance = balance;
    }

    public OperationType getType() {
        return type;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public double getBalance() {
        return balance;
    }
}