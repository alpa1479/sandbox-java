package edu.sandbox.java.anonymousclassesvslambdaexpressions.components;

@FunctionalInterface // checks that interface has only 1 non-default method, otherwise - compile error
public interface CustomFunctionalInterface {

    void doSomething();

    default void doDefault() {
    }
}
