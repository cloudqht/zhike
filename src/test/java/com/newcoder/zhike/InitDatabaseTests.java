package com.newcoder.zhike;

import com.newcoder.zhike.DAO.UserDAO;
import com.newcoder.zhike.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.Random;

@SpringBootTest
@Sql("/init-schema.sql")
public class InitDatabaseTests {
    @Autowired
    UserDAO userDAO;
    @Test
    public void initDatabase(){

        Random random = new Random();
        for(int i=0;i<5;i++){
            User user = new User();
            user.setHeadurl(String.format("https://%d.png", random.nextInt(1000)));
            user.setName(String.format("USER%d", i));
            user.setPassword("");
            user.setSalt("");
            userDAO.addUser(user);
        }

    }
}
