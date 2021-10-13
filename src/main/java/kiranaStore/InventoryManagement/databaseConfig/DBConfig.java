package kiranaStore.InventoryManagement.databaseConfig;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
public class DBConfig {
	private Connection con;
	private static DBConfig dbconfig;
	private DBConfig(){
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	}catch(ClassNotFoundException e) {
		System.out.println(e);
	}
	try {
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/InventorySystem","root","Shaurya@1709");
	}catch(SQLException e) {
		System.out.println(e);
	}
	}
	public static DBConfig getDBConfig() {
		if(dbconfig==null) {
			dbconfig=new DBConfig();
			return dbconfig;
		}else {
			return dbconfig;
		}
	}
	public Connection getCon() {
		return con;
	}
	public void finalize() {
		try {
			con.close();
		}catch(SQLException e) {
			System.out.println(e);
		}
	}
}
