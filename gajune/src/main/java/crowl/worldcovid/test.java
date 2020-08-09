package crowl.worldcovid;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import crowl.worldcovid.model.CountryStatus;

/**
 * <pre>
 * crowl.worldcovid 
 * test.java
 *
 * 설명 :
 * </pre>
 * 
 * @since : 2020. 8. 9.
 * @author : user
 * @version : v1.0
 */
public class test {

	public String previousDate() {
		Calendar c1 = new GregorianCalendar();
		c1.add(Calendar.DATE, -1); // 오늘날짜로부터 -1
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd"); // 날짜 포맷
		String d = sdf.format(c1.getTime()); // String으로 저장
		return d;
	}
	public static void main(String[] args) {
/*		Gson gson = new Gson();
		String result = "[{'Country':'South Africa','CountryCode':'ZA','Province':'','City':'','CityCode':'','Lat':'-30.56','Lon':'22.94','Confirmed':0,'Deaths':0,'Recovered':0,'Active':0,'Date':'2020-03-01T00:00:00Z'}]";
		List<CountryStatus> co = (List<CountryStatus>) gson.fromJson(result, new TypeToken<ArrayList<CountryStatus>>(){}.getType());
		for(CountryStatus object : co){
			System.out.println(object.getCity());
	}*/

		test test = new test();
		System.out.println(test.previousDate());
		
}
}