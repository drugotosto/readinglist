package com.ferrero.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by drugo on 16/06/2017.
 */

/*
    implements "UserDetails" makes possible to use a User object to represent a user in Spring Security.
 */
@Entity
public class User implements UserDetails {
    @Id
    private String username;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
    private String email;
    private String password;
    private ArrayList<GrantedAuthority> authorities;

    /*
     Always grant users READER authority.
     In a larger application, the authorities granted to a user might themselves
     be entities and be maintained in a separate database table.
    */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       return  authorities;
    }

    public void setAuthorities(ArrayList<GrantedAuthority> authorities) {
        this.authorities= authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
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
        return true;
    }
}

