package com.laoluoli.java.activitygrade.dao;

import com.laoluoli.java.activitygrade.domain.Rule;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RuleDao {
    List<Rule> findListByActivityid(Integer activityId);

    int save(Rule rule);

    Rule findById(Integer id);

    int update(Rule r);

    int delete(Integer id);
}
