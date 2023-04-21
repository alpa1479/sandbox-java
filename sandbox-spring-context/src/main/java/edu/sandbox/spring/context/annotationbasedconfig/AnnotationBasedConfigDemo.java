package edu.sandbox.spring.context.annotationbasedconfig;

import edu.sandbox.spring.context.annotationbasedconfig.service.AnnotationBasedService;
import edu.sandbox.spring.context.xmlbasedconfig.service.XmlBasedService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ImportResource;

//@ComponentScan // if we will move DependencyImpl out of annotationbasedconfig folder it won't find it
@RequiredArgsConstructor
@ImportResource("classpath:spring-context.xml")
@SpringBootApplication
public class AnnotationBasedConfigDemo {

    private static final Logger log = LoggerFactory.getLogger(AnnotationBasedConfigDemo.class);

    @Getter
    private final XmlBasedService dependency1;
    @Getter
    private final AnnotationBasedService dependency2;

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AnnotationBasedConfigDemo.class);
//        AnnotationBasedConfigDemo demo = context.getBean(AnnotationBasedConfigDemo.class);
//        XmlBasedService dependency = demo.getDependency1();
//        dependency.doSomething();

//        XmlBasedService bean = context.getBean(XmlBasedService.class);
//        bean.doSomething();
        AnnotationBasedService bean1 = context.getBean(AnnotationBasedService.class);
        bean1.doSomething();
//        log.info("-------------------------------- \n");
//        AnnotationBasedService annotationBasedService = context.getBean(AnnotationBasedService.class);
//        annotationBasedService.doSomething();

//        log.info("-------------------------------- \n");
//        NonRegisteredDependency nonRegisteredDependency = new NonRegisteredDependencyImpl();
//        DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) context.getAutowireCapableBeanFactory();
//        beanFactory.registerSingleton("nonRegisteredDependency", nonRegisteredDependency);
//        nonRegisteredDependency = (NonRegisteredDependency) context.getBean("nonRegisteredDependency");
//        nonRegisteredDependency.doSomething();
    }
}

