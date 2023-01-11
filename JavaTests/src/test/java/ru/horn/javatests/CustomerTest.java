package ru.horn.javatests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    void askForCreditTrue() {
        var fairBank = new Bank(5);
        Customer smartCustomer = new Customer(fairBank);
        smartCustomer.askForCredit();
        // В java "assertTrue" ожидает получить true,
        // это то же самое что assertEquals(true, smartCustomer.isAgree());
        assertTrue(smartCustomer.isAgree());
    }
    
    @Test
    void askForCreditFalse() {
        var fairBank = new Bank(20);
        Customer smartCustomer = new Customer(fairBank);
        smartCustomer.askForCredit();
        assertFalse(smartCustomer.isAgree());
    }
    
}