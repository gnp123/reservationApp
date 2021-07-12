package OOP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {
	
	 static String url="jdbc:sqlserver://194.141.98.98;databaseName=db1901262015";
	    static String user="stu1901262015";
	    static String password="AndreyTonev1901";

	    static Connection connect=null;

	    static Connection getConnection() {

	        {
	            try {
	            	try {
						Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	                connect = DriverManager.getConnection(url, user, password);

	                System.out.println("Connected to MSSQL");
	            } catch (SQLException throwables) {
	                System.out.println("Something is wrong!!!");
	                throwables.printStackTrace();
	            }
	        }
	        return connect;
	    }

}
