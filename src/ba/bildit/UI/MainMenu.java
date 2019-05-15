package ba.bildit.UI;

import java.sql.SQLException;

import ba.bildit.DAO.ContactDAOImplementation;
import ba.bildit.DAO.UserDAOImplementation;
import ba.bildit.DTO.Contact;
import ba.bildit.DTO.Phonebook;
import ba.bildit.DTO.User;
import ba.bildit.main.Main;

public class MainMenu {

	private User currentUser;
	private Phonebook currentPhonebook;
	
	public MainMenu(User currentUser) {
		this.currentUser = currentUser;
	}
	
	public void mainMenu() {
		
		init();
		
		System.out.println("1. Add new contact");
		System.out.println("2. Edit existing contact");
		System.out.println("3. Delete existing contact");
		System.out.println("4. List all contacts");
		System.out.println("5. Search by name");
		System.out.println("6. Search by surname");
		System.out.println("7. Search by phone number");
		System.out.println("8. Log out");
		
		int menu = 0;

		while ((menu != 1 && menu != 2 && menu != 3 && menu != 4 && menu != 5 && menu != 6 && menu != 7 && menu != 8))
			menu = Main.intInput();

		if (menu == 1)
			addNewContact();
		else if (menu == 2)
			editExistingContact();
		else if (menu == 3)
			deleteExistingContact();
		else if (menu == 4)
			listAllContacts();
		else if (menu == 5)
			searchByName();
		else if (menu == 6)
			searchBySurname();
		else if (menu == 7)
			searchByPhoneNumber();
		else if (menu == 8)
			logOut();
		
	}
	
	public void addNewContact() {
		
		System.out.println("Name: ");
		String name = Main.input.next();
		
		System.out.println("Surname: ");
		String surname = Main.input.next();
		
		System.out.println("Phone number: ");
		int phoneNumber = Main.intInput();
		
		ContactDAOImplementation accessContacts = new ContactDAOImplementation();
		try {
			accessContacts.addContact(currentUser.getId(), name, surname, phoneNumber);
			System.out.println("New contact has been successfully added!");
		} catch (SQLException e) {
			System.out.println("There was an issue while trying to add new contact!");
		}
		
		mainMenu();
	}
	
	public void editExistingContact() {
		
		System.out.println("Enter phone number of the contact you want to edit: ");
		int phoneNumberForEditing = Main.intInput();

		System.out.println("Enter new name: ");
		String newName = Main.input.next();
		
		System.out.println("Enter new surname: ");
		String newSurname = Main.input.next();
		
		System.out.println("Enter new phone number: ");
		int newPhoneNumber = Main.intInput();
		
		ContactDAOImplementation accessContacts = new ContactDAOImplementation();
		try {
			accessContacts.editContact(currentUser.getId(), newName, newSurname, newPhoneNumber, phoneNumberForEditing);
		} catch (SQLException e) {
			System.out.println("There was an issue while trying to edit contact!");
		}
		
		mainMenu();
		
	}
	
	public void deleteExistingContact() {
		
		System.out.println("Enter phone number of the contact you want to delete: ");
		int phoneNumberForDeleting = Main.intInput();
		
		ContactDAOImplementation accessContacts = new ContactDAOImplementation();
		
		try {
			accessContacts.deleteContact(currentUser.getId(), phoneNumberForDeleting);
		} catch (SQLException e) {
			System.out.println("There was an issue while trying to delete contact!");
		}
		
		mainMenu();
	}
	
	public void listAllContacts() {
		
		for(Contact c : currentPhonebook.getContacts()) 
			System.out.println(c.toString());
		
		mainMenu();
	}
	
	public void searchByName() {
		
		System.out.println("Name you are searching for: ");
		String nameForSearching = Main.input.next();
		
		for(Contact c : currentPhonebook.getContacts()) 
			if (c.getName().equals(nameForSearching))
			System.out.println(c.toString());
		
		mainMenu();
	}
	
	public void searchBySurname() {
		
		System.out.println("Surname you are searching for: ");
		String surnameForSearching = Main.input.next();
		
		for(Contact c : currentPhonebook.getContacts()) 
			if (c.getSurname().equals(surnameForSearching))
			System.out.println(c.toString());
		
		mainMenu();
		
	}
	
	public void searchByPhoneNumber() {
		
		System.out.println("Phone number you are searching for: ");
		int phonenumberForSearching = Main.intInput();
		
		for(Contact c : currentPhonebook.getContacts()) 
			if (c.getPhoneNumber() == phonenumberForSearching)
			System.out.println(c.toString());
	
		mainMenu();
	}
	
	public void logOut() {
		InitialMenu.initialMenu();
	}
	
	public void init() {
		UserDAOImplementation accessUsers = new UserDAOImplementation();
		try {
			currentPhonebook = new Phonebook(currentUser.getId(), 
					accessUsers.retrieveContactsIntoList(currentUser.getId()) );
		} catch (SQLException e) {
			System.out.println("There was an issues while logging you in!");
		}
	}
	
}
