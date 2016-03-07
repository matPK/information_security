import java.sql.*;

public class DataAccess {
	
	private static DataAccess instance;
	
	//private constructor
	private DataAccess(){
		//
	}
	
	//private instantiator
	private static DataAccess getInstance(){
		instance = new DataAccess();
		return instance;
	}
	
	//db connection method
	private Connection connect(){
		try{
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/DB_NAME_HERE?autoReconnect=true&useSSL=false", "LOGIN","PASSWORD");
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	//query executer, returns result set. Use for SELECT.
	public static ResultSet dataAccessQuery(String query){
		try{
			Connection c = getInstance().connect();
			Statement myStat = c.createStatement();
			return myStat.executeQuery(query);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	//update executer, returns nothing. Use for DELETE, UPDATE, etc.
	public static void nullDataAccessQuery(String query){
		try{
			Connection c = getInstance().connect();
			Statement myStat = c.createStatement();
			myStat.executeUpdate(query);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
