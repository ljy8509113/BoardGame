package com.boardgame.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.boardgame.model.Admin;
import com.boardgame.model.Game;
import com.boardgame.service.AdminService;
import com.boardgame.util.AdminException;

@Controller
public class AdminController {
	@Autowired
	AdminService service;
	
	@RequestMapping(value="/adminLogin.do", method=RequestMethod.GET)
	public String loginFrom(Model model) {
		return "admin/admin_login";
	}
	
	@RequestMapping(value="/adminLogin.do",method=RequestMethod.POST)
	public String login(
			HttpServletRequest request,
			String id, 
			String password) 
	{
		Admin user = null;
		
		try {
			user = service.checkIdPw(id, password);
			request.setAttribute("admin", user);
			
			HttpSession session = request.getSession(true);
			session.setAttribute("name", user.getName());
			session.setAttribute("id", user.getId());
			
			return "admin/admin_game_list";
			
		} catch (AdminException e) {
			// TODO Auto-generated catch block
			request.setAttribute("error", e.getMessage());
			return "admin/admin_login";
		}		
	}
	
	@RequestMapping(value="/adminMain.do", method=RequestMethod.GET)
	public String adminMain(Model model) {
		
		return "admin/admin_game_list";
	}

	@RequestMapping(value="/adminGameList.do", method=RequestMethod.GET)
	public String gameList(Model model) {
		List<Game> list = null;
		try {
			list = service.getGameList();
		} catch (AdminException e) {
			model.addAttribute("error", e.getMessage());
		}
		
		model.addAttribute("list", list);
		
		return "admin/admin_game_list";
	}
	
}
