package com.laoluoli.java.activitygrade.dao;

import com.laoluoli.java.activitygrade.domain.Grade;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class GradeDaoTests {
    @Autowired
    private GradeDao gradeDao;

    @Test
    public void testFindListByActivityid(){
        Integer id = 512;
        List<Grade> res = gradeDao.findListByActivityid(id);
        for(Grade g : res){
            System.out.println(g);
        }
    }

    @Test
    public void test(){
        System.out.println("hhh");
    }
}
