package com.swagger.swagger.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/rest/hello")
public class HelloResource {
    
    @GetMapping
    public String hello() {
        return "Hello World";
    }

    @PostMapping("/post")
    public String helloPost(@RequestBody final String hello) {
        return hello;
    }

    @PutMapping("/put")
    public String helloPut(@RequestBody final String hello) {
        return hello;
    }
}
