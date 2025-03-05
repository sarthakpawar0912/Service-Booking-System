package com.srp.ServiceBookingSystem.services.authentication;

import com.srp.ServiceBookingSystem.dto.SignupRequestDTO;
import com.srp.ServiceBookingSystem.dto.UserDto;

public interface AuthService {

	UserDto signupClient( SignupRequestDTO signupRequestDTO);

	Boolean presentByEmail(String email);

	 UserDto signupCompany( SignupRequestDTO signupRequestDTO) ;
}
