package com.boardgame.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import com.boardgame.util.CustomException;

public interface FileService {
	
	// 파일 추가
	public String add(HttpServletRequest request, MultipartFile attachment, String dir) throws CustomException;
	
	// 파일 다운로드
	public void download(HttpServletRequest request, HttpServletResponse response, 
			String filename) throws CustomException;
	
	// 파일 삭제
	public void remove(HttpServletRequest request, String filename, String dir) throws CustomException;
	
	// 파일 저장 경로 + 이미지 파일명
	public String getImgPath(HttpServletRequest request, String filename);
	
//	// 파일 저장 폴더 경로 가져오기(ContextPath + /upload)
//	public String getUploadPath(HttpServletRequest request);
}




