package com.example.HibernateHQLHCQL;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class App {
    public static void main(String[] args) {
        // Open a session
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        // HQL Queries
        // 1. Display all student records with all columns
        String hql = "FROM Student";
        Query<Student> query = session.createQuery(hql, Student.class);
        List<Student> students = query.getResultList();
        for (Student student : students) {
            System.out.println(student.getId() + " - " + student.getName() + " - " + student.getCgpa());
        }

        // HCQL example
        // Display students whose CGPA > 7
        hql = "SELECT s.name FROM Student s WHERE s.cgpa > 7";
        Query<String> nameQuery = session.createQuery(hql, String.class);
        List<String> names = nameQuery.getResultList();
        for (String name : names) {
            System.out.println(name);
        }

        transaction.commit();
        session.close();
    }
}
