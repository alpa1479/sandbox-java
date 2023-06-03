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
        var factor = 2;
        IntUnaryOperator multiplier = getIntUnaryOperator(factor); // each time new instance of generated class by LambdaMetafactory will be created
        multiplier.applyAsInt(5);
    }

    private static IntUnaryOperator getIntUnaryOperator(int factor) {
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
