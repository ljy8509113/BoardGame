package com.boardgame.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.boardgame.model.Admin;
import com.boardgame.model.Game;

@Repository
public class GameDao{
	
	@Autowired
	private SqlSession session;
	final String MAPPER_NS = Game.class.getName();
	
	public Game select(String gameNo) {
		Game game = null;
		try {
//			String sql = "SELECT * FROM game WHERE game_no = ?";
//			game = template.queryForObject(sql, new BeanPropertyRowMapper<Game>(Game.class),
//					gameNo);
			game = session.selectOne(MAPPER_NS + ".select-game", gameNo);
		} catch (Exception e) {
			//throw new Exception(e.getMessage());
			e.printStackTrace();
		}
		
		return game;
	}
	
	public List<Game> selectAll(){
		List<Game> list = null;
		try {
//			String sql = "select * from game";
//			list = template.query(sql, new BeanPropertyRowMapper<Game>(Game.class));
			list = session.selectList(MAPPER_NS + ".select-all-game");
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return list;
	}
}
