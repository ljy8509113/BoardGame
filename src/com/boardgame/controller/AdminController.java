package com.boardgame.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.boardgame.common.Common;
import com.boardgame.model.Admin;
import com.boardgame.model.Game;
import com.boardgame.service.AdminService;
import com.boardgame.service.FileService;
import com.boardgame.util.CustomException;

@Controller
public class AdminController {
	@Autowired
	AdminService service;
	
	@Autowired
	FileService fileService;

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

		} catch (CustomException e) {
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
		} catch (CustomException e) {
			model.addAttribute("error", e.getMessage());
		}

		model.addAttribute("list", list);

		return "admin/admin_game_list";
	}

	@RequestMapping(value="/adminLogout.do", method=RequestMethod.GET)
	public String logout(Model model) {

		return "redirect:index.html";
	}

	@RequestMapping(value="/adminGameRegist.do", method=RequestMethod.GET)
	public String addGameForm(Model model) {

		return "admin/admin_game_add";
	}

	@RequestMapping(value="/adminGameRegist.do", method=RequestMethod.POST)
	public String addGame(HttpServletRequest req, 
			String title, 
			String description, 
			String state,
			@RequestParam("imageFile") MultipartFile imageFile,
			@RequestParam("gameFile") MultipartFile gameFile) {

		if(title == null || title.equals("")) {
			req.setAttribute("error", "게임명을 입력해주세요.");
			return "forward:admin/admin_game_add";
		}else if(state == null || state.equals("")) {
			req.setAttribute("error", "게임 상태를 입력해주세요.");
			return "forward:admin/admin_game_add";
		}else {
			// 클라이언트로부터 전달받은 값으로 객체 생성
			Game game = new Game(null, description, title, null, state, null);
			try {
				
				if(imageFile != null) {
					String imageName = fileService.add(req, imageFile, Common.IMAGE_DIRECTORY);
					game.setImagePath(imageName);
				}
				
				if(gameFile != null) {
					String fileName = fileService.add(req, gameFile, Common.PREFAB_DIRECTORY);
					game.setFileName(fileName);
				}
				
				service.addGame(game);
			
				return "redirect:adminGameList.do";
				
			} catch (CustomException e) {
				System.out.println(e.getLog());
				req.setAttribute("error", e.getMessage());
				
				return "forward:admin/admin_game_add";
			} 
		}
	}
}
