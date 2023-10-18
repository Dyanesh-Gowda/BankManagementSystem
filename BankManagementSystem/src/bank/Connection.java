package bank;


import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connection {
	java.sql.Connection c;
	Statement s;
	public Connection() {
		try {
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/signup","root","Dyanesh@123");
			s=c.createStatement();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		// TODO Auto-generated constructor stub
	}

}
