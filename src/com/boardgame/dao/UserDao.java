package com.boardgame.dao;

import com.boardgame.model.User;
import com.boardgame.util.CustomException;


public interface UserDao {
	public User login(String email, String password) throws CustomException;
	public User selectByEmail(String email) throws CustomException;
}
