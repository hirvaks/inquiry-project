package com.example.Tiim_Scrum_Projekti;

import java.util.ArrayList;
import java.util.List;

import com.example.Tiim_Scrum_Projekti.web.UserDetailServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class LoginAuthentication extends WebSecurityConfigurerAdapter {

    @Autowired
	private UserDetailServiceImpl userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/login", "/questions", "/questions/{id}", "/h2-console/**").permitAll()
                .and()
			    .authorizeRequests().anyRequest().authenticated()
                .and()
                .csrf().ignoringAntMatchers("/h2-console/**")
			    .and()
			    .headers().frameOptions().sameOrigin()
			    .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/admin", true)
                .and()
                .logout()
                .permitAll();

    }

    @Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}
}
