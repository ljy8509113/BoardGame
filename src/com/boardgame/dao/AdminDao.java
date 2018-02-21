package com.boardgame.dao;

import com.boardgame.model.Admin;
import com.boardgame.util.CustomException;


public interface AdminDao {
	public Admin login(String id, String password) throws CustomException;
	
}
