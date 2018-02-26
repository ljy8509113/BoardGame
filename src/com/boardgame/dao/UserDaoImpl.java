package com.boardgame.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.boardgame.model.User;
import com.boardgame.util.CustomException;
import com.boardgame.util.ErrorMessage;


@Repository
public class UserDaoImpl implements UserDao{

	@Autowired
	private SqlSession session;
	final String MAPPER_NS = User.class.getName();
	
	public UserDaoImpl() {		
	}
	
	@Override
	public User selectByEmail(String email) throws CustomException {
		User users = null;
		try {
			users = session.selectOne(MAPPER_NS + ".select-user-by-email", email);
			
		} catch (Exception e) {
			throw new CustomException(ErrorMessage.ERROR_ID, e.getMessage());
		}
		return users;
	}
	
}
