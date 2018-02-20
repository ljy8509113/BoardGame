package com.boardgame.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boardgame.dao.GameDao;

@Service
public class WebService {
	@Autowired
	GameDao gameDao;
	
	public WebService() {
		
	}
	
	
}
