package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import connection.ConnectionFactory;
import model.MovieList;

public class MovieListDAO {
	ConnectionFactory conn = new ConnectionFactory();	
	PreparedStatement stmt;

	public void registerMovieList(MovieList ml)
	{
		conn.connectDatabase();
		
		try{
			stmt = conn.con.prepareStatement("INSERT INTO movie_list (title, rating, status) VALUES (?,?,?)");

			stmt.setString(1, ml.getTitle());
			stmt.setString(2, ml.getRating());
			stmt.setString(3, ml.getStatus());
			
			stmt.execute();
			
			JOptionPane.showMessageDialog(null, "Great, " + ml.getTitle() +" is part of " + ml.getStatus());
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e , "Registration Error",JOptionPane.ERROR_MESSAGE);
			} 
			conn.closeDatabase();	
	}
	
	public void delete (MovieList ml){
		String sql = "DELETE FROM movie_list WHERE title = ? AND username = ?";
		
		try{
			stmt = conn.con.prepareStatement(sql);
			stmt.setString(1, ml.getTitle());
			stmt.setString(2, ml.getTitle());
			stmt.execute();
						
		}catch (SQLException e){
			JOptionPane.showMessageDialog(null, e , "Registration Error",JOptionPane.ERROR_MESSAGE);
		}
	}
}