package com.example.travisherokuconfig;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by mtumilowicz on 2018-08-24.
 */
class HelloControllerTest extends BaseIT {
    
    @Test
    void hello_status() {
        assertThat(restTemplate
                        .getForEntity(
                                createURLWithPort(""),
                                String.class)
                        .getStatusCode(),
                is(HttpStatus.OK));
    }

    @Test
    void hello_entity() {
        assertThat(restTemplate
                        .getForObject(
                                createURLWithPort(""),
                                String.class),
                is("hello"));
    }
}