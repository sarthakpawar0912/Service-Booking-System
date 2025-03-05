package com.srp.ServiceBookingSystem.entity;

import com.srp.ServiceBookingSystem.dto.UserDto;
import com.srp.ServiceBookingSystem.enums.UserRole;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="users")
@Data
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true)
	private String email;

	@Column(nullable = false)
	private String password;


	private String name;

	private String lastname;

	private String phone;


	@Enumerated(EnumType.STRING) // ✅ Ensure Enum is stored as STRING
	@Column(nullable = false)
	private UserRole role;


	public UserDto getDto() {
		UserDto userDto= new UserDto();
		userDto.setId(id);
		userDto.setName(name);
		userDto.setEmail(email);
		userDto.setRole(role);

		return userDto;

	}
}
