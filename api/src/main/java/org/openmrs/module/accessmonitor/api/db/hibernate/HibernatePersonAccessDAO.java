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
package org.openmrs.module.accessmonitor.api.db.hibernate;

import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.openmrs.module.accessmonitor.PersonServiceAccess;
import org.openmrs.module.accessmonitor.api.db.PersonAccessDAO;

/**
 * It is a default implementation of  {@link OrderAccessDAO}.
 */
public class HibernatePersonAccessDAO implements PersonAccessDAO {
	protected final Log log = LogFactory.getLog(this.getClass());
	
	private SessionFactory sessionFactory;
	
	/**
     * @param sessionFactory the sessionFactory to set
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
	    this.sessionFactory = sessionFactory;
    }
    
	/**
     * @return the sessionFactory
     */
    public SessionFactory getSessionFactory() {
	    return sessionFactory;
    }
    
    // New methods added on 5/4/2015
    public List<PersonServiceAccess> getPersonServiceAccessesByAccessDate(
            Date from, Date to) {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(
                PersonServiceAccess.class);
        if (from != null || to != null) {
            if (from == null) {
                crit.add(Restrictions.le("accessDate", to));
            } else if (to == null) {
                crit.add(Restrictions.ge("accessDate", from));
            } else {
                crit.add(Restrictions.between("accessDate", from, to));
            }
        }
        return crit.list();
    }
    
    public List<PersonServiceAccess> getPersonServiceAccessesByAccessorId
                    (Integer accessorId, Date from, Date to) {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(
                PersonServiceAccess.class);
        crit.add(Restrictions.eq("accessorId", accessorId));
        if (from != null || to != null) {
            if (from == null) {
                crit.add(Restrictions.le("accessDate", to));
            } else if (to == null) {
                crit.add(Restrictions.ge("accessDate", from));
            } else {
                crit.add(Restrictions.between("accessDate", from, to));
            }
        }
        return crit.list();
    }
    
    public List<PersonServiceAccess> getPersonServiceAccessesByPersonId
                    (Integer personId, Date from, Date to) {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(
                PersonServiceAccess.class);
        crit.add(Restrictions.eq("personId", personId));
        if (from != null || to != null) {
            if (from == null) {
                crit.add(Restrictions.le("accessDate", to));
            } else if (to == null) {
                crit.add(Restrictions.ge("accessDate", from));
            } else {
                crit.add(Restrictions.between("accessDate", from, to));
            }
        }
        return crit.list();
    }

    public List<PersonServiceAccess> getPersonServiceAccessesByPersonUuid
                    (String personUuid, Date from, Date to) {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(
                PersonServiceAccess.class);
        crit.add(Restrictions.eq("personUuid", personUuid));
        if (from != null || to != null) {
            if (from == null) {
                crit.add(Restrictions.le("accessDate", to));
            } else if (to == null) {
                crit.add(Restrictions.ge("accessDate", from));
            } else {
                crit.add(Restrictions.between("accessDate", from, to));
            }
        }
        return crit.list();
    }
    
    public List<PersonServiceAccess> getPersonServiceAccessesByAccessType
                    (String accessType, Date from, Date to) {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(
                PersonServiceAccess.class);
        crit.add(Restrictions.eq("accessType", accessType));
        if (from != null || to != null) {
            if (from == null) {
                crit.add(Restrictions.le("accessDate", to));
            } else if (to == null) {
                crit.add(Restrictions.ge("accessDate", from));
            } else {
                crit.add(Restrictions.between("accessDate", from, to));
            }
        }
        return crit.list();
    }
    
    public List<PersonServiceAccess> getPersonServiceAccessesByVoidReason
                    (String voidReason, Date from, Date to) {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(
                PersonServiceAccess.class);
        crit.add(Restrictions.eq("voidReason", voidReason));
        if (from != null || to != null) {
            if (from == null) {
                crit.add(Restrictions.le("accessDate", to));
            } else if (to == null) {
                crit.add(Restrictions.ge("accessDate", from));
            } else {
                crit.add(Restrictions.between("accessDate", from, to));
            }
        }
        return crit.list();
    }
    

    @Override
    public PersonServiceAccess getPersonServiceAccessById(Integer id) {
        return (PersonServiceAccess) sessionFactory.getCurrentSession().get(PersonServiceAccess.class, id);
    }

    @Override
    public List<PersonServiceAccess> getPersonServiceAccessesByAccessorId(
            Integer accessorId) {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(
                PersonServiceAccess.class);
        crit.add(Restrictions.eq("accessorId", accessorId));
        return crit.list();
    }

    @Override
    public List<PersonServiceAccess> getPersonServiceAccessesByPersonId(
            Integer personId) {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(
                PersonServiceAccess.class);
        crit.add(Restrictions.eq("personId", personId));
        return crit.list();
    }

    @Override
    public List<PersonServiceAccess> getPersonServiceAccessesByPersonType(
            String personType) {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(
                PersonServiceAccess.class);
        crit.add(Restrictions.eq("personType", personType));
        return crit.list();
    }

    @Override
    public List<PersonServiceAccess> getPersonServiceAccessesByPersonUuid(
            String personUuid) {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(
                PersonServiceAccess.class);
        crit.add(Restrictions.eq("personUuid", personUuid));
        return crit.list();
    }

    @Override
    public List<PersonServiceAccess> getPersonServiceAccessesByAccessType(
            String accessType) {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(
                PersonServiceAccess.class);
        crit.add(Restrictions.eq("accessType", accessType));
        return crit.list();
    }

    @Override
    public List<PersonServiceAccess> getPersonServiceAccessesByVoidReason(
            String voidReason) {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(
                PersonServiceAccess.class);
        crit.add(Restrictions.eq("voidReason", voidReason));
        return crit.list();
    }

    @Override
    public List<PersonServiceAccess> getPersonServiceAccessesByAccessDate(
            Date accessDate) {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(
                PersonServiceAccess.class);
        crit.add(Restrictions.eq("accessDate", accessDate));
        return crit.list();
    }

    @Override
    public List<PersonServiceAccess> getAllPersonServiceAccesses() {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(
                PersonServiceAccess.class);
        return crit.list();
    }
    
    @Override
    public PersonServiceAccess savePersonServiceAccess(
            PersonServiceAccess personServiceAccess) {
        sessionFactory.getCurrentSession().saveOrUpdate(personServiceAccess);
        return personServiceAccess;
    }

}