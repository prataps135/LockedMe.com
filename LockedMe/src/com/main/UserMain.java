package com.main;


import java.util.Scanner;

public class UserMain {

	public static void main(String[] args) {
		// Variable declaration
		int option;
		boolean status = true;

		// use scanner object for input
		Scanner sc = new Scanner(System.in);

		System.out.println("Welcome to LockedMe.com");
		

		// checking the user option
		do {
			// displaying options to user
			System.out.println("Choose any option");
			System.out.println("1. Add a file \n2. Remove a file \n3. Search a file\n4. Exit");
			
			// taking user input for option
			option = sc.nextInt();
			switch (option) {
			case 1:

				break;
			case 2:

				break;
			case 3:

				break;
			case 4:
				status = false;
				break;

			default:
				System.out.println("Invalid input");
				break;
			}

		} while (status);
	}

}
