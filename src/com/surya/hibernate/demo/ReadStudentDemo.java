package com.surya.hibernate.demo;

import com.surya.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class ReadStudentDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            //Create
            System.out.println("Creating new Student object...");
            Student tempStudent = new Student("Daffy","Duck","daffy@gmail.com");
            session.beginTransaction();
            System.out.println("Saving the student...");
            System.out.println(tempStudent);
            session.save(tempStudent);
            session.getTransaction().commit();

            //Read
            System.out.println("Saved student. Generated id: " + tempStudent.getId());

            session = factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("\nGetting student with id: " + tempStudent.getId());
            Student myStudent = session.get(Student.class,tempStudent.getId());
            System.out.println("Get complete: " + myStudent);
            session.getTransaction().commit();
            System.out.println("Done!");
        }finally {
            factory.close();
        }
    }
}
