package com.surya.hibernate.demo;

import com.surya.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            System.out.println("Creating new Student object...");
            Student tempStudent1 = new Student("Paul","Wall","paul@gmail.com");
            Student tempStudent2 = new Student("John","Doe","john@gmail.com");
            Student tempStudent3 = new Student("Bonita","Applebum","bonita@gmail.com");
            session.beginTransaction();
            System.out.println("Saving the student...");
            session.save(tempStudent1);
            session.save(tempStudent2);
            session.save(tempStudent3);
            session.getTransaction().commit();
            System.out.println("Done!");
        }finally {
            factory.close();
        }
    }
}
