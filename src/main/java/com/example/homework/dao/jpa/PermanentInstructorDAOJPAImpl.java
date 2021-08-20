package com.example.homework.dao.jpa;

import com.example.homework.dao.PermanentInstructorDAO;
import com.example.homework.model.PermanentInstructor;
import com.example.homework.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class PermanentInstructorDAOJPAImpl implements PermanentInstructorDAO<PermanentInstructor> {
    private EntityManager entityManager;

    @Autowired
    public PermanentInstructorDAOJPAImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<PermanentInstructor> findAll() {
        return entityManager.createQuery("FROM PermanentInstructor", PermanentInstructor.class).getResultList();
    }

    @Override
    public PermanentInstructor findById(int id) {
        return entityManager.find(PermanentInstructor.class, id);
    }

    @Override
    public PermanentInstructor save(PermanentInstructor permanentInstructor) {
        return entityManager.merge(permanentInstructor);
    }

    @Override
    public void update(PermanentInstructor newPermanentInstructor) {
        PermanentInstructor permanentInstructor = entityManager.find(PermanentInstructor.class, newPermanentInstructor.getId());
        permanentInstructor.setName(newPermanentInstructor.getName());
        permanentInstructor.setAddress(newPermanentInstructor.getAddress());
        permanentInstructor.setPhoneNumber(newPermanentInstructor.getPhoneNumber());
        permanentInstructor.setFixedSalary(newPermanentInstructor.getFixedSalary());
        entityManager.merge(permanentInstructor);
    }

    @Override
    public void deleteById(int id) {
        entityManager.remove(entityManager.find(PermanentInstructor.class, id));
    }

    @Override
    public void deleteByObject(PermanentInstructor permanentInstructor) {
        entityManager.remove(entityManager.find(PermanentInstructor.class, permanentInstructor.getId()));
    }
}
