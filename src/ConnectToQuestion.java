import java.sql.*;

import javax.swing.*;

public class ConnectToQuestion {
	

	public static Connection ConnectToQues()
	{
		
		try
		{
		
			 Class.forName("org.sqlite.JDBC");
			// String db = "jdbc:odbc:C:\\Users\\choprv1\\Documents\\Admin-Normal_User1";
			 Connection con = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\choprv1\\Documents\\Questions.sqlite");
			    
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
