package com.devcat.LoginRegistration.Loginregistration.registration;

import com.devcat.LoginRegistration.Loginregistration.appuser.AppUser;
import com.devcat.LoginRegistration.Loginregistration.appuser.AppUserRole;
import com.devcat.LoginRegistration.Loginregistration.appuser.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final EmailValidator emailValidator;
    private final AppUserService appUserService;
    public String register(RegistrationRequest request){

        boolean isValidEmail = emailValidator.test(request.getEmail());
        if(!isValidEmail){
            throw new IllegalStateException("email is not valid");
        }
        return appUserService.signUpUser(
                new AppUser(
                        request.getName(),
                        request.getUsername(),
                        request.getEmail(),
                        request.getPassword(),
                        AppUserRole.USER
                )
        );
    }
}
