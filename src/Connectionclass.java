import java.sql.*;

import javax.swing.*;


public class Connectionclass {
	
	public static Connection Connect()
	{
		//Connection con = null;
		try
		{
		
			 Class.forName("org.sqlite.JDBC");
			// String db = "jdbc:odbc:C:\\Users\\choprv1\\Documents\\Admin-Normal_User1";
			 Connection con = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\choprv1\\Documents\\Users.sqlite");
			//	st = con.createStatement();										
			// JOptionPane.showMessageDialog(null,"Connection established");     
		return con;
		}	
		
		catch(Exception ex)
		{
			
			 System.out.println(ex);
			 JOptionPane.showMessageDialog(null, ex);
			 return null;
		}
		
		
		
		
	}

}
