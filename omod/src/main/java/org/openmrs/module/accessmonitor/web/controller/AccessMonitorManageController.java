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

import com.keypoint.PngEncoder;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.data.xy.XYSeriesCollection;
import org.openmrs.api.context.Context;
import org.openmrs.module.accessmonitor.OrderServiceAccess;
import org.openmrs.module.accessmonitor.PersonServiceAccess;
import org.openmrs.module.accessmonitor.VisitServiceAccess;
import org.openmrs.module.accessmonitor.api.OrderAccessService;
import org.openmrs.module.accessmonitor.api.PersonAccessService;
import org.openmrs.module.accessmonitor.api.VisitAccessService;
import org.openmrs.module.accessmonitor.web.chart.RangeChartView;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * The main controller.
 */
@Controller
public class AccessMonitorManageController {

    protected final Log log = LogFactory.getLog(getClass());
    protected Map<String, Integer> vehicles = new HashMap<String, Integer>();
    protected String title = "Person Access Counts";
    protected String xAxisLabel = "Person Access Properties";
    protected boolean init = true;
    
    List<PersonServiceAccess> tables1;
    List<OrderServiceAccess> tables2;
    List<VisitServiceAccess> tables3;

    @RequestMapping(value = "/module/accessmonitor/manage", method = RequestMethod.GET)
    public void manage(ModelMap model) {

        
        tables1 = Context.getService(PersonAccessService.class).getAllPersonServiceAccesses();
        if (tables1 == null) {
            tables1 = new ArrayList<PersonServiceAccess>();
        }
        tables2 = Context.getService(OrderAccessService.class).getAllOrderServiceAccesses();
        if (tables2 == null) {
            tables2 = new ArrayList<OrderServiceAccess>();
        }
        tables3 = Context.getService(VisitAccessService.class).getAllVisitServiceAccesses();
        if (tables3 == null) {
            tables3 = new ArrayList<VisitServiceAccess>();
        }

        model.addAttribute("user", Context.getAuthenticatedUser());
        model.addAttribute("tables1", tables1);
        model.addAttribute("tables2", tables2);
        model.addAttribute("tables3", tables3);
        model.addAttribute("personServiceAccess", new PersonServiceAccess());
        model.addAttribute("orderServiceAccess", new OrderServiceAccess());
        model.addAttribute("visitServiceAccess", new VisitServiceAccess());
    }

    @RequestMapping(value = "/module/accessmonitor/manage", method = RequestMethod.POST)
    public void postSave(ModelMap model, HttpServletRequest req) throws IOException {
        // for debug
        System.out.println(req.getParameter("datepickerFrom"));
        System.out.println(req.getParameter("datepickerTo"));
        System.out.println(req.getParameter("xaxis"));
        
        // clean date info from title
        title = "Person Access Counts";
        // Get dates from input
        Date from = null;
        Date to = null;
        // parse them to Date, update tile
        DateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        try {
            from = format.parse(req.getParameter("datepickerFrom"));
        } catch (Exception e) {
            System.out.println("======From Empty===========");
        }
        if (from != null) {
            title += " after " + format.format(from);
        }
        
        try {
            to = format.parse(req.getParameter("datepickerTo"));
        } catch (Exception e) {
            System.out.println("======To Empty===========");
        }
        if (to != null) {
            title += " before " + format.format(to);
        }
        
        xAxisLabel = req.getParameter("xaxis");
        
        // get all the records in the date frame
        List<PersonServiceAccess> list = Context.getService(PersonAccessService.class)
                .getPersonServiceAccessesByAccessDate(from, to);
        
        // clean the old data in vehicles
        vehicles.clear();
        
        // build the graph dataset
        if (xAxisLabel.equals("Accessor Id")) {
            for (PersonServiceAccess pAccess : list) {
                String accessorId = pAccess.getAccessorId().toString();
                System.out.println("Add x a: " + accessorId);
                if (vehicles.containsKey(accessorId)) {
                    Integer newInt = new Integer(vehicles.get(accessorId).intValue() + 1);
                    vehicles.put(accessorId, newInt);
                } else {
                    vehicles.put(accessorId, new Integer(1));
                }
            }
        } else if (xAxisLabel.equals("Person Id")) {
            for (PersonServiceAccess pAccess : list) {
                if (pAccess.getPersonId() == null) continue;
                String personId = pAccess.getPersonId().toString();
                System.out.println("Add x p: " + personId);
                if (vehicles.containsKey(personId)) {
                    Integer newInt = new Integer(vehicles.get(personId).intValue() + 1);
                    vehicles.put(personId, newInt);
                } else {
                    vehicles.put(personId, new Integer(1));
                }
            }
        } else if (xAxisLabel.equals("Access Type")) {
            for (PersonServiceAccess pAccess : list) {
                String accessType = pAccess.getAccessType().toString();
                System.out.println("Add x t: " + accessType);
                if (vehicles.containsKey(accessType)) {
                    Integer newInt = new Integer(vehicles.get(accessType).intValue() + 1);
                    vehicles.put(accessType, newInt);
                } else {
                    vehicles.put(accessType, new Integer(1));
                }
            }
        } else {
            // do nothing!!
        }
        
        init = false;
        
        model.addAttribute("user", Context.getAuthenticatedUser());
        model.addAttribute("tables1", list);
        model.addAttribute("tables2", tables2);
        model.addAttribute("tables3", tables3);
      
    }

    @RequestMapping(value = "/module/accessmonitor/chart", method = RequestMethod.GET)
    public void getChartView(HttpServletRequest request, HttpServletResponse response) throws Exception {

        // If first time come or page refreshed, clean the graph
        if (init) {
            vehicles.clear();
            xAxisLabel = "Person Access Properties";
            title = "Person Access Counts";
        }
        else {
            init = true;
        }
        
        RangeChartView lineGraph = new RangeChartView();
        JFreeChart chart = lineGraph.createPersonChart(vehicles, title, xAxisLabel);
        ChartRenderingInfo info = null;
        info = new ChartRenderingInfo(new StandardEntityCollection());
        response.setContentType("image/png");
        BufferedImage chartImage = chart.createBufferedImage(700, 400, info);
        PngEncoder encoder = new PngEncoder(chartImage, false, 0, 9);
        response.getOutputStream().write(encoder.pngEncode());
    }
}