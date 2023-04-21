package edu.sandbox.spring.context.packagescan.parallelpackage;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration // will work if remove
@ComponentScan
public class ParallelConfig {

//    will work if we will remove @Configuration and @ComponentScan
//    @Bean
//    ParallelPackageService parallelPackageService() {
//        return new ParallelPackageServiceImpl();
//    }
}
