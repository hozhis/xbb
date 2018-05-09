package cn.dolphinsoft.glance.service;

import cn.dolphinsoft.glance.dto.UserInfo;

public interface LoginService {

	UserInfo findUser(Integer id);

	// boolean checkUser(UserInfo user);
}
