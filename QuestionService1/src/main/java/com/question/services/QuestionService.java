package com.question.services;

import com.question.entites.Question;

import java.util.List;

public interface QuestionService {

    Question create(Question question);

    List<Question> getAllQuestions();

    Question getQuestionById(Long id);

    List<Question> getQuestionsOfQuiz(Long quizId);
}
