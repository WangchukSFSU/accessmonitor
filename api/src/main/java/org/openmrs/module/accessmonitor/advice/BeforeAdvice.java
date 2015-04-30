/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmrs.module.accessmonitor.advice;

import java.lang.reflect.Method;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.MethodBeforeAdvice;

public class BeforeAdvice implements MethodBeforeAdvice {

    protected static final Log log = LogFactory.getLog(BeforeAdvice.class);

    private int count = 0;

    @Override
    public void before(Method method, Object[] os, Object o) throws Throwable {

        if (method == null) return; // Geng makes this line.
        //if (method.getName().equals("savePerson")) {
            log.info("Method: " + method.getName() + ". Before advice called " + (++count) + " time(s) now.");
            System.out.println("Method: " + method.getName() + ". Before advice called " + (count) + " time(s) now.");
            System.out.println("Object: " + o.toString());           
            for (int i=0; i < os.length; i++){
                System.out.println("Method params: " + os[i]);
            }
        //}
    }

}
