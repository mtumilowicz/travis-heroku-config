package com.example.travisherokuconfig;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class TravisHerokuConfigApplicationTests extends BaseIT {

    @Test
    void actuator_health_status() {
        assertThat(restTemplate
                        .getForEntity(
                                createURLWithPort("actuator/health"),
                                String.class)
                        .getStatusCode(),
                is(HttpStatus.OK));
    }
}
