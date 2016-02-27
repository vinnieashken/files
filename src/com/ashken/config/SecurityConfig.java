package com.ashken.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
@ComponentScan("com.ashken.*")
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	

	@Autowired
	@Qualifier("loginService")
	private UserDetailsService loginService;
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .csrf().disable()
            .authorizeRequests()
                .antMatchers("/","/register/**","/doRegister").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/")
                .usernameParameter("username")
        		.passwordParameter("password")
                .defaultSuccessUrl("/home")
                .failureUrl("/?error=1")
                .permitAll()
                .and()
            .logout()
            	.deleteCookies("JSESSIONID")
            	.logoutUrl("/logout")
            	.logoutSuccessUrl("/?logout=1")
                .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        /*auth
            .inMemoryAuthentication()
                .withUser("user").password("password").roles("ghffh");*/
        Md5PasswordEncoder encoder = new Md5PasswordEncoder();
        //UserDetails u = loginService.loadUserByUsername("tony");
		//System.out.println(u.getUsername());
    	auth.userDetailsService(loginService).passwordEncoder(encoder);
    }
    
    @Override
    public void configure(WebSecurity web) throws Exception {
    
    	        web
    	          .ignoring()
    	             .antMatchers("/resources/**");
    
    }
    
      
}