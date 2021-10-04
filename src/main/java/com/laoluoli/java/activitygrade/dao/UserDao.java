package com.laoluoli.java.activitygrade.dao;

import com.laoluoli.java.activitygrade.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

    /**
     * 根据id获取用户
     * @param id 用户id
     * @return 用户实体
     */
    User findById(Integer id);

    /**
     * 新增用户
     * @param user 用户实体
     * @return 1成功，0失败
     */
    int save(User user);

    /**
     * 根据openid获取用户
     * @param openid 微信openid
     * @return 用户实体
     */
    User findByOpenid(String openid);

    /**
     * 更新用户
     * @param user 用户实体
     * @return 1成功，0失败
     */
    int update(User user);
}
