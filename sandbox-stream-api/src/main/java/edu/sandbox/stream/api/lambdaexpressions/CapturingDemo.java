package edu.sandbox.stream.api.lambdaexpressions;

import java.util.function.Function;

public class CapturingDemo {

    static int x = 1;
    int y = 2;

    public static void main(String[] args) {
        example1();
        example2();
        example3();
    }

    // non-captured
    private static void example1() {
        Function<Integer, Integer> sum = (a) -> a + x;
        x = 10;
        System.out.println(sum.apply(5));
    }

    // captured
    private static void example2() {
        CapturingDemo capturingDemo = new CapturingDemo();
        Function<Integer, Integer> sum = (a) -> a + capturingDemo.y;
        capturingDemo.y = 10;
        System.out.println(sum.apply(5));
    }

    // captured
    private static void example3() {
        int z = 10;
        Function<Integer, Integer> sum = (a) -> a + z;
        // z = 5; - compiler error, z should be effectively final
        System.out.println(sum.apply(5));
    }
}
