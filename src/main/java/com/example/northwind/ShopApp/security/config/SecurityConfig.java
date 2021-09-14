package com.example.northwind.ShopApp.security.config;

import com.example.northwind.ShopApp.auth.ApplicationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    private final BCryptPasswordEncoder passwordEncoder;
    private final ApplicationUserService applicationUserService;

    public SecurityConfig(BCryptPasswordEncoder passwordEncoder, ApplicationUserService applicationUserService) {
        this.passwordEncoder = passwordEncoder;
        this.applicationUserService = applicationUserService;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/**").permitAll()
                //.antMatchers("/v1/api/registration").permitAll()
                .anyRequest()
                .authenticated().and()
                .formLogin().disable();


    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }


    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(applicationUserService);
        return provider;
    }



/*
    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails kaan = User.builder()
                .username("kaan")
                .password(passwordEncoder.encode("password"))
                .roles(ADMIN.name())
                .build();

        UserDetails kardelen = User.builder()
                .username("kardelen")
                .password(passwordEncoder.encode("password123"))
                .roles(ANY_USER.name())
                .build();

        return new InMemoryUserDetailsManager(
                kaan,
                kardelen
        );
    }*/



}
