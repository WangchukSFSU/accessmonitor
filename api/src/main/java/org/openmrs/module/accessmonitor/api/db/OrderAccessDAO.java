package org.openmrs.module.accessmonitor.api.db;

import java.util.Date;
import java.util.List;
import org.openmrs.module.accessmonitor.OrderServiceAccess;


public interface OrderAccessDAO {

    // new methods
    
    public List<OrderServiceAccess> getOrderAccessesByAccessDateOrderByPatientId(Date from, Date to);
    
    public List<OrderServiceAccess> getOrderServiceAccessesByAccessorId(Integer accessorId, Date from, Date to);
    
    public List<OrderServiceAccess> getOrderServiceAccessesByPatientId(Integer patientId, Date from, Date to);
    
    public List<OrderServiceAccess> getOrderServiceAccessesByUserId(Integer userId, Date from, Date to);
    
    public List<OrderServiceAccess> getOrderServiceAccessesByOrderId(Integer orderId, Date from, Date to);
    
    public List<OrderServiceAccess> getOrderServiceAccessesByOrderType(String orderType, Date from, Date to);

    public List<OrderServiceAccess> getOrderServiceAccessesByAccessType(String accessType, Date from, Date to);
    
    public List<OrderServiceAccess> getOrderServiceAccessesByOrderUuid(String orderUuid, Date from, Date to);
    
    public List<OrderServiceAccess> getOrderServiceAccessesByAccessDate(Date from, Date to);
    
    // old methods
    public OrderServiceAccess getOrderServiceAccessById(Integer id);
    
    public List<OrderServiceAccess> getOrderServiceAccessesByAccessorId(Integer accessorId);
    
    public List<OrderServiceAccess> getOrderServiceAccessesByPatientId(Integer patientId);
    
    public List<OrderServiceAccess> getOrderServiceAccessesByUserId(Integer userId);
    
    public List<OrderServiceAccess> getOrderServiceAccessesByOrderId(Integer orderId);
    
    public List<OrderServiceAccess> getOrderServiceAccessesByOrderType(String orderType);

    public List<OrderServiceAccess> getOrderServiceAccessesByAccessType(String accessType);
    
    public List<OrderServiceAccess> getOrderServiceAccessesByOrderUuid(String orderUuid);
    
    public List<OrderServiceAccess> getOrderServiceAccessesByAccessDate(Date accessDate);
    
    public List<OrderServiceAccess> getAllOrderServiceAccesses();
    
    public OrderServiceAccess saveOrderServiceAccess(OrderServiceAccess orderServiceAccess);
}
