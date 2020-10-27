package application;
import java.sql.*;
public class jdbc
{
	public static Connection getConnection() throws Exception
	{
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Airline","root","password");
		return con;
	}
}