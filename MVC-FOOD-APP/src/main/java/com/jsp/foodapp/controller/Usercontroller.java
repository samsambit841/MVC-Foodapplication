package com.jsp.foodapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.foodapp.Dao.UserDao;
import com.jsp.foodapp.dto.User;

@Controller
public class Usercontroller {
	@Autowired
	private UserDao userdao;

	@RequestMapping("/adduser")
	public ModelAndView add() {
		ModelAndView mv = new ModelAndView("adduserform");
		mv.addObject("user", new User());
		return mv;
	}

	@RequestMapping("/saveuser")
	public ModelAndView saveuser(@ModelAttribute("user") User user) {
		ModelAndView mv = new ModelAndView("adminoptions");
		userdao.save(user);
		mv.addObject("msg", "user saved successfully");
		return mv;
	}

	@RequestMapping("/validateuser")
	public ModelAndView m2(HttpServletRequest request) {

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		User u1 = userdao.findusernameandpassword(email, password);
		if (u1 != null) {
			ModelAndView m1= new ModelAndView("useroptions");
			HttpSession hs=request.getSession();
			hs.setAttribute("user", u1);
			return m1;
		} else {
			ModelAndView mv = new ModelAndView("loginuserform");
			mv.addObject("msg", "invalid user credentials");
			return mv;
		}

	}
	
	
	
	
	
	
	
}
