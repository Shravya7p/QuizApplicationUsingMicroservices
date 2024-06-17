package com.quiz.services.impl;

import com.quiz.entities.Question;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//@FeignClient(url="http://localhost:8082",value="Question-Client")
@FeignClient(name="QUESTIONSERVICE1")
public interface QuestionClient {

    @GetMapping("/question1/quiz/{quizId}")
    List<Question> getAllQuestionsOfQuiz(@PathVariable Long quizId);
}
