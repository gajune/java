package crowl.maskmap;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class DBmain {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://192.168.0.41:3306/gajune";

	static final String USERNAME = "root";
	static final String PASSWORD = "swhacademy!";

	public static void main(String[] args) {
		ArrayList<Db> list = new ArrayList<>();
		//Db db = new Db();
		Connection connection = null;
		Statement statement = null;
		try{
			Class.forName(JDBC_DRIVER);
			connection = (Connection) DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
			System.out.println("MariaDB 연결.");
			statement = (Statement) connection.createStatement();



			//	select
			ResultSet rs = statement.executeQuery("SELECT a.code, a.lat, a.lng, b.remain_stat, a.name FROM corona AS a, corona2 AS b WHERE a.code = b.code");

			while(rs.next()){
				Db db = new Db();
				db.setName(rs.getString("name"));
				db.setCode(rs.getString("code"));
				db.setLat(rs.getString("lat"));
				db.setLng(rs.getString("lng"));
				db.setRemain_stat(rs.getString("remain_stat"));
				list.add(db);
			}
			rs.close();
		}catch(SQLException se1){
			se1.printStackTrace();
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(statement!=null) statement.close();
				if(connection!=null) connection.close();
			}catch(SQLException se2){
			}
		}
		for(Db object : list){
			System.out.println(object.getName());
		}
		System.out.println("MariaDB 연결종료.");
	}

}
