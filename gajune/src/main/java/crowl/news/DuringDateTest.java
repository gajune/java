package crowl.news;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
 
public class DuringDateTest {
    public static void main(String[] args) {
        String startDt = "20151031";
        int endDt = 20171102;
         
        int startYear = Integer.parseInt(startDt.substring(0,4));
        int startMonth= Integer.parseInt(startDt.substring(4,6));
        int startDate = Integer.parseInt(startDt.substring(6,8));
 
        Calendar cal = Calendar.getInstance();
         
        // Calendar의 Month는 0부터 시작하므로 -1 해준다.
        // Calendar의 기본 날짜를 startDt로 셋팅해준다.
        cal.set(startYear, startMonth -1, startDate);
         
        while(true) {
            // 날짜 출력
            System.out.println(getDateByString(cal.getTime()));
             
            // Calendar의 날짜를 하루씩 증가한다.
            cal.add(Calendar.DATE, 1); // one day increment
             
            // 현재 날짜가 종료일자보다 크면 종료 
            if(getDateByInteger(cal.getTime()) > endDt) break;
        }
    }
     
    public static int getDateByInteger(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return Integer.parseInt(sdf.format(date));
    }
     
    public static String getDateByString(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return sdf.format(date);
    }
}



