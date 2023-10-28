package edu.sandbox.java.anonymousclassesvslambdaexpressions;

import edu.sandbox.java.anonymousclassesvslambdaexpressions.components.InterfaceWithMultipleMethods;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AnonymousClassDemo {

    private final String finalStringField = "finalStringField";
    private String nonFinalStringField = "nonFinalStringField";

    public static void main(String[] args) {
        new AnonymousClassDemo().startExample();
    }

    // Anonymous class will be generated by compiler. You can see AnonymousClassVsLambdaExpressionDemo$1.class file in build folder (you can drag-and-drop this file to IDEA)
    private void startExample() {
        int localScopeVar = 10;
        int effectivelyFinalLocalVar = 20; // for usage inside Anonymous class local variable should be effectively final or final
        nonFinalStringField = "changed nonFinalStringField"; // instance variable can be without these restrictions

        // Anonymous class can't be abstract, we can't extend him, and it cannot implement multiple interfaces
        var interfaceWithMultipleMethods = new InterfaceWithMultipleMethods() {

            private int localScopeVar = 30; // Anonymous class creates new scope, it will be new variable with the same name as outside of Anonymous class - shadowing

            // Anonymous class can't have constructors

            // Anonymous class can implement any amount of methods
            @Override
            public void doSomething() {
                // effectivelyFinalLocalVar = 10; // compile error
                // finalStringField = "new value"; // compile error
                nonFinalStringField = "new value for nonFinalStringField";
                localScopeVar = localScopeVar + 10;
                log.info(">>>> InterfaceWithMultipleMethods.doSomething within Anonymous Class," +
                        " localScopeVar = {}, nonFinalStringField = {}", localScopeVar, nonFinalStringField);
            }

            @Override
            public void doNothing() {
                this.doSomething(); // 'this' means anonymous InterfaceWithMultipleMethods class object in this context
                log.info(">>>> InterfaceWithMultipleMethods.doNothing within Anonymous Class");
            }
        };
        // Anonymous class can have fields and saves state between method calls - see localScopeVar value
        interfaceWithMultipleMethods.doSomething();
        interfaceWithMultipleMethods.doNothing();

        // Interface the same, but as we can create only 1 instance of Anonymous class it will be different Anonymous class
        // It means that it will create second file with name - AnonymousClassVsLambdaExpressionDemo$2.class
        var secondAnonymousClass = new InterfaceWithMultipleMethods() {
            @Override
            public void doSomething() {
            }

            @Override
            public void doNothing() {
            }
        };
        secondAnonymousClass.doNothing();
    }
}