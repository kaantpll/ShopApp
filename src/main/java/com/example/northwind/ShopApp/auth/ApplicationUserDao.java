package com.example.northwind.ShopApp.auth;

import java.util.Optional;

public interface ApplicationUserDao {
    public Optional<ApplicationUser> selectedApplicationUserByUsername(String username);
}
