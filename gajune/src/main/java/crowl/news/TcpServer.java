package crowl.news;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.google.gson.Gson;
import com.mysql.jdbc.Connection;

import crowl.news.model.NewsUI;


/**
 * <pre>
 * crowl.news 
 * TcpServer.java
 *
 * 설명 :
 * </pre>
 * 
 * @since : 2020. 5. 24.
 * @author : user
 * @version : v1.0
 */
public class TcpServer {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://192.168.0.41:3306/gajune";

	static final String USERNAME = "root";
	static final String PASSWORD = "swhacademy!";
	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement preparedStatementInsert = null;
		ServerSocket ss = null;		// 서버소켓 변수
		Socket sock = null;		// 접속할 클라이언트 소켓변수
		try {
			ss = new ServerSocket(9999);	// 서버소켓생성
			System.out.println("서버 대기중 ");
			while (true) {
				// 클라이언트가 접속 할때까지 대기하다가 접속하면 socket생성
				sock = ss.accept();
				System.out.println("접속자 정보 : " + sock);
				
				// 클라이언트에서 보낸 한줄의 메시지를 출력
				BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
				String msg = in.readLine();
				//System.out.println("보낸 메시지 : "+msg);
				Gson gson = new Gson();
				NewsUI news = gson.fromJson(msg, NewsUI.class);
				String insertTableSQL = "INSERT INTO news"
						+ "(title, contents, address, id) VALUES"
						+ "(?,?,?,?)";
				try{
					Class.forName(JDBC_DRIVER);
					connection = (Connection) DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
					System.out.println("MariaDB 연결.");

					connection.setAutoCommit(false);

					preparedStatementInsert = connection.prepareStatement(insertTableSQL);
					preparedStatementInsert.setString(1, news.getTitle());
					preparedStatementInsert.setString(2, news.getContents());
					preparedStatementInsert.setString(3, news.getAddress());
					preparedStatementInsert.setString(4, news.getId());
					preparedStatementInsert.executeUpdate();
					connection.commit();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
					connection.rollback();
				} finally {
					if (preparedStatementInsert != null) preparedStatementInsert.close();
					if (connection != null) connection.close();
				}
				System.out.println("MariaDB 연결종료.");
				//클라이언트와의 연결 끊기
				in.close();
				sock.close();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}