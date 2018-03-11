package com.boardgame.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boardgame.dao.GameDao;
import com.boardgame.util.CustomException;
import com.database.model.Game;

@Service
public class GameService {
	
	@Autowired
	GameDao gameDao;
	
	public Game getGame(String gameNo) throws CustomException {
		return gameDao.select(gameNo);
	}
	
	public List<Game> getGameList() throws CustomException {
		return gameDao.selectAll();
	}
	
	public void addGame(Game game) throws CustomException {
		gameDao.insert(game);
	}
	
	public void update(Game game) throws CustomException{
		gameDao.update(game);
	}
	
}
