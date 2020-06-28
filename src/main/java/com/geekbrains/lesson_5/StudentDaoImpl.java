package com.geekbrains.lesson_5;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class StudentDaoImpl implements StudentDao{

    private SessionFactory sf = SessionFactoryUtil.getSessionFactory();


    public Student findById(Long id){
        return sf.openSession().get(Student.class, id);
    }

    public void save(Student student){
        Session session = sf.openSession();
        Transaction ta = session.beginTransaction();
        session.save(student);
        ta.commit();
        session.close();
    }

    public void update(Student student) {
        Session session = sf.openSession();
        Transaction ta = session.beginTransaction();
        session.update(student);
        ta.commit();
        session.close();
    }

    public void delete(Student student) {
        Session session = sf.openSession();
        Transaction ta = session.beginTransaction();
        session.delete(student);
        ta.commit();
        session.close();
    }

    public List<Student> findAll() {
        List<Student> students = (List<Student>)  sf.openSession().createQuery("From Student").list();
        return students;
    }
}
