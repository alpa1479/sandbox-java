package edu.sandbox.stream.api.lambdaexpressions;

import java.util.Objects;
import java.util.function.Consumer;

public class MethodReferenceVsLambdaExpressionDemo {

    // To check generated lambda expression classes use -Djdk.internal.lambda.dumpProxyClasses =
    // javap -p -c -v -constants MethodReferenceVsLambdaExpressionDemo.class
    public static void main(String[] args) {
        example1();
//        example2();
//        example3();
    }

    private static void example1() {
        Consumer<String> lambda = (str) -> System.out.println(str);
        Consumer<String> methodReference = System.out::println;
        System.setOut(null);
        methodReference.accept("methodReference");
        lambda.accept("lambda"); // throwing NPE
    }

    // target reference is evaluated when the declaration is first spotted
    // the target reference is also evaluated only once
    // so never use variable access and complex expressions as target references
    private static void example2() {
        Runnable lambda = () -> (printAndGet("some") + printAndGet("string")).toUpperCase();
        Runnable methodReference = (printAndGet("some") + printAndGet("string"))::toUpperCase;
        methodReference.run(); // won't print 'some string' but will call toUpperCase
    }

    private static void example3() {
        createLambdaAndMethodReference();
        createLambdaAndMethodReference();
        createLambdaAndMethodReference();
    }

    private static String printAndGet(String string) {
        System.out.println(string);
        return string;
    }

    private static void createLambdaAndMethodReference() {
        Runnable lambda = () -> System.out.println();
        Runnable capturedMethodReference = System.out::println;
        Consumer<Boolean> nonCapturedMethodReference = Objects::nonNull;

        // each time the same, because will generate non-captured class at runtime
        System.out.println(">>>> lambda = " + lambda.hashCode());
        System.out.println(">>>> nonCapturedMethodReference = " + nonCapturedMethodReference.hashCode());

        // each time new, because will generate captured by PrintWriter class at runtime
        System.out.println(">>>> capturedMethodReference = " + capturedMethodReference.hashCode());
    }
}
