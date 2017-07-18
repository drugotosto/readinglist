/**
 * Created by drugo on 30/06/2017.
 **/

package com.ferrero.config;

import com.ferrero.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDetailsService userDetailsService;

    /*
    Specifies that requests for “/” (which ReadingListController’s methods are mapped to)
    require an authenticated user with the READER role. All other request paths are
    configured for open access to all users.
    It also designates /login as the path for the login page as well as the login
    failure page (along with an error attribute).
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/").access("hasRole('READER')")
                .antMatchers("/**").permitAll()
            .and()

            .formLogin()
                .loginPage("/login")
                .failureUrl("/login?error=true");
    }

    /*
    * To set this up the following method sets a custom user details service.
      This service can be any class that implements "UsersDetailsService" and
      is used to look up user details given a username.
      */
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(new UserDetailsService() {
//            @Override
//            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//                UserDetails userDetails = userRepository.findByUsername(username);
//                if (userDetails != null) {
//                    return userDetails;
//                }
//                throw new UsernameNotFoundException("User '" + username + "' not found.");
//            }
//        });
//    }

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth
                .authenticationProvider(authProvider());
    }

    @Bean
    public DaoAuthenticationProvider authProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        /*
            To use SpitterUserService to authenticate users, you can configure it in your security
            configuration with the "setUserDetailsService()" method.
            The userDetailsService() method (like jdbcAuthentication(), ldapAuthentication, and inMemoryAuthentication())
            configures a configuration store. But instead of using one of Spring’s provided user stores,
            it takes any implementation of "UserDetailsService".
         */
        authProvider.setUserDetailsService(userDetailsService);
        return authProvider;
    }

}
