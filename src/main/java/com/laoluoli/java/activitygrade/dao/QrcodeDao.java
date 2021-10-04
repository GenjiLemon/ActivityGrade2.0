package com.laoluoli.java.activitygrade.dao;

import com.laoluoli.java.activitygrade.domain.Qrcode;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface QrcodeDao {
    Qrcode findByActivityidType(@Param("activityid") Integer activityid, @Param("type") Integer type);

    int Save(Qrcode qrcode);
}
