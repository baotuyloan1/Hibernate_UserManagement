package org.example.ManyToManySeparatePrimaryKey;

import org.example.ManyToManySeparatePrimaryKey.entity.GroupNew;
import org.example.ManyToManySeparatePrimaryKey.entity.UserGroup;
import org.example.ManyToManySeparatePrimaryKey.entity.UserNew;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserExtraColumnManger {
    public static void main(String[] args) throws ParseException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


//        save(session);

//        getAndSave(session);


        UserGroup userGroup =(UserGroup) session.load(UserGroup.class, 9l);
        userGroup.setGroup(null);
        userGroup.setUser(null);
        session.delete(userGroup);

//        System.out.println("AAAA"+userGroup.getId());
        transaction.commit();
        session.close();
        sessionFactory.close();
    }

    private static void getAndSave(Session session) throws ParseException {
        UserNew user = session.get(UserNew.class, 1l);
        UserNew user1 = session.get(UserNew.class, 2l);

        GroupNew group = session.get(GroupNew.class,2l);
        UserGroup userGroup = new UserGroup();
        userGroup.setGroup(group);
        userGroup.setActivated(false);
        userGroup.setRegisteredDate(new SimpleDateFormat("yyyy-MM-dd").parse("2023-3-9"));
        userGroup.setUser(user);

        session.save(userGroup);
    }

    private static void save(Session session) throws ParseException {
        UserNew userNew = new UserNew("Tommy", "YUmoot", "tommy@gmail.com");
        UserNew userNew1 = new UserNew("Tommy1", "YUmoot1", "tommy1@gmail.com");


        GroupNew groupNew = new GroupNew("Coders");
        UserGroup userGroup = new UserGroup();
        userGroup.setGroup(groupNew);
        userGroup.setUser(userNew);
        userGroup.setActivated(true);
        userGroup.setRegisteredDate(new Date());

        UserGroup userGroup1 = new UserGroup();
        userGroup1.setUser(userNew1);
        userGroup1.setGroup(groupNew);
        userGroup1.setActivated(false);
        userGroup1.setRegisteredDate(new SimpleDateFormat("yyyy-mm-dd").parse("2023-4-4"));
        session.save(userGroup);
        session.save(userGroup1);
    }
}
