package com.boardgame.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.boardgame.model.Game;

@Repository
public class GameDao{
	
	@Autowired
	protected JdbcTemplate template;
	
	public Game select(int gameNo) {
		Game game = null;
		try {
			String sql = "SELECT * FROM game WHERE game_no = ?";
			game = template.queryForObject(sql, new BeanPropertyRowMapper<Game>(Game.class),
					gameNo);
		} catch (Exception e) {
			//throw new Exception(e.getMessage());
		}
		
		return game;
	}
	
	public List<Game> selectAll(){
		List<Game> list = null;
		try {
			String sql = "select * from game";
			list = template.query(sql, new BeanPropertyRowMapper<Game>(Game.class));
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
