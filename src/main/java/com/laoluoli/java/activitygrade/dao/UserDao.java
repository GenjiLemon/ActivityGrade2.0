package com.laoluoli.java.activitygrade.dao;

import com.laoluoli.java.activitygrade.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    //常见的增删改查
    User findById(Integer id);

    int save(User user);

    User findByOpenid(String openid);

    int update(User user);
}
