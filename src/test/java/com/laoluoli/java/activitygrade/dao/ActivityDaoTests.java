package com.laoluoli.java.activitygrade.dao;


import com.laoluoli.java.activitygrade.domain.Activity;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.InputStream;
import java.util.List;

@SpringBootTest
public class ActivityDaoTests {

    @Autowired
    ActivityDao activityDao;
    @Test
    public void testFindById() {
        Activity activity = activityDao.findById(1);
        System.out.println(activity);
    }

    @Test
    public void testFindByCode() {
        Activity activity = activityDao.findByCode("34dss");
        Activity activity1 = activityDao.findByCode("34dss");
        System.out.println(activity);
        System.out.println(activity1);
    }

    @Test
    public void testUpdate() {
        Activity activity = activityDao.findById(1);
        activity.setBrief("1对校园内的歌手参赛人员进行评分");
        int res = activityDao.update(activity);
        System.out.println(res);
    }

    @Test
    public void testFindActivityByUserid() {
       List<Activity> activities = activityDao.findActivityByUserid(1);
        for(Activity e : activities){
            System.out.println(e);
        }
    }
}
