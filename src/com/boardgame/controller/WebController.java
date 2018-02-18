package com.boardgame.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boardgame.dao.GameDao;
import com.boardgame.model.Game;

@Controller
public class WebController {
	@Autowired
	GameDao gameDao;
	
	@RequestMapping("Main.do")
	public String mainGameList(Model model) {
		List<Game> list = null;
		
		try {
			// service를 이용하여 글 목록 가져오기
			list = gameDao.selectAll();
			
		} catch (Exception e) {
			// 예외가 발생하면 error키의 값을 이용하여 JSP에 표시
			model.addAttribute("error", "server");
		}
		
		// list키에 list 객체를 추가
		model.addAttribute("list", list);
		
		/*
		 *  ViewResolver에 의해서 /WEB-INF/views/board-list.jsp 페이지로
		 *  포워딩 하게 된다.
		 */
		
		return "main";
	}
	
	@RequestMapping("Key.do")
	public String getMacAddress() {
		return "key";
	}
}
