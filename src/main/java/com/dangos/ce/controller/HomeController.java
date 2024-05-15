package com.dangos.ce.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/api/v1/home")
    public String home() {
        return "Hello, World!";
    }

    @GetMapping("/")
    public String index() {
        return "Hello, World!";
    }

//    @GetMapping("/software")
//    public String software() {
//        return "software!";
//    }
//
//    @GetMapping("/secured")
//    public String secured() {
//        return "Hello, Secured!";
//    }

}
