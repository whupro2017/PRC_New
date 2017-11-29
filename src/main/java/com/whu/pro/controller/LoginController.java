package com.whu.pro.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/auth")
public class LoginController {
	
	//默认主页和登出
	@RequestMapping(value ="loginPageCtrl" , method= {RequestMethod.GET,RequestMethod.POST })
	public String loginIndex(HttpServletRequest request)
	{
		return "auth/loginPage";
	}
	@ResponseBody
	@RequestMapping(value ="mobileSuccess" , method= {RequestMethod.GET,RequestMethod.POST })
	public String loginMobileSuccess()
	{
		return "ok";
	}
	
	
	@ResponseBody
	@RequestMapping(value ="mobileFail" , method= {RequestMethod.GET,RequestMethod.POST })
	public String loginMobileFail()
	{
		return "error";
	}
	@RequestMapping(value ="loginFailedCtrl" , method= {RequestMethod.GET,RequestMethod.POST })
	public String loginFailed(HttpServletRequest request, Model model)
	{
        model.addAttribute("error", "用户名或密码错误");
		return "auth/loginPage";
	}
}
