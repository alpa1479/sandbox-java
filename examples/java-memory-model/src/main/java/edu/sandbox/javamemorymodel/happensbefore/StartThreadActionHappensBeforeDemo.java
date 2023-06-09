package edu.sandbox.javamemorymodel.happensbefore;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StartThreadActionHappensBeforeDemo {

    public static void main(String[] args) {
        var thread = new Thread(() -> log.info(">>> first action in thread"));

        // guarantee that 'start' method will be executed before first action in thread
        thread.start();
    }
}
