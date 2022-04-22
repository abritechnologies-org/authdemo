package com.abritech.demoauth.security;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers(HttpMethod.GET,"/restaurant/welcome")
                .hasAuthority("SCOPE_profile")
                .antMatchers(HttpMethod.GET,"/restaurant/token")
                .hasAuthority("SCOPE_phone")
                .anyRequest()
                .authenticated()
                .and()
                .oauth2ResourceServer()
                .jwt();

    }
}
