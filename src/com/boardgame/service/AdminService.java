package com.boardgame.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.boardgame.model.Admin;
import com.boardgame.model.Game;
import com.boardgame.util.CustomException;

@Service
public interface AdminService {
	public Admin checkIdPw(String id, String password) throws CustomException;
	public List<Game> getGameList() throws CustomException;
	public void addGame(Game game) throws CustomException;
}
