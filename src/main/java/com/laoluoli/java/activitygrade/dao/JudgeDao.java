package com.laoluoli.java.activitygrade.dao;

import com.laoluoli.java.activitygrade.domain.Judge;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JudgeDao {

    //获取活动得评委list
    List<Judge> findListByActivityid(Integer activityid);

    //获取用户得评委list
    List<Judge> findListByUserid(Integer userid);

    //用户进入新比赛时创建评委
    int save(Judge judge);


    Judge findById(Integer judgeid);

    //获取指定用户在指定活动得个体
    Judge findByUserandActivity(@Param("userid") Integer userid, @Param("activityid") Integer activityid);
}
