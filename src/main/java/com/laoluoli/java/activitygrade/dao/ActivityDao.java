package com.laoluoli.java.activitygrade.dao;

import com.laoluoli.java.activitygrade.domain.Activity;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityDao {
    List<Activity> findAll();

    /**
     * 根据邀请码返回对应个体
     * @param code 邀请码
     * @return
     */
    Activity findByCode(String code);

    /**
     * 根据ID获取活动
     * @param id 活动id
     * @return
     */
    Activity findById(Integer id);

    /**
     * 新增一个活动
     * @param activity
     * @return 1成功，0失败
     */
    int save(Activity activity);

    /**
     * 更新活动
     * @param act 活动实例
     * @return 1成功，0失败
     */
    int update(Activity act);

    /**
     * 根据userid返回活动列表
     * @param userid 用户id
     * @return 活动列表
     */
    List<Activity> findActivityByUserid(Integer userid);

    /**
     * 结束活动
     * @param act 活动实例
     * @return 1结束成功，0结束失败
     */
    int updateWithEndtime(Activity act);
}
