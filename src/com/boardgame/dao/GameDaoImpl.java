package com.boardgame.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.boardgame.util.CustomException;
import com.boardgame.util.ErrorMessage;
import com.database.model.Game;

@Repository
public class GameDaoImpl implements GameDao{
	
	@Autowired
	private SqlSession session;
	final String MAPPER_NS = Game.class.getName();
	
	public GameDaoImpl() {		
	}
	
	public Game select(String gameNo) throws CustomException {
		Game game = null;
		try {
			game = session.selectOne(MAPPER_NS + ".select-game", gameNo);
		} catch (Exception e) {
			throw new CustomException(ErrorMessage.ERROR_DB, e.getMessage());
		}
		
		return game;
	}
	
	public List<Game> selectAll() throws CustomException{
		List<Game> list = null;
		try {
			list = session.selectList(MAPPER_NS + ".select-all-game");
		}catch(Exception e) {
			throw new CustomException(ErrorMessage.ERROR_DB, e.getMessage());
			
		}
		return list;
	}

	@Override
	public void insert(Game game) throws CustomException {
		try {
			session.insert(MAPPER_NS + ".insert-game", game);
		}catch(Exception e) {
			throw new CustomException(ErrorMessage.ERROR_DB, e.getMessage());
		}
	}

	@Override
	public void update(Game game) throws CustomException {
		
		try {
			session.update(MAPPER_NS + ".update-game", game);
		}catch(Exception e) {
			throw new CustomException(ErrorMessage.ERROR_DB, e.getMessage());
		}
	}
	
	@Override
	public void deleteAll() throws CustomException {
		try {
			session.delete(MAPPER_NS + ".delete-all-game");
		}catch(Exception e) {
			throw new CustomException(ErrorMessage.ERROR_DB, e.getMessage());
		}
	}

	@Override
	public Integer getCount() throws CustomException {
		Integer count = null;
		
		try {
			count = session.selectOne(MAPPER_NS + ".count-game");
			
		} catch (Exception e) {
			throw new CustomException(ErrorMessage.ERROR_DB, e.getMessage());
		}
		
		return count;
	}

	@Override
	public Integer selectLastInsertId() throws CustomException {
		Integer lastInsertId = null;
		try {
			lastInsertId = session.selectOne(MAPPER_NS + ".select-last-insert-id");
			
		} catch (Exception e) {
			throw new CustomException(ErrorMessage.ERROR_DB, e.getMessage());
		}
		
		return lastInsertId;
	}
}
