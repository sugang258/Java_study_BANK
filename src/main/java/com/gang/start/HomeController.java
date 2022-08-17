package com.gang.start;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.z
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletResponse response) {
		
		
		Cookie cookie = new Cookie("hi", "hello"); 
		cookie.setMaxAge(60);
		response.addCookie(cookie);
		
		return "home";
	}
	
	@Autowired
	private SqlSession sqlSession;
	
	
	
}
