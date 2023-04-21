package edu.sandbox.spring.context.annotationbasedconfig.service.impl;

import edu.sandbox.spring.context.annotationbasedconfig.service.AnnotationBasedService;
import edu.sandbox.spring.context.annotationbasedconfig.service.Dependency;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
//@RequiredArgsConstructor
public class AnnotationBasedServiceImpl implements AnnotationBasedService {

    private static final Logger log = LoggerFactory.getLogger(AnnotationBasedServiceImpl.class);

    // field injection via reflection
    //    @Autowired
    private Dependency dependency;

    // constructor injection, will work without @Autowired if we have only 1 constructor, even if others are private
    public AnnotationBasedServiceImpl(Dependency dependency) {
        this.dependency = dependency;
    }

//    @Autowired
//    public void setDependency(Dependency dependency) {
//        this.dependency = dependency;
//    }

    @Override
    public void doSomething() {
        dependency.doSomething();
        log.info(">>>> doSomething from AnnotationBasedServiceImpl");
    }
}
