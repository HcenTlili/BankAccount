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

  @Test
    void getOperationsEmpty() {
        List<Operation> operations = account.getOperations();
        assertTrue(operations.isEmpty());
    }

    @Test
    void testOperationsCorrect() {
        account.deposit(100.0);
        account.withdraw(50.0);
        List<Operation> operations = account.getOperations();
        assertEquals(2, operations.size());

        Operation depositOperation = operations.get(0);
        assertEquals(OperationType.DEPOSIT, depositOperation.getType());
        assertEquals(LocalDate.now(), depositOperation.getDate());
        assertEquals(100.0, depositOperation.getAmount());
        assertEquals(100.0, depositOperation.getBalance());

        Operation withdrawalOperation = operations.get(1);
        assertEquals(OperationType.WITHDRAWAL, withdrawalOperation.getType());
        assertEquals(LocalDate.now(), withdrawalOperation.getDate());
        assertEquals(-50.0, withdrawalOperation.getAmount());
        assertEquals(50.0, withdrawalOperation.getBalance());
    }

   
}
