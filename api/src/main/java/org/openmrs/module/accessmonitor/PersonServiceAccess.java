/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmrs.module.accessmonitor;

/*
 * PersonServiceAccess class holds information to be stored in or that has been 
 * retrieved from the Person Access DB table. 
 */

import java.io.Serializable;
import java.util.Date;
import org.openmrs.BaseOpenmrsObject;
import org.openmrs.Person;
import org.openmrs.api.context.Context;

public class PersonServiceAccess extends BaseOpenmrsObject implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private Integer personAccessId; //the primary key for this entry in the Person Access DB table
    private Integer accessorId; //the user id of the user accessing the Person 
    private Integer personId; //the id of the Person whose records are being accessed
    private String personType; //the type of the Person whose records are being accessed (e.g., patient or user) 
    private String accessType; //the type of record access (e.g., save, void, etc)
    private String personUuid; //the UUID of the Person whose record is being accessed
    private String voidReason; //the reason the Person record was voided
    private Date accessDate; //the timestamp of the record access
    
    public PersonServiceAccess() {
        this.accessorId = Context.getAuthenticatedUser().getUserId();
        this.accessDate = new Date();
    }
    
    public PersonServiceAccess(Person person) {
        this.accessorId = Context.getAuthenticatedUser().getUserId();
        this.personId = person.getId();
        this.accessDate = new Date();
    }
    
    public PersonServiceAccess(Person person, String accessType) {
        this.accessorId = Context.getAuthenticatedUser().getUserId();
        this.personId = person.getId();
        this.accessType = accessType;
        this.accessDate = new Date();
    }
    
    public Integer getPersonAccessId() { return this.personAccessId; }
    public void    setPersonAccessId(Integer pk) { this.personAccessId = pk; }
    
    public Integer getAccessorId() { return this.accessorId; }
    public void    setAccessorId(Integer accessorId) { this.accessorId = accessorId; }
    
    public Integer getPersonId() { return this.personId; }
    public void    setPersonId(Integer personId) { this.personId = personId; }
    
    public String  getPersonType() { return this.personType; }
    public void    setPersonType(String personType) { this.personType = personType; }
    
    public String  getAccessType() { return this.accessType; }
    public void    setAccessType(String accessType) { this.accessType = accessType; }
    
    public String  getPersonUuid() { return this.personUuid; }
    public void    setPersonUuid(String personUuid) { this.personUuid = personUuid; }
    
    public String  getVoidReason() { return this.voidReason; }
    public void    setVoidReason(String voidReason) { this.voidReason = voidReason; }
    
    public Date    getAccessDate() { return this.accessDate; }
    public void    setAccessDate(Date timestamp) { this.accessDate = timestamp; }
    
    @Override
    public Integer getId() { return this.personAccessId; }

    @Override
    public void    setId(Integer id) { this.personAccessId = id; }
    
}
