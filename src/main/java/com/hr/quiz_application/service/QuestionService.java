package com.hr.quiz_application.service;


import com.hr.quiz_application.entity.Question;

import java.util.List;


public interface QuestionService {


    public Question save(Question question);

    public List<Question> getQuestions();

    public void deleteAllQuestions();
}
