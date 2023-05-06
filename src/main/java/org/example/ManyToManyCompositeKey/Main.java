package org.example.ManyToManyCompositeKey;

import org.example.ManyToManyCompositeKey.Entity.GroupComposite;
import org.example.ManyToManyCompositeKey.Entity.UserComposite;
import org.example.ManyToManyCompositeKey.Entity.UserGroupComposite;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws ParseException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory1();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        //        save(session);

        saveExitsEntity(session);

//        select(session);

//        delete(session);


        transaction.commit();
        session.close();
        sessionFactory.close();
    }

    private static void delete(Session session) {
        UserGroupComposite userGroupComposite = new UserGroupComposite();

        UserComposite userComposite = new UserComposite();
        userComposite.setId(3l);
        userGroupComposite.setUser(userComposite);

        GroupComposite groupComposite = new GroupComposite();
        groupComposite.setId(2l);
        userGroupComposite.setGroup(groupComposite);

        session.delete(userGroupComposite);
    }

    private static void select(Session session) {
        UserComposite userComposite = session.get(UserComposite.class,3l);
        System.out.println(userComposite);
    }

    private static void saveExitsEntity(Session session) {
        UserComposite user = session.get(UserComposite.class, 4l);
        GroupComposite group = session.get(GroupComposite.class, 3l);

        UserGroupComposite userGroupComposite = new UserGroupComposite();
        userGroupComposite.setGroup(group);
        userGroupComposite.setUser(user);
        userGroupComposite.setActivated(false);
        userGroupComposite.setRegisteredDate(new Date());

        session.save(userGroupComposite);
    }

    private static void save(Session session) throws ParseException {
        UserComposite userComposite = new UserComposite("123", "mas", "sam@gmail.com");
        session.save(userComposite);

        GroupComposite groupComposite = new GroupComposite("Designer");

        session.save(groupComposite);

        UserGroupComposite userGroup = new UserGroupComposite();
        userGroup.setGroup(groupComposite);
        userGroup.setUser(userComposite);
        userGroup.setActivated(true);
        userGroup.setRegisteredDate(new SimpleDateFormat("yyyy-MM-dd").parse("2023-5-6"));

        session.save(userGroup);
//        userComposite.addUserGroup(userGroup);
    }
}
