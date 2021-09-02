package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import connection.ConnectionFactory;
import model.Movie;

public class MovieDAO {
	ConnectionFactory conn = new ConnectionFactory();	
	PreparedStatement stmt;

	public void registerMovie(Movie m)
	{
		conn.connectDatabase();
		
		try{
			stmt = conn.con.prepareStatement("INSERT INTO movie (title, rating, director, year, length, storyline, genre, starring) VALUES (?,?,?,?,?,?,?,?)");

			stmt.setString(1,m.getTitle());
			stmt.setInt(2, m.getRating());
			stmt.setString(3, m.getDirector());
			stmt.setInt(4, m.getYear());
			stmt.setInt(5, m.getLength());
			stmt.setString(6, m.getStory_line());
			stmt.setString(7, m.getGenre());
			stmt.setString(8, m.getStarring());
			
			stmt.execute();
			
			JOptionPane.showMessageDialog(null, "Great, " + m.getTitle() +" registered!");
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e , "Registration Error",JOptionPane.ERROR_MESSAGE);
			} 
			conn.closeDatabase();	
	}
	
	public boolean delete (Movie m){
		String sql = "DELETE FROM movie WHERE title = ?";
		
		try{
			stmt = conn.con.prepareStatement(sql);
			stmt.setString(1, m.getTitle());
			stmt.execute();
			
			return true;
			
		}catch (SQLException e){
			JOptionPane.showMessageDialog(null, e , "Registration Error",JOptionPane.ERROR_MESSAGE);
		}
		return false;
	}
}
