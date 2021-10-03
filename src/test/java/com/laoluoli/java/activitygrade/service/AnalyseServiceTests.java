package com.laoluoli.java.activitygrade.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AnalyseServiceTests {
    @Autowired
    private AnalyseService analyseService;

    @Test
    public void getPlayerFairOrderTest(){
        Integer actid = 512;
        for(int i = 0;i<5;i++){
            System.out.println(analyseService.getPlayerFairOrder(actid));
        }
    }

}
