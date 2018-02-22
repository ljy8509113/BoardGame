package com.boardgame.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boardgame.dao.AdminDao;
import com.boardgame.model.Admin;
import com.boardgame.util.CustomException;

@Service
public class AdminService {
//	public Admin checkIdPw(String id, String password) throws CustomException;
//	public List<Game> getGameList() throws CustomException;
//	public void addGame(Game game) throws CustomException;
//	public Game detailGame(String gameNo) throws CustomException;
	
	@Autowired
	AdminDao adminDao;
	
	public Admin checkIdPw(String id, String password) throws CustomException {
		return adminDao.login(id, password);
	}
	
}
