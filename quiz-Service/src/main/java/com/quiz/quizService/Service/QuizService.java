package com.quiz.quizService.Service;


import com.quiz.quizService.Controller.QuizController;
import com.quiz.quizService.Controller.RestTemplateConfig;
import com.quiz.quizService.Dao.QuizDao;
import com.quiz.quizService.Model.QuestionWrapper;
import com.quiz.quizService.Model.Quiz;
import com.quiz.quizService.Model.Response;
import com.quiz.quizService.QuizFeign.QuizInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuizInterface quizInterface;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {

        List<Integer> questions = quizInterface.getQuestionsForQuiz(category, numQ).getBody();
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);

        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        Quiz quiz = quizDao.findById(id).get();
        List<Integer> questionIds = quiz.getQuestions();
        ResponseEntity<List<QuestionWrapper>> questions = quizInterface.getQuestionsFromId(questionIds);
        return questions;
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        ResponseEntity<Integer> score = quizInterface.getScore(responses);
        return score;
    }
}






//import com.quiz.quizService.Controller.RestTemplateConfig;
//import com.quiz.quizService.Dao.QuizDao;
//import com.quiz.quizService.Model.QuestionWrapper;
//import com.quiz.quizService.Model.Quiz;
//import com.quiz.quizService.Model.Response;
//import com.quiz.quizService.QuizFeign.QuizInterface;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class QuizService {
//
//    @Autowired
//    QuizDao quizDao;
//
//    @Autowired
//    RestTemplateConfig restTemplateConfig;
//
//    private final String questionServiceBaseUrl = "http://QUESTION-SERVICE"; // Replace with the actual base URL
//
//
////    @Autowired
////    QuizInterface quizInterface;
//
//    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
//
//        List<Integer> questions = quizInterface.getQuestionsForQuiz(category, numQ).getBody();
//        Quiz quiz = new Quiz();
//        quiz.setTitle(title);
//        quiz.setQuestions(questions);
//        quizDao.save(quiz);
//
//        return new ResponseEntity<>("Success", HttpStatus.CREATED);
//
//    }
//
//
//        public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
//            Quiz quiz = quizDao.findById(id).get();
//            System.out.println(quiz);
//            List<Integer> questionIds = quiz.getQuestions();
//            System.out.println("wprk 2" + questionIds);
//            ResponseEntity<List<QuestionWrapper>> questions = quizInterface.getQuestionsFromId(questionIds);
//            System.out.println("work 3");
//            System.out.println(questions);
//            return questions;
//
//        }
//
//    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
//
//        ResponseEntity<Integer> right = quizInterface.getScore(responses);
//
//        return right;
//    }
//}
