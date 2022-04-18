package com.example.demo.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class Ram {
@NotNull
	private int id;
@NotBlank(message="entr a username")
	private String username;
@NotBlank(message="enter a contact")
	private String contact;
@NotBlank(message="enter a email")
	private String email;
@Size(min=6, message="enter a 6 digit above")
	private String password;

}
