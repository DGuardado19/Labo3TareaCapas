package com.uca.capas.tareal3.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.tareal3.domain.Product;

@Controller
public class ProductController {
	
	private List<Product> productos = new ArrayList<Product>();
	
	@GetMapping("/compraProducto")
	public ModelAndView compraProducto() {
		ModelAndView mav = new ModelAndView();
		
		productos.add(new Product(0, "LOL", 60));
		productos.add(new Product(1, "MINECRAFT", 20));
		productos.add(new Product(2, "WWZ", 10));
		productos.add(new Product(3, "DIABLO", 8));
		productos.add(new Product(4, "MHW", 20));
		
		mav.setViewName("index");
		mav.addObject("product", new Product());
		mav.addObject("producto", productos);
		return mav;
	}
	
	@PostMapping("/validar")
	@ResponseBody
	public ModelAndView validar(Product product) {
		ModelAndView mav = new ModelAndView();
		if(productos.get(product.getId()).getCantidad() >= product.getCantidad()) {
			mav.setViewName("compra");
			mav.addObject("resultado", "El producto: " + productos.get(product.getId()).getNombre() + "se adquirio.");
			return mav;
		}else
		mav.addObject("resultado", "El producto: "+ productos.get(product.getId()).getNombre() + " no se puede adquirir.");
		mav.setViewName("error");
		return mav;
	}
	
}