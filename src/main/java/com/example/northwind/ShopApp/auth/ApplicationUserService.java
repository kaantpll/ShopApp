package com.example.northwind.ShopApp.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserService implements UserDetailsService {

    private final AppUserRepository applicationUserDao;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public ApplicationUserService(AppUserRepository applicationUserDao, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.applicationUserDao = applicationUserDao;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return applicationUserDao.findByEmail(email).
                orElseThrow(()->
                        new UsernameNotFoundException(String.format("Username not found !!!")));
    }

    public String signUpUser(ApplicationUser appUser) {
        boolean userExists = applicationUserDao
                .findByEmail(appUser.getEmail())
                .isPresent();

        if (userExists) {
            // TODO check of attributes are the same and
            // TODO if email not confirmed send confirmation email.

            throw new IllegalStateException("email already taken");
        }

        String encodedPassword = bCryptPasswordEncoder.encode(appUser.getPassword());

        appUser.setPassword(encodedPassword);

        applicationUserDao.save(appUser);

        return "it works once sA:Dsdasda";
    }


}
