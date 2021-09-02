package controller;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import connection.Connector;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Movie;


public class AdministratorMoviListController implements Initializable{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView <Movie> table_movie;
    
    @FXML
    private TableColumn<Movie,String> col_director;

    @FXML
    private TableColumn<Movie, String> col_starring;

    @FXML
    private TableColumn<Movie, String> col_title;

    @FXML
    private TableColumn<Movie, Integer> col_year;

    
    ObservableList<Movie> listM;
    ObservableList<Movie> dataList;

    int index = -1;

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO Auto-generated method stub
        col_title.setCellValueFactory(new PropertyValueFactory<Movie,String>("title"));
        col_director.setCellValueFactory(new PropertyValueFactory<Movie, String>("director") );
        col_year.setCellValueFactory(new PropertyValueFactory<Movie, Integer>("year") );
        col_starring.setCellValueFactory(new PropertyValueFactory<Movie, String>("starring") );
        
        listM = Connector.getMyMovies(); 
        table_movie.setItems(listM);
	}
}
