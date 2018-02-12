package dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Game;


@Repository
public class GameDao {
	@Autowired
	private SqlSessionFactory factory;
	
	public Game getGame(int no) {
		SqlSession session = factory.openSession();
		Game game = session.selectOne("model.Game.select", no);
		session.close();
		
		return game;
	}
}
