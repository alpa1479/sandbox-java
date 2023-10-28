package edu.sandbox.java.javamemorymodel.happensbefore;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadInterruptActionHappensBeforeDemo {

    public static void main(String[] args) {
        var thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
            }
            log.info(">>>> Thread interrupted");
        });

        thread.start();
        // guarantee that interrupt method happens before isInterrupted will return true
        thread.interrupt();

        log.info(">>>> Main thread finished");
    }
}
