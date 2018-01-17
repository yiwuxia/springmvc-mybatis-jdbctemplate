package com.qypt.backstage.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qypt.backstage.entity.peadmin.PeAdmin;
import com.qypt.backstage.service.LoginService;
import com.qypt.backstage.util.Md5Util;

@Controller
public class AdminController {
	
	@Autowired
	private LoginService loginService;


	@RequestMapping("/verification")
	public String verification(PeAdmin admin, HttpServletRequest request) {
		//admin.setAdminPass(Md5Util.getMD5(admin.getAdminPass()));
		try {
			PeAdmin peAdmin = loginService.getPeAdminByUserNameAndPass(admin);
			if (peAdmin != null) {
				request.getSession().setAttribute("user", admin);
				return "redirect:/index";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		request.setAttribute("noUserAndPass", "账号密码错误，请重新输入");
		return "forward:/login";
	}

	@RequestMapping(value = "/login")
	public String login() {
		return "login/login";
	}
	@RequestMapping(value="/index")
	public String index(){
		return "/login/qyptIndex";
	}
	@RequestMapping(value="/over")
	public String over(HttpServletRequest request){
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		return "redirect:/login";
	}
	@RequestMapping("/")
	public String a(){
		return "login/login";
	}
}
