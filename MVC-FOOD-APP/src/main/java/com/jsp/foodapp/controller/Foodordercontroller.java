package com.jsp.foodapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.foodapp.Dao.Foodorderdao;
import com.jsp.foodapp.Dao.UserDao;
import com.jsp.foodapp.dto.FoodOrder;
import com.jsp.foodapp.dto.Item;
import com.jsp.foodapp.dto.User;

@Controller
public class Foodordercontroller {
	@Autowired
	Foodorderdao foodorderdao;

	@Autowired
	UserDao userdao;

	@RequestMapping("/viewallfoodorders")
	public ModelAndView m1() {
		ModelAndView mv = new ModelAndView("viewall");
		List<FoodOrder> fod = foodorderdao.viewall();
		mv.addObject("foodorders", fod);
		return mv;

	}

	@RequestMapping("/viewfoodorderuser")
	public ModelAndView m2(@RequestParam("uid") int userId) {
		ModelAndView mv = new ModelAndView("viewfooduser");

		User user = userdao.findUserById(userId);
		List<FoodOrder> userFoodOrders = foodorderdao.findFoodOrdersByUser(user);

		mv.addObject("user", user);
		mv.addObject("userFoodOrders", userFoodOrders);
		return mv;
	}

	@RequestMapping("/addfoodorder")
	public ModelAndView m3() {
		ModelAndView mv = new ModelAndView("addfoodorderform");
		FoodOrder fd = new FoodOrder();
		mv.addObject("foodorder", fd);
		return mv;

	}

	@RequestMapping("/savefoodorder")
	public ModelAndView savefoodorder(@ModelAttribute("foodorder") FoodOrder order, HttpSession session) {
		ModelAndView mv = new ModelAndView("redirect:/viewallproduct");
		session.setAttribute("foodorder", order);
		return mv;

	}

	@RequestMapping("/savefoodorders")
	public ModelAndView savefoodorders(HttpSession session) {
		User user = (User) session.getAttribute("user");
		FoodOrder foodorder = (FoodOrder) session.getAttribute("foodorder");
		List<FoodOrder> order = user.getFoodorder();
		if (order != null) {
			order.add(foodorder);
			double sum = 0;
			List<Item> items = foodorder.getItems();
			for (Item i : items) {
				sum += i.getCost();
			}
			foodorder.setTotalcost(sum);
			user.setFoodorder(order);
			foodorder.setUser(user);
		} else {
			List<FoodOrder> order1 = new ArrayList<FoodOrder>();
			order1.add(foodorder);
			double sum = 0;
			List<Item> items = foodorder.getItems();
			for (Item i : items) {
				sum += i.getCost();
			}
			foodorder.setTotalcost(sum);
			foodorder.setUser(user);
			user.setFoodorder(order1);
		}
		userdao.updateuser(user);
		return new ModelAndView("displaybill");

	}

}
