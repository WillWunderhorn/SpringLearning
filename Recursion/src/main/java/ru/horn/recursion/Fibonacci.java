package ru.horn.recursion;

public class Fibonacci {

    public void fibonacci(int i) {
        System.out.println(i);
        if (i <= 1) {
            return;
        }
        fibonacci(i - 1);
    }
}
