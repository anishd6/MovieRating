package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import connection.ConnectionFactory;
import dao.MovieListDAO;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Movie;
import model.MovieList;

public class HomeController {
	MovieList ml = new MovieList();
    MovieListDAO ml_dao = new MovieListDAO();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button deleteButton;

    @FXML
    private TextField director_movieField;

    @FXML
    private TextField genre_movieField;

    @FXML
    private TextField length_movieField;

    @FXML
    private ComboBox<String> rating_movieComboBox;

    @FXML
    private TextField rating_movieField;

    @FXML
    private Button search_movieButton;

    @FXML
    private TextField search_movieField;

    @FXML
    private TextField starring_movieField;

    @FXML
    private ComboBox<String> status_movieComboBox;

    @FXML
    private TextArea storyline_movieField;

    @FXML
    private Button submit_movieButton;

    @FXML
    private TextField title_movieField;

    @FXML
    private TabPane userTab;
    
    @FXML
    private Button movie_listButton;

    @FXML
    private TextField usernameField;

    @FXML
    private TextField year_movieField;

    @FXML
    private TableView<Movie> moviesTable;

    @FXML
    private TableColumn<Movie, String> titleColumn;

    @FXML
    private TableColumn<Movie, Integer> yearColumn;

    @FXML
    private TableColumn<Movie, String> genreColumn;
    
    ObservableList<Movie> obs;
    
    @FXML
    void MovieListClicked(MouseEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/MovieList.fxml"));
	        AnchorPane pane;
			pane = (AnchorPane) loader.load();
			Stage stage = new Stage();
	        stage.setScene(new Scene(pane));
	        stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Sorry, we could not open your movie list");
		}
          
    }

    @FXML
    void SearchMovie(MouseEvent event) {
    	ConnectionFactory conn = new ConnectionFactory();
    	conn.connectDatabase();
    	try{
    		Statement stmt = conn.con.createStatement();
    		String sql = "SELECT * FROM movie";
    		ResultSet rs = stmt.executeQuery(sql);
    		
    		while(rs.next())
    		{
    			if(search_movieField.getText().equals(rs.getString("title")))
    			{
    				title_movieField.setText(rs.getString("title"));
    				rating_movieField.setText(rs.getString("rating"));
    				starring_movieField.setText(rs.getString("starring"));
    				length_movieField.setText(rs.getString("length"));
    				storyline_movieField.setText(rs.getString("storyline"));
    				year_movieField.setText(rs.getString("year"));
    				genre_movieField.setText(rs.getString("genre"));
    				director_movieField.setText(rs.getString("director"));
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
    void SubmitMovieClicked(MouseEvent event) {
    	ml.setTitle(title_movieField.getText());
    	ml.setRating(rating_movieComboBox.getSelectionModel().getSelectedItem());
    	ml.setStatus(status_movieComboBox.getSelectionModel().getSelectedItem());
    	
        ml_dao.registerMovieList(ml);
    }

    @FXML
    void deleteClicked(MouseEvent event) {
    }
    
    @FXML    
    public void initialize() {       	
        status_movieComboBox.getItems().clear();
        status_movieComboBox.getItems().add("1 - Horrible");
        status_movieComboBox.getItems().add("2 - Average");
        status_movieComboBox.getItems().add("3 - Fine");
        status_movieComboBox.getItems().add("4 - Great");
        status_movieComboBox.getItems().add("5 - Masterpiece");
        
        rating_movieComboBox.getItems().clear();
        rating_movieComboBox.getItems().add("Plan to Watch");
        rating_movieComboBox.getItems().add("Completed");
        rating_movieComboBox.getItems().add("Watching");
    }
}
