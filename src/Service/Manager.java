package Service;
import java.sql.*;
public class Manager {
	public static Connection getconnexion(){
		Connection cn=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/reporting","root","");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return cn;
	}

}
