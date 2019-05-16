package ba.bildit.DTO;

public class UserBuilder {

	private Integer id;
	private String name;
	private String surname;
	private String password;
	
	public UserBuilder(int id) {
		this.id = id;
	}
	
	public UserBuilder withName(String name) {
		this.name = name;
		return this;
	}
	
	public UserBuilder withSurname(String surname) {
		this.surname = surname;
		return this;
	}
	
	public UserBuilder withPassword(String password) {
		this.password = password;
		return this;
	}
	
	 public User build(){
         User user = new User();  
         user.setId(this.id);
         user.setName(this.name);
         user.setSurname(this.surname);
         user.setPassword(password);
         return user;
     }
	
}
