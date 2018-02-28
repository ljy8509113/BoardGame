package com.boardgame.dao;

import java.util.List;

import com.boardgame.model.Game;
import com.boardgame.util.CustomException;

public interface GameDao{
	
	public Game select(String gameNo) throws CustomException;
	
	public List<Game> selectAll() throws CustomException;
	
	public void insert(Game game) throws CustomException;
	
	public void update(Game game) throws CustomException;
	
	public void deleteAll() throws CustomException;
	
	public Integer getCount() throws CustomException;
	
	public Integer selectLastInsertId() throws CustomException;
}
