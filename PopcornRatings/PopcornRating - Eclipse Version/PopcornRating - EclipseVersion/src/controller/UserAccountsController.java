package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import connection.ConnectionFactory;
import dao.UserDAO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.User;


public class UserAccountsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button deleteButton;

    @FXML
    private Button editButton;

    @FXML
    private TextField emailField;

    @FXML
    private Button goButton;

    @FXML
    private Label messageLabel;

    @FXML
    private Button newButton;

    @FXML
    private TextField searchField;

    @FXML
    private TextField usernameField;


    @FXML
    void DeleteAccount(MouseEvent event) {
    	int delete = 0;
    	User u = new User();
    	
    	delete = JOptionPane.showConfirmDialog(null, "Are you sure about it?");
    	
    	if(delete == JOptionPane.YES_OPTION)
    	{
    		UserDAO dao = new UserDAO();
    		u.setUsername(usernameField.getText());
    		dao.delete(u);
    	}
    }

    @FXML
    void EditAccount(MouseEvent event) {
    }

    @FXML
    void NewAccount(MouseEvent event) {
    	try{
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/RegisterUser.fxml"));
	        AnchorPane pane = (AnchorPane) loader.load();
	        Stage stage = new Stage();
	        stage.setTitle("Register New User");
	        stage.setScene(new Scene(pane));
	        stage.show();
	 	}catch(IOException e){
	         JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
	 	}
    }

    @FXML
    void SearchAccount(MouseEvent event) {
    	ConnectionFactory conn = new ConnectionFactory();
    	conn.connectDatabase();
    	try{
    		Statement stmt = conn.con.createStatement();
    		String sql = "SELECT * FROM client";
    		ResultSet rs = stmt.executeQuery(sql);
    		
    		while(rs.next())
    		{
    			if(searchField.getText().equals(rs.getString("username"))){
    				usernameField.setText(rs.getString("username"));
    				emailField.setText(rs.getString("email"));
    			}
    		}
        	conn.closeDatabase();
        	rs.close();
        	stmt.close();
    	}catch (Exception e) {
	         JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
		}
    }

    @FXML
    void initialize() {
        assert deleteButton != null : "fx:id=\"deleteButton\" was not injected: check your FXML file 'UserAccounts.fxml'.";
        assert editButton != null : "fx:id=\"editButton\" was not injected: check your FXML file 'UserAccounts.fxml'.";
        assert emailField != null : "fx:id=\"emailField\" was not injected: check your FXML file 'UserAccounts.fxml'.";
        assert goButton != null : "fx:id=\"goButton\" was not injected: check your FXML file 'UserAccounts.fxml'.";
        assert messageLabel != null : "fx:id=\"messageLabel\" was not injected: check your FXML file 'UserAccounts.fxml'.";
        assert newButton != null : "fx:id=\"newButton\" was not injected: check your FXML file 'UserAccounts.fxml'.";
        assert searchField != null : "fx:id=\"searchField\" was not injected: check your FXML file 'UserAccounts.fxml'.";
        assert usernameField != null : "fx:id=\"usernameField\" was not injected: check your FXML file 'UserAccounts.fxml'.";
    }
}
