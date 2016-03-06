import java.sql.*;

public class DataAccess {
	
	private static DataAccess instance;
	
	private DataAccess(){
		//
	}
	
	//instanciador privado
	private static DataAccess getInstance(){
		instance = new DataAccess();
		return instance;
	}
	
	//conector privado
	private Connection connect(){
		try{
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/DB_NAME_HERE?autoReconnect=true&useSSL=false", "LOGIN","PASSWORD");
			
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	public static ResultSet dataAccessQuery(String query){
		try{
			Connection c = getInstance().connect();
			Statement myStat = c.createStatement();
			ResultSet myRs = myStat.executeQuery(query);
			return myRs;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}