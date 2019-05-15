package ba.bildit.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import ba.bildit.DTO.User;

public class UserDAOImplementation implements UserDAO {

	Connection connection = ConnectionManager.getInstance().getConnection();
	
	@Override
	public User getUser(Integer id) throws SQLException {
		
		User user = null;

		String query = "SELECT * FROM users WHERE id = ?";

		ResultSet rs = null;

		try (PreparedStatement statement = connection.prepareStatement(query);) {

			statement.setInt(1, id);

			rs = statement.executeQuery();

			if (rs.next()) {

				user = new User(rs.getInt("id"), rs.getString("name"),
						rs.getString("surname"), rs.getString("password"));

				rs.close();
			}
		}

		return user;
		
	}

	@Override
	public void addUser(String name, String surname, String password) throws SQLException {
		
		String query = "INSERT INTO users(name, surname, password) VALUES (?, ?, ?)";

		try (PreparedStatement statement = connection.prepareStatement(query);) {

			statement.setString(1, name);
			statement.setString(2, surname);
			statement.setString(3, password);

			statement.executeUpdate();

		}
	}
		
	}


