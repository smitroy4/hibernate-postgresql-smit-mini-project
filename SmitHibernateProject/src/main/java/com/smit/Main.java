package com.smit;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setsName("Smit");
        s1.setRollno(4);
        s1.setsAge(22);

        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(com.smit.Student.class);
        cfg.configure("hibernate.cfg.xml");

        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();

        Transaction transaction = session.beginTransaction();

        session.persist(s1);

        transaction.commit();
        System.out.println(s1);


    }
}