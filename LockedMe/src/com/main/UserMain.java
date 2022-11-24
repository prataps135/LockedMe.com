package com.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.bean.FileBean;
import com.controller.UserController;

public class UserMain {
	public static void main(String[] args) throws Exception {
		// Variable declaration
		int option;
		boolean status = true;

		// creating object of user controller class
		UserController usrc = new UserController();

		// creating input stream and buffered reader object for user input
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);

		System.out.println("Welcome to LockedMe.com");

		// checking the user option
		do {
			// displaying options to user
			System.out.println("Choose any option");
			System.out.println("1. Retriving all files name. \n2. Performing operation on files. \n3. Exit.");

			// taking user input for option
			option = Integer.parseInt(br.readLine());
			switch (option) {
			case 1:
				String[] arr = usrc.displayList();
				System.out.println("List of files stored in Database");
				for (int i = 0; i < arr.length; i++) {
					System.out.println(arr[i]);
				}
				break;
			case 2:
				int key;
				boolean inStatus = true;
				do {
					System.out.println("Choose any option");
					System.out
							.println("1. Add a file.\n2. Delete a file. \n3. Search a file. \n4. Return to main menu");
					key = Integer.parseInt(br.readLine());
					switch (key) {
					case 1:
						// creating local variables
						String fileName;
						String fileContent;

						// taking file name and content from user
						System.out.println("Enter file name = ");
						fileName = br.readLine();

						// creating object of file bean class
						FileBean file = new FileBean();

						file.setName(fileName);
						boolean insertStatus = usrc.insertFile(file);
						if (insertStatus) {
							System.out.println("Enter file content = ");
							fileContent = br.readLine();
							file.setFileContent(fileContent);
							System.out.println("File inserted");
						} else {
							System.out.println("Duplicate file name");
						}
						break;

					case 2:
						String fileNameDelete;
						boolean deleteStatus;
						System.out.println("Enter file name to delete = ");
						fileNameDelete = br.readLine();
						deleteStatus = usrc.deleteFile(fileNameDelete);
						if (!deleteStatus) {
							System.out.println("File Not Found");
						}

						break;
					case 3:
						String searchFileName;
						FileBean searchFile = new FileBean();
						System.out.println("Enter the name of file you want to search = ");
						searchFileName = br.readLine();
						searchFile = usrc.serach(searchFileName);
						if (searchFile == null) {
							System.out.println("File Not found");
						} else {
							System.out.println("File name = " + searchFile.getName());
							System.out.println("File Content = " + searchFile.getFileContent());
						}
						break;
					case 4:
						inStatus = false;
						break;

					default:
						System.out.println("Invalid input \nPlease enter a valid number.");
						break;
					}
				} while (inStatus);
				break;
			case 3:
				status = false;
				break;
			default:
				System.out.println("Invalid input \nPlease enter a valid number.");
				break;
			}

		} while (status);

	}

}
