package edu.sandbox.javamemorymodel.volatileandsynchronizedkeywords;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class VolatileVisibilityProblemDemo {

    // To ensure that updates to variables propagate predictably to other threads, we should apply the volatile modifier.
    // In this case reads and writes will be from main memory.
    private volatile boolean sharedFlag = false;

    public static void main(String[] args) {
        var demo = new VolatileVisibilityProblemDemo();
        var readerThread = new Thread(() -> {
            while (!demo.sharedFlag) { // reader thread waits 'sharedFlag' variable update
                Thread.yield();
            }
            log.info(">>>> sharedFlag = {}", demo.sharedFlag);
        });

        readerThread.start();

        // If 'sharedFlag' variable is not volatile, then:
        // When the main thread updates the 'sharedFlag' variable, there's no guarantee about what the reader thread may see.
        // In other words, the reader thread may see the updated value right away, with some delay, or never at all.
        // In this case volatile solves visibility problem.
        demo.sharedFlag = true;
    }
}
