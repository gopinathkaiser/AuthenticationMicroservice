package com.quiz.quizService.Controller;


import com.quiz.quizService.DTO.QuizDto;
import com.quiz.quizService.Model.QuestionWrapper;
import com.quiz.quizService.Model.Response;
import com.quiz.quizService.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestBody QuizDto quizDto){

        return quizService.createQuiz(quizDto.getCategoryName(),quizDto.getNumQuestion(),quizDto.getTitle());
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id){
        System.out.println("work 1");
        return quizService.getQuizQuestions(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses){
        return quizService.calculateResult(id, responses);
    }

}
