package study.DB;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class DBUtil {
	String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	String DB_URL;

	String USERNAME;
	String PASSWORD;

	public DBUtil(String url, String table, String id, String password) {
		// TODO Auto-generated constructor stub
		DB_URL = "jdbc:mysql://" + url + ":3306/" + table;
		USERNAME = id;
		PASSWORD = password;
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean insert() {
		boolean result = false;
		Connection connection = null;
		Statement statement = null;

		try {
			connection = (Connection) DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			statement = (Statement) connection.createStatement();
			result = statement.execute("insert into user(name,age) values('가준',17);");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (statement != null)
					statement.close();
				if (connection != null)
					connection.close();
			} catch (final SQLException se2) {
			}

		}
		return result;
	}

	public List<StoreData> select() {
		Connection connection = null;
		Statement statement = null;
		List<StoreData> list = new ArrayList<StoreData>();

		try {
			connection = (Connection) DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			statement = (Statement) connection.createStatement();
			ResultSet rs = statement.executeQuery(
					"SELECT a.code, a.lat, a.lng, b.remain_stat, a.name FROM corona AS a, corona2 AS b WHERE a.code = b.code");
			while (rs.next()) {
				StoreData sd = new StoreData();
				sd.setName(rs.getString("name"));
				sd.setCode(rs.getString("code"));
				sd.setLat(rs.getString("lat"));
				sd.setLng(rs.getString("lng"));
				sd.setRemain_stat(rs.getString("remain_stat"));
				list.add(sd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (statement != null)
					statement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException se2) {
			}

		}
		return list;
	}
}
