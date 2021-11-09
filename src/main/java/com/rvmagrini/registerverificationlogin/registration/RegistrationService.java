package com.rvmagrini.registerverificationlogin.registration;

import org.springframework.stereotype.Service;

import com.rvmagrini.registerverificationlogin.appuser.AppUser;
import com.rvmagrini.registerverificationlogin.appuser.AppUserRole;
import com.rvmagrini.registerverificationlogin.appuser.AppUserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RegistrationService {
	
	private final AppUserService appUserService;
	private final EmailValidator emailValidator;

	public String register(RegistrationRequest request) {
		boolean isValidEmail = emailValidator.test(request.getEmail());
		
		if (!isValidEmail) {
			throw new IllegalStateException("email not valid");
		}
		
		return appUserService.signUpUser(new AppUser(
				request.getFirstName(),
				request.getLastName(),
				request.getEmail(),
				request.getPassword(),
				AppUserRole.USER));
	}

}
