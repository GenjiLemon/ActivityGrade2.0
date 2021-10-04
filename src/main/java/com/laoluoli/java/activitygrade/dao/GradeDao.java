package com.laoluoli.java.activitygrade.dao;

import com.laoluoli.java.activitygrade.domain.Grade;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradeDao {

    /**
     * 获取活动的所有打分成绩
     * 一个选手有多个成绩，获取所有选手的所有成绩
     * @param activityId 活动id
     * @return 成绩List
     */
    List<Grade> findListByActivityid(Integer activityId);


    /**
     * 获取选手的所有评委打分
     * @param playerid 选手id
     * @return 选手的得分list
     */
    List<Grade> findListByPlayerid(Integer playerid);


    /**
     * 评委对选手的一次打分记录
     * @param grade 打分实体
     */
    void save(Grade grade);


    /**
     * 根据Id获取打分记录
     * @param id 记录id
     * @return 打分实体
     */
    Grade findById(Integer id);


    /**
     * 更新打分
     * @param grade 新的打分实体
     */
    void update(Grade grade);


    /**
     * 获取一个活动中评委的所有评分
     * @param judgeid 评委id
     * @return 评分记录list
     */
    List<Grade> getListByJudgeid(Integer judgeid);


    /**
     * 获取某评委对某个选手的打分
     * @param judgeid 评委id
     * @param playerid 选手id
     * @return 打分记录实体
     */
    Grade findByJidandPid(@Param("judgeid") Integer judgeid, @Param("playerid") Integer playerid);
}
