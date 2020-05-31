package crowl.news;


/**
 * <pre>
 * crowl.news 
 * Calender.java
 *
 * 설명 :
 * </pre>
 * 
 * @since : 2020. 5. 31.
 * @author : user
 * @version : v1.0
 */
public class Calender {
	/*Quiz. 20160101와 20160103을 입력하면
	20160101
	20160102
	20160103
	을 출력하는 코드를 작성하세요.*/

//		입력한 달이 몇일까지 있는지를 계산
	public int endDayFromTotalDay(int year, int month){
			int lastday;
			switch (month) {
			case 2:
				lastday = 28;
				if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
					lastday = 29;
			else
					lastday = 28;
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				lastday = 30;
				break;
			default:
				lastday = 31;
			}
			return lastday;
	}

//		입력한 날짜의 총 날 수를 계산(기준은 1970.1.1부터)
	public  int totalDayFromCalendar(int year, int month, int day){
			int totaldays;
			totaldays = 365 * (year - 1);
			for (int i = 1; i < year; i++) {
				if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0)
					totaldays++;
			}
			int premonth = month - 1;
			if (premonth >= 1)
				totaldays += 31;
			if (premonth >= 2)
				totaldays += 28;
			if (premonth >= 3)
				totaldays += 31;
			if (premonth >= 4)
				totaldays += 30;
			if (premonth >= 5)
				totaldays += 31;
			if (premonth >= 6)
				totaldays += 30;
			if (premonth >= 7)
				totaldays += 31;
			if (premonth >= 8)
				totaldays += 31;
			if (premonth >= 9)
				totaldays += 30;
			if (premonth >= 10)
				totaldays += 31;
			if (premonth >= 11)
				totaldays += 30;
			if (month > 2 && (year % 4 == 0 && year % 100 != 0 || year % 400 == 0))
				totaldays++;
			totaldays++;

			
			totaldays = totaldays + day;
			return totaldays;
	}


}
