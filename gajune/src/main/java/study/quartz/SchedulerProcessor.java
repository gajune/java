package study.quartz;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;



/**
 * <pre>
 * study.quartz 
 * SchedulerProcessor.java
 *
 * 설명 :
 * </pre>
 * 
 * @since : 2020. 5. 24.
 * @author : user
 * @version : v1.0
 */
public class SchedulerProcessor implements org.quartz.Job{
	private static int count = 0;
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		// TODO Auto-generated method stub
		System.out.println(++count + "돈다");
		try {
			Thread.sleep(900);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(count + "끝났다");
	}
}