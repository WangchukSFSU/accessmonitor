/**
 * The contents of this file are subject to the OpenMRS Public License Version
 * 1.0 (the "License"); you may not use this file except in compliance with the
 * License. You may obtain a copy of the License at http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for
 * the specific language governing rights and limitations under the License.
 *
 * Copyright (C) OpenMRS, LLC. All Rights Reserved.
 */
package org.openmrs.module.accessmonitor.web.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.simple.JSONValue;
import org.openmrs.api.context.Context;
import org.openmrs.module.accessmonitor.PersonServiceAccess;
import org.openmrs.module.accessmonitor.api.PersonAccessService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * The main controller.
 */
@Controller
public class AccessMonitorPersonController {

    protected final Log log = LogFactory.getLog(getClass());
    
    private final int DAYNUM = 30;
    private final int SHOWNUM = 20;
    
    List<PersonServiceAccess> personAccessData;

    @RequestMapping(value = "/module/accessmonitor/person", method = RequestMethod.GET)
    public void person(ModelMap model, HttpServletRequest request) {
        
        // parse them to Date, null is acceptabl
        DateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        // Get the from date and to date
        Date to = null;
        Date from = null;
        try {
            from = format.parse(request.getParameter("datepickerFrom"));
        } catch (Exception e) {
            //System.out.println("======From Date Empty=======");
        }
        try {
            to = format.parse(request.getParameter("datepickerTo"));
        } catch (Exception e) {
            //System.out.println("======To Date Empty=======");
        }
        
        // get all the records in the date range
        personAccessData = ((PersonAccessService) Context.getService(PersonAccessService.class))
                .getPersonAccessesByAccessDateOrderByPersonId(from, to);
        if (personAccessData == null) {
            personAccessData = new ArrayList<PersonServiceAccess>();
        }
        
        // get date for small graph
        Date toSmall = to;
        Date fromSmall = null;
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 1);
        if (toSmall == null) {
            toSmall = calendar.getTime();
        } else {
            calendar.setTime(toSmall);
        }
        calendar.add(Calendar.DATE, - DAYNUM);
        fromSmall = calendar.getTime();
        
        List<String> dateStrings = new ArrayList<String>();
        for (int i = 0; i < DAYNUM; i++) {
            if (i == DAYNUM - 1) {
                dateStrings.add(format.format(toSmall));
            } else if (i == 0) {
                dateStrings.add(format.format(fromSmall));
            } else {
                dateStrings.add("");
            }
        }
        
        ArrayList<ArrayList<Integer>> tooltip = new ArrayList<ArrayList<Integer>>();
        tooltip.add(new ArrayList<Integer>());
        for (int j = 0; j < SHOWNUM + 1; j++) {
            tooltip.get(0).add(1000+j);
        }
        for (int i = 1; i < DAYNUM + 1; i++) {
            tooltip.add(new ArrayList<Integer>());
            tooltip.get(i).add(i);
            for (int j = 0; j < SHOWNUM; j++) {
                tooltip.get(i).add(0);
            }
        }

        ArrayList<String> personIds = new ArrayList<String>();
        ArrayList<Integer> personCounts = new ArrayList<Integer>();
        for (PersonServiceAccess pa : personAccessData) {
            // data for big graph
            String idString = (pa.getPersonId() == null) ? "No ID" : pa.getPersonId().toString();
            int index = personIds.indexOf(idString);
            if (index < 0) {
                if (personIds.size() >= SHOWNUM)
                    break;
                personIds.add(idString);
                personCounts.add(1);
                index = personIds.size() - 1;//index = personIds.indexOf(idString);
            } else {
                personCounts.set(index, personCounts.get(index) + 1);
            }
            // data for small graph
            if (pa.getAccessDate().after(fromSmall) && 
                    pa.getAccessDate().before(toSmall)) {
                int index2 = (int) ((pa.getAccessDate().getTime() - fromSmall.getTime()) / (1000 * 60 * 60 * 24));
                if (index2 < DAYNUM && index2 >= 0)
                    tooltip.get(index2 + 1).set(index + 1, tooltip.get(index2 + 1).get(index + 1) + 1);
            }
        }
        String personIdString = JSONValue.toJSONString(personIds);
        String personCountString = JSONValue.toJSONString(personCounts);
        String dateSmallString = JSONValue.toJSONString(dateStrings);
        String tooltipdata = JSONValue.toJSONString(tooltip);
        model.addAttribute("personIds", personIdString);
        model.addAttribute("personCounts", personCountString);
        model.addAttribute("dateSmallString", dateSmallString);
        model.addAttribute("tooltipdata", tooltipdata);
        
        
        model.addAttribute("user", Context.getAuthenticatedUser());
        model.addAttribute("tables1", personAccessData);
        model.addAttribute("dateSmall", dateStrings);
    }

    @RequestMapping(value = "/module/accessmonitor/person", method = RequestMethod.POST)
    public void postSave(ModelMap model, HttpServletRequest request) throws IOException {
       
    }

}