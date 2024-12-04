package application;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import application.entities.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class HomeController {
	
	@FXML
	private Label bienvenue;
	
	@FXML
	private Label email;

	
	@FXML
	private Label dateNow;

	@FXML
	private MenuItem apropos;
	
	@FXML 
	private MenuItem addFournisseurBtn;
	
	@FXML
	private MenuItem fournisseurBtn;
	
	@FXML
	private MenuItem deconnexion;
	
	@FXML
	private MenuItem financeBtn;
	
	@FXML
	public void clickFinanceButton(ActionEvent event) throws IOException {
		if(event.getSource() == financeBtn) {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("finance.fxml"));
			Parent root = loader.load();

			try {
				// Get the current stage using any Node in the current scene
				MenuItem menuItem = (MenuItem) event.getSource(); // Get the triggering MenuItem
				Stage stage = (Stage) menuItem.getParentPopup().getOwnerNode().getScene().getWindow(); // Access the
																										// Scene via
																										// MenuItem's
																										// parent
				Scene scene = new Scene(root);
				stage.setScene(scene);
				stage.show();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	@FXML
	private void initialize() {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("EEEE dd/MM/yyyy 'à' HH:mm");
	    // Display the current username
	    User currentUser = Session.getCurrentUser();
	    bienvenue.setText("Bienvenue " + currentUser.getUsername() );
	    email.setText("Votre email : " + currentUser.getEmail() );
	    dateNow.setText("On est " + LocalDateTime.now().format(format));	    
	}
	
	@FXML 
	private void deconnexion(ActionEvent event) throws IOException {
		if(event.getSource()==deconnexion) {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
			Parent root = loader.load();

			try {
				MenuItem menuItem = (MenuItem) event.getSource(); // Get the triggering MenuItem
				Stage stage = (Stage) menuItem.getParentPopup().getOwnerNode().getScene().getWindow(); // Access the

				Scene scene = new Scene(root);
				stage.setScene(scene);
				stage.show();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	@FXML
	public void clickAddFournisseur(ActionEvent event) throws IOException {
		if (event.getSource() == addFournisseurBtn) {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Sample.fxml"));
			Parent root = loader.load();

			try {
				// Get the current stage using any Node in the current scene
				MenuItem menuItem = (MenuItem) event.getSource(); // Get the triggering MenuItem
				Stage stage = (Stage) menuItem.getParentPopup().getOwnerNode().getScene().getWindow(); // Access the
																										// Scene via
																										// MenuItem's
																										// parent
				Scene scene = new Scene(root);
				stage.setScene(scene);
				stage.show();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
	@FXML
	public void clickApropos(ActionEvent event) throws IOException {
		if (event.getSource() == apropos) {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("apropos.fxml"));
			Parent root = loader.load();

			try {
				// Get the current stage using any Node in the current scene
				MenuItem menuItem = (MenuItem) event.getSource(); // Get the triggering MenuItem
				Stage stage = (Stage) menuItem.getParentPopup().getOwnerNode().getScene().getWindow(); // Access the
																										// Scene via
																										// MenuItem's
																										// parent
				Scene scene = new Scene(root);
				stage.setScene(scene);
				stage.show();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
	
	@FXML
	public void switchBetweenScenes(ActionEvent event) throws IOException {
		if (event.getSource() == fournisseurBtn) {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Sample2.fxml"));
			Parent root = loader.load();

			try {
				// Get the current stage using any Node in the current scene
				MenuItem menuItem = (MenuItem) event.getSource(); // Get the triggering MenuItem
				Stage stage = (Stage) menuItem.getParentPopup().getOwnerNode().getScene().getWindow(); // Access the
																										// Scene via
																										// MenuItem's
																										// parent
				Scene scene = new Scene(root);
				stage.setScene(scene);
				stage.show();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
	

}
