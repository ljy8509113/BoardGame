package com.boardgame.dao;

import com.boardgame.util.CustomException;
import com.database.model.User;


public interface UserDao {
	public User selectByEmail(String email) throws CustomException;
}
