package edu.sandbox.lambdaexpressions.methodreferences;

import lombok.extern.slf4j.Slf4j;

import java.util.Objects;
import java.util.function.Consumer;

@Slf4j
public class MethodReferencesDemo {

    public static void main(String[] args) {
        var demo = new MethodReferencesDemo();

        demo.earlyExecutionExample();
        demo.capturingExample();
        demo.npeExample(); // program will fail with npe
    }

    private void npeExample() {
        Consumer<String> lambda1 = (str) -> System.out.println(str);
        Consumer<String> methodReference1 = System.out::println; // it will create new link to the PrintWriter object
        System.setOut(null);
        methodReference1.accept("methodReference");
        lambda1.accept("lambda"); // throwing NPE
    }

    private void earlyExecutionExample() {
        Runnable lambda2 = () -> (printAndGet("some") + printAndGet("string")).toUpperCase(); // lazy execution
        Runnable methodReference2 = (printAndGet("some") + printAndGet("string"))::toUpperCase; // first execution, then method reference
        methodReference2.run(); // won't print 'some string', but will call toUpperCase
    }

    private void capturingExample() {
        createLambdaAndMethodReference();
        createLambdaAndMethodReference();
        createLambdaAndMethodReference();
    }

    private static String printAndGet(String string) {
        log.info(string);
        return string;
    }

    private static void createLambdaAndMethodReference() {
        Runnable lambda = () -> System.out.println(); // non-captured lambda
        Runnable capturedMethodReference = System.out::println; // captured lambda
        Consumer<Boolean> nonCapturedMethodReference = Objects::nonNull;

        // each time the same, because will generate non-captured class at runtime
        log.info(">>>> lambda = " + lambda.hashCode());
        log.info(">>>> nonCapturedMethodReference = " + nonCapturedMethodReference.hashCode());

        // each time new, because will generate captured by PrintWriter class at runtime
        log.info(">>>> capturedMethodReference = " + capturedMethodReference.hashCode());
    }
}
