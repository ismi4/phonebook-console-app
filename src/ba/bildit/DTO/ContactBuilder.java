package ba.bildit.DTO;

public class ContactBuilder {

	private Integer id;
	private String name;
	private String surname;
	private Integer phoneNumber;
	
	public ContactBuilder(int id) {
		this.id = id;
	}
	
	public ContactBuilder withName(String name) {
		this.name = name;
		return this;
	}
	
	public ContactBuilder withSurname(String surname) {
		this.surname = surname;
		return this;
	}
	
	public ContactBuilder withPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
		return this;
	}
	
	public Contact build(){
        Contact contact = new Contact();  
        contact.setId(this.id);
        contact.setName(this.name);
        contact.setSurname(this.surname);
        contact.setPhoneNumber(this.phoneNumber);
        return contact;
    }
	
}
