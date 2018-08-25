package com.example.travisherokuconfig;

import org.junit.jupiter.api.Test;
import org.springframework.boot.actuate.health.Health;
import org.springframework.http.HttpStatus;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by mtumilowicz on 2018-08-24.
 */
class HelloControllerHealthCheckTest extends BaseIT {
    
    @Test
    void health() {
        assertThat(restTemplate
                        .getForEntity(
                                createURLWithPort("/health"),
                                Health.class)
                        .getStatusCode(),
                is(HttpStatus.OK));
    }
}