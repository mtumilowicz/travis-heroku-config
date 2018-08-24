package com.example.travisherokuconfig;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * Created by mtumilowicz on 2018-08-24.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
public class BaseIT {
    @Autowired
    TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
}
