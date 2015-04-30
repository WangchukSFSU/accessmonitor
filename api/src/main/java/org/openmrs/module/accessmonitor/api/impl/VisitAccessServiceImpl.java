/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmrs.module.accessmonitor.api.impl;

import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.accessmonitor.VisitServiceAccess;
import org.openmrs.module.accessmonitor.api.VisitAccessService;
import org.openmrs.module.accessmonitor.api.db.VisitAccessDAO;

/**
 *
 * @author Ray
 */
public class VisitAccessServiceImpl extends BaseOpenmrsService implements VisitAccessService{
    protected final Log log = LogFactory.getLog(this.getClass());
    
    private VisitAccessDAO dao;
    
        /**
     * @param dao the dao to set
     */
    public void setDao(VisitAccessDAO dao) {
        this.dao = dao;
    }
    
    /**
     * @return the dao
     */
    public VisitAccessDAO getDao() {
        return dao;
    }

    @Override
    public VisitServiceAccess getVisitServiceAccessById(Integer id) {
        return dao.getVisitServiceAccessById(id);
    }

    @Override
    public List<VisitServiceAccess> getVisitServiceAccessesByAccessorId(Integer accessorId) {
        return dao.getVisitServiceAccessesByAccessorId(accessorId);
    }

    @Override
    public List<VisitServiceAccess> getVisitServiceAccessesByPatientId(Integer patientId) {
        return dao.getVisitServiceAccessesByPatientId(patientId);
    }

    @Override
    public List<VisitServiceAccess> getVisitServiceAccessesByVisitId(Integer visitId) {
        return dao.getVisitServiceAccessesByVisitId(visitId);
    }

    @Override
    public List<VisitServiceAccess> getVisitServiceAccessesByVisitType(String visitType) {
        return dao.getVisitServiceAccessesByVisitType(visitType);
    }

    @Override
    public List<VisitServiceAccess> getVisitServiceAccessesByAccessType(String accessType) {
        return dao.getVisitServiceAccessesByAccessType(accessType);
    }

    @Override
    public List<VisitServiceAccess> getVisitServiceAccessesByVisitUuid(String visitUuid) {
        return dao.getVisitServiceAccessesByVisitUuid(visitUuid);
    }

    @Override
    public List<VisitServiceAccess> getVisitServiceAccessesByVoidReason(String voidReason) {
        return dao.getVisitServiceAccessesByVoidReason(voidReason);
    }

    @Override
    public List<VisitServiceAccess> getVisitServiceAccessesByAccessDate(Date accessDate) {
        return dao.getVisitServiceAccessesByAccessDate(accessDate);
    }

    @Override
    public List<VisitServiceAccess> getVisitServiceAccessesByVisitStartDate(Date visitStartDate) {
        return dao.getVisitServiceAccessesByVisitStartDate(visitStartDate);
    }

    @Override
    public List<VisitServiceAccess> getVisitServiceAccessesByVisitEndDate(Date visitEndDate) {
        return dao.getVisitServiceAccessesByVisitEndDate(visitEndDate);
    }

    @Override
    public List<VisitServiceAccess> getAllVisitServiceAccesses() {
        return dao.getAllVisitServiceAccesses();
    }

    @Override
    public VisitServiceAccess saveVisitServiceAccess(VisitServiceAccess visitServiceAccess) {
        return dao.saveVisitServiceAccess(visitServiceAccess);
    }
}
