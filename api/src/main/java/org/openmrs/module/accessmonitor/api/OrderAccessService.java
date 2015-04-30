package org.openmrs.module.accessmonitor.api;

import java.util.Date;
import java.util.List;
import org.openmrs.api.OpenmrsService;
import org.openmrs.module.accessmonitor.OrderServiceAccess;


public interface OrderAccessService extends OpenmrsService {
    
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
