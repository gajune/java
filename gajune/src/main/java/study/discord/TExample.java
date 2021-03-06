package study.discord;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;

/**
 * <pre>
 * study.discord 
 * TExample.java
 *
 * 설명 :
 * </pre>
 * 
 * @since : 2020. 5. 31.
 * @author : user
 * @version : v1.0
 */
public class TExample {

	public static JDA jda;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JDABuilder jb = new JDABuilder(AccountType.BOT);
		jb.setAutoReconnect(true);
		jb.setStatus(OnlineStatus.DO_NOT_DISTURB);
		jb.setToken("NjYzMzM5NjU3MDIyNTM3NzM5.XhHFug.EF49sS3ggs38MnqAIe0ukECnuTg");
		jb.addEventListeners(new TListener());

		try {
			jda = jb.build();
		} catch (LoginException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}