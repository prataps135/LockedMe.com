package com.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.bean.FileBean;
import com.controller.UserController;

public class UserMain {
	public static void main(String[] args) {
		// Variable declaration
		String option = null;
		boolean status = true;

		// creating object of user controller class
		UserController usrc = new UserController();

		// creating input stream and buffered reader object for user input
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);

		System.out.println("Welcome to LockedMe.com");
		System.out.println("Developed by :- Pratap Singh Sisodia\n");

		// checking the user option
		do {
			// displaying options to user
			System.out.println("Choose any option");
			System.out.println("1. Retriving all files name. \n2. Performing operation on files. \n3. Exit.");

			// taking user input for option
			try {
				option = br.readLine();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			switch (option.trim()) {
			case "1":
				String[] arr = usrc.displayList();
				System.out.println("List of files stored in Database");
				for (int i = 0; i < arr.length; i++) {
					System.out.println(arr[i]);
				}
				break;
			case "2":
				String key = null;
				boolean inStatus = true;
				do {
					System.out.println("Choose any option");
					System.out
							.println("1. Add a file.\n2. Delete a file. \n3. Search a file. \n4. Return to main menu");
					try {
						key = br.readLine();
					} catch (IOException e) {
						e.printStackTrace();
					}
					switch (key.trim()) {
					case "1":
						// creating local variables
						String fileName = null;
						String fileContent = null;

						// taking file name and content from user
						System.out.println("Enter file name = ");
						try {
							fileName = br.readLine();
						} catch (IOException e) {
							e.printStackTrace();
						}

						// creating object of file bean class
						FileBean file = new FileBean();

						file.setName(fileName);
						boolean insertStatus = usrc.insertFile(file);
						if (insertStatus) {
							System.out.println("Enter file content = ");
							try {
								fileContent = br.readLine();
							} catch (IOException e) {
								e.printStackTrace();
							}
							file.setFileContent(fileContent);
							System.out.println("File inserted");
						} else {
							System.out.println("Duplicate file name");
						}
						break;

					case "2":
						String fileNameDelete = null;
						boolean deleteStatus;
						System.out.println("Enter file name to delete = ");
						try {
							fileNameDelete = br.readLine();
						} catch (IOException e) {
							e.printStackTrace();
						}
						deleteStatus = usrc.deleteFile(fileNameDelete);
						if (!deleteStatus) {
							System.out.println("File Not Found");
						}
						break;

					case "3":
						String searchFileName = null;
						FileBean searchFile = new FileBean();
						System.out.println("Enter the name of file you want to search = ");
						try {
							searchFileName = br.readLine();
						} catch (IOException e) {
							e.printStackTrace();
						}
						searchFile = usrc.serach(searchFileName);
						if (searchFile == null) {
							System.out.println("File Not found");
						} else {
							System.out.println("File name = " + searchFile.getName());
							System.out.println("File Content = " + searchFile.getFileContent());
						}
						break;

					case "4":
						inStatus = false;
						break;

					default:
						System.out.println("Invalid input \nPlease enter a valid number.");
						break;
					}
				} while (inStatus);
				break;

			case "3":
				status = false;
				break;

			default:
				System.out.println("Invalid input \nPlease enter a valid number.");
				break;
			}
		} while (status);
	}
}
