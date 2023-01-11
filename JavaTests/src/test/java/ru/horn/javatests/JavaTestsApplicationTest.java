package ru.horn.javatests;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JavaTestsApplicationTest {

    @Test
    void BanksNotNullable(){
        Bank fairBank = new Bank(5);
        Bank unFairBank = new Bank(20);

        assertNotNull(fairBank);
        assertNotNull(unFairBank);
    }
}