package com.hr.quiz_application.controller;

import com.hr.quiz_application.entity.Question;
import com.hr.quiz_application.service.QuestionService;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @PostMapping("/admin/uploadCSV")
    public String uploadCSV(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        try {
            Reader reader = new InputStreamReader(file.getInputStream());
            Iterable<CSVRecord> records = CSVFormat.DEFAULT
                    .withHeader("question", "option1", "option2", "option3", "option4", "correct_answer")
                    .parse(reader);

            for (CSVRecord record : records) {
                Question question = new Question(
                        record.get("question"),
                        record.get("option1"),
                        record.get("option2"),
                        record.get("option3"),
                        record.get("option4"),
                        record.get("correct_answer")
                );
                questionService.save(question);  // Use the injected service here
            }
            redirectAttributes.addFlashAttribute("message", "File uploaded and data saved successfully!");
        } catch (IOException e) {
            redirectAttributes.addFlashAttribute("message", "Failed to upload file: " + e.getMessage());
        }
        return "redirect:/admin";
    }
}
