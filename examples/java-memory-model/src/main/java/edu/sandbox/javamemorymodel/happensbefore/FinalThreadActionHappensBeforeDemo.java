package edu.sandbox.javamemorymodel.happensbefore;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FinalThreadActionHappensBeforeDemo {

    private static boolean finished = false;

    public static void main(String[] args) throws InterruptedException {
        var thread = new Thread(() -> {
            log.info(">>>> T1 finishing last task");
            finished = true; // last action in thread
        });
        thread.start();

        // guarantee that last action in 'thread' will be visible in main thread
        thread.join();

        if (finished) {
            log.info(">>>> T1 finished last task");
        }
    }
}
