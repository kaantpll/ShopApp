package com.example.northwind.ShopApp.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional(readOnly = true)
@Repository
public interface AppUserRepository extends JpaRepository<ApplicationUser,Integer> {
     Optional<ApplicationUser> findByEmail(String email);
}
