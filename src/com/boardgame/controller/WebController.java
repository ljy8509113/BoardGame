package com.boardgame.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boardgame.service.WebService;

@Controller
public class WebController {
	@Autowired
	WebService webService;
	
	@RequestMapping("Key.do")
	public String getMacAddress() {
		return "key";
	}
	
}
