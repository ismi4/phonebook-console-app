package ba.bildit.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import ba.bildit.DTO.Contact;
import ba.bildit.DTO.User;


public interface UserDAO {

	public User getUser(String name, String surname) throws SQLException;

	public void addUser(String name, String surname, String password) throws SQLException;
	
	public ArrayList<Contact> retrieveContactsIntoList(int id) throws SQLException;
	
}
