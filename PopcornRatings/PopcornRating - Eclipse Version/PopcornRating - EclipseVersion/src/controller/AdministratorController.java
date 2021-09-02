package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class AdministratorController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button moviesButton;

    @FXML
    private Button register_movieButton;

    @FXML
    private Button register_showButton;

    @FXML
    private Button showButton;

    @FXML
    private Button usersButton;

    @FXML
    void listMovies(MouseEvent event) {
    	try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/AdministratorMovieList.fxml"));
            AnchorPane pane = (AnchorPane) loader.load();
            Stage stage = new Stage();
            stage.setTitle("Registered Movie");
            stage.setScene(new Scene(pane));
            stage.show();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @FXML
    void manageUsers(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/UserAccounts.fxml"));
            AnchorPane pane = (AnchorPane) loader.load();
            Stage stage = new Stage();
            stage.setTitle("Registered Users");
            stage.setScene(new Scene(pane));
            stage.show();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @FXML
    void registerMovie(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/RegisterMovie.fxml"));
            AnchorPane pane = (AnchorPane) loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(pane));
            stage.show();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @FXML
    void initialize() {
        assert moviesButton != null : "fx:id=\"moviesButton\" was not injected: check your FXML file 'Administrator.fxml'.";
        assert register_movieButton != null : "fx:id=\"register_movieButton\" was not injected: check your FXML file 'Administrator.fxml'.";
        assert register_showButton != null : "fx:id=\"register_showButton\" was not injected: check your FXML file 'Administrator.fxml'.";
        assert showButton != null : "fx:id=\"showButton\" was not injected: check your FXML file 'Administrator.fxml'.";
        assert usersButton != null : "fx:id=\"usersButton\" was not injected: check your FXML file 'Administrator.fxml'.";
    }
}
