package com.example.demo.controller;

import java.time.LocalTime;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.Ben;

@Controller
public class TimeController {
	@Autowired
	UserMapper userMapper;
	
	@GetMapping("/dotime")
	public String time(Model model) {
		model.addAttribute("ben", new Ben());
		return "Time";
	}
@PostMapping("/intime")
public String intime(@Valid Ben ben, BindingResult result, Model model) {
	if(result.hasErrors()) {
		return "redirect:dotime";
	}
	int resultType = userMapper.timeLoging(ben);
	if(resultType>0) {
		LocalTime a=LocalTime.now();
		ben.setInTime(a);
		userMapper.doInsert(ben);
		model.addAttribute("msg", "出勤しました..........");
		return"Time";
		} else {
			model.addAttribute("ms", "input error..........");
			return"Time";
	}
}
@PostMapping("/outtime")
public String outtime(@Valid Ben ben, BindingResult result, Model model) {
	   if(result.hasErrors()) {
		   
		   return "redirect:dotime";
	   }else {
		  // 
		  
		   LocalTime l =LocalTime.now();
        ben.setOutTime(l);
			if(userMapper.doUpdate(ben)>0) {
				model.addAttribute("msgg", "退勤しました..........");
			}else {
				model.addAttribute("msgg", "input error...........");
			}
		   return "Time";
	   }
}
	}


