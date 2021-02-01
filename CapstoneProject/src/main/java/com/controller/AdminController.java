package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dao.OrderDao;
import com.dao.ProductDao;
import com.dao.UserDao;
import com.model.OrderDetails;
import com.model.Product;
import com.model.UserData;

@RestController
public class AdminController {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private OrderDao orderDao;
	
	@RequestMapping(path = "/admin")
	public ModelAndView admin(HttpSession session)
	{
		ModelAndView mav = new ModelAndView();
		if (session.getAttribute("activeUser") != null)
		{
			if (((UserData) session.getAttribute("activeUser")).getRole().equals("admin"))
			{
				mav.setViewName("adminDash");
			}
			else
			{
				mav.setViewName("redirect:/main");
			}
		}
		else
		{
			mav.setViewName("redirect:/login");
		}
		return mav;
	}
	
	@RequestMapping(path = "/admin/productHub")
	public ModelAndView productHub(HttpSession session)
	{
		ModelAndView mav = new ModelAndView();
		if (session.getAttribute("activeUser") != null)
		{
			if (((UserData) session.getAttribute("activeUser")).getRole().equals("admin"))
			{
				mav.setViewName("productHub");
				List<Product> listing = (List<Product>) productDao.findAll();
				mav.addObject("listing", listing);
				mav.addObject("count", listing.size());
			}
			else
			{
				mav.setViewName("redirect:/main");
			}
		}
		else
		{
			mav.setViewName("redirect:/login");
		}
		return mav;
	}
	
	@RequestMapping(path = "/admin/addProduct")
	public ModelAndView addProduct(HttpSession session)
	{
		ModelAndView mav = new ModelAndView();
		if (session.getAttribute("activeUser") != null)
		{
			if (((UserData) session.getAttribute("activeUser")).getRole().equals("admin"))
			{
				mav.setViewName("addProduct");
			}
			else
			{
				mav.setViewName("redirect:/main");
			}
		}
		else
		{
			mav.setViewName("redirect:/login");
		}
		return mav;
	}
	
	@RequestMapping(path = "/admin/addProductEndpoint")
	public ModelAndView addProductEndpoint(@RequestParam String productName, @RequestParam double cost, @RequestParam String description, @RequestParam String imageRefLink, @RequestParam String genre, HttpSession session)
	{
		ModelAndView mav = new ModelAndView();
		if (session.getAttribute("activeUser") != null)
		{
			if (((UserData) session.getAttribute("activeUser")).getRole().equals("admin"))
			{
				mav.setViewName("redirect:/admin/productHub");
				Product p = new Product(productName, cost, description, imageRefLink, genre);
				productDao.save(p);
			}
			else
			{
				mav.setViewName("redirect:/main");
			}
		}
		else
		{
			mav.setViewName("redirect:/login");
		}
		return mav;
	}
	
	@RequestMapping(path = "/admin/editProduct")
	public ModelAndView editProduct(@RequestParam Integer id, HttpSession session)
	{
		ModelAndView mav = new ModelAndView();
		if (session.getAttribute("activeUser") != null)
		{
			if (((UserData) session.getAttribute("activeUser")).getRole().equals("admin"))
			{
				if (productDao.existsById(id))
				{
					mav.setViewName("editProduct");
					Product p = productDao.findById(id).get();
					mav.addObject("product", p);
				}
				else
				{
					mav.setViewName("redirect:/admin/productHub");
				}
			}
			else
			{
				mav.setViewName("redirect:/main");
			}
		}
		else
		{
			mav.setViewName("redirect:/login");
		}
		return mav;
	}
	
	@RequestMapping(path = "/admin/editProductEndpoint")
	public ModelAndView editProductEndpoint(@RequestParam Integer id, @RequestParam String productName, @RequestParam double cost, @RequestParam String description, @RequestParam String imageRefLink, @RequestParam String genre, HttpSession session)
	{
		ModelAndView mav = new ModelAndView();
		if (session.getAttribute("activeUser") != null)
		{
			if (((UserData) session.getAttribute("activeUser")).getRole().equals("admin"))
			{
				mav.setViewName("redirect:/admin/productHub");
				Product p = productDao.findById(id).get();
				p.setProductName(productName);
				p.setCost(cost);
				p.setDescription(description);
				p.setImageRefLink(imageRefLink);
				p.setGenre(genre);
				productDao.save(p);
			}
			else
			{
				mav.setViewName("redirect:/main");
			}
		}
		else
		{
			mav.setViewName("redirect:/login");
		}
		return mav;
	}
	
	@RequestMapping(path = "/admin/deleteProduct")
	public ModelAndView deleteProduct(@RequestParam Integer id, HttpSession session)
	{
		ModelAndView mav = new ModelAndView();
		if (session.getAttribute("activeUser") != null)
		{
			if (((UserData) session.getAttribute("activeUser")).getRole().equals("admin"))
			{
				mav.setViewName("redirect:/admin/productHub");
				productDao.deleteById(id);
			}
			else
			{
				mav.setViewName("redirect:/main");
			}
		}
		else
		{
			mav.setViewName("redirect:/login");
		}
		return mav;
	}
	
	@RequestMapping(path = "/admin/userHub")
	public ModelAndView userHub(HttpSession session)
	{
		ModelAndView mav = new ModelAndView();
		if (session.getAttribute("activeUser") != null)
		{
			if (((UserData) session.getAttribute("activeUser")).getRole().equals("admin"))
			{
				mav.setViewName("userHub");
				List<UserData> listing = (List<UserData>) userDao.findAll();
				mav.addObject("listing", listing);
			}
			else
			{
				mav.setViewName("redirect:/main");
			}
		}
		else
		{
			mav.setViewName("redirect:/login");
		}
		return mav;
	}
	
	@RequestMapping(path = "/admin/editUser")
	public ModelAndView editUser(@RequestParam Integer id, HttpSession session)
	{
		ModelAndView mav = new ModelAndView();
		if (session.getAttribute("activeUser") != null)
		{
			if (((UserData) session.getAttribute("activeUser")).getRole().equals("admin"))
			{
				if (userDao.existsById(id))
				{
					mav.setViewName("editUser");
					UserData u = userDao.findById(id).get();
					mav.addObject("user", u);
				}
				else
				{
					mav.setViewName("redirect:/admin/userHub");
				}
			}
			else
			{
				mav.setViewName("redirect:/main");
			}
		}
		else
		{
			mav.setViewName("redirect:/login");
		}
		return mav;
	}
	
	@RequestMapping(path = "/admin/editUserEndpoint")
	public ModelAndView editUserEndpoint(@RequestParam Integer id, @RequestParam String username, @RequestParam String password, @RequestParam String emailAddress, @RequestParam String billingAddress, HttpSession session)
	{
		ModelAndView mav = new ModelAndView();
		if (session.getAttribute("activeUser") != null)
		{
			if (((UserData) session.getAttribute("activeUser")).getRole().equals("admin"))
			{
				mav.setViewName("redirect:/admin/userHub");
				UserData u = userDao.findById(id).get();
				u.setUsername(username);
				u.setPassword(password);
				u.setEmailAddress(emailAddress);
				u.setBillingAddress(billingAddress);
				userDao.save(u);
			}
			else
			{
				mav.setViewName("redirect:/main");
			}
		}
		else
		{
			mav.setViewName("redirect:/login");
		}
		return mav;
	}
	
	@RequestMapping(path = "/admin/deleteUser")
	public ModelAndView deleteUser(@RequestParam Integer id, HttpSession session)
	{
		ModelAndView mav = new ModelAndView();
		if (session.getAttribute("activeUser") != null)
		{
			if (((UserData) session.getAttribute("activeUser")).getRole().equals("admin"))
			{
				mav.setViewName("redirect:/admin/userHub");
				UserData u = userDao.findById(id).get();
				UserData current = (UserData) session.getAttribute("activeUser");
				if (!(u.getUsername().equals(current.getUsername())))
				{
					userDao.deleteById(id);
				}
			}
			else
			{
				mav.setViewName("redirect:/main");
			}
		}
		else
		{
			mav.setViewName("redirect:/login");
		}
		return mav;
	}
	
	@RequestMapping(path = "/admin/orderHub")
	public ModelAndView orderHub(HttpSession session)
	{
		ModelAndView mav = new ModelAndView();
		if (session.getAttribute("activeUser") != null)
		{
			if (((UserData) session.getAttribute("activeUser")).getRole().equals("admin"))
			{
				mav.setViewName("orderHub");
				List<OrderDetails> listing = (List<OrderDetails>) orderDao.findAll();
				mav.addObject("listing", listing);
				mav.addObject("count", listing.size());
			}
			else
			{
				mav.setViewName("redirect:/main");
			}
		}
		else
		{
			mav.setViewName("redirect:/login");
		}
		return mav;
	}
	
	@RequestMapping(path = "/admin/editOrder")
	public ModelAndView editOrder(@RequestParam Integer id, HttpSession session)
	{
		ModelAndView mav = new ModelAndView();
		if (session.getAttribute("activeUser") != null)
		{
			if (((UserData) session.getAttribute("activeUser")).getRole().equals("admin"))
			{
				mav.setViewName("editOrder");
				OrderDetails order = orderDao.findById(id).get();
				mav.addObject("order", order);
			}
			else
			{
				mav.setViewName("redirect:/main");
			}
		}
		else
		{
			mav.setViewName("redirect:/login");
		}
		return mav;
	}
	
	@RequestMapping(path = "/admin/editOrderEndpoint")
	public ModelAndView editOrderEndpoint(@RequestParam Integer id, @RequestParam String status, HttpSession session)
	{
		ModelAndView mav = new ModelAndView();
		if (session.getAttribute("activeUser") != null)
		{
			if (((UserData) session.getAttribute("activeUser")).getRole().equals("admin"))
			{
				mav.setViewName("redirect:/admin/orderHub");
				OrderDetails order = orderDao.findById(id).get();
				order.setStatus(status);
				orderDao.save(order);
			}
			else
			{
				mav.setViewName("redirect:/main");
			}
		}
		else
		{
			mav.setViewName("redirect:/login");
		}
		return mav;
	}
	
	@RequestMapping(path = "/admin/deleteOrder")
	public ModelAndView deleteOrder(@RequestParam Integer id, HttpSession session)
	{
		ModelAndView mav = new ModelAndView();
		if (session.getAttribute("activeUser") != null)
		{
			if (((UserData) session.getAttribute("activeUser")).getRole().equals("admin"))
			{
				mav.setViewName("redirect:/admin/orderHub");
				orderDao.deleteById(id);
			}
			else
			{
				mav.setViewName("redirect:/main");
			}
		}
		else
		{
			mav.setViewName("redirect:/login");
		}
		return mav;
	}
}
