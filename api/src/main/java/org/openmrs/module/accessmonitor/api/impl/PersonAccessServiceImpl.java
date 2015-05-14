/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.module.accessmonitor.api.impl;

import java.util.Date;
import java.util.List;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.module.accessmonitor.PersonServiceAccess;
import org.openmrs.module.accessmonitor.api.PersonAccessService;
import org.openmrs.module.accessmonitor.api.db.PersonAccessDAO;

/**
 * It is a default implementation of {@link PersonAccessService}.
 */
public class PersonAccessServiceImpl extends BaseOpenmrsService implements
        PersonAccessService {
    
    protected final Log log = LogFactory.getLog(this.getClass());
    
    private PersonAccessDAO dao;
    
    /**
     * @param dao
     *            the dao to set
     */
    public void setDao(PersonAccessDAO dao) {
        this.dao = dao;
    }
    
    /**
     * @return the dao
     */
    public PersonAccessDAO getDao() {
        return dao;
    }
    
    // New methods added on 5/13/2015
    public List<PersonServiceAccess> getPersonAccessesByAccessDateOrderByPersonId(
            Date from, Date to) {
        return dao.getPersonAccessesByAccessDateOrderByPersonId(from, to);
    }
    
    // New methods added on 5/4/2015
    public List<PersonServiceAccess> getPersonServiceAccessesByAccessDate(
            Date from, Date to) {
        return dao.getPersonServiceAccessesByAccessDate(from, to);
    }
    
    public List<PersonServiceAccess> getPersonServiceAccessesByAccessorId(
            Integer accessorId, Date from, Date to) {
        return dao.getPersonServiceAccessesByAccessorId(accessorId, from, to);
    }
    
    public List<PersonServiceAccess> getPersonServiceAccessesByPersonId(
            Integer personId, Date from, Date to) {
        return dao.getPersonServiceAccessesByPersonId(personId, from, to);
    }
    
    public List<PersonServiceAccess> getPersonServiceAccessesByPersonUuid(
            String personUuid, Date from, Date to) {
        return dao.getPersonServiceAccessesByPersonUuid(personUuid, from, to);
    }
    
    public List<PersonServiceAccess> getPersonServiceAccessesByAccessType(
            String accessType, Date from, Date to) {
        return dao.getPersonServiceAccessesByAccessType(accessType, from, to);
    }
    
    public List<PersonServiceAccess> getPersonServiceAccessesByVoidReason(
            String voidReason, Date from, Date to) {
        return dao.getPersonServiceAccessesByVoidReason(voidReason, from, to);
    }
    
    @Override
    public PersonServiceAccess getPersonServiceAccessById(Integer id) {
        return dao.getPersonServiceAccessById(id);
    }
    
    // @Override
    // public List<PersonServiceAccess> getPersonServiceAccessesByAccessorId(
    // Integer accessorId) {
    // return dao.getPersonServiceAccessesByAccessorId(accessorId);
    // }
    
    @Override
    public List<PersonServiceAccess> getPersonServiceAccessesByPersonId(
            Integer personId) {
        return dao.getPersonServiceAccessesByPersonId(personId);
    }
    
    @Override
    public List<PersonServiceAccess> getPersonServiceAccessesByPersonType(
            String personType) {
        return dao.getPersonServiceAccessesByPersonType(personType);
    }
    
    @Override
    public List<PersonServiceAccess> getPersonServiceAccessesByPersonUuid(
            String personUuid) {
        return dao.getPersonServiceAccessesByPersonUuid(personUuid);
    }
    
    @Override
    public List<PersonServiceAccess> getPersonServiceAccessesByAccessType(
            String accessType) {
        return dao.getPersonServiceAccessesByAccessType(accessType);
    }
    
    @Override
    public List<PersonServiceAccess> getPersonServiceAccessesByVoidReason(
            String voidReason) {
        return dao.getPersonServiceAccessesByVoidReason(voidReason);
    }
    
    @Override
    public List<PersonServiceAccess> getPersonServiceAccessesByAccessDate(
            Date accessDate) {
        return dao.getPersonServiceAccessesByAccessDate(accessDate);
    }
    
    @Override
    public List<PersonServiceAccess> getAllPersonServiceAccesses() {
        return dao.getAllPersonServiceAccesses();
    }
    
    @Override
    public PersonServiceAccess savePersonServiceAccess(
            PersonServiceAccess personServiceAccess) {
        return dao.savePersonServiceAccess(personServiceAccess);
    }
    
    @Override
    public List<PersonServiceAccess> getPersonServiceAccessesByAccessorId(
            Integer accessorId) {
        return null;
    }
    
}