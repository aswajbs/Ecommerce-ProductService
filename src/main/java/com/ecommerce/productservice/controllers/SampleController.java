package com.ecommerce.productservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/say")
public class SampleController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello Everyone";
    }

    @GetMapping("/bye")
    public String sayBye() {
        return "Bye Everyone";
    }
    @GetMapping("/wc/{name}/{dept}")
    public String welocome(@PathVariable String name, @PathVariable String dept){
        return "Welcome to Everyone to BITM "+name+" from Deparment "+dept;
    }
}
