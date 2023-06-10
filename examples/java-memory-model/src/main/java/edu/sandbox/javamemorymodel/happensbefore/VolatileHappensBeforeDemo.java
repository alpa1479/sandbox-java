package edu.sandbox.javamemorymodel.happensbefore;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class VolatileHappensBeforeDemo {

    private volatile int variableToRead = 10;
    private int nonVolatileVariableToRead = 20;

    private volatile int variableToWrite;
    private int nonVolatileVariableToWrite;

    public static void main(String[] args) {
        var demo = new VolatileHappensBeforeDemo();

        // Reordering optimization may break 'volatile' visibility
        // But 'happens-before' guarantee that read of volatile variable happens before read other variables
        int value = demo.variableToRead;
        int otherValue = demo.nonVolatileVariableToRead; // will also be from main memory because it after volatile variable, even if this variable is not volatile

        // 'happens-before' guarantee that all writes that happens before 'volatile' variable write, will remain before
        demo.nonVolatileVariableToWrite = 10; // will also be written to main memory because it before volatile variable
        demo.variableToWrite = 3;
    }
}
