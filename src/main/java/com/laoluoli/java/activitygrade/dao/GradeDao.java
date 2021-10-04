package com.laoluoli.java.activitygrade.dao;

import com.laoluoli.java.activitygrade.domain.Grade;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradeDao {
    //获取活动的grade list
    List<Grade> findListByActivityid(Integer activityId);

    //获取选手的得分list
    List<Grade> findListByPlayerid(Integer playerid);

    //打分时进行成绩保存
    void save(Grade grade);


    Grade findById(Integer id);

    //更新打分
    void update(Grade grade);

    //获取评分grade list
    List<Grade> getListByJudgeid(Integer judgeid);

    //获取特定评委对特定选手的打分个体
    Grade findByJidandPid(@Param("judgeid") Integer judgeid, @Param("playerid") Integer playerid);
}
