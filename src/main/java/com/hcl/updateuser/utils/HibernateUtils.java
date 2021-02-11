package com.hcl.updateuser.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.hcl.updateuser.entity.User;


public class HibernateUtils {

	
	static Session hibernateSession;
    static SessionFactory hibernateSessionFactory;

    public static SessionFactory buildSessionFactory() {
        Configuration conf = new Configuration();
        conf.addAnnotatedClass(User.class);
        conf.configure("hibernate.cfg.xml");
        ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder()
                .applySettings(
                        conf.getProperties()
                ).build();
        hibernateSessionFactory = conf.buildSessionFactory(serviceRegistryObj);
        return hibernateSessionFactory;
    }
}
