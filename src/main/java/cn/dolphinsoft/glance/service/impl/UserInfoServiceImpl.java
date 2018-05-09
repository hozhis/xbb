package cn.dolphinsoft.glance.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.dolphinsoft.glance.dto.UserInfo;
import cn.dolphinsoft.glance.entity.UserEntity;
import cn.dolphinsoft.glance.repository.UserInfoRepository;
import cn.dolphinsoft.glance.service.UserInfoService;

@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	private UserInfoRepository userInfoRepository;

	@Override
	public UserInfo findByLoginId(String loginId) {
		UserEntity entity = userInfoRepository.findByLoginId(loginId);
		UserInfo userInfo = new UserInfo();
		userInfo.setLoginId(entity.getLoginId());
		userInfo.setPassword(entity.getPassword());
		userInfo.setName(entity.getUserName());
		userInfo.setUserId(entity.getUserId());
		userInfo.setToken(String.valueOf(System.currentTimeMillis()));
		return userInfo;
	}
}
