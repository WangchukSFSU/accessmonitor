package org.openmrs.module.accessmonitor.api.impl;

import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.accessmonitor.OrderServiceAccess;
import org.openmrs.module.accessmonitor.api.OrderAccessService;
import org.openmrs.module.accessmonitor.api.db.OrderAccessDAO;


public class OrderAccessServiceImpl extends BaseOpenmrsService implements OrderAccessService {
    
    protected final Log log = LogFactory.getLog(this.getClass());
    
    private OrderAccessDAO dao;
    
    public void setDao(OrderAccessDAO dao) {
        this.dao = dao;
    }
    
    public OrderAccessDAO getDao() {
        return dao;
    }
    
    // new methods
    
    public List<OrderServiceAccess> getOrderAccessesByAccessDateOrderByPatientId(Date from, Date to) {
        return dao.getOrderAccessesByAccessDateOrderByPatientId(from, to);
    }
    
    public List<OrderServiceAccess> getOrderServiceAccessesByAccessorId(Integer accessorId, Date from, Date to) {
        return dao.getOrderServiceAccessesByAccessorId(accessorId, from, to);
    }
    
    public List<OrderServiceAccess> getOrderServiceAccessesByPatientId(Integer patientId, Date from, Date to) {
        return dao.getOrderServiceAccessesByPatientId(patientId, from, to);
    }
    
    public List<OrderServiceAccess> getOrderServiceAccessesByUserId(Integer userId, Date from, Date to) {
        return dao.getOrderServiceAccessesByUserId(userId, from, to);
    }
    
    public List<OrderServiceAccess> getOrderServiceAccessesByOrderId(Integer orderId, Date from, Date to) {
        return dao.getOrderServiceAccessesByOrderId(orderId, from, to);
    }
    
    public List<OrderServiceAccess> getOrderServiceAccessesByOrderType(String orderType, Date from, Date to) {
        return dao.getOrderServiceAccessesByOrderType(orderType, from, to);
    }

    public List<OrderServiceAccess> getOrderServiceAccessesByAccessType(String accessType, Date from, Date to) {
        return dao.getOrderServiceAccessesByAccessType(accessType, from, to);
    }
    
    public List<OrderServiceAccess> getOrderServiceAccessesByOrderUuid(String orderUuid, Date from, Date to) {
        return dao.getOrderServiceAccessesByOrderUuid(orderUuid, from, to);
    }
    
    public List<OrderServiceAccess> getOrderServiceAccessesByAccessDate(Date from, Date to) {
        return dao.getOrderServiceAccessesByAccessDate(from, to);
    }
    
    // old methods
    
    @Override
    public OrderServiceAccess getOrderServiceAccessById(Integer id) {
        return dao.getOrderServiceAccessById(id);
    }
    
    @Override
    public List<OrderServiceAccess> getOrderServiceAccessesByAccessorId(
            Integer accessorId) {
        return dao.getOrderServiceAccessesByAccessorId(accessorId);
    }
    
    @Override
    public List<OrderServiceAccess> getOrderServiceAccessesByPatientId(
            Integer patientId) {
        return dao.getOrderServiceAccessesByPatientId(patientId);
    }
    
    @Override
    public List<OrderServiceAccess> getOrderServiceAccessesByUserId(Integer userId) {
        return dao.getOrderServiceAccessesByUserId(userId);
    }
    
    @Override
    public List<OrderServiceAccess> getOrderServiceAccessesByOrderId(
            Integer orderId) {
        return dao.getOrderServiceAccessesByOrderId(orderId);
    }
    
    @Override
    public List<OrderServiceAccess> getOrderServiceAccessesByOrderType(
            String orderType) {
        return dao.getOrderServiceAccessesByOrderType(orderType);
    }
    
    @Override
    public List<OrderServiceAccess> getOrderServiceAccessesByAccessType(
            String accessType) {
        return dao.getOrderServiceAccessesByAccessType(accessType);
    }
    
    @Override
    public List<OrderServiceAccess> getOrderServiceAccessesByOrderUuid(
            String orderUuid) {
        return dao.getOrderServiceAccessesByOrderUuid(orderUuid);
    }
    
    @Override
    public List<OrderServiceAccess> getOrderServiceAccessesByAccessDate(
            Date accessDate) {
        return dao.getOrderServiceAccessesByAccessDate(accessDate);
    }
    
    @Override
    public List<OrderServiceAccess> getAllOrderServiceAccesses() {
        return dao.getAllOrderServiceAccesses();
    }
    
    @Override
    public OrderServiceAccess saveOrderServiceAccess(
            OrderServiceAccess orderServiceAccess) {
        return dao.saveOrderServiceAccess(orderServiceAccess);
    }
    
//    public void generateData() {
//        dao.generateData();
//    }

}
