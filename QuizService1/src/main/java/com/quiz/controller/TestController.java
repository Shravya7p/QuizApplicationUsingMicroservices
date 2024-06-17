package com.quiz.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quizTest")
public class TestController {

    @GetMapping
    public String quizTest(){
        return "Working!";
    }
}
