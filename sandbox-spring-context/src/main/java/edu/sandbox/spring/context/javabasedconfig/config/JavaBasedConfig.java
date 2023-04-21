package edu.sandbox.spring.context.javabasedconfig.config;

import edu.sandbox.spring.context.javabasedconfig.service.JavaBasedConfigService;
import edu.sandbox.spring.context.javabasedconfig.service.Dependency;
import edu.sandbox.spring.context.javabasedconfig.service.impl.DependencyImpl;
import edu.sandbox.spring.context.javabasedconfig.service.impl.JavaBasedConfigServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // will work without this annotation
public class JavaBasedConfig {

    @Bean
    Dependency dependency() {
        return new DependencyImpl();
    }

    // method injection
    @Bean
    JavaBasedConfigService javaBasedConfigService(Dependency dependency) {
        return new JavaBasedConfigServiceImpl(dependency);
    }
}
