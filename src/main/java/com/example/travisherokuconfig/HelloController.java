package com.example.travisherokuconfig;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mtumilowicz on 2018-08-24.
 */
@RestController
public class HelloController {
    
    @GetMapping
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("hello");
    }
    
    @GetMapping("health")
    public boolean health() { 
        return true;
    }
}
