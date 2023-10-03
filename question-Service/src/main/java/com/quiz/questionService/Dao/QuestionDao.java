package com.quiz.questionService.Dao;


import com.quiz.questionService.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question,Integer> {


    List<Question> findByCategory(String category);

    @Query(value = "select * from question q where category=:category ORDER BY RANDOM() LIMIT :numQ",nativeQuery = true)
    List<Integer> findRandomQuestionsByDao(String category, int numQ);
}
