package com.boardgame.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.boardgame.model.Admin;
import com.boardgame.util.CustomException;
import com.boardgame.util.ErrorMessage;


@Repository
public class AdminDaoImpl implements AdminDao{

	@Autowired
	private SqlSession session;
	final String MAPPER_NS = Admin.class.getName();
	
	public Admin login(String id, String password) throws CustomException {
		try {			
			Admin user = session.selectOne(MAPPER_NS + ".select-account", id);
			
			if(user == null)
				throw new CustomException(ErrorMessage.ERROR_ID, "");
			
			if(user.getPassword().equals(password))
				return user;
			else 
				throw new CustomException(ErrorMessage.ERROR_LOGIN, "");
			
		} catch (Exception e) {
			throw new CustomException(ErrorMessage.ERROR_DB, e.getMessage());
		}		
	}	
	
	
	
}
