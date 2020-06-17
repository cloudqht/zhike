package com.newcoder.zhike.controller;

import com.newcoder.zhike.model.Question;
import com.newcoder.zhike.model.ViewObject;
import com.newcoder.zhike.service.QuestionService;
import com.newcoder.zhike.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    UserService userService;

    @Autowired
    QuestionService questionService;

    @RequestMapping(path = {"/", "/index"})
    public String index(Model model) {
        List<ViewObject> volist = getQuestions(0, 0, 10);
        model.addAttribute("volist", volist);
        return "index";
    }

    @RequestMapping(path = {"/user/{userId}"})
    public String userIndex(Model model,
                            @PathVariable("userId") int userId) {
        List<ViewObject> volist = getQuestions(userId, 0, 5);
        model.addAttribute("volist", volist);
        return "index";
    }

    private List<ViewObject> getQuestions(int userId, int offset, int limit){
        List<Question> questionList = questionService.getLatestQuestions(userId, offset, limit);
        List<ViewObject> volist = new ArrayList<>();

        for(Question question:questionList){
            ViewObject vo = new ViewObject();
            vo.set("question", question);
            vo.set("user", userService.getUser(question.getUserId()));
            volist.add(vo);
        }
        return volist;
    }
}
