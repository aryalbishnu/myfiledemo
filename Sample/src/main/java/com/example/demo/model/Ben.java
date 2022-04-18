package com.example.demo.model;

import java.time.LocalTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
@Data
public class Ben {
	@NotNull
	private int id;
	@NotBlank
	private String username;
	private LocalTime inTime;
	private LocalTime outTime;

}
