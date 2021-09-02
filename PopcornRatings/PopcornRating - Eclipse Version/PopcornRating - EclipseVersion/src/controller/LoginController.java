package controller;

import connection.ConnectionFactory;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class LoginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button loginButton;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button resetButton;

    @FXML
    private Label signLabel;

    @FXML
    private TextField usernameField;

    @FXML
    void LoginClicked(MouseEvent event) {
        ConnectionFactory conn = new ConnectionFactory();
    	PreparedStatement stmt = null;
    	conn.connectDatabase();
    
        String sql = "SELECT * FROM client WHERE username = ? AND password = ?";
    	
        try{
            stmt = conn.con.prepareStatement(sql);
            stmt.setString(1, usernameField.getText());
            stmt.setString(2, passwordField.getText());
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()){	
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Home.fxml"));
                AnchorPane pane = (AnchorPane) loader.load();
                Stage stage = new Stage();
                stage.setTitle("Welcome to Popcorn Rating");
    			  stage.setScene(new Scene(pane));
    			  stage.show();
            }
            else{
                if(usernameField.getText().equals("admin") && passwordField.getText().equals("password")){
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Administrator.fxml"));
                    AnchorPane pane = (AnchorPane) loader.load();
                    Stage stage = new Stage();
                    stage.setTitle("Administrator Access");
                    stage.setScene(new Scene(pane));
                    stage.show();
    		}
    		else{
                    JOptionPane.showMessageDialog(null, "Invalid Username and/or Password","Login Error",JOptionPane.ERROR_MESSAGE);
    		}
            }
    	}catch(Exception e){
    		JOptionPane.showMessageDialog(null, e , "Error",JOptionPane.ERROR_MESSAGE);
    	}
    	conn.closeDatabase();
    }

    @FXML
    void ResetClicked(MouseEvent event) {
        usernameField.clear();
        passwordField.clear();
    }

    @FXML
    void SignClicked(MouseEvent event)  {
        try{
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/RegisterUser.fxml"));
                AnchorPane pane = (AnchorPane) loader.load();
                Stage stage = new Stage();
                stage.setTitle("Register New User");
                stage.setScene(new Scene(pane));
                stage.show();
            
    	}catch(Exception e){
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
    	}
    }
    
    @FXML
    void initialize() {
        assert loginButton != null : "fx:id=\"loginButton\" was not injected: check your FXML file 'Login.fxml'.";
        assert passwordField != null : "fx:id=\"passwordField\" was not injected: check your FXML file 'Login.fxml'.";
        assert resetButton != null : "fx:id=\"resetButton\" was not injected: check your FXML file 'Login.fxml'.";
        assert signLabel != null : "fx:id=\"signLabel\" was not injected: check your FXML file 'Login.fxml'.";
        assert usernameField != null : "fx:id=\"usernameField\" was not injected: check your FXML file 'Login.fxml'.";
    }
}
