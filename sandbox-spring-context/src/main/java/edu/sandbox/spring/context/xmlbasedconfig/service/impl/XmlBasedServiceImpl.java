package edu.sandbox.spring.context.xmlbasedconfig.service.impl;

import edu.sandbox.spring.context.xmlbasedconfig.service.Dependency;
import edu.sandbox.spring.context.xmlbasedconfig.service.XmlBasedService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@RequiredArgsConstructor
public class XmlBasedServiceImpl implements XmlBasedService {

    private static final Logger log = LoggerFactory.getLogger(XmlBasedServiceImpl.class);

    private final Dependency dependency;

    // for constructor injection
    public XmlBasedServiceImpl(Dependency dependency) {
        this.dependency = dependency;
    }

    // for setter injection
//    public void setDependency(Dependency dependency) {
//        this.dependency = dependency;
//    }

    @Override
    public void doSomething() {
        dependency.doSomething();
        log.info(">>>> doSomething from XmlBasedServiceImpl");
    }
}
