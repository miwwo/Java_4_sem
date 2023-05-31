package com.example.java_14.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController{
    @GetMapping("/home")
    public String getHome() {
        return "index";
    }
}
