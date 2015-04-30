/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmrs.module.accessmonitor.advice;

/**
 *
 * @author xuejing
 */
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.Visit;
import org.openmrs.api.context.Context;
import org.openmrs.module.aoptest.VisitServiceAccess;
import org.openmrs.module.aoptest.api.VisitAccessService;
import org.springframework.aop.MethodBeforeAdvice;


public class VisitServiceAdvice implements MethodBeforeAdvice {
    
    protected static final Log log = LogFactory.getLog(BeforeAdvice.class);


    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        
        VisitServiceAccess accessRecord = new VisitServiceAccess();
        
        if(method.getName().equals("getVisit")){        
            accessRecord.setVisitId((Integer)args[0]);
            accessRecord.setAccessType("Get Visit");
            //for(int i=0; i < args.length; i++){
            //    System.out.println("Method params: " + args[i]);
            //}
            //the following lines will be changed to insert the information into
            //the DB once we put everything together
//            System.out.println("Accessor ID: " + accessRecord.getAccessorId()); 
//            System.out.println("Visit ID: " + accessRecord.getVisitId());
//            System.out.println("Access Type " + accessRecord.getAccessType());
//            System.out.println("Access Date: " + accessRecord.getAccessDate());
//            System.out.println("Visit Start Date: " + accessRecord.getVisitStartDate());
//            System.out.println("Visit End Date: " + accessRecord.getVisitEndDate());
            Context.getService(VisitAccessService.class).saveVisitServiceAccess(accessRecord);
        } 
        else if(method.getName().equals("getVisitByUuid")){
//            accessRecord.setVisitUuid((String)args[0]);
            accessRecord.setAccessType("Get Visit By Uuid");
            
//            System.out.println("Accessor ID: " + accessRecord.getAccessorId()); 
//            System.out.println("Visit UuiD: " + accessRecord.getVisitId());
//            System.out.println("Access Type " + accessRecord.getAccessType());
//            System.out.println("Access Date: " + accessRecord.getAccessDate());
//            System.out.println("Visit Start Date: " + accessRecord.getVisitStartDate());
//            System.out.println("Visit End Date: " + accessRecord.getVisitEndDate());
            Context.getService(VisitAccessService.class).saveVisitServiceAccess(accessRecord);
        } 
        else if(method.getName().equals("saveVisit")){
            Visit visit = (Visit)args[0];
            accessRecord.setVisitId(visit.getId());
            if(visit.getId()==null){
                accessRecord.setAccessType("New Visit");
            } else {
                accessRecord.setAccessType("Update Visit");
            }
            Context.getService(VisitAccessService.class).saveVisitServiceAccess(accessRecord);
        } else if(method.getName().equals("purgeVisit")){
            Visit visit = (Visit)args[0];
            accessRecord.setVisitId(visit.getId());
            accessRecord.setAccessType("Purge Visit");
            Context.getService(VisitAccessService.class).saveVisitServiceAccess(accessRecord);
           // for(int i=0; i < args.length; i++){
           //     System.out.println("Method params: " +  args[i]);
           // }
            //the following lines will be changed to insert the information into
            //the DB once we put everything together
//            System.out.println("Accessor ID: " + accessRecord.getAccessorId()); 
//            System.out.println("Visit ID: " + accessRecord.getVisitId());
//            System.out.println("Access Type " + accessRecord.getAccessType());
//            System.out.println("Access Date: " + accessRecord.getAccessDate());
//            System.out.println("Visit Start Date: " + accessRecord.getVisitStartDate());
//            System.out.println("Visit End Date: " + accessRecord.getVisitEndDate());
//            Context.getService(VisitAccessService.class).saveVisitServiceAccess(accessRecord);
        } else if(method.getName().equals("unvoidVisit")){
            Visit visit = (Visit)args[0];
            accessRecord.setVisitId(visit.getId());
            accessRecord.setAccessType("Un-void Visit");
            Context.getService(VisitAccessService.class).saveVisitServiceAccess(accessRecord);
        } else if(method.getName().equals("voidVisit")){
            Visit visit = (Visit)args[0];
            accessRecord.setVisitId(visit.getId());
            accessRecord.setAccessType("Void Visit");
            Context.getService(VisitAccessService.class).saveVisitServiceAccess(accessRecord);
        }
    }
    
}