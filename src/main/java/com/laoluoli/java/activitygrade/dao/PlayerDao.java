package com.laoluoli.java.activitygrade.dao;

import com.laoluoli.java.activitygrade.domain.Player;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerDao {

    //获取活动选手list
    List<Player> findListByActivityid(Integer activityId);

    //添加选手sql
    int save(Player player);

    Player findById(Integer id);

    int update(Player p);

    //评委打分时，对player表同步进行更新
    void updateWithScore(Player p);

    int delete(Integer id);

    //获取某个活动根据Score列进行排序的结果
    List<Player> findListByActivityidOrderScore(Integer activityid);

    //获取某个活动根据fairscore列进行排序的结果
    List<Player> findListByActivityidOrderByFariScore(Integer activityid);


}
