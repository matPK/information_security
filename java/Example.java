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
	public boolean updateTable(int x, int y, query){
		try{
			DataAccess.nullDataAccessQuery(query);
			return true;
		}catch(Exception e){
			e.getStackTrace();
			return false;
		}
	}
	
	public static void main(String[] args) {
		
		//using dataAccessQuery
		String s = "select * from table where id = x";
		printSelectedIDs(s);
		
		//using nullDataAccessQuery
		s = 
			"UPDATE tb_name "+
			"SET col = "+x+" "+
			"WHERE col = "+y;
			
		if(updateTable(1,2,s)){
			System.out.println("Updated!");
		}else{
			System.out.println("Failed!");
		}
	}
}
