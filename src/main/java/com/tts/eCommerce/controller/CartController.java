package com.tts.eCommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/storefront")
public class CartController {
	@GetMapping("/cart")
	public String viewCart (Cart cart) {
		return null;
		
	}
}

@Controller
@RequestMapping ("/storefront")
public class MainController {
	@GetMapping("/")
	public String index(Model model) {
		model.addAllAttributes("cart", new Cart());
		return "storefront/index"
				
	}
}
