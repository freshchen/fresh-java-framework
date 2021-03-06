package com.example.springcloudsecurityauth;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author darcy
 * @since 2020/06/16
 **/
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    /**
     * 改登陆页
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests().antMatchers("/login").permitAll().anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").successForwardUrl("/home").permitAll()
                .and()
                .logout()
                .permitAll()
                .and()
                .sessionManagement()
                .maximumSessions(1);
    }
}
