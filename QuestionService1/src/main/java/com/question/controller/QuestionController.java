package com.question.controller;

import com.question.entites.Question;
import com.question.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question1")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    //create
    @PostMapping("/add")
    public Question addQuestion(@RequestBody Question question){
        return questionService.create(question);
    }

    //get all
    @GetMapping
    public List<Question> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    //get by id
    @GetMapping("/{id}")
    public Question getQuestionById(@PathVariable Long id){
        return questionService.getQuestionById(id);
    }

    //get all questions of specific quiz
    @GetMapping("/quiz/{quizId}")
    public List<Question> getAllQuestionsOfQuiz(@PathVariable Long quizId){
        return questionService.getQuestionsOfQuiz(quizId);
    }
}
