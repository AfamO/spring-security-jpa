/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.afam.apps.springsecurityjpa.model;

import com.afam.apps.springsecurityjpa.model.User;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author HP
 */
public class MyUserDetails implements UserDetails {
    
    private Boolean active;
    private String password;
    private List<GrantedAuthority> authorities;
    private String userName;
    
    private User user;
    
    public MyUserDetails(String username) {
        
    }
    
    public MyUserDetails(User user) {
        this.userName = user.getUserName();
        this.password = user.getPassword();
        this.active = user.getActive();
        this.authorities = Arrays.stream(user.getRoles().split(","))
                            .map(SimpleGrantedAuthority::new)
                            .collect(Collectors.toList());
                        
        
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
       return this.userName; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }
    
}
