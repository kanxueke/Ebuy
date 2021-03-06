package com.ebuy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.ebuy.entity.EasybuyUser;
import com.ebuy.service.EasybuyUserService;
import com.ebuy.service.impl.EasybuyUserServiceImpl;

/**
 * 
 * @author linbingyang
 * @version 1.0 2017-10-30
 * 用户控制器
 * 控制用户登陆和用户注册
 *
 */
@WebServlet(urlPatterns={"/User"},name = "User")
public class UserServlet extends HttpServlet {
	private Logger log = Logger.getLogger(UserServlet.class);
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		EasybuyUserService userService = new EasybuyUserServiceImpl();
		String type = req.getParameter("type");
		//判断请求类型
		if(type.equals("regist")){
			//注册功能
			//获取请求值
			String loginName = req.getParameter("loginName");
			String password = req.getParameter("password");
			String email = req.getParameter("email");
			String mobile = req.getParameter("mobile");
			//构建新的EasybuyUser对象
			EasybuyUser user = new EasybuyUser();
			//设置user对象的值
			user.setLoginName(loginName);
			user.setPassword(password);
			user.setEmail(email);
			user.setMobile(mobile);
			
			//判断用户名是否存在
			if(!userService.findUserByLoginName(loginName)){
				//添加数据库
				boolean isRegist = userService.registUser(user);
				if(isRegist){
					//跳转登陆页面
					log.debug(loginName+"注册成功");
					resp.sendRedirect("Login.html");					
				}else{
					log.error(loginName+"注册失败");
					resp.sendRedirect("Regist.html");
				}	
			}
		}else if(type.equals("login")){
			//登陆功能
			//获取请求值
			String loginName = req.getParameter("loginName");
			String password = req.getParameter("password");
			//是否登陆成功
			EasybuyUser user = userService.toLogin(loginName, password);
			
			if(user != null){
				log.debug(loginName+"登陆成功");
				session.setAttribute("user", user);
				resp.sendRedirect("index.jsp");
			}else{
				log.debug("登陆失败");
				resp.sendRedirect("Login.html");
			}
		}
		
		
		
	}
}
