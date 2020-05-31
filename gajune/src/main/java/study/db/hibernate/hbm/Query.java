package study.db.hibernate.hbm;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


/**
 * <pre>
 * study.DB.hbm 
 * Query.java
 *
 * 설명 :
 * </pre>
 * 
 * @since : 2020. 5. 24.
 * @author : user
 * @version : v1.0
 */
public class Query {
	public static void main( String[] args ){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        SWHAcademy user = new SWHAcademy();
        user.setEmail("swhacademy@gmail.com");
        user.setName("SWH");
        user.setId("key");
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        System.out.println("Insert completed");

        session.beginTransaction();
        SWHAcademy myuser = (SWHAcademy)session.get(SWHAcademy.class, "key");
        System.out.println("name:"+myuser.getName());
        myuser.setName("SWHAcademy");
        session.getTransaction().commit();
        
        session.close();
        sessionFactory.close();
    }
}