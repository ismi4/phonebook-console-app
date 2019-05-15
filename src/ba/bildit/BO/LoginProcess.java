package ba.bildit.BO;

import java.sql.SQLException;

import ba.bildit.DAO.UserDAOImplementation;
import ba.bildit.DTO.User;
import ba.bildit.UI.InitialMenu;
import ba.bildit.UI.MainMenu;
import ba.bildit.main.Main;

public class LoginProcess {

	public static void loginProcess() throws SQLException {

		System.out.println("Enter your name: ");
		String name = Main.input.next();

		System.out.println("Enter your surname: ");
		String surname = Main.input.next();

		User currentUser = findUser(name, surname);

		if (currentUser == null) {
			System.out.println("There is not an existing user with entered name and surname!");
			InitialMenu.initialMenu();
		}
			
		System.out.println("Enter password: ");
		String password = Main.input.next();

		if (isPasswordValid(currentUser, password)) {
			MainMenu mainMenu = new MainMenu(currentUser);
			mainMenu.mainMenu();
		} else
			System.out.println("Entered password is not valid!");

		InitialMenu.initialMenu();
	}

	public static User findUser(String name, String surname) throws SQLException {

		UserDAOImplementation accessUsers = new UserDAOImplementation();
		return accessUsers.getUser(name, surname);

	}

	public static boolean isPasswordValid(User user, String enteredPassword) {

		if (user.getPassword().equals(enteredPassword))
			return true;

		return false;
	}

}
