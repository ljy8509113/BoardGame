package com.boardgame.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

		return "admin/admin_login";
	}

	// 로그아웃
	@RequestMapping(value="/admin/logout.do", method=RequestMethod.GET)
	public String logout(HttpServletRequest req, HttpServletResponse resp) {
		// 서비스의 로그아웃 메소드 호출
		service.logout(req, resp);

		// 로그아웃 한 뒤 로그인 페이지로 이동 후 로그아웃 메시지 출력을 위해 쿼리문자열 사용
		return "redirect:/adminLogin.do";
	}


}
