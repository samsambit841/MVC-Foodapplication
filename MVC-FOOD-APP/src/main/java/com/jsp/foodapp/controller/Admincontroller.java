package com.jsp.foodapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;

import com.jsp.foodapp.Dao.AdminDao;
import com.jsp.foodapp.dto.Admin;

@Controller
public class Admincontroller {

	@Autowired
	AdminDao admindao;
	
	@RequestMapping("/addadmin")
	public ModelAndView m1() {
		ModelAndView mav=new ModelAndView("adminloginform");
		Admin a=new Admin();
		a.setEmail("admin");
		a.setPassword("password");
		
		admindao.saveAdmin(a);
		return mav;
		
	}
	
	@RequestMapping("/validate")
	public ModelAndView m2(HttpServletRequest request) {
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
	Admin a1=	admindao.findByUsernameAndPassword(email, password);
	if(a1!=null) {
		return new ModelAndView("adminoptions");
	}else {
		ModelAndView mv=new ModelAndView("adminloginform");
		mv.addObject("msg","invalid credential");
		return mv;
	}
	}
	
	@RequestMapping("/adminoption")
	public ModelAndView m3(HttpSession session) {
		session.removeAttribute("user");
		session.removeAttribute("foodorder");
		return new ModelAndView ("adminoptions");
		
	}
}
