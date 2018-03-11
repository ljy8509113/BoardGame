package com.boardgame.dao;

import com.boardgame.util.CustomException;
import com.database.model.User;


public interface UserDao {
	public User selectByEmail(String email) throws CustomException;

	// 사용자 전체 삭제
	public void deleteAll() throws CustomException;

	// 사용자 수 가져오기
	public Integer getCount() throws CustomException;

	// users_authority 테이블 전체 삭제
	public void deleteAllUsersAuthority() throws CustomException;

	// users_authority 테이블 행의 수 가져오기
	public Integer getCountUsersAuthority() throws CustomException;
	
	public void insert(User user) throws CustomException;
	
	public Integer selectLastInsertId() throws CustomException;
	
	public void insertAuthority(User users) throws CustomException;
}
