package edu.sandbox.javamemorymodel.volatileandsynchronizedkeywords;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class VolatileAtomicityProblemDemo {

    private static final int LIMIT = 100_000;

    // despite that visibility problem is solved, we still have synchronization problem
    private volatile int counter = 0;

    private void inc() {
        for (var idx = 0; idx < LIMIT; idx++) {
            // increment operator is not atomic, here we have:
            // read counter variable
            // increase value of counter variable
            // save counter variable
            counter++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        var counter = new VolatileAtomicityProblemDemo();
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
