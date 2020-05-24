package study.DB;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class MariaDBTransaction {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://192.168.0.41:3306/gajune";

	static final String USERNAME = "root";
	static final String PASSWORD = "swhacademy!";

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Connection connection = null;
		PreparedStatement preparedStatementInsert = null;
		PreparedStatement preparedStatementUpdate = null;

		String insertTableSQL = "INSERT INTO STUDENT"
				+ "(id, name) VALUES"
				+ "(?,?)";

		String updateTableSQL = "UPDATE STUDENT SET name =? "
				+ "WHERE id = ?";
		try{
			Class.forName(JDBC_DRIVER);
			connection = (Connection) DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
			System.out.println("MariaDB 연결.");

			connection.setAutoCommit(false);

			preparedStatementInsert = connection.prepareStatement(insertTableSQL);
			preparedStatementInsert.setInt(1, 301);
			preparedStatementInsert.setString(2, "돌샘");
			preparedStatementInsert.executeUpdate();

			preparedStatementUpdate = connection.prepareStatement(updateTableSQL);
			
			/*	정상처리	*/
			preparedStatementUpdate.setString(1, "소리");
			preparedStatementUpdate.setInt(2, 168);
			
			/*	오류
			 * 	첫번째 쿼리가 수행되지 않음	
			 * */
		//	preparedStatementUpdate.setString(1, "소리");
			
			
			preparedStatementUpdate.executeUpdate();
			connection.commit();
			System.out.println("트랜잭션 정상처리");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			connection.rollback();
		} finally {
			if (preparedStatementInsert != null) preparedStatementInsert.close();
			if (preparedStatementUpdate != null) preparedStatementUpdate.close();
			if (connection != null) connection.close();
		}
		System.out.println("MariaDB 연결종료.");
	}

}