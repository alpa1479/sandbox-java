package edu.sandbox.spring.context.xmlbasedconfig.service.impl;

import edu.sandbox.spring.context.xmlbasedconfig.service.XmlBasedService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(locations = "/test-spring-context.xml")
@DisplayName("Test should check that XmlBasedService initialized properly")
class XmlBasedServiceTest {

    @Autowired
    private XmlBasedService xmlBasedService;

    @Test
    @DisplayName("should check that xmlBasedService is not null")
    void shouldCheckThatObjectNonNull() {
        Assertions.assertThat(xmlBasedService).isNotNull();
    }
}
