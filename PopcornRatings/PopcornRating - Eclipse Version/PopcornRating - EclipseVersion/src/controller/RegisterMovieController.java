package controller;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import connection.ConnectionFactory;
import dao.MovieDAO;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Movie;


public class RegisterMovieController {

	Movie m = new Movie();
	MovieDAO dao = new MovieDAO();
    ConnectionFactory conn = new ConnectionFactory();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField directorField;

    @FXML
    private TextField genreField;

    @FXML
    private Button imageButton;

    @FXML
    private TextField lengthField;

    @FXML
    private ImageView noImageView;

    @FXML
    private TextField ratingField;

    @FXML
    private Button resetButton;

    @FXML
    private TextField starringField;

    @FXML
    private TextArea storyArea;

    @FXML
    private TextField titleField;

    @FXML
    private TextField yearField;


    @FXML
    void RegisterMovie(MouseEvent event) {
    	Movie m = new Movie();
    	MovieDAO dao = new MovieDAO();
    	
    	m.setTitle(titleField.getText());
    	m.setRating(Integer.parseInt(ratingField.getText()));
    	m.setLength(Integer.parseInt(lengthField.getText()));
    	m.setStarring(starringField.getText());
    	m.setDirector(directorField.getText());
    	m.setYear(Integer.parseInt(yearField.getText()));
    	m.setGenre(genreField.getText());
    	m.setStory_line(storyArea.getText());
    	
    	dao.registerMovie(m);
    }

    @FXML
    void Reset(MouseEvent event) {
        titleField.clear();
        ratingField.clear();
        lengthField.clear();
        starringField.clear();
        storyArea.clear();
        yearField.clear();
        genreField.clear();
        directorField.clear();
    }

    @FXML
    void SelectImage(MouseEvent event) {
    	FileChooser fileChooser = new FileChooser();
    	FileChooser.ExtensionFilter imageFilter = new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png");
    	fileChooser.getExtensionFilters().add(imageFilter);
    	File file = fileChooser.showOpenDialog(new Stage());
    	String filename = file.getAbsolutePath();    
    	if(file != null)
    	{
    		noImageView.setImage(new Image("file:///" + filename));
    	}
    	
    }

    @FXML
    void initialize() {
        assert directorField != null : "fx:id=\"directorField\" was not injected: check your FXML file 'RegisterMovie.fxml'.";
        assert genreField != null : "fx:id=\"genreField\" was not injected: check your FXML file 'RegisterMovie.fxml'.";
        assert imageButton != null : "fx:id=\"imageButton\" was not injected: check your FXML file 'RegisterMovie.fxml'.";
        assert lengthField != null : "fx:id=\"lengthField\" was not injected: check your FXML file 'RegisterMovie.fxml'.";
        assert noImageView != null : "fx:id=\"noImageView\" was not injected: check your FXML file 'RegisterMovie.fxml'.";
        assert ratingField != null : "fx:id=\"ratingField\" was not injected: check your FXML file 'RegisterMovie.fxml'.";
        assert resetButton != null : "fx:id=\"resetButton\" was not injected: check your FXML file 'RegisterMovie.fxml'.";
        assert starringField != null : "fx:id=\"starringField\" was not injected: check your FXML file 'RegisterMovie.fxml'.";
        assert storyArea != null : "fx:id=\"storyArea\" was not injected: check your FXML file 'RegisterMovie.fxml'.";
        assert titleField != null : "fx:id=\"titleField\" was not injected: check your FXML file 'RegisterMovie.fxml'.";
        assert yearField != null : "fx:id=\"yearField\" was not injected: check your FXML file 'RegisterMovie.fxml'.";


    }

}
