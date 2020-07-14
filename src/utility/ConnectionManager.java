package utility;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager{
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("oracle.jdbc.OracleDriver");
		
		Connection con = null;
		
		con = DriverManager.getConnection("jdbc:oracle:thin:system/Amudhan.123@localhost:1521:orcle");
		if(con!=null) {
			System.out.println("Established");
		}
		return con;
	}
	
	public static Properties loadPropertiesFile() throws IOException {
		Properties prop = new Properties();	
		InputStream in = ConnectionManager.class.getClassLoader().getResourceAsStream("jdbc.properties");
		prop.load(in);
		in.close(); 
		return prop;
	}
}

