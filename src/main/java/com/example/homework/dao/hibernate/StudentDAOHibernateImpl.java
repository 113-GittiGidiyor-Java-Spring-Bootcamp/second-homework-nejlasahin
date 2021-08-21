package com.example.homework.dao.hibernate;

import com.example.homework.dao.StudentDAO;
import com.example.homework.model.Student;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class StudentDAOHibernateImpl implements StudentDAO<Student> {
    private EntityManager entityManager;

    @Autowired
    public StudentDAOHibernateImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Student> findAll() {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("FROM Student", Student.class).getResultList();
    }

    @Override
    public Student findById(int id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Student.class, id);
    }

    @Override
    public Student save(Student student) {
        Session session = entityManager.unwrap(Session.class);
        return (Student) session.merge(student);
    }

    @Override
    public void update(Student student) {
        session.merge(student);
    }

    @Override
    public void deleteById(int id) {
        Session session = entityManager.unwrap(Session.class);
        session.delete(session.get(Student.class, id));
    }

    @Override
    public void deleteByObject(Student student) {
        Session session = entityManager.unwrap(Session.class);
        session.delete(session.get(Student.class, student.getId()));
    }
}
