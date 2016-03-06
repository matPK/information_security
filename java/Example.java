//example on how to use the DataAccess Class

import java.sql.*;

public class Main {

	public static void printSelectedIDs(String query){
		try{
			ResultSet rs = DataAccess.dataAccessQuery(query);
			while(rs.next()){
				System.out.println(rs.getInt("id"));
			}
		}catch(Exception e){
			e.getStackTrace();
		}
	}
	
	public static void main(String[] args) {
		String s = "select * from table where id = x";
		printSelectedIDs(s);
	}
}
