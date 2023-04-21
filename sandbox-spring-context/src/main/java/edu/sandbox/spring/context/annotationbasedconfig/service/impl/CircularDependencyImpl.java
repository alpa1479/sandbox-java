package edu.sandbox.spring.context.annotationbasedconfig.service.impl;

import edu.sandbox.spring.context.annotationbasedconfig.service.CircularDependency;
import edu.sandbox.spring.context.annotationbasedconfig.service.Dependency;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class CircularDependencyImpl implements CircularDependency {

    private static final Logger log = LoggerFactory.getLogger(CircularDependencyImpl.class);

    private final Dependency dependency;

    // jdk.proxy2.$Proxy9@2052
    // without Lazy - Error creating bean with name 'dependencyImpl': Requested bean is currently in creation: Is there an unresolvable circular reference?
    public CircularDependencyImpl(@Lazy Dependency dependency) {
        this.dependency = dependency;
    }

    @Override
    public void doSomething() {
        dependency.doNothing();
        log.info(">>>> doSomething from CircularDependencyImpl");
    }
}
