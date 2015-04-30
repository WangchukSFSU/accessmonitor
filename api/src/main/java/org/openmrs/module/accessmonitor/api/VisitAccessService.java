/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmrs.module.accessmonitor.api;

import java.util.*;
import org.openmrs.api.OpenmrsService;
import org.openmrs.module.accessmonitor.VisitServiceAccess;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ray
 */
@Transactional
public interface VisitAccessService extends OpenmrsService{
    
    public VisitServiceAccess getVisitServiceAccessById(Integer id);
    
    public List<VisitServiceAccess> getVisitServiceAccessesByAccessorId(Integer accessorId);
    
    public List<VisitServiceAccess> getVisitServiceAccessesByPatientId(Integer patientId);
    
    public List<VisitServiceAccess> getVisitServiceAccessesByVisitId(Integer visitId);
    
    public List<VisitServiceAccess> getVisitServiceAccessesByVisitType(String visitType);
    
    public List<VisitServiceAccess> getVisitServiceAccessesByAccessType(String accessType);
    
    public List<VisitServiceAccess> getVisitServiceAccessesByVisitUuid(String visitUuid);
    
    public List<VisitServiceAccess> getVisitServiceAccessesByVoidReason(String voidReason);
    
    public List<VisitServiceAccess> getVisitServiceAccessesByAccessDate(Date accessDate);
    
    public List<VisitServiceAccess> getVisitServiceAccessesByVisitStartDate(Date visitStartDate);
    
    public List<VisitServiceAccess> getVisitServiceAccessesByVisitEndDate(Date visitEndDate);
    
    public List<VisitServiceAccess> getAllVisitServiceAccesses();
    
    public VisitServiceAccess saveVisitServiceAccess(VisitServiceAccess visitServiceAccess);

    }