/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmrs.module.accessmonitor;

/*
 * VisitServiceAccess class holds information to be stored in or that has been 
 * retrieved from the Visit Access DB table. 
 * 
 */
import java.io.Serializable;
import org.openmrs.Patient;
import org.openmrs.api.context.Context;
import java.util.Date;
import org.openmrs.BaseOpenmrsObject;
import org.openmrs.BaseOpenmrsMetadata;

/**
 * It is a model class. It should extend either {@link BaseOpenmrsObject} or {@link BaseOpenmrsMetadata}.
 */
public class VisitServiceAccess extends BaseOpenmrsObject implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private Integer visitAccessId; //primary key in the visit access table
    private Integer accessorId;//the user id of the user accessing the Visit Service
    private Integer patientId; //the id of the Patient whose records are being accessed
    private Integer visitId; //the id of one visit are being accessed 
    private String visitType;//the type of the visit are being accessed
    private String accessType; //the type of record access (e.g., save, void, etc)
    private String visitUuid; //the UUID of the visit whose record is being accessed
    private String voidReason; //the reason the Person record was voided
    private Date accessDate; //the timestamp of the record access
    private Date visitStartDate;//the timestamp of the starting of the record
    private Date visitEndDate;//the timestamp if the ending of the record

    public VisitServiceAccess() {
        this.accessorId = Context.getAuthenticatedUser().getUserId();
        this.accessDate = new Date();
    }
    
    public VisitServiceAccess(Patient patient) {
        this.accessorId = Context.getAuthenticatedUser().getUserId();
        this.patientId = patient.getId();
        this.accessDate = new Date();
    }
    
    public VisitServiceAccess(Patient patient, String accessType) {
        this.accessorId = Context.getAuthenticatedUser().getUserId();
        this.patientId = patient.getId();
        this.accessType = accessType;
        this.accessDate = new Date();
    }
    
    public Integer getVisitAccessId() { return this.visitAccessId; }
    public void    setVisitAccessId(Integer visitAccessId) { this.visitAccessId = visitAccessId; }
    
    public Integer getAccessorId() { return this.accessorId; }
    public void    setAccessorId(Integer accessorId) { this.accessorId = accessorId; }
    
    public Integer getPatientId() { return this.patientId; }
    public void    setPatientId(Integer patientId) { this.patientId = patientId; }
    
    public Integer getVisitId() { return this.visitId; }
    public void    setVisitId(Integer visitId) { this.visitId = visitId; }
    
    public String  getVisitType() { return this.visitType; }
    public void    setVisitType(String visitType) { this.visitType = visitType; }
    
    public String  getAccessType() { return this.accessType; }
    public void    setAccessType(String accessType) { this.accessType = accessType; }
    
    public String  getVisitUuid() { return this.visitUuid; }
    public void    setVisitUuid(String visitUuid) { this.visitUuid = visitUuid; }
    
    public String  getVoidReason() { return this.voidReason; }
    public void    setVoidReason(String voidReason) { this.voidReason = voidReason; }
    
    public Date    getAccessDate() { return this.accessDate; }
    public void    setAccessDate(Date accessTimestamp) { this.accessDate = accessTimestamp; }
    
    public Date    getVisitStartDate() { return this.visitStartDate; }
    public void    setVisitStartDate(Date startTimestamp) { this.visitStartDate = startTimestamp; }
    
    public Date    getVisitEndDate() { return this.visitEndDate; }
    public void    setVisitEndDate(Date endTimestamp) { this.visitEndDate = endTimestamp; }

    @Override
    public Integer getId() { return this.visitAccessId; }

    @Override
    public void    setId(Integer id) { this.visitAccessId = id; }
    
    
}
