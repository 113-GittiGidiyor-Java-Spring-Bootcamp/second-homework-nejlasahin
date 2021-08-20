package com.example.homework.service;

import com.example.homework.dao.PermanentInstructorDAO;
import com.example.homework.model.PermanentInstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PermanentInstructorService implements BaseService<PermanentInstructor>{
    private PermanentInstructorDAO permanentInstructorDAO;

    // @Qualifier("permanentInstructorDAOJPAImpl") or @Qualifier("permanentInstructorDAOHibernateImpl")
    @Autowired
    public PermanentInstructorService(@Qualifier("permanentInstructorDAOJPAImpl") PermanentInstructorDAO permanentInstructorDAO) {
        this.permanentInstructorDAO = permanentInstructorDAO;
    }

    @Override
    public List<PermanentInstructor> findAll() {
        return permanentInstructorDAO.findAll();
    }

    @Override
    public PermanentInstructor findById(int id) {
        return (PermanentInstructor) permanentInstructorDAO.findById(id);
    }

    @Override
    @Transactional
    public PermanentInstructor save(PermanentInstructor permanentInstructor) {
        return (PermanentInstructor) permanentInstructorDAO.save(permanentInstructor);
    }

    @Override
    @Transactional
    public void update(PermanentInstructor PermanentInstructor) {
        permanentInstructorDAO.update(PermanentInstructor);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        permanentInstructorDAO.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteByObject(PermanentInstructor permanentInstructor) {
        permanentInstructorDAO.deleteByObject(permanentInstructor);
    }
}
