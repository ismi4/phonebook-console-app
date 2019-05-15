package ba.bildit.DAO;

import java.sql.SQLException;

import ba.bildit.DTO.Contact;


public interface ContactDAO {
	
	public Contact getContact(int id, int phoneNumber) throws SQLException;

	public void addContact(int id, String name, String surname, int phoneNumber) throws SQLException;
	
	public void editContact(int id, String newName, String newSurname, int newPhoneNumber, int phoneNumber) throws SQLException;
	
	public void deleteContact(int id, int phoneNumber) throws SQLException;

}
