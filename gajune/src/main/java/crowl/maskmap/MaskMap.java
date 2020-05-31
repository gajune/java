package crowl.maskmap;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.google.gson.Gson;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import study.db.annotation.HibernateAnnotationUtil;

public class MaskMap {
	int num = 1;
	HttpClient client = HttpClients.createDefault();
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://192.168.0.41:3306/gajune";

	static final String USERNAME = "root";
	static final String PASSWORD = "swhacademy!";

	public void insertStores() {
		SessionFactory sessionFactory = HibernateAnnotationUtil.getSessionFactory();

		while (true) {
			HttpGet request = new HttpGet(
					"https://8oi9s0nnth.apigw.ntruss.com/corona19-masks/v1/stores/json?page=" + num + "&perPage=500");
			try {
				// 필요에 따라서는 헤더 추가
				// request.addHeader("Content-type", "application/json");

				// 요청
				HttpResponse response = client.execute(request);

				// 응답
				String result = EntityUtils.toString(response.getEntity());
				Gson gson = new Gson();
				MaskInfor mask = gson.fromJson(result, MaskInfor.class);
				List<StoreInfo> storeInfos = mask.getStoreInfos();
				if (storeInfos.size() == 0)
					break;
				Session session = sessionFactory.openSession();
				session.beginTransaction();
				for (StoreInfo object : storeInfos) {
					session.save(object);
				}
				session.getTransaction().commit();
				session.close();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			num++;
		}

	}

	
	
	public void insertSales() {
		SessionFactory sessionFactory = HibernateAnnotationUtil.getSessionFactory();

		while (true) {
			HttpGet request = new HttpGet(
					"https://8oi9s0nnth.apigw.ntruss.com/corona19-masks/v1/sales/json?page=" + num + "&perPage=500");
			try {
				// 필요에 따라서는 헤더 추가
				// request.addHeader("Content-type", "application/json");

				// 요청
				HttpResponse response = client.execute(request);

				// 응답
				String result = EntityUtils.toString(response.getEntity());
				Gson gson = new Gson();
				Storestate mask = gson.fromJson(result, Storestate.class);
      		 	List<SalesList> saleslist = mask.getSales();
				if (saleslist.size() == 0)
					break;
				Session session = sessionFactory.openSession();
				session.beginTransaction();
				for (SalesList object : saleslist) {
					session.save(object);
				}
				session.getTransaction().commit();
				session.close();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			num++;
		}
	}
	
	public void showDBList() {
		ArrayList<Db> list = new ArrayList<>();
		Connection connection = null;
		Statement statement = null;
		try{
			Class.forName(JDBC_DRIVER);
			connection = (Connection) DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
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
	}
}
