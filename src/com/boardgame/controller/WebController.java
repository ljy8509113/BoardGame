package com.boardgame.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.boardgame.model.Game;
import com.boardgame.service.GameService;
import com.boardgame.service.WebService;
import com.boardgame.util.CustomException;

@Controller
public class WebController {
	@Autowired
	WebService webService;
	
	@Autowired
	GameService gameService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index(Model model) {
		return getGameList(model);
	}
	
	@RequestMapping(value="gameList.do", method=RequestMethod.GET)
	public String mainGameList(Model model) {
		return getGameList(model);
		
	}
	
	String getGameList(Model model) {
		List<Game> list = null;
		try {
			list = gameService.getGameList();
		} catch (CustomException e) {
			model.addAttribute("error", e.getMessage());
		}

		model.addAttribute("list", list);
		
		return "game_list";
	}
	
	@RequestMapping("Key.do")
	public String getMacAddress() {
		return "key";
	}
	
	
	
	
}
