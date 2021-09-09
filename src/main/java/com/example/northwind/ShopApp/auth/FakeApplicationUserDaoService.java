package com.example.northwind.ShopApp.auth;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.example.northwind.ShopApp.security.ApplicationUserRole.ADMIN;
import static com.example.northwind.ShopApp.security.ApplicationUserRole.ANY_USER;


@Repository("fake")
public class FakeApplicationUserDaoService implements ApplicationUserDao {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public FakeApplicationUserDaoService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<ApplicationUser> selectedApplicationUserByUsername(String username) {
        return getApplicationUsers()
                .stream()
                .filter(applicationUser -> username.equals(applicationUser.getUsername()))
                .findFirst();
    }

    private List<ApplicationUser> getApplicationUsers()
    {
        List<ApplicationUser> applicationUsers = Lists.newArrayList(
                new ApplicationUser(
                        ADMIN.getGrantedAuthorities(),
                        passwordEncoder.encode("password"),
                        "kaan",
                        true,
                        true,
                        true,
                        true
                ),
                new ApplicationUser(
                        ANY_USER.getGrantedAuthorities(),
                        passwordEncoder.encode("password123"),
                        "kardelen",
                        true,
                        true,
                        true,
                        true
                )
        );

        return applicationUsers;
    }
}
