package cn.dolphinsoft.glance.service;

import cn.dolphinsoft.glance.dto.UserInfo;

public interface UserInfoService {

    UserInfo findByLoginId(String loginId);
}
