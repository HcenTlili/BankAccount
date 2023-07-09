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

  @Test
    void depositPositiveAmount() {
        account.deposit(100.0);
        assertEquals(100.0, account.getBalance());
    }

    @Test
    void depositInvlalidAmount() {
        assertThrows(IllegalArgumentException.class, () -> account.deposit(0.0));
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-50.0));
    }

    @Test
    void depositNUll() {
        assertThrows(IllegalArgumentException.class, () -> account.deposit((Double) null));
    }

      @Test
    void validWithdraw() {
        account.deposit(100.0);
        account.withdraw(50.0);
        assertEquals(50.0, account.getBalance());
    }

    @Test
    void invalidAmountWithdraw() {
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(0.0));
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(-50.0));
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(50.0));
    }

    @Test
    void withdrawValueGreaterThanBalance() {
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(50.0));
    }

    @Test
    void withdrawNull() {
        assertThrows(IllegalArgumentException.class, () -> account.withdraw((Double) null));
    }


   
}
