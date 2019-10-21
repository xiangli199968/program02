package com.dzkj.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dzkj.pojo.users;
import com.dzkj.service.IUsersDao;
import com.dzkj.smsutil.SendSmsUtil;

@Controller
@RequestMapping("/home")
public class controller {
	@Autowired
	private IUsersDao dao;
	
	//String codestr = "987654";
	@RequestMapping("/phonecode")
	@ResponseBody
	public String code(String phone) {
		String codestr = SendSmsUtil.sendCheckMSM(phone);
		
//		System.out.println(codestr);
		return codestr;
	}
	@RequestMapping("/phonezc")
	public String phonezc(String phone,String password) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String time = sdf.format(date);
		users u = new users();
		u.setPwd(password);
		u.setTellphone(phone);
		u.setTime(time);
		dao.add(u);
		return "redirect:/home/login.jsp";
	}
	@RequestMapping("/emailzc")
	public String emailzc(String email,String password) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String time = sdf.format(date);
		users u = new users();
		u.setPwd(password);
		u.setEmail(email);
		u.setTime(time);
		dao.add(u);
		return "redirect:/home/login.jsp";
	}
	@RequestMapping("/login")
	public String login(String username,String password,HttpServletRequest req) {
		users us = new users();
		us.setPwd(password);
		String reg = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
		String reg1 = "^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9]|17[0-9]|16[0-9])\\d{8}$";
		Pattern pattern = Pattern.compile(reg);
		Pattern pattern1 = Pattern.compile(reg1);
		if(pattern.matcher(username).matches()==true) {
			us.setEmail(username);
		}else if(pattern1.matcher(username).matches()==true) {
			us.setTellphone(username);
		}else {
			us.setUname(username);
		}
		users u = dao.login(us);
		if(u!=null) {
			req.getSession().setAttribute("user", u);
			return "home";
		}else {
			return "redirect:/home/login.jsp";
		}
	}
}
