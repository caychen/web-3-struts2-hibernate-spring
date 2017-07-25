package org.com.cay.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory sf;
	private static ThreadLocal<Session> sessionLocal = new ThreadLocal<Session>(); 

	static {
		// 加载配置文件
		Configuration conf = new Configuration();
		conf.configure("/hibernate.cfg.xml");

		// 创建SessionFactory
		sf = conf.buildSessionFactory();
	}
	
	
	/**
	 * 同一个线程，只创建一个Session，创建出来后利用ThreadLocal将Session与当前线程绑定
	 * @return
	 */
	public static Session openSession() {
		// 获取Session
		Session session = sessionLocal.get();
		if(session == null){
			//当前线程第一次调用，创建一个Session
			session = sf.openSession();
			
			//当session存入ThreadLocal
			sessionLocal.set(session);
		}
		//如果能取到Session，说明当前线程已经创建过session
		return session;
	}
	
	public static void closeSession(){
		Session session = sessionLocal.get();
		sessionLocal.set(null);
		if(session.isOpen()){
			session.close();
		}
	}
}
