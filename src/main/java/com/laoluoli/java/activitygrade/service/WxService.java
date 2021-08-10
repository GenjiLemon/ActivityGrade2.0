package com.laoluoli.java.activitygrade.service;

import com.laoluoli.java.activitygrade.domain.UserLoginRes;

import java.io.IOException;

public interface WxService {

    String getAccessToken() throws IOException;

    UserLoginRes code2Session(String code) throws IOException;
}
