/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afam.apps.springsecurityjpa.controllers;

import com.afam.apps.springsecurityjpa.model.User;
import com.afam.apps.springsecurityjpa.repository.UserRepository;
import com.afam.apps.springsecurityjpa.responseDto.UserProfile;
import java.security.Principal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author afam.okonkwo
 */

@Slf4j
@RestController
public class RestResource {
    
    @Autowired
    UserRepository userRepository;
    
    @RequestMapping("/api/users")
    //@PreAuthorize("oauth2.hasAnyScope('read')")
    public String profile_Oauth2() {
        /**
            User user = new User();
            user.setActive(Boolean.TRUE);
            user.setUserName("Afam");
            user.setPassword(NoOpPasswordEncoder.getInstance().encode("pass"));
            user.setRoles("USER");
            userRepository.save(user);
            user = new User();
            user.setActive(Boolean.TRUE);
            user.setUserName("CigaO");
            user.setPassword(NoOpPasswordEncoder.getInstance().encode("pass"));
            user.setRoles("ADMIN");
            userRepository.save(user);
            */
        
        return "Welcome All!!!";
        
    }
    
    @RequestMapping("/api/users/user")
    public ResponseEntity<UserProfile> profile_NormalPrincipal_user(Principal auth) {
        
        
        // Build some data to return for testing
        String email = auth.toString().toLowerCase() + "@gmail.com";
        log.info("Request Made for user " + auth.toString().toLowerCase());
        
        UserProfile profile = new UserProfile();
        profile.setEmail(email);
        profile.setName(auth.toString());
        
        return ResponseEntity.ok(profile);
        
    }
    @RequestMapping("/api/users/admin")
    public ResponseEntity<UserProfile> profile_NormalPrincipal_admin(Principal auth) {
        
        
        // Build some data to return for testing
        String email = auth.toString().toLowerCase() + "@gmail.com";
        log.info("Request Made for user " + auth.toString().toLowerCase());
        
        UserProfile profile = new UserProfile();
        profile.setEmail(email);
        profile.setName(auth.toString());
        
        return ResponseEntity.ok(profile);
        
    }
    
    
}
