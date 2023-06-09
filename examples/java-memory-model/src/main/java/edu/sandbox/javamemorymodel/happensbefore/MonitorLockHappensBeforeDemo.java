package edu.sandbox.javamemorymodel.happensbefore;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MonitorLockHappensBeforeDemo {

    private final Object lock = new Object();

    private int number;
    private boolean initialized = false;

    public void write() {
        // guarantee that only one thread at the same time will be within synchronized block
        synchronized (lock) {
            number = 3;
            initialized = true;
        }
    }

    public void read() {
        synchronized (lock) {
            // guarantee that 'reader' thread will see changes done after release lock in 'writer' thread
            if (initialized) {
                log.info(">>>> T2 number = {}", number);
            }
        }
    }

    public static void main(String[] args) {
        var demo = new MonitorLockHappensBeforeDemo();

        var writer = new Thread(demo::write);
        writer.start();

        var reader = new Thread(demo::read);
        reader.start();
    }
}
