package com.ferrero.service;

import com.ferrero.model.User;
import com.ferrero.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by drugo on 06/07/2017.
 */
@Service
public class UserUserDetailsService implements  UserDetailsService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            // Si rilascia allo spitter appena prelevato "l'autorità/ruolo" di SPITTER
            ArrayList<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            authorities.add(new SimpleGrantedAuthority("ROLE_READER"));
            user.setAuthorities(authorities);
            return user;
        }
        throw new UsernameNotFoundException("User '" + username + "' not found.");
    }
}