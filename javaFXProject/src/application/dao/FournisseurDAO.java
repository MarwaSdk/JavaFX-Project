package application.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import application.entities.Fournisseur;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FournisseurDAO {
	
	public static ObservableList<Fournisseur> searchFournisseurs() throws SQLException {
		ObservableList<Fournisseur> listFournisseur = FXCollections.observableArrayList();
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","");
		Statement stmt = con.createStatement();
		ResultSet result = stmt.executeQuery("SELECT * FROM fournisseur");
		while(result.next()) {
			 listFournisseur.add(new Fournisseur(result.getString("nom"),result.getString("adresse"),result.getString("telephone"),result.getString("email")));
		}
		System.out.println("result "+listFournisseur);

		return listFournisseur;
		
	}
	
	public static void insertFournisseur(Fournisseur fournisseur) throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","");
		PreparedStatement pstmt = con.prepareStatement("INSERT INTO fournisseur(nom,adresse,telephone,email) VALUES (?,?,?,?)");
		pstmt.setString(1, fournisseur.getNom());
		pstmt.setString(2, fournisseur.getAdresse());
		pstmt.setString(3, fournisseur.getTelephone());
		pstmt.setString(4, fournisseur.getEmail());
		pstmt.executeUpdate();
	}
	
	
	
	
}
