package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Label;
import connection.*;
import dao.UserDAO;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;
import model.User;

public class RegisterUserController {
	
    User u = new User();
    UserDAO dao = new UserDAO();
    ConnectionFactory conn = new ConnectionFactory();
	
    @FXML
    private ResourceBundle resources;
    
    @FXML
    private Label messageLabel;

    @FXML
    private URL location;

    @FXML
    public ComboBox <String> comboBox;
    
    @FXML
    private Button registerButton;
    
    @FXML
    private PasswordField confirm_passwordField;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField usernameField;
    
    @FXML
    private TextField answerField;
    
    @FXML
    void registerClicked(MouseEvent event) {
        
        String password, confirm;
        
        password = passwordField.getText();
        confirm = confirm_passwordField.getText();
        
        if(confirm.equals(password))
        {
            u.setUsername(usernameField.getText());
            u.setPassword(passwordField.getText());
            u.setConfirm_password(confirm_passwordField.getText());
            u.setEmail(emailField.getText());
            u.setSecurity_question((comboBox.getSelectionModel().getSelectedItem()));
            u.setSecurity_answer(answerField.getText());
            dao.register(u); 
        }
        else{
            JOptionPane.showMessageDialog(null, "Password does not match", "Registration Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    @FXML
    void initialize() {
        comboBox.getItems().clear();
        comboBox.getItems().add("What's dog's name?");
        comboBox.getItems().add("What's your favorite movie?");
        comboBox.getItems().add("What's your lucky number?");
    } 
}
