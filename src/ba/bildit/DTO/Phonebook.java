package ba.bildit.DTO;

import java.util.ArrayList;

public class Phonebook {

	private Integer id;
	private ArrayList<Contact> contacts;
	
	public Phonebook() {
		
	}
	
	public Phonebook(Integer id, ArrayList<Contact> contacts) {
		this.id = id;
		this.contacts = contacts;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ArrayList<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(ArrayList<Contact> contacts) {
		this.contacts = contacts;
	}
	
}
