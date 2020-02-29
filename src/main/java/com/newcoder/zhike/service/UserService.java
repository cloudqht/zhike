package com.newcoder.zhike.service;

import com.newcoder.zhike.dao.LoginTicketDAO;
import com.newcoder.zhike.dao.UserDAO;
import com.newcoder.zhike.model.LoginTicket;
import com.newcoder.zhike.model.User;
import com.newcoder.zhike.util.WendaUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {
    @Autowired
    UserDAO userDAO;
    @Autowired
    LoginTicketDAO loginTicketDAO;
    public User getUser(int id){
        return userDAO.selectById(id);
    }

    public Map<String, String> register(String username, String password){
        Map<String, String> map = new HashMap<>();
        if(StringUtils.isBlank(username)){
            map.put("msg", "用户名不能为空");
            return map;

        }
        if(StringUtils.isBlank(password)){
            map.put("msg", "密码不能为空");
            return map;
        }
        User user = userDAO.selectByName(username);
        if(user!=null){
            map.put("msg", "用户名已经被注册");
            return map;
        }
        user = new User();
        user.setName(username);

        user.setSalt(UUID.randomUUID().toString().substring(0,5));
        user.setPassword(WendaUtil.MD5(password+user.getSalt()));
        user.setHeadurl(String.format("https://images.nowcoder.com/head/%dm.png", new Random().nextInt(1000)));
        userDAO.addUser(user);

        String ticket = addLoginTicket(user.getId());
        map.put("ticket", ticket);
        return map;
    }
    public Map<String, String> login(String username, String password){
        Map<String, String> map = new HashMap<>();
        if(StringUtils.isBlank(username)){
            map.put("msg", "用户名不能为空");
            return map;

        }
        if(StringUtils.isBlank(password)){
            map.put("msg", "密码不能为空");
            return map;
        }
        User user = userDAO.selectByName(username);
        if(user==null){
            map.put("msg", "用户名不存在");
            return map;
        }
        if(!WendaUtil.MD5(password + user.getSalt()).equals(user.getPassword())){
            map.put("msg", "密码错误");
            return map;
        }
        String ticket = addLoginTicket(user.getId());
        map.put("ticket", ticket);

        return map;
    }
    public String addLoginTicket(int userId){
        LoginTicket loginTicket = new LoginTicket();
        loginTicket.setUserId(userId);
        Date date = new Date();
        date.setTime(date.getTime() + 1000*3600*12);
        loginTicket.setExpired(date);
        loginTicket.setStatus(0);
        loginTicket.setTicket(UUID.randomUUID().toString().replaceAll("-", ""));
        loginTicketDAO.addTicket(loginTicket);
        return loginTicket.getTicket();
    }
}
