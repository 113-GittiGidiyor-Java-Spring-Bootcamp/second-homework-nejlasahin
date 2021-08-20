package com.example.homework.service;

import com.example.homework.dao.VisitingResearcherDAO;
import com.example.homework.model.VisitingResearcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class VisitingResearcherService implements BaseService<VisitingResearcher> {
    private VisitingResearcherDAO visitingResearcherDAO;

    // @Qualifier("visitingResearcherDAOJPAImpl") or @Qualifier("visitingResearcherDAOHibernateImpl")
    @Autowired
    public VisitingResearcherService(@Qualifier("visitingResearcherDAOHibernateImpl") VisitingResearcherDAO visitingResearcherDAO) {
        this.visitingResearcherDAO = visitingResearcherDAO;
    }

    @Override
    public List<VisitingResearcher> findAll() {
        return visitingResearcherDAO.findAll();
    }

    @Override
    public VisitingResearcher findById(int id) {
        return (VisitingResearcher) visitingResearcherDAO.findById(id);
    }

    @Override
    @Transactional
    public VisitingResearcher save(VisitingResearcher visitingResearcher) {
        return (VisitingResearcher) visitingResearcherDAO.save(visitingResearcher);
    }

    @Override
    @Transactional
    public void update(VisitingResearcher visitingResearcher) {
        visitingResearcherDAO.update(visitingResearcher);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        visitingResearcherDAO.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteByObject(VisitingResearcher visitingResearcher) {
        visitingResearcherDAO.deleteByObject(visitingResearcher);
    }
}
