package edu.sandbox.spring.context.javabasedconfig;

import edu.sandbox.spring.context.javabasedconfig.config.JavaBasedConfig;
import edu.sandbox.spring.context.javabasedconfig.service.JavaBasedConfigService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaBasedConfigDemo {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(JavaBasedConfig.class);
// in case if we don't pass JavaBasedConfig.class in AnnotationConfigApplicationContext constructor will be
// org.springframework.context.annotation.AnnotationConfigApplicationContext@fad74ee has not been refreshed yet
// then need:
//        context.register(JavaBasedConfig.class);
//        context.refresh();
        JavaBasedConfigService service = context.getBean(JavaBasedConfigService.class);
        service.doSomething();
    }
}
