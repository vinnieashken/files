package com.ashken.controllers;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ashken.entities.SiteUser;
import com.ashken.jpaRepositories.UserRepository;

@Controller
@RequestMapping("/settings")
public class SettingsController {
    
	@Autowired
	UserRepository userepository;
	
	@RequestMapping("/password")
	@ResponseBody
	public void changePassword(Principal principal,HttpServletRequest request)
	{
		String password = request.getParameter("password");
		SiteUser user = userepository.findByUsername( principal.getName());
		
		user.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()).toString());
		userepository.save(user);
	}
}
