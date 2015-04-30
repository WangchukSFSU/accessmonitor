/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmrs.module.accessmonitor.advice;

import java.lang.reflect.Method;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.Order;
import org.openmrs.api.context.Context;
import org.openmrs.module.aoptest.OrderServiceAccess;
import org.openmrs.module.aoptest.api.OrderAccessService;
import org.springframework.aop.MethodBeforeAdvice;

/**
 *
 * @author arod
 */
public class OrderServiceAdvice implements MethodBeforeAdvice {

    protected static final Log log = LogFactory.getLog(BeforeAdvice.class);

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        log.info("");

        try {
            OrderServiceAccess orderAccess = null;

            String methodName = method.getName();

            if (methodName.equals("purgeOrder")) {
                orderAccess = new OrderServiceAccess();

                Order order = (Order) args[0];

                orderAccess.setOrderAndOrderType(order);
                orderAccess.setAccessType("Purge Order");

            } else if (methodName.equals("saveOrder")) {
                orderAccess = new OrderServiceAccess();

                Order order = (Order) args[0];

                orderAccess.setOrderAndOrderType(order);
                if (order.getOrderId() == null) {
                    orderAccess.setAccessType("New Order");
                } else {
                    orderAccess.setAccessType("Update Order");
                }

            } else if (methodName.equals("voidOrder")) {
                orderAccess = new OrderServiceAccess();

                Order order = (Order) args[0];

                orderAccess.setOrderAndOrderType(order);
                orderAccess.setAccessType("Void Order");

            } else if (methodName.equals("unvoidOrder")) {
                orderAccess = new OrderServiceAccess();

                Order order = (Order) args[0];

                orderAccess.setOrderAndOrderType(order);
                orderAccess.setAccessType("Un-Void Order");

            } else if (methodName.equals("undiscontinueOrder")) {
                orderAccess = new OrderServiceAccess();

                Order order = (Order) args[0];

                orderAccess.setOrderAndOrderType(order);
                orderAccess.setAccessType("Un-Discontinue Order");

            }

            if (orderAccess != null) {
                System.out.println("***********************************");
                System.out.println(orderAccess.toString());
                System.out.println("***********************************");
                // geng
                Context.getService(OrderAccessService.class).saveOrderServiceAccess(orderAccess);
            }

        } catch (Exception exception) {
            System.out.println("Something went wrong here: " + exception.getMessage());
        }
    }
}
