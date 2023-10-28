package edu.sandbox.java.anonymousclassesvslambdaexpressions;

import edu.sandbox.java.anonymousclassesvslambdaexpressions.components.CustomFunctionalInterface;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LambdaExpressionDemo {

    private final String finalStringField = "finalStringField";
    private String nonFinalStringField = "nonFinalStringField";

    public static void main(String[] args) {
        new LambdaExpressionDemo().startExample();
    }

    // Lambda Expression will be created by JVM at runtime using LambdaMetafactory
    // Usually it faster than Anonymous Classes - https://www.oracle.com/technetwork/java/jvmls2013kuksen-2014088.pdf
    // To see generated Lambda Expression - set JVM argument: -Djdk.internal.lambda.dumpProxyClasses=./examples/anonymous-classes-and-lambda-expressions/src/main/generated
    // To see bytecode: javap -p -c -v -constants LambdaExpressionDemo.class
    private void startExample() {

        // it can't implement interface with multiple non-default methods. Interface should be functional
        // InterfaceWithMultipleMethods interfaceWithMultipleMethods = () -> {}; // compile error

        int localScopeVar = 10;
        int effectivelyFinalLocalVar = 20; // for usage inside Lambda Expression local variable should be effectively final or final
        nonFinalStringField = "changed nonFinalStringField"; // instance variable can be without these restrictions
        CustomFunctionalInterface customFunctionalInterface = () -> {
            // int localScopeVar = 10; // compile error - Variable 'localScopeVar' is already defined in the scope - no shadowing
            // effectivelyFinalLocalVar = 10; // compile error
            // finalStringField = "new value"; // compile error
            nonFinalStringField = "new value for nonFinalStringField";
            log.info(">>>> CustomFunctionalInterface.doSomething within Lambda Expression, nonFinalStringField = {}", nonFinalStringField);
            this.instanceMethod(); // 'this' means LambdaExpressionDemo class object in this context
        };

        customFunctionalInterface.doSomething();
        customFunctionalInterface.doDefault(); // can execute default interface method
    }

    private void instanceMethod() {
        log.info(">>>> LambdaExpressionDemo.instanceMethod");
    }
}
