package crowl.news;

import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;

/**
 * <pre>
 * crowl.news 
 * CalenderUI.java
 *
 * 설명 :
 * </pre>
 * 
 * @since : 2020. 5. 31.
 * @author : user
 * @version : v1.0
 */
public class CalenderUI {
	ArrayList<Integer> arrayList = new ArrayList<>();
	Calender cal = new Calender();

	CalenderUI(String num1, String num2) {
		String d1 = num1;
		String d2 = num2;

		int startyear = Integer.parseInt(d1.substring(0, 4));
		int startmonth = Integer.parseInt(d1.substring(4, 6));
		int startday = Integer.parseInt(d1.substring(6, 8));
		int endall = Integer.parseInt(d2);
		{
			while (true) {

				String changeyear = Integer.toString(startyear);
				String changemonth = StringUtils.leftPad(String.valueOf(startmonth), 2, "0");
				String changeday = StringUtils.leftPad(String.valueOf(startday), 2, "0");
				String all = changeyear + changemonth + changeday;
				int startall = Integer.parseInt(all);
				System.out.println(startall);
				arrayList.add(startall);
				if (startall == endall)
					break;
				{
				}
				int check = cal.endDayFromTotalDay(startyear, startmonth);
				startday++;
				if (startday > check) {
					startday = 01;
					startmonth++;
					if (startmonth > 12) {
						startmonth = 01;
						startyear++;
						startday = 01;
					}
				}

			}
		}
	}
}