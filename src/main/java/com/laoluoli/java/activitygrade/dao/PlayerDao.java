package com.laoluoli.java.activitygrade.dao;

import com.laoluoli.java.activitygrade.domain.Player;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerDao {


    /**
     * 获取活动选手列表
     * @param activityId 活动id
     * @return Player列表
     */
    List<Player> findListByActivityid(Integer activityId);


    /**
     * 新增选手
     * @param player 选手实体
     * @return 1成功，0失败
     */
    int save(Player player);

    /**
     * 获取选手
     * @param id 选手id
     * @return 选手实体
     */
    Player findById(Integer id);

    /**
     * 更新选手基本信息
     * @param player 选手实体
     * @return 1成功，0失败
     */
    int update(Player player);


    /**
     * 带成绩更新选手
     * @param player 选手实体（更新成绩）
     */
    void updateWithScore(Player player);

    /**
     * 删除选手
     * @param id 选手id
     * @return 1成功，0失败
     */
    int delete(Integer id);


    /**
     * 获取活动的选手分数排行榜
     * @param activityid 活动id
     * @return 选手列表（成绩倒序）
     */
    List<Player> findListByActivityidOrderScore(Integer activityid);

    /**
     * 获取活动的选手分数排行榜（截尾算法）
     * @param activityid 活动id
     * @return 选手列表（截尾算法成绩倒序）
     */
    List<Player> findListByActivityidOrderByFariScore(Integer activityid);


}
