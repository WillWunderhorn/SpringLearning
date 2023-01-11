package ru.horn.javatests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer {
    Bank bank;
    boolean agree;

    public Customer(Bank bank) {
        this.bank = bank;
    }

    public void askForCredit(){
        if (bank.percent <= 10) {
            agree = true;
            System.out.println("I agree '#shakehands'");
        } else {
            agree = false;
            System.out.println("Are you flexing on me? '#gettingoffsound'");
        }
    }

}
