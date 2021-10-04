package com.laoluoli.java.activitygrade.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RedisDaoTests {
    @Autowired
    private RedisDao redisDao;
    @Test
    public void testFindByKey(){
        String key = "appid_old";
        System.out.println(redisDao.findByKey(key));
    }
}
