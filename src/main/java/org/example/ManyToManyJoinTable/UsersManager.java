package org.example.ManyToManyJoinTable;

import org.example.ManyToManyJoinTable.Entity.Group;
import org.example.ManyToManyJoinTable.Entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.util.Set;

public class UsersManager {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

//        save(session);

        User user = session.get(User.class,1l);
        Set<Group> groupSet =  user.getGroups();

        System.out.println(groupSet);
        transaction.commit();
        session.close();
        sessionFactory.close();
    }

    private static void save(Session session) {
        Group groupAdmin = new Group("Administrator Group");
        Group groupGuest = new Group("Guest Group");

        User user1 = new User("Tom","tomcat","tom@gmail.com");
        User user2 = new User("Jery","jerry","jerry@gmail.com");

        groupAdmin.addUser(user1);
        groupAdmin.addUser(user2);

        groupGuest.addUser(user2);

        session.save(groupAdmin);
        session.save(groupGuest);
    }
}