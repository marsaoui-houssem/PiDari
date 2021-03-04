package com.esprit.dari.security;


import com.esprit.dari.services.UserDetailsServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImp userDetailsServiceImp;
    //springboot n'instanssi pas Bcript par default crre un ben dans l'app
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

//        auth.inMemoryAuthentication()
//                .withUser("admin").password("{noop}admin").roles("ADMIN","USER")
//                .and()
//        .withUser("user").password("{noop}user").roles("USER");
        auth.userDetailsService(userDetailsServiceImp).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();
        //ce formulere generer par spring desactiver le au phase front-end
        http.formLogin();
        http.authorizeRequests().antMatchers(HttpMethod.POST).hasAuthority("ADMIN");
        http.authorizeRequests().anyRequest().authenticated();

    }
}
