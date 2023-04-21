package edu.sandbox.spring.context.annotationbasedconfig.service.impl;

import edu.sandbox.spring.context.annotationbasedconfig.service.Dependency;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(TestConfig.class)
@DisplayName("Test should check that Dependency initialized properly")
class DependencyTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private Dependency dependency;

    @Test
    @DisplayName("should check that dependency and applicationContext are not null")
    void shouldCheckThatObjectNonNull() {
        Assertions.assertThat(applicationContext).isNotNull();
        Assertions.assertThat(dependency).isNotNull();
    }
}
