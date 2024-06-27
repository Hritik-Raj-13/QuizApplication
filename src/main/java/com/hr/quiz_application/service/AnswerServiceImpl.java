package com.hr.quiz_application.service;

import com.hr.quiz_application.entity.Answer;
import com.hr.quiz_application.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    @Override
    public void saveAnswers(List<String> answers) {
        Answer answerEntity = new Answer(answers);
        answerRepository.save(answerEntity);
    }
}