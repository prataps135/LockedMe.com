package com.service;

import com.bean.FileBean;
import com.dao.UserDAO;

public class UserService {
	UserDAO dao = new UserDAO();

	public boolean insertFile(FileBean file) {
		boolean insertStatus = false;
		insertStatus = dao.insertFile(file);
		return insertStatus;
	}
	
	public String[] displayList() {
		return dao.displayList();
	}
	
	public boolean deleteFile(String fileName) {
		boolean deleteStatus = false;
		deleteStatus = dao.deleteFile(fileName);
		return deleteStatus;
	}
	
	public FileBean serach(String fileName) {
		FileBean file = new FileBean();
		file = dao.serach(fileName);
		return file;
	}


}
