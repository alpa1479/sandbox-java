package edu.sandbox.spring.context.annotationbasedconfig.service.impl;

import edu.sandbox.spring.context.annotationbasedconfig.service.NonRegisteredDependency;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NonRegisteredDependencyImpl implements NonRegisteredDependency {

    private static final Logger log = LoggerFactory.getLogger(NonRegisteredDependencyImpl.class);

    @Override
    public void doSomething() {
        log.info(">>>> doSomething from NonRegisteredDependencyImpl");
    }
}
