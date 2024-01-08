package com.jsp.foodapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.foodapp.Dao.Productdao;
import com.jsp.foodapp.dto.Product;

@Controller
public class Productcontroller {

	@Autowired
	Productdao productdao;

	@RequestMapping("/addproduct")
	public ModelAndView m2() {
		ModelAndView m1 = new ModelAndView("addproductform");
		m1.addObject("product", new Product());
		return m1;

	}

	@RequestMapping("/saveproduct")
	public ModelAndView save(@ModelAttribute("product") Product product) {

		ModelAndView mv = new ModelAndView("adminoptions");
		productdao.save(product);
		mv.addObject("msg", "product added successfully");
		return mv;

	}

	@RequestMapping("/viewallproducts")
	public ModelAndView m3() {
		ModelAndView mv = new ModelAndView("allproducts");
		List<Product> productlist = productdao.getall();
		mv.addObject("products", productlist);
		return mv;

	}

	@RequestMapping("/updateproduct")
	public ModelAndView m4(@RequestParam("id") int id) {
		ModelAndView mv = new ModelAndView("updateform");
		System.out.println(id);
		mv.addObject("productinfo", productdao.find(id));
		return mv;
	}

	@RequestMapping("/updateproductof")
	public ModelAndView updateProduct(@ModelAttribute("productinfo") Product updatedProduct) {

		productdao.update(updatedProduct);

		return new ModelAndView("redirect:/viewallproducts");
	}
	@RequestMapping("/deleteproduct")
    public ModelAndView deleteProduct(@RequestParam("id") int id) {
        productdao.delete(id);
        return new ModelAndView("redirect:/viewallproducts");
    }
	@RequestMapping("/viewallproduct")
	public ModelAndView m4() {
		ModelAndView mv = new ModelAndView("displayallproducts");
		List<Product> productlist = productdao.getall();
		mv.addObject("products", productlist);
		return mv;

	}

}
