package com.ashken.controllers;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ashken.entities.SiteUser;
import com.ashken.jpaRepositories.UserRepository;


@Controller
public class AuthenticationController {
	
	
	
	@Autowired
	UserRepository userepo;
	
	@Autowired
	@Qualifier("loginService")
	UserDetailsService loginService;
	
	@RequestMapping("/")
	public String getLoginPage()
	{
		return "login";
	}
	
	@RequestMapping("/?error=1")
	public String getLoginErrorPage()
	{
		return "login";
	}
	
	@RequestMapping("/?logout=1")
	public String getLogoutPage()
	{
		return "login";
	}
	
	@RequestMapping("/?registered=1")
	public String getRegistrationSuccessPage()
	{
		return "login";
	}
	
	@RequestMapping("/userlist")
	public ModelAndView getUserList()
	{
		//UserDetails u = loginService.loadUserByUsername("tony");
		//System.out.println(u.getPassword());
		
		ModelAndView model = new ModelAndView("userlist");
		model.addObject("userlist", userepo.findAll());
		model.addObject("specific", userepo.findByUsername("tony"));
		return model;
	}
	
	
	
	@RequestMapping("/home")
	public String getHomePage()
	{
		return "upload";
	}
	
	@RequestMapping("/register")
	public String getRegisterPage()
	{
		//ModelAndView model = new ModelAndView("register");
    	return "register";
	}
	
	@RequestMapping("/doRegister")
	public ModelAndView RegisterUser(HttpServletRequest request)
    {
        
    	SiteUser siteUser = new SiteUser();
    	siteUser.setUsername(request.getParameter("username"));
    	siteUser.setEmail(request.getParameter("email"));
    	siteUser.setPassword(DigestUtils.md5DigestAsHex(request.getParameter("password").getBytes()).toString());
    	siteUser.setRole("USER");
    	
    	SiteUser old = userepo.findByUsername(request.getParameter("username"));
    	SiteUser old2 = userepo.findByEmail(request.getParameter("email"));
    	if(old == null && old2 == null)
    		userepo.save(siteUser);
    	return new ModelAndView("redirect:/?registered=1");
    }
	
	@RequestMapping("/settingspage")
	public String getSettingsPage()
	{
		return "settings";
	}
	
	@RequestMapping("/register/check/username")
	@ResponseBody
	public String checkUsername(HttpServletRequest request)
	{

		String username = request.getParameter("username");
		SiteUser user = userepo.findByUsername(username);
		if(user != null)
			return null;
		
		return "true";
	}
	
	@RequestMapping("/register/check/email")
	@ResponseBody
	public String checkEmail(HttpServletRequest request)
	{
		String email = request.getParameter("email");
		SiteUser user = userepo.findByEmail(email);
		if(user != null)
			return null;
		
		return "true";
	}

}
