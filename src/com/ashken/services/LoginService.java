package com.ashken.services;

import java.util.ArrayList;
import java.util.Collection;

//import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import com.ashken.entities.SiteUser;
import com.ashken.jpaRepositories.UserRepository;

@Service("loginService")
public class LoginService implements UserDetailsService{
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	@org.springframework.transaction.annotation.Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		SiteUser user = userRepository.findByUsername(username);
		
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		SimpleGrantedAuthority userAuthority = new SimpleGrantedAuthority("ROLE_USER");
		SimpleGrantedAuthority adminAuthority = new SimpleGrantedAuthority("ROLE_ADMIN");
		User u = null;
		if(user == null) {
			throw new UsernameNotFoundException("No such User: " + username);
		} 
		else
		{

			if (user.getRole().equals("USER"))
				   authorities.add(userAuthority);
			
			else if (user.getRole().equals("ADMIN")) 
			{
				   authorities.add(userAuthority);
				   authorities.add(adminAuthority);
			}
			u = new User(user.getUsername(), user.getPassword(), authorities);
		}
			
		return u;
	}

}
