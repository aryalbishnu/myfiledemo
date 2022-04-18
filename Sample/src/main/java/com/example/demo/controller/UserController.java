package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Combine;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.Ram;

@Controller
public class UserController {
	@Autowired
	
	UserMapper userMapper;
	@GetMapping("/try")
	public String formuser(Model model) {
		model.addAttribute("ram", new Ram());
		
		return"form";
	}


	@PostMapping("/process")
	//public String formas(@ModelAttribute Ram ram , Model model) {
		public String checkPersonInfo(@Valid Ram ram, BindingResult bindingResult) {
		       
			if (bindingResult.hasErrors()) {
				return "form";
			}
		userMapper.doinsert(ram);
		return"loging";
}
	@PostMapping("/hello")
	public String logingform(@ModelAttribute Ram ram, Model model) {
		int result=userMapper.doLoging(ram);
		if(result>0) {
			List<Combine>userlist =userMapper.doSelect(ram);
			model.addAttribute("userlist", userlist);
			return"result";
		}else {
			model.addAttribute("msg", "Please enter a correct email & password");
		return"loging";
	}
	}
		
	@PostMapping("/edit")
	public String doedit(@ModelAttribute Ram ram , Model model) {
		//userMapper.doinsert(ram);
		return"edit";
}
	@PostMapping("/doedit")
	//public String editUser(@ModelAttribute Ram ram, Model model) {
		public String edituser(@Valid Ram ram, BindingResult bindingResult , Model model) {
		       
			if (bindingResult.hasErrors()) {
				return "edit";
			}
		userMapper.editUser(ram);

		List<Combine> userlist = userMapper.doSelect(ram);

		model.addAttribute("userlist", userlist);
		model.addAttribute("ram", new Ram());
		return"result";
	}
	@PostMapping("/delete")
	public String deletUser(@ModelAttribute Ram ram, Model model) {
		userMapper.deleteUser(ram);
        List<Combine>userlist=userMapper.doSelect(ram);
        model.addAttribute("userlist", userlist);
		model.addAttribute("ram", new Ram());
		return"result";
	}
	@PostMapping("/search")
	public String searchUser(@ModelAttribute Ram ram, Model model) {
	
		List<Combine>userlist=userMapper.searchUser(ram);
        model.addAttribute("userlist", userlist);
		model.addAttribute("ram", new Ram());
		return"result";
	}
	
	@PostMapping("/add")
	public String adduser(@ModelAttribute Ram ram, Model model) {
		return"adduser";
	}
	@PostMapping("/doadd")
	//public String doadd(@ModelAttribute Ram ram, Model model) {
	public String doadd(@Valid Ram ram, BindingResult bindingResult, Model model) {
	       
		if (bindingResult.hasErrors()) {
			return "adduser";
		}
	userMapper.doinsert(ram);
	List<Combine>userlist=userMapper.doSelect(ram);
	model.addAttribute("userlist", userlist);
	model.addAttribute("ram", new Ram());
	return"result";
	}
	@PostMapping("/return")
	public String doreturn(@ModelAttribute Ram ram, Model model) {
		List<Combine>userlist=userMapper.doSelect(ram);
		model.addAttribute("userlist", userlist);
		return"result";
	}
}