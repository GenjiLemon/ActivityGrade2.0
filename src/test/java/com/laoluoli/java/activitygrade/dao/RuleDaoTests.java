package com.laoluoli.java.activitygrade.dao;

import com.laoluoli.java.activitygrade.domain.Rule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class RuleDaoTests {
    @Autowired
    private RuleDao ruleDao;

    @Test
    public void testFindListByActivityid(){
        Integer activityid=416;
        List<Rule> list = ruleDao.findListByActivityid(activityid);
        for(Rule r : list){
            System.out.println(r);
        }
    }
}
