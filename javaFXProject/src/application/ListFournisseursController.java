package application;

import java.io.IOException;
import java.sql.SQLException;

import application.dao.FournisseurDAO;
import application.entities.Fournisseur;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ListFournisseursController {
	
	
	
	@FXML
	private TableView<Fournisseur> fournisseurTable;

	@FXML
	private TableColumn<Fournisseur, String> nomColumn;

	@FXML
	private TableColumn<Fournisseur, String> adresseColumn;

	@FXML
	private TableColumn<Fournisseur, String> telephoneColumn;

	@FXML
	private TableColumn<Fournisseur, String> emailColumn;
	
	@FXML
	private MenuItem apropos;
	
	@FXML 
	private MenuItem addFournisseurBtn;
	
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
	    System.out.println("Initializing table...");
		nomColumn.setCellValueFactory(new PropertyValueFactory<>("nom"));
		adresseColumn.setCellValueFactory(new PropertyValueFactory<>("adresse"));
		telephoneColumn.setCellValueFactory(new PropertyValueFactory<>("telephone"));
		emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
		
		ObservableList<Fournisseur> fournisseursList;
		try {
			fournisseursList = FournisseurDAO.searchFournisseurs();
			System.out.println("hjvj "+fournisseursList);
			if (fournisseursList.isEmpty()) {
	            System.out.println("No fournisseurs found in the database.");
	        }
			fournisseurTable.setItems(fournisseursList);
		} catch (SQLException e) {
			e.printStackTrace();
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


}
