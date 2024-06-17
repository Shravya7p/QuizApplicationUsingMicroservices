package com.quiz.controller;

import com.quiz.entities.Quiz;
import com.quiz.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz1")
public class QuizController {

    @Autowired
    private QuizService quizService;


    //create
    @PostMapping("/add/")
    public Quiz create(@RequestBody Quiz quiz){
        return quizService.addQuiz(quiz);
    }

    //get All
    @GetMapping
    public List<Quiz> get(){
        return quizService.getQuizzes();
    }

    //get quiz by id
    @GetMapping("/{id}")
    public Quiz getQuizById(@PathVariable Long id){
        return quizService.getQuizById(id);
    }
}
