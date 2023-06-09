package edu.sandbox.javamemorymodel.happensbefore;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class VolatileHappensBeforeDemo {

    /* When the main thread updates the number and ready variables,
     * there's no guarantee about what the reader thread may see. In other words, the reader thread may see the updated value right away,
     * with some delay, or never at all.
     *
     * To ensure that updates to variables propagate predictably to other threads, we should apply the 'volatile' modifier
     */
    private static volatile int number;
    private static volatile boolean ready;

    public static void main(String[] args) {
        var thread = new Thread(() -> {
            while (!ready) {
                Thread.yield();
            }
            log.info(">>>> number = {}", number);
        });

        thread.start();

        number = 3;
        ready = true;
    }
}
