/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmrs.module.accessmonitor.api.db.hibernate;

import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.openmrs.module.accessmonitor.VisitServiceAccess;
import org.openmrs.module.accessmonitor.api.db.VisitAccessDAO;

/**
 *
 * @author Ray
 */
public class HibernateVisitAccessDAO implements VisitAccessDAO{
    
    
    protected final Log log = LogFactory.getLog(this.getClass());
	
	private SessionFactory sessionFactory;
	
	/**
     * @param sessionFactory the sessionFactory to set
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
	    this.sessionFactory = sessionFactory;
    }
    
	/**
     * @return the sessionFactory
     */
    public SessionFactory getSessionFactory() {
	    return sessionFactory;
    }


    @Override
     public VisitServiceAccess getVisitServiceAccessById(Integer id) {
        return (VisitServiceAccess) sessionFactory.getCurrentSession().get(VisitServiceAccess.class, id);
    }

    @Override
    public List<VisitServiceAccess> getVisitServiceAccessesByAccessorId(
            Integer accessorId) {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(
                VisitServiceAccess.class);
        crit.add(Restrictions.eq("accessorId", accessorId));
        return crit.list();
    }

    @Override
    public List<VisitServiceAccess> getVisitServiceAccessesByPatientId(Integer patientId) {
         Criteria crit = sessionFactory.getCurrentSession().createCriteria(
                VisitServiceAccess.class);
        crit.add(Restrictions.eq("patienId", patientId));
        return crit.list();
    }

    @Override
    public List<VisitServiceAccess> getVisitServiceAccessesByVisitId(Integer visitId) {
         Criteria crit = sessionFactory.getCurrentSession().createCriteria(
                VisitServiceAccess.class);
        crit.add(Restrictions.eq("visitId", visitId));
        return crit.list();
    }

    @Override
    public List<VisitServiceAccess> getVisitServiceAccessesByVisitType(String visitType) {
         Criteria crit = sessionFactory.getCurrentSession().createCriteria(
                VisitServiceAccess.class);
        crit.add(Restrictions.eq("visitType", visitType));
        return crit.list();
    }

    @Override
    public List<VisitServiceAccess> getVisitServiceAccessesByAccessType(String accessType) {
         Criteria crit = sessionFactory.getCurrentSession().createCriteria(
                VisitServiceAccess.class);
        crit.add(Restrictions.eq("accessType", accessType));
        return crit.list();
    }

    @Override
    public List<VisitServiceAccess> getVisitServiceAccessesByVisitUuid(String visitUuid) {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(
                VisitServiceAccess.class);
        crit.add(Restrictions.eq("visitUuid", visitUuid));
        return crit.list();
    }

    @Override
    public List<VisitServiceAccess> getVisitServiceAccessesByVoidReason(String voidReason) {
         Criteria crit = sessionFactory.getCurrentSession().createCriteria(
                VisitServiceAccess.class);
        crit.add(Restrictions.eq("accessorId", voidReason));
        return crit.list();
    }

    @Override
    public List<VisitServiceAccess> getVisitServiceAccessesByAccessDate(Date accessDate) {
         Criteria crit = sessionFactory.getCurrentSession().createCriteria(
                VisitServiceAccess.class);
        crit.add(Restrictions.eq("accessDate", accessDate));
        return crit.list();
    }

    @Override
    public List<VisitServiceAccess> getVisitServiceAccessesByVisitStartDate(Date visitStartDate) {
         Criteria crit = sessionFactory.getCurrentSession().createCriteria(
                VisitServiceAccess.class);
        crit.add(Restrictions.eq("visitStartDate", visitStartDate));
        return crit.list();
    }

    @Override
    public List<VisitServiceAccess> getVisitServiceAccessesByVisitEndDate(Date visitEndDate) {
         Criteria crit = sessionFactory.getCurrentSession().createCriteria(
                VisitServiceAccess.class);
        crit.add(Restrictions.eq("visitEndDate", visitEndDate));
        return crit.list();
    }

    @Override
    public List<VisitServiceAccess> getAllVisitServiceAccesses() {
         Criteria crit = sessionFactory.getCurrentSession().createCriteria(
                VisitServiceAccess.class);
        return crit.list();
    }

        @Override
    public VisitServiceAccess saveVisitServiceAccess(
            VisitServiceAccess visitServiceAccess) {
        sessionFactory.getCurrentSession().saveOrUpdate(visitServiceAccess);
        return visitServiceAccess;
    }
    
}
