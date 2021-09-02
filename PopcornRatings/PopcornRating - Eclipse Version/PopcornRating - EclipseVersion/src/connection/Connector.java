package connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Movie;

public class Connector {

    static java.sql.Connection conn = null;
    static final String USER= "root";
    static final String PASS= "";
    static final String DB_URL= "jdbc:mysql://localhost/popcornrating";

    public static java.sql.Connection ConnectDb() {
        try {

            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);

             JOptionPane.showMessageDialog(null, "Connection Established!");

            return conn;

        } catch( Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    public static ObservableList<Movie> getMyMovies() {

        java.sql.Connection conn = ConnectDb();
        ObservableList<Movie> list = FXCollections.observableArrayList();

        try {
            PreparedStatement ps = conn.prepareStatement("Select * from movie");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Movie(Integer.parseInt(rs.getString("year")), rs.getString("title"), rs.getString("director"), rs.getString("starring")));
            }

        } catch (Exception e) {

        }
        return list;
    }

}
