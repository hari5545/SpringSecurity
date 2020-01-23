package srit.rhes.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import srit.rhes.security.services.CustomUserService;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true )
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private CustomUserService userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// in memory authentication
		/*
		 auth .inMemoryAuthentication() .withUser("rohit") .password("{noop}rohit").roles("ADMIN");
		 */

		// Authentication by using db

		
		  auth 
		  .userDetailsService(userDetailsService)
		  .passwordEncoder(passwordEncoder());
	}


	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf()
		.disable();

		http
		.authorizeRequests()
		.antMatchers("/auth/**")
		.authenticated()
		.anyRequest()
		.permitAll()
		.and()
		.formLogin()
		.permitAll();
		
		/*
		 * .loginPage("/loginpage") .successForwardUrl("/home")
		 * .failureForwardUrl("/failure") .usernameParameter("username")
		 * .passwordParameter("password") .and() .logout() .logoutSuccessUrl("/logout")
		 */
	} 
	private PasswordEncoder passwordEncoder() {
		return new PasswordEncoder() {
			@Override
			public String encode(CharSequence charSequence) {
				return charSequence.toString();
			}
			@Override
			public boolean matches(CharSequence charSequence, String s) {
				return true;
			}
		};
	}
}
