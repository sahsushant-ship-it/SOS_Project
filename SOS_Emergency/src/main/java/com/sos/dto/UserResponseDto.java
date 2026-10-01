package com.sos.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponseDto {
	
	private Integer userId;
	
	private String namel;
	
	private String Phone;
	
	private String email;
	
	private String password;
	
	private LocalDate dob;
	
	private LocalDateTime createdAt;

}
