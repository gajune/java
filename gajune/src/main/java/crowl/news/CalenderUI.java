package crowl.news;

import org.apache.commons.lang3.StringUtils;

public class CalenderUI {
	public static void main(String[] args) {
		calender cal = new calender();
		String d1="20150809";
		String d2 = "20150810";
		int startyear = Integer.parseInt(d1.substring(0,4));
		int startmonth = Integer.parseInt(d1.substring(4,6));
		int startday = Integer.parseInt(d1.substring(6,8));
		int endall = Integer.parseInt(d2);
		while(true){
			String changeyear = Integer.toString(startyear);
			String changemonth = StringUtils.leftPad(String.valueOf(startmonth),2,"0");
			String changeday = StringUtils.leftPad(String.valueOf(startday),2,"0");
			String all = changeyear+changemonth+changeday;
			int startall = Integer.parseInt(all);
			System.out.println(startall);
			if (startall == endall)break;{}
			int check = cal.endDayFromTotalDay(startyear, startmonth);
			startday++;
			if(startday>check){
				startday = 01;
				startmonth++;
				if (startmonth>12){
					startmonth = 01;
					startyear++;
					startday = 01;
				}
			}
			
	}
}
}
