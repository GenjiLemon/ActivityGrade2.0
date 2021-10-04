package com.laoluoli.java.activitygrade.dao;

import com.laoluoli.java.activitygrade.domain.Player;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PlayerDaoTests {
    @Autowired
    private PlayerDao playerDao;

    @Test
    public void testFindListByActivityid(){
        Integer activityid = 512;
        List<Player> list = playerDao.findListByActivityid(activityid);
        for(Player p : list){
            System.out.println(p);
        }
    }
}
