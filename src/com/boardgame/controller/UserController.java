package com.boardgame.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.boardgame.service.FileService;
import com.boardgame.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService service;
	
	@Autowired
	FileService fileService;
	
	@RequestMapping(value="/adminLogin.do", method=RequestMethod.GET)
	public String loginFrom(Model model) {
		return "admin/admin_login";
	}
	
	// 접근 제한 페이지
		@RequestMapping(value="/access-denied.do", method=RequestMethod.GET)
		public String accessDenied(Model model) {
			
			model.addAttribute("email", service.getPrincipal().getUsername());
			
			return "access-denied";
		}
	
}
