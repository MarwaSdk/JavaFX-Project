/**
 * 
 */
package application;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import application.dao.FournisseurDAO;
import application.entities.Fournisseur;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * 
 */
public class FournisseursController {

	@FXML
	private MenuItem fournisseurBtn;

	@FXML
	private MenuItem apropos;

	@FXML
	private Button ajouterBtn;

	@FXML
	private TextField name;

	@FXML
	private TextField adresse;

	@FXML
	private TextField telephone;

	@FXML
	private TextField email;

	@FXML
	private MenuItem addFournisseurBtn;

	@FXML
	private MenuItem deconnexion;

	@FXML
	private Label messageLabel;
	
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

	@FXML
	public void clickAddFournisseur(ActionEvent event) throws IOException {
		if (event.getSource() == fournisseurBtn) {
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
		if (event.getSource() == deconnexion) {
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
	private void ajouterFournisseurs(ActionEvent event) throws SQLException {
		if (event.getSource() == ajouterBtn) {
			
				if (!name.getText().isEmpty() && !adresse.getText().isEmpty() && !telephone.getText().isEmpty()
						&& !email.getText().isEmpty()) {
					Fournisseur fournisseur = new Fournisseur(name.getText(), adresse.getText(), telephone.getText(),
							email.getText());

					FournisseurDAO.insertFournisseur(fournisseur);
					name.setStyle(null);
					name.clear();
					adresse.setStyle(null);
					adresse.clear();
					telephone.setStyle(null);
					telephone.clear();
					email.setStyle(null);
					email.clear();
					messageLabel.setTextFill(javafx.scene.paint.Color.GREEN);
					messageLabel.setText("Fournisseur ajouter avec success");
					messageLabel.setVisible(true);
				} else {
					messageLabel.setTextFill(javafx.scene.paint.Color.RED);
					messageLabel.setText("Veuillez remplir tous les champs obligatoires !");
					messageLabel.setVisible(true);
					if (name.getText().isEmpty()) {
						name.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
					}else {
						name.setStyle(null);

					}
					if (adresse.getText().isEmpty()) {
						adresse.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
					}else {
						adresse.setStyle(null);
					}
					if (telephone.getText().isEmpty()) {
						telephone.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
					}else {
						telephone.setStyle(null);
					}
					if (email.getText().isEmpty()) {
						email.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
					}else {
						email.setStyle(null);
					}

				}

			

		}

	}

}
