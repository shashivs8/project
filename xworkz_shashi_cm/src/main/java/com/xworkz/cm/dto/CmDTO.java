package com.xworkz.cm.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class CmDTO {
	
	private int id;
	
	@NotNull(message = "userId should be not be null")
	@Size(max = 30,min = 4, message = "size must be grether than 4 less than 30")
	private String userId;
	@NotNull(message = "email should be not be null")
	@Size(max = 30,min = 4, message = "size must be grether than 4 less than 30")
	private String email;

	private Long mobile;
	@NotNull(message = "password should be not be null")
	@Size(max = 30,min = 4, message = "size must be grether than 4 less than 30")
	private String password;
	
	@NotNull(message = "password should be same")
	private String confirmPassword;

}
