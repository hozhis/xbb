package cn.dolphinsoft.glance.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.dolphinsoft.glance.dto.UserInfo;
import cn.dolphinsoft.glance.entity.UserEntity;
import cn.dolphinsoft.glance.repository.UserInfoRepository;
import cn.dolphinsoft.glance.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private UserInfoRepository userinfoRepostiory;

	public UserInfo findUser(Integer id) {
		userinfoRepostiory.findAll();
		UserEntity user = userinfoRepostiory.findOne(id);
		// user = loginRepostiory.findById(id);
		UserInfo userInfo = new UserInfo();
		userInfo.setLoginId(null);
		userInfo.setName(user.getUserName());
		return userInfo;
	}

	// @Override
	// public boolean checkUser(UserInfo user) {
	// // 判断登录用户名和密码是否为空，如果为空，则用户登录校验失败
	// if (StringUtils.isNotBlank(user.getLoginId())
	// && StringUtils.isNotBlank(user.getPassword())) {
	// // 根据用户名从数据库查询数据
	// UserEntity userEntity = loginRepostiory.findByLoginId(user
	// .getLoginId());
	// // 当存在用户的情况下，判断密码是否正确，如果不正确则登录校验失败
	// if (userEntity != null
	// && user.getPassword().equals(userEntity.getPassword())) {
	// return true;
	// }
	// }
	// return false;
	// }
}
