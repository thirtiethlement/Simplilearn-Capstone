package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dao.ProductDao;
import com.model.Product;

@RestController
public class CoreController {

	@Autowired
	private ProductDao productDao;
	
	@RequestMapping(path = "/")
	public ModelAndView landing(HttpSession session)
	{
		ModelAndView mav = new ModelAndView("main");
		return mav;
	}
	
	@RequestMapping(path = "/main")
	public ModelAndView altLanding(HttpSession session)
	{
		ModelAndView mav = new ModelAndView("main");
		return mav;
	}
	
	@RequestMapping(path = "/catalog")
	public ModelAndView catalog(HttpSession session)
	{
		ModelAndView mav = new ModelAndView("catalog");
		List<Product> listing = (List<Product>) productDao.findAll();
		mav.addObject("listing", listing);
		mav.addObject("count", listing.size());
		return mav;
	}
	
	@RequestMapping(path = "/catalog/{id}")
	public ModelAndView productPage(@PathVariable Integer id, HttpSession session)
	{
		ModelAndView mav = new ModelAndView("productView");
		Product p = productDao.findById(id).get();
		mav.addObject("productData", p);
		return mav;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(path = "/addToCart/{id}")
	public ModelAndView productEndpoint(@PathVariable Integer id, HttpSession session)
	{
		ModelAndView mav = new ModelAndView();
		if (session.getAttribute("activeUser") != null)
		{
			if (productDao.existsById(id))
			{
				Product p = productDao.findById(id).get();
				List<Product> cart = (List<Product>) session.getAttribute("cart");
				cart.add(p);
				session.setAttribute("cart", cart);
				session.setAttribute("count", cart.size());
			}
			mav.setViewName("redirect:/catalog");
			return mav;
		}
		else
		{
			mav.setViewName("redirect:/login");
			return mav;
		}
	}
	
	@RequestMapping(path = "/search")
	public ModelAndView search(@RequestParam String term, HttpSession session)
	{
		ModelAndView mav = new ModelAndView("catalog");
		List<Product> listing = productDao.findByProductNameContaining(term);
		mav.addObject("listing", listing);
		mav.addObject("count", listing.size());
		return mav;
	}
}
