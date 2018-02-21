package com.boardgame.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.boardgame.model.Admin;
import com.boardgame.model.Game;
import com.boardgame.util.CustomException;
import com.boardgame.util.ErrorMessage;

@Repository
public class GameDaoImpl implements GameDao{
	
	@Autowired
	private SqlSession session;
	final String MAPPER_NS = Game.class.getName();
	
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
}
