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

import com.jsp.foodapp.Dao.Productdao;
import com.jsp.foodapp.dto.FoodOrder;
import com.jsp.foodapp.dto.Item;
import com.jsp.foodapp.dto.Product;

@Controller
public class Itemcontroller {
	@Autowired
	Productdao productdao;

	@RequestMapping("/additem")
	public ModelAndView additem(@RequestParam("id")int id) {
		ModelAndView mv=new ModelAndView("additemform");
		Product p=productdao.find(id);
		Item item=new Item();
		item.setName(p.getName());
		item.setCost(p.getCost());
		mv.addObject("item", item);
		return mv;
		
	}
	@RequestMapping("/saveitem")
	public ModelAndView saveitem(@ModelAttribute("item")Item item,HttpSession session) {
		
		item.setCost(item.getQuantity()*item.getCost());
		FoodOrder order=(FoodOrder)session.getAttribute("foodorder");
		
		List<Item>items=order.getItems();
		if(items!=null) {
			items.add(item);
			order.setItems(items);
			item.setFoodorder(order);
		}else {
			List<Item>items1=new ArrayList<Item>();
			items1.add(item);
			order.setItems(items1);
			item.setFoodorder(order);
		}
		return new ModelAndView("redirect:/viewallproduct");
	}
}
