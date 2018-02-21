package com.boardgame.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boardgame.dao.AdminDao;
import com.boardgame.dao.GameDao;
import com.boardgame.model.Admin;
import com.boardgame.model.Game;
import com.boardgame.util.CustomException;

@Service
public class AdminServiceImpl implements AdminService{
	@Autowired
	GameDao gameDao;
	
	@Autowired
	AdminDao adminDao;
	
	public AdminServiceImpl() {
		
	}
	
	@Override
	public Admin checkIdPw(String id, String password) throws CustomException {
		return adminDao.login(id, password);
	}
	
	@Override
	public List<Game> getGameList() throws CustomException{
		return gameDao.selectAll();
	}

	@Override
	public void addGame(Game game) throws CustomException {
		gameDao.insert(game);		
	}
}
