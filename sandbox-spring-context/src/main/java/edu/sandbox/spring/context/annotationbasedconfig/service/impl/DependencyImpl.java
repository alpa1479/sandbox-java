package edu.sandbox.spring.context.annotationbasedconfig.service.impl;

import edu.sandbox.spring.context.annotationbasedconfig.service.CircularDependency;
import edu.sandbox.spring.context.annotationbasedconfig.service.Dependency;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DependencyImpl implements Dependency {

    private static final Logger log = LoggerFactory.getLogger(DependencyImpl.class);

    private final CircularDependency circularDependency;

    @Override
    public void doSomething() {
        circularDependency.doSomething();
        log.info(">>>> doSomething from DependencyImpl");
    }

    @Override
    public void doNothing() {
        log.info(">>>> doNothing from DependencyImpl");
    }
}
