package ba.bildit.BO;

import java.sql.SQLException;

import ba.bildit.DAO.UserDAOImplementation;
import ba.bildit.UI.InitialMenu;
import ba.bildit.main.Main;

public class RegistrationProcess {

	public static void registerProcess() throws SQLException {
		
		System.out.println("Enter your name: ");
		String name = Main.input.next();

		System.out.println("Enter your surname: ");
		String surname = Main.input.next();
		
		if (doesUserExists(name, surname)) {
			System.out.println("That user already exists!");
			InitialMenu.initialMenu();
		}
		
		System.out.println("Enter your password: ");
		String password = Main.input.next();
		
		createUser(name, surname, password);
		System.out.println("The user has been successfully created!");
		
		InitialMenu.initialMenu();
	}
	
	
	public static boolean doesUserExists(String name, String surname) throws SQLException {
		
		UserDAOImplementation accessUsers = new UserDAOImplementation();
		
		if (accessUsers.getUser(name, surname) == null)
			return false;
		
		return true;
		
	}
	
	public static void createUser(String name, String surname, String password) throws SQLException {
		
		UserDAOImplementation accessUsers = new UserDAOImplementation();
		
		accessUsers.addUser(name, surname, password);
		
	}

}
