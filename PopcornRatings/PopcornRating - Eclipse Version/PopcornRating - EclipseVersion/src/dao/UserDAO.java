package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import connection.ConnectionFactory;
import model.User;

public class UserDAO{
	ConnectionFactory conn = new ConnectionFactory();
	User u = new User();

	public void register(User u){
		conn.connectDatabase();
		
		try{
			PreparedStatement stmt = conn.con.prepareStatement("INSERT INTO client (username, password, confirm_password, email, security_answer, security_question) VALUES (?,?,?,?,?,?)");
	
			stmt.setString(1, u.getUsername());
			stmt.setString(2, u.getPassword());
			stmt.setString(3, u.getConfirm_password());
			
			stmt.setString(4, u.getEmail());
			stmt.setString(5, u.getSecurity_answer());			
			stmt.setString(6, u.getSecurity_question());
			stmt.execute();
			
			JOptionPane.showMessageDialog(null, "Great, You are registered!");
    	
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e , "Registration Error",JOptionPane.ERROR_MESSAGE);
		}
		conn.closeDatabase();
	}
	
	public void delete(User u)
	{
    	conn.connectDatabase();
    	
    	try{
    		PreparedStatement stmt = conn.con.prepareStatement("DELETE FROM client WHERE username = ?");
    		stmt.setString(1, u.getUsername());
    		stmt.execute();
			JOptionPane.showMessageDialog(null, u.getUsername() + " was deleted sucessefully!");
    	}catch (Exception e) {
			JOptionPane.showMessageDialog(null, e , "Registration Error",JOptionPane.ERROR_MESSAGE);
		}
    	conn.closeDatabase();
	}
}

