package com.boardgame.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boardgame.dao.AdminDao;
import com.boardgame.dao.GameDao;
import com.boardgame.model.Admin;
import com.boardgame.model.Game;
import com.boardgame.util.AdminException;

@Service
public class AdminService {
	@Autowired
	GameDao gameDao;
	
	@Autowired
	AdminDao adminDao;
	
	public AdminService() {
		
	}
	
	public Admin checkIdPw(String id, String password) throws AdminException {
		return adminDao.login(id, password);
	}
	
	
	public List<Game> getGameList() throws AdminException{
		return gameDao.selectAll();
	}
}
