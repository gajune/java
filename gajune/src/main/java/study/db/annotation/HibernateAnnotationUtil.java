package study.db.annotation;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import crowl.maskmap.Db;
import crowl.maskmap.StoreInfo;



/**
 * <pre>
 * study.DB.hbm.annotation 
 * HibernateAnnotationUtil.java
 *
 * 설명 :
 * </pre>
 * 
 * @since : 2020. 5. 24.
 * @author : user
 * @version : v1.0
 */
public class HibernateAnnotationUtil {
	static SessionFactory sessionFactory;
	static ServiceRegistry serviceRegistry;
	
	static{
		try{
			Configuration configuration = new Configuration().configure("hibernate-annotation.cfg.xml");
			
			configuration.addAnnotatedClass(Cart.class);
			configuration.addAnnotatedClass(Items.class);
			configuration.addAnnotatedClass(Person.class);
			configuration.addAnnotatedClass(Db.class);
			configuration.addAnnotatedClass(StoreInfo.class);
			
			
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