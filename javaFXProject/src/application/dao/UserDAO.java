package application.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import application.entities.User;

public class UserDAO {

	public static User searchFournisseurs(User user) throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","");
		PreparedStatement pstmt = con.prepareStatement("SELECT * FROM platformusers WHERE email=? AND password=?");
		pstmt.setString(1, user.getEmail());
		pstmt.setString(2, user.getPassword());
		ResultSet result = pstmt.executeQuery();
		if(result.next()) {
			return new User(result.getString("username"),result.getString("password"),result.getString("email"),result.getString("telephone"));
		}
		return null;
		
	}
	
	
}
