package com.example.northwind.ShopApp.auth.registration;

import com.example.northwind.ShopApp.auth.AppUserRole;
import com.example.northwind.ShopApp.auth.ApplicationUser;
import com.example.northwind.ShopApp.auth.ApplicationUserService;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    private final ApplicationUserService applicationUserService;
    private final EmailValidator emailValidator;

    public RegistrationService(ApplicationUserService applicationUserService, EmailValidator emailValidator) {
        this.applicationUserService = applicationUserService;
        this.emailValidator = emailValidator;
    }

    public String register(RegistrationRequest request) {
        boolean isValidEmail = emailValidator.
                test(request.getEmail());

        if (!isValidEmail) {
            throw new IllegalStateException("email not valid");
        }

        return applicationUserService.signUpUser(
                new ApplicationUser(
                        request.getUsername(),
                        "",
                        request.getPassword(),
                        AppUserRole.USER,
                        true,
                        true
                )
        );
    }

}
