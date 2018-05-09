package cn.dolphinsoft.glance.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.dolphinsoft.glance.dto.ResultDto;
import cn.dolphinsoft.glance.dto.UserInfo;
import cn.dolphinsoft.glance.service.LoginService;

@Controller
@RequestMapping(value = "/auth")
public class LoginController {
	private static Logger logger = LoggerFactory
			.getLogger(LoginController.class);

	@Autowired
	private LoginService loginService;

	@RequestMapping(value = "/login")
	public String index(Model model) {
		return "login/login";
	}

	@RequestMapping(value = "/login/authc", method = RequestMethod.POST)
	@ResponseBody
	public ResultDto authc(@RequestBody UserInfo user) {
		UsernamePasswordToken token = new UsernamePasswordToken(
				user.getLoginId(), new Md5Hash(user.getPassword(),
						user.getLoginId()).toHex());
		token.setRememberMe(true);
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(token);
		} catch (UnknownAccountException e) {
			logger.error("登录验证失败，账户不存在");
			return new ResultDto("error", "账户不存在", null);
		} catch (IncorrectCredentialsException e) {
			logger.error("登录验证失败，用户名或密码错误");
			return new ResultDto("error", "用户名或密码错误", null);
		} catch (AuthenticationException e) {
			logger.error("登录验证失败，用户名或密码错误");
			return new ResultDto("error", "用户名或密码错误", null);
		}
		if (subject.isAuthenticated()) {
			return new ResultDto("success", "登录成功", null);
		} else {
			return new ResultDto("error", "登录失败", null);
		}
	}

	@RequestMapping(value = "/test")
	public String test(Model model) {
		loginService.findUser(null);
		return "test/test";
	}

}
