package com.test;

import com.bean.FileBean;
import com.dao.UserDAO;

import junit.framework.TestCase;

public class UserDAOTest extends TestCase {

	public void testInsertValidFileName() {
		String fileName = "Dddd";
		String fileContent = "welcome";
		UserDAO dao = new UserDAO();
		FileBean file = new FileBean();
		file.setName(fileName);
		file.setFileContent(fileContent);
		boolean insertStatus = dao.insertFile(file);
		assertTrue(insertStatus);
	}

	public void testInsertAlreadyExistFileName() {
		String fileName = "Aaaa";
		String fileContent = "welcome";
		UserDAO dao = new UserDAO();
		FileBean file = new FileBean();
		file.setName(fileName);
		file.setFileContent(fileContent);
		boolean insertStatus = dao.insertFile(file);
		assertFalse(insertStatus);
	}

	public void testInsertNullFileName() {
		String fileName = null;
		String fileContent = "welcome";
		UserDAO dao = new UserDAO();
		FileBean file = new FileBean();
		file.setName(fileName);
		file.setFileContent(fileContent);
		boolean insertStatus = dao.insertFile(file);
		assertFalse(insertStatus);
	}

	public void testInsertSpaceInFileName() {
		String fileName = "	";
		String fileContent = "welcome";
		UserDAO dao = new UserDAO();
		FileBean file = new FileBean();
		file.setName(fileName);
		file.setFileContent(fileContent);
		boolean insertStatus = dao.insertFile(file);
		assertFalse(insertStatus);
	}

	public void testInsertEmptyFileName() {
		String fileName = "";
		String fileContent = "welcome";
		UserDAO dao = new UserDAO();
		FileBean file = new FileBean();
		file.setName(fileName);
		file.setFileContent(fileContent);
		boolean insertStatus = dao.insertFile(file);
		assertFalse(insertStatus);
	}

	public void testDisplayValidList() {
		String[] arrExpected = { "Aaaa", "Bbbb", "Cccc" };
		UserDAO dao = new UserDAO();
		String[] arrActual = dao.displayList();
		for (int i = 0; i < arrActual.length; i++) {
			assertEquals(arrExpected[i], arrActual[i]);
		}
	}

	public void testDisplayInvalidList() {
		String[] arrExpected = { "aaaa", "bbbb", "cccc" };
		UserDAO dao = new UserDAO();
		String[] arrActual = dao.displayList();
		for (int i = 0; i < arrActual.length; i++) {
			assertNotSame(arrExpected[i], arrActual[i]);
		}
	}

	public void testDeleteValidFile() {
		String fileName = "Aaaa";
		UserDAO dao = new UserDAO();
		boolean deleteStatus = dao.deleteFile(fileName);
		assertTrue(deleteStatus);
	}

	public void testDeleteInvalidFileCaseSensetive() {
		String fileName = "aaaa";
		UserDAO dao = new UserDAO();
		boolean deleteStatus = dao.deleteFile(fileName);
		assertFalse(deleteStatus);
	}

	public void testDeleteInValidFile() {
		String fileName = "Dddd";
		UserDAO dao = new UserDAO();
		boolean deleteStatus = dao.deleteFile(fileName);
		assertFalse(deleteStatus);
	}

	public void testDeleteNullFile() {
		String fileName = null;
		UserDAO dao = new UserDAO();
		boolean deleteStatus = dao.deleteFile(fileName);
		assertFalse(deleteStatus);
	}

	public void testDeleteSpaceFile() {
		String fileName = "		";
		UserDAO dao = new UserDAO();
		boolean deleteStatus = dao.deleteFile(fileName);
		assertFalse(deleteStatus);
	}

	public void testSerachValidFile() {
		String fileName = "Aaaa";
		FileBean fileExpected = new FileBean();
		UserDAO dao = new UserDAO();
		fileExpected.setName(fileName);
		fileExpected.setFileContent(null);
		FileBean fileActual = dao.serach(fileName);
		assertEquals(fileExpected.getName(), fileActual.getName());
		assertEquals(fileExpected.getFileContent(), fileActual.getFileContent());
	}

	public void testSerachInvalidFileContent() {
		String fileName = "Aaaa";
		FileBean fileExpected = new FileBean();
		UserDAO dao = new UserDAO();
		fileExpected.setName(fileName);
		fileExpected.setFileContent("Welcome");
		FileBean fileActual = dao.serach(fileName);
		assertEquals(fileExpected.getName(), fileActual.getName());
		assertNotSame(fileExpected.getFileContent(), fileActual.getFileContent());
	}

	public void testSerachInvalidFileNameCaseSensitive() {
		String fileName = "aaaa";
		FileBean fileExpected = new FileBean();
		UserDAO dao = new UserDAO();
		fileExpected.setName(fileName);
		fileExpected.setFileContent("Welcome");
		FileBean fileActual = dao.serach(fileName);
		assertNull(fileActual);
	}
	
	public void testSerachNullFile() {
		String fileName = null;
		FileBean fileExpected = new FileBean();
		UserDAO dao = new UserDAO();
		fileExpected.setName(fileName);
		fileExpected.setFileContent(null);
		FileBean fileActual = dao.serach(fileName);
		assertNull(fileActual);
	}
	
	public void testSerachSpaceFile() {
		String fileName = "		";
		FileBean fileExpected = new FileBean();
		UserDAO dao = new UserDAO();
		fileExpected.setName(fileName);
		fileExpected.setFileContent(null);
		FileBean fileActual = dao.serach(fileName);
		assertNull(fileActual);
	}

}
