package study.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * <pre>
 * study.log 
 * Log4jMain.java
 *
 * 설명 :
 * </pre>
 * 
 * @since : 2020. 5. 24.
 * @author : user
 * @version : v1.0
 */
public class Log4jMain {

	private static final Logger logger = LogManager.getLogger(Log4jMain.class.getName());

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		logger.trace("Entering application.");
		LoggingService bar = new LoggingService();
		if (!bar.check()) {
			logger.error("Didn't do it.");
		}
		logger.trace("Exiting application.");

		logger.fatal("[{}] 로그를 출력합니다.", "FATAL");
		logger.error("[{}] 로그를 출력합니다.", "ERROR");
		logger.warn("[{}] 로그를 출력합니다.", "WARN");
		logger.info("[{}] 로그를 출력합니다.", "INFO");
		logger.debug("[{}] 로그를 출력합니다.", "DEBUG");
		logger.trace("[{}] 로그를 출력합니다.", "TRACE");
	}

}