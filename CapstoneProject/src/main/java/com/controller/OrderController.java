package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dao.OrderDao;
import com.model.OrderDetails;
import com.model.Product;
import com.model.UserData;

@RestController
public class OrderController {

	@Autowired
	private OrderDao orderDao;
	
	@SuppressWarnings("unchecked")
	@RequestMapping(path = "/checkout")
	public ModelAndView checkout(HttpSession session)
	{
		ModelAndView mav = new ModelAndView();
		if (session.getAttribute("activeUser") == null)
		{
			mav.setViewName("redirect:/login");
			return mav;
		}
		else if (((List<Product>) session.getAttribute("cart")).size() == 0)
		{
			mav.setViewName("redirect:/catalog");
			return mav;
		}
		else
		{
			mav.setViewName("checkout");
			return mav;
		}
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(path = "/addOrder")
	public ModelAndView addOrder(HttpSession session)
	{
		ModelAndView mav = new ModelAndView();
		if (session.getAttribute("activeUser") == null)
		{
			mav.setViewName("redirect:/login");
			return mav;
		}
		else if (((List<Product>) session.getAttribute("cart")).size() == 0)
		{
			mav.setViewName("redirect:/catalog");
			return mav;
		}
		else
		{
			UserData u = (UserData) session.getAttribute("activeUser");
			List<Product> cart = (List<Product>) session.getAttribute("cart");
			OrderDetails od = new OrderDetails(cart, u, "Submitted");
			orderDao.save(od);
			cart = new ArrayList<Product>();
			session.setAttribute("cart", cart);
			mav.setViewName("orderSuccess");
			return mav;
		}
	}
	
	@RequestMapping(path = "/emptyCart")
	public ModelAndView emptyCart(HttpSession session)
	{
		ModelAndView mav = new ModelAndView("redirect:/catalog");
		List<Product> cart = new ArrayList<Product>();
		session.setAttribute("cart", cart);
		return mav;
	}
	
	@RequestMapping(path = "/checkOrders")
	public ModelAndView checkOrders(HttpSession session)
	{
		ModelAndView mav = new ModelAndView();
		if (session.getAttribute("activeUser") == null)
		{
			mav.setViewName("redirect:/login");
			return mav;
		}
		else
		{
			UserData u = (UserData) session.getAttribute("activeUser");
			List<OrderDetails> orders = orderDao.findByUser_UserId(u.getUserId());
			mav.addObject("orders", orders);
			mav.addObject("count", orders.size());
			mav.setViewName("checkOrders");
			return mav;
		}
	}
}
