package com.newcoder.zhike.service;

import com.newcoder.zhike.dao.QuestionDAO;
import com.newcoder.zhike.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionDAO questionDAO;

    public List<Question> getLatestQuestions(int userId, int offset, int limit) {
        return questionDAO.selectLatestQuestions(userId, offset, limit);
    }

    public int addQuestion(Question question) {
        //添加成功的返回值大于0
        return questionDAO.addQuestion(question) > 0 ? question.getId() : 0;
    }
}
