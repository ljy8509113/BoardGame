package com.boardgame.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.boardgame.common.Common;
import com.boardgame.model.Game;
import com.boardgame.service.FileService;
import com.boardgame.service.GameService;
import com.boardgame.util.CustomException;
import com.boardgame.util.ErrorMessage;

@Controller
public class GameController {
	@Autowired
	GameService service;
	
	@Autowired
	FileService fileService;

	@RequestMapping(value="gameList.do", method=RequestMethod.GET)
	public String mainGameList(Model model) {
		List<Game>list = getGameList(model);
		model.addAttribute("list", list);
		
		return "game_list";
	}
	
	@RequestMapping(value="/admin/adminGameList.do", method=RequestMethod.GET)
	public String gameList(Model model) {
		List<Game> list = getGameList(model);
		model.addAttribute("list", list);
		
		return "admin/admin_game_list";
	}
	
	List<Game> getGameList(Model model) {
		List<Game> list = null;
		try {
			list = service.getGameList();
		} catch (CustomException e) {
			model.addAttribute("error", e.getMessage());
		}		
		return list;		
	}
	
	@RequestMapping(value="/admin/adminGameDetail.do", method=RequestMethod.GET)
	public String gameDetail(Model model, HttpServletRequest request,
	@RequestParam(value="gameNo", required=true) String gameNo) 
	{
		Game game = null;
		String imagePath = null;
		String filePath = null;
		
		try {
			game = service.getGame(gameNo);
				
			imagePath = fileService.getPath(request, Common.IMAGE_DIRECTORY, game.getCoverImage());
			filePath = fileService.getPath(request, Common.PREFAB_DIRECTORY, game.getFileName());
			
			game.setCoverImage(imagePath);
			game.setFileName(filePath);
			
		}catch(CustomException e) {
			System.out.println(e.getLog());
			request.setAttribute("error", e.getMessage());
		} catch (UnsupportedEncodingException e) {
			System.out.println(e.getMessage());
			request.setAttribute("error", ErrorMessage.ERROR_INCODING);
		}
		
		model.addAttribute("game", game);
		
		return "admin/admin_game_detail";
	}
	
	@RequestMapping(value="/admin/adminGameRegist.do", method=RequestMethod.GET)
	public String addGameForm(Model model) {

		return "admin/admin_game_add";
	}
	
	@RequestMapping(value="/admin/adminGameRegist.do", method=RequestMethod.POST)
	public String addGame(HttpServletRequest req, 
			String title, 
			String description, 
			String state,
			String version,
			@RequestParam("coverImage") MultipartFile imageFile,
			@RequestParam("gameFile") MultipartFile gameFile) {

		if(title == null || title.equals("")) {
			req.setAttribute("error", "게임명을 입력해주세요.");
			return "forward:admin/admin_game_add";
		}else if(state == null || state.equals("")) {
			req.setAttribute("error", "게임 상태를 입력해주세요.");
			return "forward:admin/admin_game_add";
		}else {
			// 클라이언트로부터 전달받은 값으로 객체 생성
			try {
				Game game = new Game(null, description, title, null, state, null, version);
					
				String imageName = fileService.add(req, imageFile, Common.IMAGE_DIRECTORY);
				if(imageName != null)
					game.setCoverImage(imageName);
				else
					game.setCoverImage(fileService.getPath(req, Common.IMAGE_DIRECTORY, Common.DEFAULT_CORVER));

				String fileName = fileService.add(req, gameFile, Common.PREFAB_DIRECTORY);
				if(fileName != null)
					game.setFileName(fileName);
				
				service.addGame(game);
			
				return "redirect:adminGameList.do";
				
			} catch (CustomException e) {
				System.out.println(e.getLog());
				req.setAttribute("error", e.getMessage());
				
				return "forward:admin/admin_game_add";
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
				req.setAttribute("error", ErrorMessage.ERROR_INCODING);
				
				return "";
			} 
		}
	}
	
	@RequestMapping(value="/admin/adminGameModify.do", method=RequestMethod.GET)
	public String modifyGameForm(Model model, @RequestParam("gameNo") String gameNo) {
		Game game = null;
		try {
			game = service.getGame(gameNo);
			model.addAttribute("game", game);
			return "admin/admin_game_modify";
			
		} catch (CustomException e) {
			System.out.println(e.getLog());
			model.addAttribute("error", e.getMessage());
			
			return "admin/admin_game_modify";
		}
	}
	
	@RequestMapping(value="/admin/adminGameModify.do", method=RequestMethod.POST)
	public String modifyGame(HttpServletRequest req, 
			String gameNo,
			String title, 
			String description, 
			String state,
			String version,
			@RequestParam("coverImage") MultipartFile imageFile,
			@RequestParam("gameFile") MultipartFile gameFile) {
		
		if(title == null || title.equals("")) {
			req.setAttribute("error", "게임명을 입력해주세요.");
			return "forward:admin/admin_game_add";
		}else if(state == null || state.equals("")) {
			req.setAttribute("error", "게임 상태를 입력해주세요.");
			return "forward:admin/admin_game_add";
		}else {
			try {
				Game game = service.getGame(gameNo);
				
				game.setTitle(title);
				game.setDescription(description);
				game.setState(state);
				game.setVersion(version);
				
				String imageName = fileService.add(req, imageFile, Common.IMAGE_DIRECTORY);
				if(imageName != null) {
					fileService.remove(req, game.getCoverImage(), Common.IMAGE_DIRECTORY);
					game.setCoverImage(imageName);
				}
				
				String fileName = fileService.add(req, gameFile, Common.PREFAB_DIRECTORY);
				if(fileName != null) {	
					fileService.remove(req, game.getFileName(), Common.PREFAB_DIRECTORY);
					game.setFileName(fileName);
				}
				
				service.update(game);
			
				return "redirect:adminGameList.do";
				
			} catch (CustomException e) {
				System.out.println(e.getLog());
				req.setAttribute("error", e.getMessage());
				
				return "forward:admin/admin_game_add";
			}
		}
		
	}
	
	
}
