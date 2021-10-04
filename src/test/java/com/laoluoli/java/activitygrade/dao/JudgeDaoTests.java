package com.laoluoli.java.activitygrade.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JudgeDaoTests {
    @Autowired
    private JudgeDao judgeDao;

    @Test
    public void testFindById(){
        Integer id = 1;
        System.out.println(judgeDao.findById(id));
    }
}
