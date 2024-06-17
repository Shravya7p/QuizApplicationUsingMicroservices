package com.quiz.services.impl;

import com.quiz.entities.Quiz;
import com.quiz.repositories.QuizRepository;
import com.quiz.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizServiceImpl implements QuizService {
    private QuizRepository repo;
    private QuestionClient questionClient;

    public QuizServiceImpl(QuizRepository repo, QuestionClient questionClient) {
        this.repo = repo;
        this.questionClient = questionClient;
    }



    @Override
    public Quiz addQuiz(Quiz quiz) {
        return repo.save(quiz);
    }

    @Override
    public List<Quiz> getQuizzes() {
        List<Quiz> quizzes = repo.findAll();
        List<Quiz> newQuizList = quizzes.stream().map(quiz -> {quiz.setQuestions(questionClient.getAllQuestionsOfQuiz(quiz.getId()));
            return quiz;
        }).collect(Collectors.toList());

        return newQuizList;
    }

    @Override
    public Quiz getQuizById(Long id) {
        Quiz quiz = repo.findById(id).orElseThrow(()->new RuntimeException("Quiz not found with given id!"));
        quiz.setQuestions(questionClient.getAllQuestionsOfQuiz(quiz.getId()));
        return quiz;
    }
}
