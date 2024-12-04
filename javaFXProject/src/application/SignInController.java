package application;

import java.io.IOException;
import java.sql.SQLException;

import application.dao.UserDAO;
import application.entities.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SignInController {
	
	@FXML
	private TextField email;
	
	@FXML
	private PasswordField password;
	
	@FXML
	private Button signInBtn;
	
	@FXML 
	private Label errorLabel;
	
	@FXML
	public void signIn(ActionEvent event) throws SQLException, IOException {
		if(event.getSource()==signInBtn) {
			User user = new User(email.getText(),password.getText());
			if(UserDAO.searchFournisseurs(user) != null) {
				Session.setCurrentUser(UserDAO.searchFournisseurs(user));
				FXMLLoader loader = new FXMLLoader(getClass().getResource("home.fxml"));
				Parent root = loader.load();

				try {
				    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
					Scene scene = new Scene(root);
					stage.setScene(scene);
					stage.show();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else {
				email.clear();
				password.clear();
				errorLabel.setVisible(true);
				
			}
		}
	}
	

}
