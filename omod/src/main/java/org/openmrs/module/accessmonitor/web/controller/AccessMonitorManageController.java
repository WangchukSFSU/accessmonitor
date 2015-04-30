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
package org.openmrs.module.accessmonitor.web.controller;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.context.Context;
import org.openmrs.module.accessmonitor.OrderServiceAccess;
import org.openmrs.module.accessmonitor.PersonServiceAccess;
import org.openmrs.module.accessmonitor.VisitServiceAccess;
import org.openmrs.module.accessmonitor.api.OrderAccessService;
import org.openmrs.module.accessmonitor.api.PersonAccessService;
import org.openmrs.module.accessmonitor.api.VisitAccessService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * The main controller.
 */
@Controller
public class  AccessMonitorManageController {
	
	protected final Log log = LogFactory.getLog(getClass());
	
//	@RequestMapping(value = "/module/accessmonitor/manage", method = RequestMethod.GET)
//	public void manage(ModelMap model) {
//		model.addAttribute("user", Context.getAuthenticatedUser());
//	}
	
	@RequestMapping(value = "/module/accessmonitor/manage", method = RequestMethod.GET)
    public void manage(ModelMap model) {
        
        List<PersonServiceAccess> tables1;
        List<OrderServiceAccess> tables2;
        List<VisitServiceAccess> tables3;
        tables1 = Context.getService(PersonAccessService.class).getAllPersonServiceAccesses();
        if (tables1 == null)
            tables1 = new ArrayList<PersonServiceAccess>();
        tables2 = Context.getService(OrderAccessService.class).getAllOrderServiceAccesses();
        if (tables2 == null)
            tables2 = new ArrayList<OrderServiceAccess>();
        tables3 = Context.getService(VisitAccessService.class).getAllVisitServiceAccesses();
        if (tables3 == null)
            tables3 = new ArrayList<VisitServiceAccess>();
        
        model.addAttribute("user", Context.getAuthenticatedUser());
        model.addAttribute("tables1", tables1);
        model.addAttribute("tables2", tables2);
        model.addAttribute("tables3", tables3);
        model.addAttribute("personServiceAccess", new PersonServiceAccess());
        model.addAttribute("orderServiceAccess", new OrderServiceAccess());
        model.addAttribute("visitServiceAccess", new VisitServiceAccess());
        
    }
}
