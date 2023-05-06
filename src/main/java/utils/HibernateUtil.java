package utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
    private static SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory sessionFactory1 = buildSessionFactory("hibernate_2.cfg.xml");
    private static SessionFactory buildSessionFactory() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").configure().build();
        return new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }

    private static SessionFactory buildSessionFactory(String name) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure(name).build();
        return new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }

    public static SessionFactory getSessionFactory1(){
        return sessionFactory1;
    }
}
