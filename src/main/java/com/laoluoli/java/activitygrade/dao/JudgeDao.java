package com.laoluoli.java.activitygrade.dao;

import com.laoluoli.java.activitygrade.domain.Judge;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JudgeDao {

    /**
     * 获取活动的评委列表
     * @param activityid 活动id
     * @return 评委list
     */
    List<Judge> findListByActivityid(Integer activityid);


    /**
     * 获取用户担任过的所有评委
     * @param userid 用户id
     * @return 评委list
     */
    List<Judge> findListByUserid(Integer userid);


    /**
     * 新建评委
     * @param judge 评委实体
     * @return 成功为1，失败为0
     */
    int save(Judge judge);


    /**
     * 根据id获取judge
     * @param judgeid 评委id
     * @return 评委实体
     */
    Judge findById(Integer judgeid);

    //获取指定用户在指定活动得

    /**
     * 获取用户在某活动的评委实体
     * @param userid 用户id
     * @param activityid 活动id
     * @return 用户评委实体
     */
    Judge findByUserandActivity(@Param("userid") Integer userid, @Param("activityid") Integer activityid);
}
