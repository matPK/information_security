//example on how to use the DataAccess Class

import java.sql.*;

public class Main {

	public static void main(String[] args) {
		try{
			ResultSet rs = DataAccess.dataAccessQuery(
					"select * "+
					"from table "+
					"where x = y");
			while(rs.next()){
				System.out.println(rs.getInt("x"));
			}
		}catch(Exception e){
			e.getStackTrace();
		}
	}
}
