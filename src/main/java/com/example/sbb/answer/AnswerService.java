package com.example.sbb.answer;

import com.example.sbb.question.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import com.example.sbb.user.SiteUser;

import java.util.Optional;
import com.example.sbb.DataNotFoundException;

@RequiredArgsConstructor
@Service
public class AnswerService
{

    private final AnswerRepository answerRepository;

    public Answer create(Question question,String content, SiteUser author)
    {
        Answer answer=new Answer();
        answer.setContent(content);
        answer.setCreateDate(LocalDateTime.now());
        answer.setQuestion(question);
        answer.setAuthor(author);
        this.answerRepository.save(answer);
        return answer;
    }

    public Answer getAnswer(Integer id)
    {
        Optional<Answer> answer=this.answerRepository.findById(id);
        if(answer.isPresent())
        {
            return answer.get();
        }
        else
        {
            throw new DataNotFoundException("answer not found");
        }
    }

    public void modify(Answer answer, String content)
    {
        answer.setContent(content);
        answer.setModifyDate(LocalDateTime.now());
        this.answerRepository.save(answer);
    }

    public void delete(Answer answer)
    {
        this.answerRepository.delete(answer);
    }

}
