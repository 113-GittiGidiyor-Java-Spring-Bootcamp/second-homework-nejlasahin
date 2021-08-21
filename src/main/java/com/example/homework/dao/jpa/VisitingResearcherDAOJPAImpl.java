package com.example.homework.dao.jpa;

import com.example.homework.dao.VisitingResearcherDAO;
import com.example.homework.model.PermanentInstructor;
import com.example.homework.model.VisitingResearcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class VisitingResearcherDAOJPAImpl implements VisitingResearcherDAO<VisitingResearcher> {
    private EntityManager entityManager;

    @Autowired
    public VisitingResearcherDAOJPAImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<VisitingResearcher> findAll() {
        return entityManager.createQuery("FROM VisitingResearcher", VisitingResearcher.class).getResultList();
    }

    @Override
    public VisitingResearcher findById(int id) {
        return entityManager.find(VisitingResearcher.class, id);
    }

    @Override
    public VisitingResearcher save(VisitingResearcher visitingResearcher) {
        return entityManager.merge(visitingResearcher);
    }

    @Override
    public void update(VisitingResearcher visitingResearcher) {
        entityManager.merge(visitingResearcher);
    }

    @Override
    public void deleteById(int id) {
        entityManager.remove(entityManager.find(VisitingResearcher.class, id));
    }

    @Override
    public void deleteByObject(VisitingResearcher visitingResearcher) {
        entityManager.remove(entityManager.find(VisitingResearcher.class, visitingResearcher.getId()));
    }
}
