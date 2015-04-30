package org.openmrs.module.accessmonitor.api.db.hibernate;

import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.openmrs.module.accessmonitor.OrderServiceAccess;
import org.openmrs.module.accessmonitor.api.db.OrderAccessDAO;


public class HibernateOrderAccessDAO implements OrderAccessDAO {
    
    protected final Log log = LogFactory.getLog(this.getClass());
    
    private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    @Override
    public OrderServiceAccess getOrderServiceAccessById(Integer id) {
        return (OrderServiceAccess) sessionFactory.getCurrentSession().get(OrderServiceAccess.class, id);
    }
    
    @Override
    public List<OrderServiceAccess> getOrderServiceAccessesByAccessorId(
            Integer accessorId) {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(
                OrderServiceAccess.class);
        crit.add(Restrictions.eq("accessorId", accessorId));
        return crit.list();
    }
    
    @Override
    public List<OrderServiceAccess> getOrderServiceAccessesByPatientId(
            Integer patientId) {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(
                OrderServiceAccess.class);
        crit.add(Restrictions.eq("patientId", patientId));
        return crit.list();
    }
    
    @Override
    public List<OrderServiceAccess> getOrderServiceAccessesByUserId(
            Integer userId) {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(
                OrderServiceAccess.class);
        crit.add(Restrictions.eq("userId", userId));
        return crit.list();
    }
    
    @Override
    public List<OrderServiceAccess> getOrderServiceAccessesByOrderId(
            Integer orderId) {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(
                OrderServiceAccess.class);
        crit.add(Restrictions.eq("orderId", orderId));
        return crit.list();
    }
    
    @Override
    public List<OrderServiceAccess> getOrderServiceAccessesByOrderType(
            String orderType) {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(
                OrderServiceAccess.class);
        crit.add(Restrictions.eq("orderType", orderType));
        return crit.list();
    }
    
    @Override
    public List<OrderServiceAccess> getOrderServiceAccessesByAccessType(
            String accessType) {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(
                OrderServiceAccess.class);
        crit.add(Restrictions.eq("accessType", accessType));
        return crit.list();
    }
    
    @Override
    public List<OrderServiceAccess> getOrderServiceAccessesByOrderUuid(
            String orderUuid) {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(
                OrderServiceAccess.class);
        crit.add(Restrictions.eq("orderUuid", orderUuid));
        return crit.list();
    }
    
    @Override
    public List<OrderServiceAccess> getOrderServiceAccessesByAccessDate(
            Date accessDate) {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(
                OrderServiceAccess.class);
        crit.add(Restrictions.eq("accessorDate", accessDate));
        return crit.list();
    }
    
    @Override
    public List<OrderServiceAccess> getAllOrderServiceAccesses() {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(
                OrderServiceAccess.class);
        return crit.list();
    }
    
    @Override
    public OrderServiceAccess saveOrderServiceAccess(
            OrderServiceAccess orderServiceAccess) {
        sessionFactory.getCurrentSession().saveOrUpdate(orderServiceAccess);
        return orderServiceAccess;
    }
    
}
