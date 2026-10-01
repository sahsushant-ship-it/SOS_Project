package com.sos.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "appUsers")
public class User {
	
	
	private static LocalDateTime $default$createAt() {
		
		return LocalDateTime.now();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	
	
	@Column(nullable = false)
	private String name;
	
	
	@Column(unique = true, nullable = false)
	private String phoneNo;
	
	@Column(unique = true)
	private String email;
	
	@Column(nullable = false)
	private String password;
	
	private String bloodGroup;
	
	private LocalDate dob;
	
	@Builder.Default
	private LocalDateTime createAt = LocalDateTime.now();
	

}
