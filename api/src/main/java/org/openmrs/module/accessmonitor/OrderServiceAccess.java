/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmrs.module.accessmonitor;

import java.io.Serializable;
import java.util.Date;
import org.openmrs.BaseOpenmrsObject;
import org.openmrs.User;
import org.openmrs.Patient;
import org.openmrs.Order;
import org.openmrs.api.context.Context;

/**
 *
 * @author arod
 */
public class OrderServiceAccess extends BaseOpenmrsObject implements Serializable {


    private static final long serialVersionUID = 1L;
    protected Integer orderAccessId;
    protected Integer accessorId;
    protected Integer patientId;
    protected Integer userId;
    protected Integer orderId;
    protected String orderType;
    protected String accessType;
    protected String orderUuid;
    protected Date accessDate;

    /**
     * Default constructor Since nothing in the DB is absolutely needed except
     * order_access_id, and that property is set on insertion, nothing needs to
     * be initialized here except the date that the access occurred. The rest of
     * the object should be set manually.
     */
    public OrderServiceAccess() {
        this.accessorId = Context.getAuthenticatedUser().getUserId();
        this.accessDate = new Date();
    }

    public Integer getOrderAccessId(){ return orderAccessId; }
    public void    setOrderAccessId(Integer orderAccessId) { this.orderAccessId = orderAccessId; }
    
    public Integer getAccessorId() { return accessorId; }
    public void    setAccessorId(Integer accessorId) { this.accessorId = accessorId; }
    
    public Integer getPatientId() { return patientId; }
    public void    setPatientId(Integer patientId) { this.patientId = patientId; }
    
    public Integer getUserId() { return userId; }
    public void    setUserId(Integer userId) { this.userId = userId; }
    
    public Integer getOrderId() { return orderId; }
    public void    setOrderId(Integer orderId) { this.orderId = orderId; }
    
    public String  getOrderType() { return orderType; }
    public void    setOrderType(String orderType) { this.orderType = orderType; }
    
    public String  getAccessType() { return accessType; }
    public void    setAccessType(String accessType) { this.accessType = accessType; }
    
    public String  getOrderUuid() { return orderUuid; }
    public void    setOrderUuid(String orderUuid) { this.orderUuid = orderUuid; }
    
    public Date    getAccessDate() { return accessDate; }
    public void    setAccessDate(Date date) { this.accessDate = date; }
    
    @Override
    public Integer getId() { return this.orderAccessId; }

    @Override
    public void setId(Integer id) { this.orderAccessId = id; }

    public void setPatient(Patient patient) { this.patientId = patient.getPatientId(); }
    public void setUser(User user) { this.userId = user.getUserId(); }
    public void setOrder(Order order) { this.orderId = order.getOrderId(); }
    public void setOrderType(Order order) { this.orderType = order.getOrderType().getDescription(); }
    public void setOrderAndOrderType(Order order) {
        this.orderId = order.getOrderId();
        this.orderType = order.getOrderType().getDescription();
        this.patientId = order.getPatient().getPatientId();
    }

    @Override
    public String toString() {
        String output = "";

        output += "Accessor: " + accessorId + "\n";
        output += (patientId == null) ? "" : "Patient: " + patientId + "\n";
        output += (userId == null) ? "" : "User: " + userId + "\n";
        output += (orderId == null) ? "" : "Order: " + orderId + "\n";
        output += (orderType == null) ? "" : "Order Type: " + orderType + "\n";
        output += (accessType == null) ? "" : "Access Type: " + accessType + "\n";
        output += "Date: " + accessDate.toString() + "\n";

        return output;
    }

}
