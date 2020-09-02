package com.example.demo.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.demo.Service.MyUserDetailsService;



@Configuration
@EnableWebSecurity
public class AllConfig extends WebSecurityConfigurerAdapter {


	@Autowired
	MyUserDetailsService myuserDetailsService;
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authProvider());
	}

	@Bean
	public static BCryptPasswordEncoder passwordEncoder() {

		return new BCryptPasswordEncoder(4);
	}

	@Bean
	public AuthenticationProvider authProvider() {

		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();

		provider.setUserDetailsService(myuserDetailsService);

		provider.setPasswordEncoder(passwordEncoder());
		return provider;
	}

	@Bean
	public static AuthenticationFailureHandler customAuthenticationFailureHandler() {
		return new CustomAuthenticationFailureHandler();
	}
	

	@Configuration
	@Order(1)
	public static class AdminSecurityConfig extends WebSecurityConfigurerAdapter {
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.requestMatcher(new AntPathRequestMatcher("/Admin/**"))
			.csrf().disable()
			.authorizeRequests()
			.antMatchers("/Admin/**").hasAnyRole("ADMIN")
			.and()
			.formLogin()
			.loginPage("/Admin/adminlogin").permitAll()
			.usernameParameter("username")
			.passwordParameter("password")
			.defaultSuccessUrl("/Admin/AdminDashBoard")
			.and()
			.logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/Admin/logout"))
			.logoutSuccessUrl("/Admin/logoutpage")
			.invalidateHttpSession(true)
			.and()
			.exceptionHandling().accessDeniedPage("/Admin/access-denied");
		}
	}

	@Configuration
	@Order(2)
	public static class UserSecurityConfig extends WebSecurityConfigurerAdapter {
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.requestMatcher(new AntPathRequestMatcher("/**"))
			.csrf().disable()
			.authorizeRequests()
			.antMatchers("/myaccount").hasAnyRole("USER","ADMIN")
			.antMatchers("/about").permitAll()
			.and()
			.formLogin()
			.loginPage("/login").permitAll()
			.usernameParameter("username")
			.passwordParameter("password")
			.defaultSuccessUrl("/")
			.and()
			.logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutSuccessUrl("/logoutpage")
			.invalidateHttpSession(true)
			.and()
			.exceptionHandling().accessDeniedPage("/access-denied");
		}

	}
	
	
}
