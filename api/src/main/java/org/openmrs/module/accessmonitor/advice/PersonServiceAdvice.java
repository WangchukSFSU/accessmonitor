
package org.openmrs.module.accessmonitor.advice;

/*
 * PersonServiceAdvice class gathers information about use of PersonSerivce 
 * and stores it in the Person Access DB table. 
 */

import java.lang.reflect.Method;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.Person;
import org.openmrs.api.context.Context;
import org.openmrs.module.accessmonitor.PersonServiceAccess;
import org.openmrs.module.accessmonitor.api.PersonAccessService;
import org.springframework.aop.MethodBeforeAdvice;


public class PersonServiceAdvice implements MethodBeforeAdvice {
    
    protected static final Log log = LogFactory.getLog(BeforeAdvice.class);


    @Override
    public void before(Method method, Object[] os, Object o) throws Throwable {
        PersonServiceAccess accessRecord = new PersonServiceAccess();
        if(method.getName().equals("getPerson")){        
            accessRecord.setPersonId((Integer)os[0]);
            accessRecord.setAccessType("Get Person");
//            for(int i=0; i < os.length; i++){
//                System.out.println("Method params: " + os[i]);
//            }
            //the following lines will be changed to insert the information into
            //the DB once we put everything together
//            System.out.println("Accessor ID: " + accessRecord.getAccessorId()); 
//            System.out.println("Person ID: " + accessRecord.getPersonId());
//            System.out.println("Access Type " + accessRecord.getAccessType());
//            System.out.println("Access Date: " + accessRecord.getAccessDate());
            Context.getService(PersonAccessService.class).savePersonServiceAccess(accessRecord);
            
        } else if(method.getName().equals("getPersonByUuid")){
            accessRecord.setPersonUuid((String)os[0]);
            accessRecord.setAccessType("Get Person By Uuid");
            Context.getService(PersonAccessService.class).savePersonServiceAccess(accessRecord);
        
        } else if(method.getName().equals("savePerson")){
            Person person = (Person)os[0];
            accessRecord.setPersonId(person.getId());
            if(person.getId()==null){
                accessRecord.setAccessType("New Person");
            } else {
                accessRecord.setAccessType("Update Person");
            }
            Context.getService(PersonAccessService.class).savePersonServiceAccess(accessRecord);
        } else if(method.getName().equals("purgePerson")){
            Person person = (Person)os[0];
            accessRecord.setPersonId(person.getId());
            accessRecord.setAccessType("Purge Person");
            Context.getService(PersonAccessService.class).savePersonServiceAccess(accessRecord);
        } else if(method.getName().equals("unvoidPerson")){
            Person person = (Person)os[0];
            accessRecord.setPersonId(person.getId());
            accessRecord.setAccessType("Un-void Person");
            Context.getService(PersonAccessService.class).savePersonServiceAccess(accessRecord);
        } else if(method.getName().equals("voidPerson")){
            Person person = (Person)os[0];
            accessRecord.setPersonId(person.getId());
            accessRecord.setAccessType("Void Person");
            Context.getService(PersonAccessService.class).savePersonServiceAccess(accessRecord);
        }
        
    }
    
}
