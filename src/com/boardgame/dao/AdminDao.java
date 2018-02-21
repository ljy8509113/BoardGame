package com.boardgame.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.boardgame.model.Admin;
import com.boardgame.util.AdminException;


@Repository
public class AdminDao {

	@Autowired
	private SqlSession session;
	
	final String MAPPER_NS = Admin.class.getName();
	
	public Admin login(String id, String password) throws AdminException {
		try {			
			Admin user = session.selectOne(MAPPER_NS + ".select-account", id);
			
			if(user == null)
				throw new AdminException("아이디가 존재하지 않습니다.");
			
			if(user.getPassword().equals(password))
				return user;
			else 
				throw new AdminException("패스워드 확인이 필요합니다.");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new AdminException("DB에서 오류 발생.");
		}		
	}	
	
	
	
}
