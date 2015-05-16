package org.openmrs.module.accessmonitor.api.db.hibernate;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
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

    @Override
    public List<OrderServiceAccess> getOrderAccessesByAccessDateOrderByPatientId(
            Date from, Date to) {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(
                OrderServiceAccess.class);
        crit.addOrder(Order.asc("patientId"));
        if (from != null || to != null) {
            if (from == null) {
                crit.add(Restrictions.le("accessDate", to));
            } else if (to == null) {
                crit.add(Restrictions.ge("accessDate", from));
            } else {
                crit.add(Restrictions.between("accessDate", from, to));
            }
        }
        return crit.list();
    }

    @Override
    public List<OrderServiceAccess> getOrderServiceAccessesByAccessorId(
            Integer accessorId, Date from, Date to) {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(
                OrderServiceAccess.class);
        crit.add(Restrictions.eq("accessorId", accessorId));
        if (from != null || to != null) {
            if (from == null) {
                crit.add(Restrictions.le("accessDate", to));
            } else if (to == null) {
                crit.add(Restrictions.ge("accessDate", from));
            } else {
                crit.add(Restrictions.between("accessDate", from, to));
            }
        }
        return crit.list();
    }

    @Override
    public List<OrderServiceAccess> getOrderServiceAccessesByPatientId(
            Integer patientId, Date from, Date to) {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(
                OrderServiceAccess.class);
        crit.add(Restrictions.eq("patientId", patientId));
        if (from != null || to != null) {
            if (from == null) {
                crit.add(Restrictions.le("accessDate", to));
            } else if (to == null) {
                crit.add(Restrictions.ge("accessDate", from));
            } else {
                crit.add(Restrictions.between("accessDate", from, to));
            }
        }
        return crit.list();
    }

    @Override
    public List<OrderServiceAccess> getOrderServiceAccessesByUserId(
            Integer userId, Date from, Date to) {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(
                OrderServiceAccess.class);
        crit.add(Restrictions.eq("userId", userId));
        if (from != null || to != null) {
            if (from == null) {
                crit.add(Restrictions.le("accessDate", to));
            } else if (to == null) {
                crit.add(Restrictions.ge("accessDate", from));
            } else {
                crit.add(Restrictions.between("accessDate", from, to));
            }
        }
        return crit.list();
    }

    @Override
    public List<OrderServiceAccess> getOrderServiceAccessesByOrderId(
            Integer orderId, Date from, Date to) {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(
                OrderServiceAccess.class);
        crit.add(Restrictions.eq("orderId", orderId));
        if (from != null || to != null) {
            if (from == null) {
                crit.add(Restrictions.le("accessDate", to));
            } else if (to == null) {
                crit.add(Restrictions.ge("accessDate", from));
            } else {
                crit.add(Restrictions.between("accessDate", from, to));
            }
        }
        return crit.list();
    }

    @Override
    public List<OrderServiceAccess> getOrderServiceAccessesByOrderType(
            String orderType, Date from, Date to) {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(
                OrderServiceAccess.class);
        crit.add(Restrictions.eq("orderType", orderType));
        if (from != null || to != null) {
            if (from == null) {
                crit.add(Restrictions.le("accessDate", to));
            } else if (to == null) {
                crit.add(Restrictions.ge("accessDate", from));
            } else {
                crit.add(Restrictions.between("accessDate", from, to));
            }
        }
        return crit.list();
    }

    @Override
    public List<OrderServiceAccess> getOrderServiceAccessesByAccessType(
            String accessType, Date from, Date to) {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(
                OrderServiceAccess.class);
        crit.add(Restrictions.eq("accessType", accessType));
        if (from != null || to != null) {
            if (from == null) {
                crit.add(Restrictions.le("accessDate", to));
            } else if (to == null) {
                crit.add(Restrictions.ge("accessDate", from));
            } else {
                crit.add(Restrictions.between("accessDate", from, to));
            }
        }
        return crit.list();
    }

    @Override
    public List<OrderServiceAccess> getOrderServiceAccessesByOrderUuid(
            String orderUuid, Date from, Date to) {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(
                OrderServiceAccess.class);
        crit.add(Restrictions.eq("orderUuid", orderUuid));
        if (from != null || to != null) {
            if (from == null) {
                crit.add(Restrictions.le("accessDate", to));
            } else if (to == null) {
                crit.add(Restrictions.ge("accessDate", from));
            } else {
                crit.add(Restrictions.between("accessDate", from, to));
            }
        }
        return crit.list();
    }

    @Override
    public List<OrderServiceAccess> getOrderServiceAccessesByAccessDate(
            Date from, Date to) {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(
                OrderServiceAccess.class);
        if (from != null || to != null) {
            if (from == null) {
                crit.add(Restrictions.le("accessDate", to));
            } else if (to == null) {
                crit.add(Restrictions.ge("accessDate", from));
            } else {
                crit.add(Restrictions.between("accessDate", from, to));
            }
        }
        return crit.list();
    }
    
//    public void generateData() {
//        Random r = new Random();
//        
//        String[] at = {"Void Order", "Purge Order","New Order","Update Order", "Un-Void Order", "Un-Discontinue Order"};
//        Calendar c = Calendar.getInstance();
//        r.setSeed(c.getTimeInMillis());
//        long end = c.getTimeInMillis();
//        c.set(2013, 0, 1);
//        long start = c.getTimeInMillis();
//        for (int i = 0; i < 10000; i++) {
//            OrderServiceAccess o = new OrderServiceAccess();
//            long date = start + r.nextLong() % (end - start);
//            c.setTimeInMillis(date);
//            o.setAccessDate(c.getTime());
//            o.setAccessorId(r.nextInt(10));
//            o.setAccessType(at[r.nextInt(6)]);
//            o.setOrderId(r.nextInt(5000));
//            o.setPatientId(r.nextInt(8000)+1000);
//            o.setUserId(r.nextInt(1000));
//            saveOrderServiceAccess(o);
//        }
//        
//    }
    
}
