package org.openmrs.module.accessmonitor.api.db;

import java.util.Date;
import java.util.List;
import org.openmrs.module.accessmonitor.OrderServiceAccess;


public interface OrderAccessDAO {
    
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
