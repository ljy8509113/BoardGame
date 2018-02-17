package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import dao.GameDao;
import model.Game;

public class TestDrive {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("/config/config.xml");
		GameDao dao = context.getBean(GameDao.class);
		Game g = dao.getGame(1);
		
		System.out.println(g);
	}
}
