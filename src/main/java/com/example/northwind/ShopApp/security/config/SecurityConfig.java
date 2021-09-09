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
import org.springframework.security.crypto.password.PasswordEncoder;

import static com.example.northwind.ShopApp.security.ApplicationUserRole.ANY_USER;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    private final PasswordEncoder passwordEncoder;
    private final ApplicationUserService applicationUserService;


    @Autowired
    public SecurityConfig(PasswordEncoder passwordEncoder, ApplicationUserService applicationUserService) {
        this.passwordEncoder = passwordEncoder;
        this.applicationUserService = applicationUserService;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/**").permitAll()
        /*        .antMatchers("/v1/product/**").hasRole(ANY_USER.name())
                .antMatchers("/manager/v1/product/**").hasRole(ANY_USER.name())*/
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }
 /*** IN Memory*/
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

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    /** In My Database*/
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(applicationUserService);
        return provider;
    }
}
