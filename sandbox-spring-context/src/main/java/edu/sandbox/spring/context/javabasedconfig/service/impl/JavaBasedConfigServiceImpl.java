package edu.sandbox.spring.context.javabasedconfig.service.impl;

import edu.sandbox.spring.context.javabasedconfig.service.Dependency;
import edu.sandbox.spring.context.javabasedconfig.service.JavaBasedConfigService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequiredArgsConstructor
public class JavaBasedConfigServiceImpl implements JavaBasedConfigService {

    private static final Logger log = LoggerFactory.getLogger(JavaBasedConfigServiceImpl.class);

    private final Dependency dependency;

    @Override
    public void doSomething() {
        dependency.doSomething();
        log.info(">>>> doSomething from JavaBasedConfigServiceImpl");
    }
}
