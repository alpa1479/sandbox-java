package edu.sandbox.lambdaexpressions.gcimpact;

import lombok.extern.slf4j.Slf4j;

import java.util.function.IntUnaryOperator;

@Slf4j
public class CapturingLambdaExpressionGcImpactDemo {

    // to remove method inlining and then escape analysis optimization use flag: -XX:MaxInlineLevel=0
    // or you can uncomment runnable.run(); method call because by default methods with size greater than 35 (in byte code) will not be inlined
    // option to configure: -XX:MaxInlineSize=35
    public static void main(String[] args) {
        while (true) {
            new CapturingLambdaExpressionGcImpactDemo().startExample();
        }
    }

    private void startExample() {
        // Lambda Expression with link to local variable
        final var factor = 2; // if this variable is final then multiplier2 will create non-capturing lambda, but multiplier1 still be capturing

        // why multiplier1 still be capturing?
        // getIntUnaryOperator will initiate generation of capturing lambda class by LambdaMetafactory,
        // then this method will be inlined, and each time new lambda object will be created, but because of escape analysis these objects won't be created in heap

        IntUnaryOperator multiplier1 = getIntUnaryOperator(factor); // each time new instance of generated class by LambdaMetafactory will be created
        multiplier1.applyAsInt(5);

        IntUnaryOperator multiplier2 = number -> number * factor; // will inline factor variable and will create non-capturing lambda
        multiplier2.applyAsInt(5);
    }

    private static IntUnaryOperator getIntUnaryOperator(final int factor) { // even if we declare 'factor' variable as final here, it anyway will create capturing lambda
        Runnable runnable = () -> log.trace("");
        runnable.run();
        runnable.run();
        runnable.run();
        runnable.run();
        runnable.run();
        runnable.run();
        runnable.run();
        runnable.run();
        runnable.run();
        runnable.run();
        runnable.run();
        runnable.run();
        runnable.run();
        runnable.run();
        runnable.run();
        runnable.run();
        runnable.run();
        runnable.run();
        runnable.run();
        runnable.run();
        // runnable.run(); // remove comment to exceed limit of -XX:MaxInlineSize=35
        return number -> number * factor;
    }
}
