package crowl.worldcovid;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;
import java.util.TimeZone;


import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import crowl.maskmap.model.Db;
import crowl.worldcovid.model.CountryStatus;
import study.db.hibernate.annotation.HibernateAnnotationUtil;

/**
 * <pre>
 * crowl.worldcovid 
 * WorldCovid19.java
 *
 * 설명 :
 * </pre>
 * 
 * @since : 2020. 7. 5.
 * @author : user
 * @version : v1.0
 */
public class WorldCovid19 {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://dev-swh.ga:3306/gajune";

	static final String USERNAME = "root";
	static final String PASSWORD = "swhacademy!";
	
	public List<String> countryCode() {
		ArrayList<String> list = new ArrayList<>();
		Connection connection = null;
		Statement statement = null;
		try{
			Class.forName(JDBC_DRIVER);
			connection = (Connection) DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
			statement = (Statement) connection.createStatement();
			
			//	select
			ResultSet rs = statement.executeQuery("SELECT a.kor FROM CountryCode AS a;");

			while(rs.next()){
				list.add(rs.getString("kor"));
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
		return list;
	}
	
	public String changeDate(String date) throws ParseException {
		SimpleDateFormat fDate = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat sDate = new SimpleDateFormat("yyyy-MM-dd");
		Date changedate = fDate.parse(date);
		return date = sDate.format(changedate);
	}

	public String previousDate() {
		Calendar c1 = new GregorianCalendar();
		c1.add(Calendar.DATE, -1); // 오늘날짜로부터 -1
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd"); // 날짜 포맷
		String d = sdf.format(c1.getTime()); // String으로 저장
		return d;
	}

	public long dateToLong(String string_date) {
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		f.setTimeZone(TimeZone.getTimeZone("GMT"));
		long milliseconds = 0;
		try {
		    Date d = f.parse(string_date);
		    milliseconds = d.getTime();
		} catch (ParseException e) {
		    e.printStackTrace();
		}
		return milliseconds;
	}
	public static void main(String[] args) throws ParseException {
		SessionFactory sessionFactory = HibernateAnnotationUtil.getSessionFactory();
		String startday = null;
		String endday =null;
		WorldCovid19 world = new WorldCovid19();
		String today = world.previousDate();
		Scanner sc = new Scanner(System.in);
		HttpClient client = HttpClients.createDefault();
		System.out.println("어느나라?");
		String country = sc.next();
		while(true){
			System.out.println("시작날짜");
			startday = sc.next();
			int compare = startday.compareTo(today);
			if (compare>0){
				System.out.println("현재 날짜보다 크거나 같습니다, 현재날짜보다 작게 설정해주세요");
				continue;
			}
			else break;
		}
		while(true){
			System.out.println("끝날짜");
			endday = sc.next();
			int compare = endday.compareTo(today);
			int compare1 = endday.compareTo(startday);
			if (compare>0){
				System.out.println("현재 날짜보다 크거나 같습니다. 현재날짜보다 작게 설정해주세요");
				continue;
			}
			if (compare1<0){
				System.out.println("시작날짜보다 작습니다. 다시입력해주세요");
				continue;
			}
			else break;
		}
		startday = world.changeDate(startday);
		endday = world.changeDate(endday);
		sc.close();
		String url = "https://api.covid19api.com/country/" + country + "?from=" + startday + "T00:00:00Z&to=" + endday
				+ "T23:59:59Z";
		//System.out.println(url);
		HttpGet request = new HttpGet(url);

		// 필요에 따라서는 헤더 추가
		// request.addHeader("Content-type", "application/json");

		// 요청
		HttpResponse response;
		Session session = null;
		try {
			response = client.execute(request);
			String result = EntityUtils.toString(response.getEntity());
			Gson gson = new Gson();
			List<CountryStatus> co = (List<CountryStatus>) gson.fromJson(result,
					new TypeToken<ArrayList<CountryStatus>>() {
					}.getType());
			long beforeTime = System.currentTimeMillis();
			session = sessionFactory.openSession();
			session.beginTransaction();
			for (CountryStatus object : co) {
				object.setId(world.dateToLong(object.getDate()), object.getCountryCode());
				//System.out.println(object.getId());
				session.save(object);
			}
			session.getTransaction().commit();
			long afterTime = System.currentTimeMillis();
			long secDiffTime = (afterTime - beforeTime);
			System.out.println("시간차이(m) : "+secDiffTime);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if(session != null) session.close();
		}

		// 응답
		sessionFactory.close();
	}
}
