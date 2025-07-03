package com.example.sbb;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.sbb.question.QuestionRepository;

import com.example.sbb.question.QuestionService;

@SpringBootTest
class SbbApplicationTests {

    @Autowired
    private QuestionService questionService;

    @Test
    void testJpa()
    {
        for (int i=0;i<300;i++)
        {
            String subject="Test subject "+i;
            String content="Test content";
            this.questionService.create(subject,content,null);
        }
    }
}