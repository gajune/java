package crowl.news;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class PrintDate {
	public static void main(String args[]) throws ParseException {

		// 시작 , 끝 날짜 임의 세팅

		String s1 = "20080110";
		String s2 = "20080211";

		DateFormat df = new SimpleDateFormat("yyyyMMdd");

		// Date타입으로 변경

		Date d1 = df.parse(s1);
		Date d2 = df.parse(s2);

		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();

		// Calendar 타입으로 변경 add()메소드로 1일씩 추가해 주기위해 변경
		c1.setTime(d1);
		c2.setTime(d2);

		// 시작날짜와 끝 날짜를 비교해, 시작날짜가 작거나 같은 경우 출력

		while (c1.compareTo(c2) != 1) {

			// 출력
			System.out.printf("%tF\n", c1.getTime());

			// 시작날짜 + 1 일
			c1.add(Calendar.DATE, 1);
		}

	}
}