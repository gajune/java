package study.log;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


/**
 * <pre>
 * study.log 
 * LoggingService.java
 *
 * 설명 :
 * </pre>
 * 
 * @since : 2020. 5. 24.
 * @author : user
 * @version : v1.0
 */
public class LoggingService {
	static final Logger logger = LogManager.getLogger(LoggingService.class.getName());

	public boolean check() {
		
		if(logger.isErrorEnabled()){
			logger.error("에러가 발생했어요.");
		}
		if(logger.isDebugEnabled()){
			logger.debug("버그가 발생했어요.");
		}
		return false;
	}
}
