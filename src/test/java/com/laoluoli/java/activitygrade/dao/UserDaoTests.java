package com.laoluoli.java.activitygrade.dao;

import com.laoluoli.java.activitygrade.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserDaoTests {
    @Autowired
    private UserDao userDao;

    @Test
    public void testFindById(){
        Integer userId = 15;
        String openid="o1RE745XUjLqSxYbnKEpMasN75wk";
        User user = userDao.findById(userId);
        Assertions.assertTrue(user.getOpenid().equals(openid));
    }

    @Test
    public void testFindByOpenid(){
        String openid="o1RE745XUjLqSxYbnKEpMasN75wk";
        Integer userId=15;
        User user = userDao.findByOpenid(openid);
        Assertions.assertTrue(user.getId().equals(userId));
    }
}
