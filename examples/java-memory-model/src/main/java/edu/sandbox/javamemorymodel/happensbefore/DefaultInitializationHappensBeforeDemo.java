package edu.sandbox.javamemorymodel.happensbefore;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DefaultInitializationHappensBeforeDemo {

    private static int number; // default value will be 0

    public static void main(String[] args) {
        // guarantee that 'number' will be initialized with default value before first action in every thread
        new Thread(() -> log.info(">>>> T1 number = {}", number)).start();
        new Thread(() -> log.info(">>>> T2 number = {}", number)).start();
    }
}
