package bank.test;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import bank.entities.Account;
import bank.entities.Operation;
import bank.entities.OperationType;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    private Account account;

    @BeforeEach
    void setUp() {
        account = new Account();
    }

   
}
