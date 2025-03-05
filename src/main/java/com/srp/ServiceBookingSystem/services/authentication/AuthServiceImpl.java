package com.srp.ServiceBookingSystem.services.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.srp.ServiceBookingSystem.dto.SignupRequestDTO;
import com.srp.ServiceBookingSystem.dto.UserDto;
import com.srp.ServiceBookingSystem.entity.User;
import com.srp.ServiceBookingSystem.enums.UserRole;
import com.srp.ServiceBookingSystem.repository.UserRepository;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UserDto signupClient(SignupRequestDTO signupRequestDTO) {
		User user = new User();
		user.setName(signupRequestDTO.getName());
		user.setLastname(signupRequestDTO.getLastname());
		user.setEmail(signupRequestDTO.getEmail());
		user.setPhone(signupRequestDTO.getPhone());
		user.setPassword(passwordEncoder.encode(signupRequestDTO.getPassword()));
		user.setRole(UserRole.CLIENT); // Ensure role is set correctly

		// Debugging: Print the role value
		System.out.println("Role being set for client: " + user.getRole());

		return userRepository.save(user).getDto();
	}

	@Override
	public UserDto signupCompany(SignupRequestDTO signupRequestDTO) {
		User user = new User();
		user.setName(signupRequestDTO.getName());
		user.setEmail(signupRequestDTO.getEmail());
		user.setPhone(signupRequestDTO.getPhone());
		user.setPassword(passwordEncoder.encode(signupRequestDTO.getPassword()));
		user.setRole(UserRole.COMPANY);


		System.out.println("Role being set for company: " + user.getRole());

		return userRepository.save(user).getDto();
	}


	@Override
	public Boolean presentByEmail(String email) {
		return userRepository.findFirstByEmail(email) != null;
	}
}
