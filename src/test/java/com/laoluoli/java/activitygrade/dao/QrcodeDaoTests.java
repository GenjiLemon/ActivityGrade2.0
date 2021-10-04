package com.laoluoli.java.activitygrade.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class QrcodeDaoTests {
    @Autowired
    private QrcodeDao qrcodeDao;

    @Test
    public void testFindByActivityidType(){
        Integer activityid = 416;
        for(int i = 1;i<=3;i++){
            System.out.println(qrcodeDao.findByActivityidType(activityid,i).getUrl());
        }
    }
}
