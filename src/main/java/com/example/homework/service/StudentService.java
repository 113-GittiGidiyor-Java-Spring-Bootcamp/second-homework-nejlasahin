package com.example.homework.service;

import com.example.homework.dao.StudentDAO;
import com.example.homework.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class StudentService implements BaseService<Student>{
    private StudentDAO studentDao;

    // @Qualifier("studentDAOJPAImpl") or @Qualifier("studentDAOHibernateImpl")
    @Autowired
    public StudentService(@Qualifier("studentDAOJPAImpl") StudentDAO studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public Student findById(int id) {
        return (Student) studentDao.findById(id);
    }

    @Override
    @Transactional
    public Student save(Student student) {
        return (Student) studentDao.save(student);
    }

    @Override
    @Transactional
    public void update(Student student) {
        studentDao.update(student);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        studentDao.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteByObject(Student student) {
        studentDao.deleteByObject(student);
    }
}
