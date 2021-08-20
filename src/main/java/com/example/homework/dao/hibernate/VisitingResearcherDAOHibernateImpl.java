package com.example.homework.dao.hibernate;

import com.example.homework.dao.VisitingResearcherDAO;
import com.example.homework.model.VisitingResearcher;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class VisitingResearcherDAOHibernateImpl implements VisitingResearcherDAO<VisitingResearcher> {
    private EntityManager entityManager;

    @Autowired
    public VisitingResearcherDAOHibernateImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<VisitingResearcher> findAll() {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("FROM VisitingResearcher", VisitingResearcher.class).getResultList();
    }

    @Override
    public VisitingResearcher findById(int id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(VisitingResearcher.class, id);
    }

    @Override
    public VisitingResearcher save(VisitingResearcher visitingResearcher) {
        Session session = entityManager.unwrap(Session.class);
        return (VisitingResearcher) session.merge(visitingResearcher);
    }

    @Override
    public void update(VisitingResearcher newVisitingResearcher) {
        Session session = entityManager.unwrap(Session.class);
        VisitingResearcher visitingResearcher = session.get(VisitingResearcher.class, newVisitingResearcher.getId());
        visitingResearcher.setName(newVisitingResearcher.getName());
        visitingResearcher.setAddress(newVisitingResearcher.getAddress());
        visitingResearcher.setPhoneNumber(newVisitingResearcher.getPhoneNumber());
        visitingResearcher.setHourlySalary(newVisitingResearcher.getHourlySalary());
        session.merge(visitingResearcher);
    }

    @Override
    public void deleteById(int id) {
        Session session = entityManager.unwrap(Session.class);
        session.delete(session.get(VisitingResearcher.class, id));
    }

    @Override
    public void deleteByObject(VisitingResearcher visitingResearcher) {
        Session session = entityManager.unwrap(Session.class);
        session.delete(session.get(VisitingResearcher.class, visitingResearcher.getId()));
    }
}
