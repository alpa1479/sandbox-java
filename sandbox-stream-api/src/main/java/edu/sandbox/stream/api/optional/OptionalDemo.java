package edu.sandbox.stream.api.optional;

import java.util.Optional;
import java.util.Random;

public class OptionalDemo {

    // https://stackoverflow.com/questions/31696485/why-use-optional-of-over-optional-ofnullable
    public static void main(String[] args) {
        Integer number = getNumber();
        // use in case of literals or short computations like using of  getters, constructors etc.
        Optional.ofNullable(number).map(Integer::bitCount).orElse(shortComputation());
        // use lambda for long computation because it will be executed only if needed
        Optional.ofNullable(number).map(Integer::bitCount).orElseGet(() -> longComputation());
    }

    public static Integer getNumber() {
        int randomNumber = new Random().ints(1, 10).findFirst().orElse(1);
        return randomNumber == 1 ? randomNumber : null;
    }

    public static Integer shortComputation() {
        System.out.println("execution of shortComputation");
        return 10;
    }

    public static Integer longComputation() {
        System.out.println("shortComputation");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 30;
    }
}
