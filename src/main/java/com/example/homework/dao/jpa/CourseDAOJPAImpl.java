package com.example.homework.dao.jpa;

import com.example.homework.dao.CourseDAO;
import com.example.homework.model.Course;
import com.example.homework.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CourseDAOJPAImpl implements CourseDAO<Course> {
    private EntityManager entityManager;

    @Autowired
    public CourseDAOJPAImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Course> findAll() {
        return entityManager.createQuery("FROM Course", Course.class).getResultList();
    }

    @Override
    public Course findById(int id) {
        return entityManager.find(Course.class, id);
    }

    @Override
    public Course save(Course course) {
        return entityManager.merge(course);
    }

    @Override
    public void update(Course newCourse) {
        Course course = entityManager.find(Course.class, newCourse.getId());
        course.setCourseName(newCourse.getCourseName());
        course.setCourseCode(newCourse.getCourseCode());
        course.setCreditScore(newCourse.getCreditScore());
        entityManager.merge(course);
    }

    @Override
    public void deleteById(int id) {
        entityManager.remove(entityManager.find(Course.class, id));
    }

    @Override
    public void deleteByObject(Course course) {
        entityManager.remove(entityManager.find(Course.class, course.getId()));
    }
}
