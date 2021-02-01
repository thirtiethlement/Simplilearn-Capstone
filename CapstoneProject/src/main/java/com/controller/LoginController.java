package com.controller;

import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dao.UserDao;
import com.model.UserData;
import com.model.Product;

@RestController
public class LoginController {

	@Autowired
	private UserDao userDao;
	
	@RequestMapping(path = "/login")
	public ModelAndView loginLanding(HttpSession session)
	{
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}
	
	@RequestMapping(path = "/register")
	public ModelAndView registration(@RequestParam String username, @RequestParam String password, @RequestParam String emailAddress, @RequestParam String streetAddress, HttpSession session)
	{
		ModelAndView mav = new ModelAndView("login");
		if (!userDao.existsByUsername(username))
		{
			UserData u = new UserData("customer", username, password, emailAddress, streetAddress);
			userDao.save(u);
			mav.addObject("registerToken", username);
			return mav;
		}
		else
		{
			mav.addObject("registerFailToken", username);
			return mav;
		}
	}
	
	@RequestMapping(path = "/loginEndpoint")
	public ModelAndView login(@RequestParam String username, @RequestParam String password, HttpSession session)
	{
		ModelAndView mav = new ModelAndView();
		if (userDao.existsByUsername(username))
		{
			UserData u = userDao.findByUsername(username);
			if (u.getPassword().equals(password))
			{
				List<Product> cart = new ArrayList<Product>();
				session.setAttribute("activeUser", u);
				session.setAttribute("cart", cart);
				session.setAttribute("count", 0);
				mav.setViewName("redirect:/");
				return mav;
			}
			else
			{
				mav.setViewName("login");
				mav.addObject("loginFailedToken", "Password does not match");
				return mav;
			}
		}
		else
		{
			mav.setViewName("login");
			mav.addObject("loginFailedToken", "No user exists under that name");
			return mav;
		}
	}
	
	@RequestMapping(path = "/logout")
	public ModelAndView logout(HttpSession session)
	{
		ModelAndView mav = new ModelAndView("main");
		if (session.getAttribute("activeUser") != null)
		{
			session.invalidate();
		}
		return mav;
	}
}
