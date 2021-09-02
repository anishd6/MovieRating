package connection;

import java.sql.*;

import javax.swing.JOptionPane;

public class ConnectionFactory {

	public Statement stmt;
	public ResultSet rs;
	public Connection con;

//	static final String DRIVER = "org.postgresql.Driver";
//	static final String URL = "jdbc:postgresql://localhost/popcornrating";
//	static final String USER = "postgres"; 
//	static final String PASS = "DarkMagician25"; 
	
	static final String DRIVER= "com.mysql.jdbc.Driver"; 
    static final String URL= "jdbc:mysql://localhost/popcornrating";
    static final String USER= "root";
    static final String PASS= "";

	public void connectDatabase()
	{	
		try{
			Class.forName(DRIVER);
			JOptionPane.showMessageDialog(null, "Connecting to database...");
			con = DriverManager.getConnection(URL,USER,PASS);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e , "Connection Error",JOptionPane.ERROR_MESSAGE);
		}	
	}
	public void closeDatabase()
	{
		try{
			con.close();
			JOptionPane.showMessageDialog(null, "Disconnected");
		}catch(SQLException e)
		{
			JOptionPane.showMessageDialog(null, e , "Connection Error",JOptionPane.ERROR_MESSAGE);
		}
	}
}
