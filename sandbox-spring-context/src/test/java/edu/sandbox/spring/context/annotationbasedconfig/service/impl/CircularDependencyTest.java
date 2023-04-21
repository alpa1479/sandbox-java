package edu.sandbox.spring.context.annotationbasedconfig.service.impl;

import edu.sandbox.spring.context.annotationbasedconfig.service.CircularDependency;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig({
        CircularDependencyImpl.class,
        DependencyImpl.class
})
@DisplayName("Test should check that CircularDependency initialized properly")
class CircularDependencyTest {

    @Autowired
    private CircularDependency circularDependency;

    @Test
    @DisplayName("should check that circularDependency is not null")
    void shouldCheckThatObjectNonNull() {
        Assertions.assertThat(circularDependency).isNotNull();
    }
}
