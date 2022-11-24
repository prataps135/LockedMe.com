package com.dao;

import java.util.Map;
import java.util.TreeMap;

import com.bean.FileBean;

public class UserDAO {
	// declaring Set
	Map<String, FileBean> fileMap;

	public UserDAO() {

		// creating set object
		fileMap = new TreeMap<>();

		// creating file objects to access the file
		FileBean file1 = new FileBean();
		file1.setName("Aaaa");
		file1.setFileContent(null);

		FileBean file3 = new FileBean();
		file3.setName("Cccc");
		file1.setFileContent(null);

		FileBean file2 = new FileBean();
		file2.setName("Bbbb");
		file1.setFileContent(null);

		fileMap.put(file1.getName(), file1);
		fileMap.put(file3.getName(), file3);
		fileMap.put(file2.getName(), file2);
	}

	public boolean insertFile(FileBean file) {
		boolean insertStatus = false;
		if (fileMap.containsKey(file.getName())) {
			System.out.println("File already exist");
		} else {
			fileMap.put(file.getName(), file);
			insertStatus = true;
		}
		return insertStatus;
	}

	public String[] displayList() {
		int i = 0;
		String[] arr = new String[fileMap.size()];
		for (String keys : fileMap.keySet()) {
			arr[i] = keys;
			i++;
		}
		return arr;
	}

	public boolean deleteFile(String fileName) {
		boolean deleteStatus = false;
		if (fileMap.containsKey(fileName)) {
			fileMap.remove(fileName);
			System.out.println("File Succesfully deleted");
			deleteStatus = true;
		}
		return deleteStatus;
	}

	public FileBean serach(String fileName) {
		FileBean file = null;
		if (fileMap.containsKey(fileName)) {
			file = fileMap.get(fileName);
		}
		return file;
	}

}
