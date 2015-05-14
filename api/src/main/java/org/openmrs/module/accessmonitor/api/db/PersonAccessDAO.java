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
package org.openmrs.module.accessmonitor.api.db;

import java.util.Date;
import java.util.List;
import org.openmrs.module.accessmonitor.PersonServiceAccess;

/**
 * Database methods for {@link PersonAccessService}.
 */
public interface PersonAccessDAO {
    
    /*
     * Add DAO methods here
     */
    
    // New methods added on 5/13/2015
    public List<PersonServiceAccess> getPersonAccessesByAccessDateOrderByPersonId(
            Date from, Date to);
    
    // New methods added on 5/4/2015
    public List<PersonServiceAccess> getPersonServiceAccessesByAccessDate(
            Date from, Date to);
    
    public List<PersonServiceAccess> getPersonServiceAccessesByAccessorId(
            Integer accessorId, Date from, Date to);
    
    public List<PersonServiceAccess> getPersonServiceAccessesByPersonId(
            Integer personId, Date from, Date to);
    
    public List<PersonServiceAccess> getPersonServiceAccessesByPersonUuid(
            String personUuid, Date from, Date to);
    
    public List<PersonServiceAccess> getPersonServiceAccessesByAccessType(
            String accessType, Date from, Date to);
    
    public List<PersonServiceAccess> getPersonServiceAccessesByVoidReason(
            String voidReason, Date from, Date to);
    
    public PersonServiceAccess getPersonServiceAccessById(Integer id);
    
    public List<PersonServiceAccess> getPersonServiceAccessesByAccessorId(
            Integer accessorId);
    
    public List<PersonServiceAccess> getPersonServiceAccessesByPersonId(
            Integer personId);
    
    public List<PersonServiceAccess> getPersonServiceAccessesByPersonType(
            String personType);
    
    public List<PersonServiceAccess> getPersonServiceAccessesByPersonUuid(
            String personUuid);
    
    public List<PersonServiceAccess> getPersonServiceAccessesByAccessType(
            String accessType);
    
    public List<PersonServiceAccess> getPersonServiceAccessesByVoidReason(
            String voidReason);
    
    public List<PersonServiceAccess> getPersonServiceAccessesByAccessDate(
            Date accessDate);
    
    public List<PersonServiceAccess> getAllPersonServiceAccesses();
    
    public PersonServiceAccess savePersonServiceAccess(
            PersonServiceAccess personServiceAccess);
}