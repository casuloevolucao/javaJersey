package br.com.haras.factory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateFactory {
	
	private static SessionFactory sf;
	
	public static synchronized Session getHibernateSession(){	
		if(sf == null){
			Configuration c = new Configuration();
			sf = c.configure().buildSessionFactory();
		}
		Session s = sf.getCurrentSession();
		return s;
	}
	
	public static SessionFactory getSessionFactory() {
		return sf;
	}
}
