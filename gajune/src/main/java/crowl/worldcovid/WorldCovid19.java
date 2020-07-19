package crowl.worldcovid;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import crowl.worldcovid.model.*;

import com.google.gson.Gson;

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
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HttpClient client = HttpClients.createDefault();
		System.out.println("어느나라?");
		String country = sc.next();
		System.out.println("시작날짜");
		String startday = sc.next();
		System.out.println("끝날짜");
		String endday = sc.next();
		while (true) {
			HttpGet request = new HttpGet("https://api.covid19api.com/country/" + country + "?from=" + startday
					+ "T00:00:00Z&to=" + endday + "T23:59:59Z");

			// 필요에 따라서는 헤더 추가
			// request.addHeader("Content-type", "application/json");

			// 요청
			HttpResponse response;
			try {
				response = client.execute(request);
				String result = EntityUtils.toString(response.getEntity());
				Gson gson = new Gson();
				List<CountryStatus> co = (List<CountryStatus>) gson.fromJson(result, CountryStatus.class);
				for(CountryStatus object : co){
					System.out.println(object.getCity());
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// 응답
		}
	}
}
