package cn.dolphinsoft.glance.common.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import cn.dolphinsoft.glance.dto.UserInfo;
import cn.dolphinsoft.glance.service.UserInfoService;

public class MyShiro extends AuthorizingRealm {

	@Autowired
	private UserInfoService userInfoService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		UserInfo userInfo = userInfoService.findByLoginId(token.getUsername());
		if (userInfo != null) {
			return new SimpleAuthenticationInfo(userInfo.getLoginId(),
					userInfo.getPassword(), userInfo.getName());
		} else {
			return null;
		}
	}

}
