package com.laoluoli.java.activitygrade.dao;

import com.laoluoli.java.activitygrade.domain.Rule;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RuleDao {
    /**
     * 获取活动规则列表
     * @param activityId 活动id
     * @return 规则列表
     */
    List<Rule> findListByActivityid(Integer activityId);

    /**
     * 新增规则
     * @param rule 规则实体
     * @return 1成功，0失败
     */
    int save(Rule rule);

    /**
     * 根据id获取规则
     * @param id 规则id
     * @return 规则实体
     */
    Rule findById(Integer id);

    /**
     * 更新规则
     * @param rule 规则实体
     * @return 1成功，0失败
     */
    int update(Rule rule);

    /**
     * 删除规则
     * @param id 规则id
     * @return 1成功，0失败
     */
    int delete(Integer id);
}
