package com.example.homework.dao.hibernate;

import com.example.homework.dao.CourseDAO;
import com.example.homework.model.Course;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CourseDAOHibernateImpl implements CourseDAO<Course> {
    private EntityManager entityManager;

    @Autowired
    public CourseDAOHibernateImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Course> findAll() {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("FROM Course", Course.class).getResultList();
    }

    @Override
    public Course findById(int id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Course.class, id);
    }

    @Override
    public Course save(Course course) {
        Session session = entityManager.unwrap(Session.class);
        return (Course) session.merge(course);
    }

    @Override
    public void update(Course newCourse) {
        Session session = entityManager.unwrap(Session.class);
        Course course = session.get(Course.class, newCourse.getId());
        course.setCourseName(newCourse.getCourseName());
        course.setCourseCode(newCourse.getCourseCode());
        course.setCreditScore(newCourse.getCreditScore());
        session.merge(course);

    }

    @Override
    public void deleteById(int id) {
        Session session = entityManager.unwrap(Session.class);
        Course course = session.get(Course.class, id);
        session.delete(course);
    }

    @Override
    public void deleteByObject(Course course) {
        Session session = entityManager.unwrap(Session.class);
        session.delete(session.get(Course.class, course.getId()));
    }
}
