package com.boardgame.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Service;

import com.boardgame.dao.UserDao;
import com.boardgame.util.CustomException;
import com.database.model.User;

@Service
public class UserService {
//	public Admin checkIdPw(String id, String password) throws CustomException;
//	public List<Game> getGameList() throws CustomException;
//	public void addGame(Game game) throws CustomException;
//	public Game detailGame(String gameNo) throws CustomException;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public User detailByEmail(String email) throws CustomException {
		return userDao.selectByEmail(email);
	}

	public UserDetails getPrincipal() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		Object principal = auth.getPrincipal();
		if (principal instanceof UserDetails) {
			return (UserDetails) principal;
		}
		
		return null;
	}
	
	public void logout(HttpServletRequest req, HttpServletResponse resp) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(req, resp, auth);
		}
	}

	public boolean isPasswordMatched(String oldPassword) throws CustomException {
		// 현재 로그인한 사용자의 암호화된 비밀번호를 가져온다.
		String email = this.getPrincipal().getUsername();
		User users = userDao.selectByEmail(email);
		
		// 입력한 비밀번호와 기존 비밀번호를 비교하여 일치하면 true, 아니면 false 리턴
		return passwordEncoder.matches(oldPassword, users.getPassword());
	}
}
