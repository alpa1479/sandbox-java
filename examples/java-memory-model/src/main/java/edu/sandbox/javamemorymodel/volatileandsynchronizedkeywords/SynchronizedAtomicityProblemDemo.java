package edu.sandbox.javamemorymodel.volatileandsynchronizedkeywords;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SynchronizedAtomicityProblemDemo {

    private static final int LIMIT = 100_000;

    private int counter = 0;

    // only one thread at time can execute this method
    // that's why this program will behave as program with one thread
    private synchronized void inc() {
        for (var idx = 0; idx < LIMIT; idx++) {
            counter++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        var counter = new SynchronizedAtomicityProblemDemo();
        counter.startExample();
    }

    private void startExample() throws InterruptedException {
        var thread1 = new Thread(this::inc);
        var thread2 = new Thread(this::inc);
        var thread3 = new Thread(this::inc);

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();
        log.info(">>>> counter: {}", counter);
    }
}
