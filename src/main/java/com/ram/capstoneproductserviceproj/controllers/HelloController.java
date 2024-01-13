package com.ram.capstoneproductserviceproj.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController
{
    @GetMapping("/hi")
    public String SayHelloHi()
    {
        return "Hello Hii";
    }

    @GetMapping("/hi/{name}")
    public String sayHelloTo(@PathVariable("name") String name)
    {
        return "Hello "+name;
    }
}
