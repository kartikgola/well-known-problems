/*
 * Author: Kartik Gola
 * Date: 1/15/22, 12:36 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.function.IntConsumer;

// synchronized methods + while (...) wait, notifyAll
// need to say "continue outer;" to check for i <= n
public class FizzBuzzMultithreaded {

    private int n;
    private int i = 1;

    public FizzBuzzMultithreaded(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public synchronized void fizz(Runnable printFizz) throws InterruptedException {
        outer:
        while (i <= n) {
            while (i % 3 != 0 || i % 5 == 0) {
                wait();
                continue outer;
            }
            printFizz.run();
            i++;
            notifyAll();
        }
    }

    // printBuzz.run() outputs "buzz".
    public synchronized void buzz(Runnable printBuzz) throws InterruptedException {
        outer:
        while (i <= n) {
            while (i % 5 != 0 || i % 3 == 0) {
                wait();
                continue outer;
            }
            printBuzz.run();
            i++;
            notifyAll();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public synchronized void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        outer:
        while (i <= n) {
            while (i % 3 != 0 || i % 5 != 0) {
                wait();
                continue outer;
            }
            printFizzBuzz.run();
            i++;
            notifyAll();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public synchronized void number(IntConsumer printNumber) throws InterruptedException {
        outer:
        while (i <= n) {
            while (i % 3 == 0 || i % 5 == 0) {
                wait();
                continue outer;
            }
            printNumber.accept(i);
            i++;
            notifyAll();
        }
    }
}

// synchronized methods + while (...) wait, notifyAll
// while loop conditions are easier in this version
// basically, "fizz" should be printed when, condition = (i % 3 == 0 && i % 5 != 0) is true
// that means, thread should keep waiting if the condition is false
// likewise, we can have while (!condition) for all other scenarios
class FizzBuzzMultithreaded2 {

    private int n;
    private int i = 1;

    public FizzBuzzMultithreaded2(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public synchronized void fizz(Runnable printFizz) throws InterruptedException {
        outer:
        while (i <= n) {
            while (!(i % 3 == 0 && i % 5 != 0)) {
                wait();
                continue outer;
            }
            printFizz.run();
            i++;
            notifyAll();
        }
    }

    // printBuzz.run() outputs "buzz".
    public synchronized void buzz(Runnable printBuzz) throws InterruptedException {
        outer:
        while (i <= n) {
            while (!(i % 5 == 0 && i % 3 != 0)) {
                wait();
                continue outer;
            }
            printBuzz.run();
            i++;
            notifyAll();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public synchronized void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        outer:
        while (i <= n) {
            while (!(i % 3 == 0 && i % 5 == 0)) {
                wait();
                continue outer;
            }
            printFizzBuzz.run();
            i++;
            notifyAll();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public synchronized void number(IntConsumer printNumber) throws InterruptedException {
        outer:
        while (i <= n) {
            while (!(i % 3 != 0 && i % 5 != 0)) {
                wait();
                continue outer;
            }
            printNumber.accept(i);
            i++;
            notifyAll();
        }
    }
}
