package study.db;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

/**
 * <pre>
 * study.db 
 * MariaDBSelect.java
 *
 * 설명 :
 * </pre>
 * 
 * @since : 2020. 5. 31.
 * @author : user
 * @version : v1.0
 */
public class MariaDBSelect {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://192.168.0.41:3306/gajune";

	static final String USERNAME = "root";
	static final String PASSWORD = "swhacademy!";

	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		try{
			Class.forName(JDBC_DRIVER);
			connection = (Connection) DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
			System.out.println("MariaDB 연결.");
			statement = (Statement) connection.createStatement();

			
			//	insert
			boolean result = statement.execute("insert into user(name,age) values('가준',17);");
//			boolean result = statement.execute(String.format("insert into a(c1,c2) values(%d, %s);", v1, v2));
			if(result) System.out.println("ResultSet 값 있다.");
			else System.out.println("업데이트 된 행이 있거나 리턴되는 값이 없는 경우");
					
			//	update
//			int result = statement.executeUpdate("update a set c1 = v1;");		//	result = 업데이터된 행의 숫자
//			if(result > 0) System.out.println("정상처리");
//			else System.out.println("비정상처리");
				
			//	select
			ResultSet rs = statement.executeQuery("SELECT * FROM user;");
			
			while(rs.next()){
				int user_id = rs.getInt("user_id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				System.out.println("user_id : " + user_id);
				System.out.println("name: " + name);
				System.out.println("age: " + age);
				System.out.println(rs.getInt(1));	// 첫번 째 열
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
		System.out.println("MariaDB 연결종료.");
	}

}
