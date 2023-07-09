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

    

    public double getBalance() {
        return balance;
    }
   
}
