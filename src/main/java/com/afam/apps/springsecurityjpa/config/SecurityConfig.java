/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afam.apps.springsecurityjpa.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *
 * @author afam.okonkwo
 */
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
    }
    
    @Override
    public void configure(HttpSecurity http) throws Exception {
        
       http.authorizeRequests()
               .antMatchers("/api/users/admin**").hasRole("ADMIN")
               .antMatchers("/api/users/user**").hasAnyRole("USER", "ADMIN")
               .antMatchers("/api/users").permitAll()
               .and()
               .formLogin();
               
        
    }
}
