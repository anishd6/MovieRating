package controller;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import connection.ConnectionFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;


public class MovieListController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button deleteButton;

    @FXML
    private Button editButton;

    @FXML
    private Button goButton;

    @FXML
    private ComboBox<String> ratingComboBox;

    @FXML
    private Button saveButton;

    @FXML
    private TextField searchField;

    @FXML
    private ComboBox<String> statusComboBox;


    @FXML
    void DeleteMovieList(MouseEvent event) {
    }

    @FXML
    void EditMovieList(MouseEvent event) {
        statusComboBox.getItems().clear();
        statusComboBox.getItems().add("1 - Horrible");
        statusComboBox.getItems().add("2 - Average");
        statusComboBox.getItems().add("3 - Fine");
        statusComboBox.getItems().add("4 - Great");
        statusComboBox.getItems().add("5 - Masterpiece");
        
        ratingComboBox.getItems().clear();
        ratingComboBox.getItems().add("Plan to Watch");
        ratingComboBox.getItems().add("Completed");
        ratingComboBox.getItems().add("Watching");
    }

    @FXML
    void SaveMovieList(MouseEvent event) {
    }

    @FXML
    void SearchMovie(MouseEvent event) {
    	ConnectionFactory conn = new ConnectionFactory();
    	conn.connectDatabase();
    	try{
    		Statement stmt = conn.con.createStatement();
    		String sql = "SELECT * FROM movie_list";
    		ResultSet rs = stmt.executeQuery(sql);
    		
    		while(rs.next())
    		{
    			if(searchField.getText().equals(rs.getString("title")))
    			{
    				ratingComboBox.setValue(rs.getString("rating"));
    				statusComboBox.setValue(rs.getString("status"));
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
        ratingComboBox.getItems().clear();
        statusComboBox.getItems().clear();
    }
}
