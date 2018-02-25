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
	
	public User login(String id, String password) throws CustomException {
		try {			
			User user = session.selectOne(MAPPER_NS + ".select-account", id);
			
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
	
	@Override
	public User selectByEmail(String email) throws CustomException {
		User users = null;
		try {
			users = session.selectOne(MAPPER_NS + ".select-users-by-email", email);
			
		} catch (Exception e) {
			throw new CustomException(ErrorMessage.ERROR_ID, e.getMessage());
		}
		return users;
	}
	
}
