package com.example.homework.dao.jpa;

import com.example.homework.dao.StudentDAO;
import com.example.homework.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class StudentDAOJPAImpl implements StudentDAO<Student> {
    private EntityManager entityManager;

    @Autowired
    public StudentDAOJPAImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Student> findAll() {
        return entityManager.createQuery("FROM Student", Student.class).getResultList();
    }

    @Override
    public Student findById(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public Student save(Student student) {
        return entityManager.merge(student);
    }

    @Override
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    public void deleteById(int id) {
        entityManager.remove(entityManager.find(Student.class, id));
    }

    @Override
    public void deleteByObject(Student student) {
        entityManager.remove(entityManager.find(Student.class, student.getId()));
    }
}
