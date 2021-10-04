package com.laoluoli.java.activitygrade.dao;

import com.laoluoli.java.activitygrade.domain.Qrcode;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface QrcodeDao {
    /**
     * 获取某个活动的qrcode实体
     * @param activityid 活动id
     * @param type 二维码类型：1评委邀请二维码，2正常均值二维码，3截尾均值二维码
     * @return Qrcode实体
     */
    Qrcode findByActivityidType(@Param("activityid") Integer activityid, @Param("type") Integer type);

    /**
     * 新增一个二维码
     * @param qrcode 二维码对象实体
     * @return 1成功，0失败
     */
    int Save(Qrcode qrcode);
}
