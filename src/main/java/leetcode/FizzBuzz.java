package leetcode;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

public class FizzBuzz {
    private int n;
    private Integer c = 1;
    private Lock l = new ReentrantLock();
    private Condition fizzbuzz = l.newCondition();
    private Condition fizz = l.newCondition();
    private Condition buzz = l.newCondition();
    private Condition number = l.newCondition();
    private Condition startCondition = l.newCondition();
    private Integer start;

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        l.lock();
        start++;
        if (start == 3) {
            startCondition.signalAll();
        }
        while (c <= n) {
            fizz.await();
            printFizz.run();
            number.signalAll();
        }
        l.unlock();
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        l.lock();
        start++;
        if (start == 3) {
            startCondition.signalAll();
        }
        while (c <= n) {
            buzz.await();
            printBuzz.run();
            number.signalAll();
        }
        l.unlock();
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {

        l.lock();
        start++;
        if (start == 3) {
            startCondition.signalAll();
        }
        while (c <= n) {
            fizzbuzz.await();
            printFizzBuzz.run();
            number.signalAll();
        }
        l.unlock();
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        l.lock();
        if (start != 3) {
            startCondition.await();
        }
        while (c <= n) {
            if (c % 15 == 0) {
                fizzbuzz.signalAll();
                number.await();
            } else if (c % 3 == 0) {
                fizz.signalAll();
                number.await();
            } else if (c % 5 == 0) {
                buzz.signalAll();
                number.await();
            } else {
                printNumber.accept(c);
            }
            c++;
        }
        fizzbuzz.signalAll();
        fizz.signalAll();
        buzz.signalAll();

        l.unlock();
    }
}
