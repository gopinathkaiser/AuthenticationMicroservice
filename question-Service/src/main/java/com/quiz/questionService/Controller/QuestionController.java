package com.quiz.questionService.Controller;


import com.quiz.questionService.Model.Question;
import com.quiz.questionService.Model.QuestionWrapper;
import com.quiz.questionService.Model.Response;
import com.quiz.questionService.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return  questionService.addQuestion(question);
    }

    @GetMapping("generate/{categoryName}/{numQuestions}")
    public ResponseEntity<List<Integer>> getQuestionsForQuiz
            (@PathVariable String categoryName, @PathVariable Integer numQuestions ){
        System.out.println("create quiz from question");
        return questionService.getQuestionsForQuiz(categoryName, numQuestions);
    }

    @PostMapping("getQuestions")
    public List<QuestionWrapper> getQuestionsFromId(@RequestBody List<Integer> questionIds){
        System.out.println("afterr ms");
        return questionService.getQuestionsFromId(questionIds);
    }

    @PostMapping("getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses)
    {
        return questionService.getScore(responses);
    }

}