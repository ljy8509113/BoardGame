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
	
	public Integer getCount() throws CustomException {
		Integer count = null;
		
		try {
			count = session.selectOne(MAPPER_NS + ".count-users");
			
		} catch (Exception e) {
			throw new CustomException(ErrorMessage.ERROR_DB, e.getMessage());
		}
		
		return count;
	}

	@Override
	public void deleteAllUsersAuthority() throws CustomException {
		try {
			session.delete(MAPPER_NS + ".delete-all-users-authority");
			
		} catch (Exception e) {
			throw new CustomException(ErrorMessage.ERROR_DB, e.getMessage());
		}
	}

	@Override
	public Integer getCountUsersAuthority() throws CustomException {
		Integer count = null;
		
		try {
			count = session.selectOne(MAPPER_NS + ".count-users-authority");
			
		} catch (Exception e) {
			throw new CustomException(ErrorMessage.ERROR_DB, e.getMessage());
		}
		
		return count;
	}

	@Override
	public void deleteAll() throws CustomException {
		try {
			session.delete(MAPPER_NS + ".delete-all-users");
			
		} catch (Exception e) {
			throw new CustomException(ErrorMessage.ERROR_DB, e.getMessage());
		}		
	}

	@Override
	public void insert(User user) throws CustomException {
		try {
			session.insert(MAPPER_NS + ".insert-user", user);			
		} catch (Exception e) {
			throw new CustomException(ErrorMessage.ERROR_DB, e.getMessage());
		}		
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
	
	@Override
	public void insertAuthority(User users) throws CustomException {
		try {
			session.insert(MAPPER_NS + ".insert-authority", users);
			
		} catch (Exception e) {
			throw new CustomException(ErrorMessage.ERROR_DB, e.getMessage());
		}
	}
	
}
