package com.boardgame.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boardgame.dao.UserDao;
import com.boardgame.model.User;
import com.boardgame.util.CustomException;

@Service
public class UserService {
//	public Admin checkIdPw(String id, String password) throws CustomException;
//	public List<Game> getGameList() throws CustomException;
//	public void addGame(Game game) throws CustomException;
//	public Game detailGame(String gameNo) throws CustomException;
	
	@Autowired
	UserDao userDao;
	
	public User checkIdPw(String email, String password) throws CustomException {
		return userDao.login(email, password);
	}
	
	public User detailByEmail(String email) throws CustomException {
		return userDao.selectByEmail(email);
	}

	
}
