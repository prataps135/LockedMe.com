package com.controller;

import com.bean.FileBean;
import com.service.UserService;

public class UserController {
	UserService us = new UserService();

	public boolean insertFile(FileBean file) {
		boolean insertStatus = false;
		insertStatus = us.insertFile(file);
		return insertStatus;
	}
	
	public String[] displayList() {
		return us.displayList();
	}
	
	public boolean deleteFile(String fileName) {
		boolean deleteStatus = false;
		deleteStatus = us.deleteFile(fileName);
		return deleteStatus;
	}
	
	public FileBean serach(String fileName) {
		FileBean file = new FileBean();
		file = us.serach(fileName);
		return file;
	}

}
