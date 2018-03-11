package com.boardgame.dao;

import java.util.List;

import com.boardgame.util.CustomException;
import com.database.model.Game;

public interface GameDao{
	
	public Game select(String gameNo) throws CustomException;
	
	public List<Game> selectAll() throws CustomException;
	
	public void insert(Game game) throws CustomException;
	
	public void update(Game game) throws CustomException;
}
