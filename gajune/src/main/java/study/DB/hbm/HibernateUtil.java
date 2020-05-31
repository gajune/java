package study.DB.hbm;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


/**
 * <pre>
 * study.DB.hbm 
 * HibernateUtil.java
 *
 * 설명 :
 * </pre>
 * 
 * @since : 2020. 5. 24.
 * @author : user
 * @version : v1.0
 */
public class HibernateUtil {
	static SessionFactory sessionFactory;
	static ServiceRegistry serviceRegistry;
	
	static{
		try{
			Configuration configuration = new Configuration().configure();
			configuration.addClass(SWHAcademy.class);
			serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		}catch(HibernateException e){
			e.printStackTrace();
		}
	}
	
	public static SessionFactory getSessionFactory(){ 
		return sessionFactory;
	}
}