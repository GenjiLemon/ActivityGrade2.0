package com.laoluoli.java.activitygrade.utils;

import com.laoluoli.java.activitygrade.domain.Activity;
import com.laoluoli.java.activitygrade.service.ActivityService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RedisUtilsTests {
    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private ActivityService activityService;

    @Test
    public void testGetString(){
        String key = "name";
        String value = (String)redisUtils.get(key);
        System.out.println(value);
    }

    @Test
    public void testSetString(){
        String key = "name";
        String value = "fay";
        redisUtils.set(key, value, 1000);
        testGetString();
    }

    @Test
    public void testSetObject(){
        Activity activity = activityService.getActivity(1);
        redisUtils.set("activity_1",activity, 1000);
    }

    @Test
    public void testSetAndGetObject(){
        String key = "activity_1";
        Activity activity = activityService.getActivity(1);
        redisUtils.set(key,activity,1000);
        Activity activity2 = (Activity)redisUtils.get(key);
        System.out.println(activity.toString());
    }

}
