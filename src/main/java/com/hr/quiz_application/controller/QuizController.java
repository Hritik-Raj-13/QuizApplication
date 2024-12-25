package com.hr.quiz_application.controller;

import com.hr.quiz_application.entity.Question;
import com.hr.quiz_application.service.AnswerService;
import com.hr.quiz_application.service.AnswerServiceImpl;
import com.hr.quiz_application.service.ImageService;
import com.hr.quiz_application.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private AnswerServiceImpl answerServiceimpl;

    @Autowired
    private ImageService imageService;

    // this is for the admin panel this will return the list of the questions with answers
    @GetMapping("/questions")
    public List<Question> getQuestions(){
        return questionService.getQuestions();
    }

    @Controller
    public static class QuizPageController{
        @GetMapping("/quiz")
        public String showQuiz(){
            return "quiz";
        }
    }

    @PostMapping("/submit")
    public ResponseEntity<?> submitAnswers(@RequestBody Map<String, List<String>> payload) {
        List<String> answers = payload.get("answers");
        // Save the answers using your service
        answerServiceimpl.saveAnswers(answers);
        return ResponseEntity.ok("Answers saved successfully");
    }

    @PostMapping("/uploadImage")
    public ResponseEntity<?> uploadImage(@RequestBody Map<String, String> payload){
        String base64Image = payload.get("image");
        byte[] imageBytes = Base64.getDecoder().decode(base64Image.split(",")[1]);
        // now save the image by using our service layer
        imageService.saveImage(imageBytes);
        return ResponseEntity.ok("Image saved successfully");
    }

    @DeleteMapping("/questions")
    public ResponseEntity<String> deleteAllQuestions() {
        questionService.deleteAllQuestions();
        return ResponseEntity.ok("All questions deleted successfully");
    }

}
