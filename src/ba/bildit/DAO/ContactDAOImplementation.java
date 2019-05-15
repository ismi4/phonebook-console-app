package ba.bildit.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import ba.bildit.DTO.Contact;

public class ContactDAOImplementation implements ContactDAO {

	Connection connection = ConnectionManager.getInstance().getConnection();

	@Override
	public Contact getContact(int id, int phoneNumber) throws SQLException {

		Contact contact = null;

		String query = "SELECT * FROM contacts WHERE id = ? AND phonenumber = ?";

		ResultSet rs = null;

		try (PreparedStatement statement = connection.prepareStatement(query);) {

			statement.setInt(1, id);
			statement.setInt(2, phoneNumber);

			rs = statement.executeQuery();

			if (rs.next()) {

				contact = new Contact(rs.getInt("id"), rs.getString("name"), rs.getString("surname"),
						rs.getInt("phonenumber"));

				rs.close();
			}
		}

		return contact;

	}

	@Override
	public void addContact(int id, String name, String surname, int phoneNumber) throws SQLException {

		String query = "INSERT INTO contacts(name, surname, phonenumber, id) VALUES (?, ?, ?, ?)";

		try (PreparedStatement statement = connection.prepareStatement(query);) {

			statement.setString(1, name);
			statement.setString(2, surname);
			statement.setInt(3, phoneNumber);
			statement.setInt(4, id);
			
			statement.executeUpdate();

		}

	}

	@Override
	public void editContact(int id, String newName, String newSurname, int newPhoneNumber, int phoneNumber) throws SQLException {

		String query = "UPDATE contacts SET name = ?, surname = ? phonenumber = ? WHERE id = ? AND WHERE phonenumber = ?";

		try (PreparedStatement statement = connection.prepareStatement(query);) {

			statement.setString(1, newName);
			statement.setString(2, newSurname);
			statement.setInt(3, newPhoneNumber);
			statement.setInt(4, id);
			statement.setInt(5, phoneNumber);

			statement.executeUpdate();

		}

	}

	@Override
	public void deleteContact(int id, int phoneNumber) throws SQLException {

		String query = "DELETE FROM contacts? WHERE id = ?";

		try (PreparedStatement statement = connection.prepareStatement(query);) {

			statement.setInt(1, id);

			statement.executeUpdate();

		}

	}

}
