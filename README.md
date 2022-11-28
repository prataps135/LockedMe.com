# LockedMe.com
Phase 1, Project SL (FSJD)

### Project name = LockedMe.com

### Developer deatils :-
  name = Pratap Singh Sisodia
  
  email = prataps135@gmail.com
 
### Core concepts used in the project:
1. Collections Framework.
2. File Handling.
3. Sorting.
4. Flow Control.
5. Recursion.
6. Exception Handling.
7. Streams API.

### Unique Selling Points of the Application:
	The application is designed to keep on running and taking user inputs even after exceptions occur. To terminate the application, appropriate option needs to be selected.

	The application can take any file/folder name as input. Even if the user wants to create nested folder structure, user can specify the relative path, and the application takes care of creating the required folder structure.


	User is also provided the option to write content if they want into the newly created file.

	The application doesn’t restrict user to specify the exact filename to search/delete file/folder. They can specify the starting input, and the program searches all files/folder starting with the value and displays it. The user is then provided the option to select all files or to select a specific index to delete.

	The application also allows user to delete folders which are not empty. 

	The user is able to seamlessly switch between options or return to previous menu even after any required operation like adding, searching, deleting or retrieving of files is performed.

	When the option to retrieve files in ascending order is selected, user is displayed with two options of viewing the files. 

	Ascending order of folders first which have files sorted in them,
	Ascending order of all files and folders inside the “main” folder.

	The application is designed with modularity in mind. Even if one wants to update the path, they can change it through the source code. Application has been developed keeping in mind that there should be very less “hardcoding” of data.





### Number of sprints = 2 sprints (6 Day for 1 Sprint)

### Flow of the program
![Flowcharts(1)](https://user-images.githubusercontent.com/48864550/203711434-242de3cf-f3fa-4698-b311-2d87720a24ec.png)


### Conclusions:
Further enhancements to the application can be made which may include: 

1.	Conditions to check if user is allowed to delete the file or add the file at the specific locations.
2.	Asking user to verify if they really want to delete the selected directory if it’s not empty.
3.	Retrieving files/folders by different criteria like Last Modified, Type, etc.
4.	Allowing user to append data to the file.
