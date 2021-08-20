package com.example.homework.service;

import com.example.homework.dao.CourseDAO;
import com.example.homework.model.Course;
import com.example.homework.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CourseService implements BaseService<Course>{
    private CourseDAO courseDAO;

    // @Qualifier("courseDAOJPAImpl") or @Qualifier("courseDAOHibernateImpl")
    @Autowired
    public CourseService(@Qualifier("courseDAOJPAImpl") CourseDAO courseDAO) {
        this.courseDAO = courseDAO;
    }

    @Override
    public List<Course> findAll() {
        return courseDAO.findAll();
    }

    @Override
    public Course findById(int id) {
        return (Course) courseDAO.findById(id);
    }

    @Override
    @Transactional
    public Course save(Course course) {
        return (Course) courseDAO.save(course);
    }

    @Override
    @Transactional
    public void update(Course course) {
        courseDAO.update(course);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        courseDAO.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteByObject(Course course) {
        courseDAO.deleteByObject(course);
    }
}
