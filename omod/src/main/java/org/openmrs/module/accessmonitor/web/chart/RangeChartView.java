/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmrs.module.accessmonitor.web.chart;

import java.awt.Color;
import java.util.Map;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.axis.SymbolAxis;
import org.jfree.chart.axis.TickUnit;
import org.jfree.chart.axis.TickUnits;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author tenzinwangchuk
 */
public class RangeChartView {
    
    // create chart in one step
    public JFreeChart createPersonChart(Map<String, Integer> vehicles, String title, String xAxisLabel) {
        
        final XYSeries series1 = new XYSeries("Person Access");
        String[] xs = new String[vehicles.size()];
        int count = 0;
        for (String key : vehicles.keySet()) {
            xs[count] = key;
            series1.add(count, vehicles.get(key));
            count++;
        }
        final XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series1);
        
        final JFreeChart chart = ChartFactory.createHistogram(
                title, // chart title
                "Person Access Property", // x axis label
                "Counts", // y axis label
                dataset, // data
                PlotOrientation.VERTICAL,
                false, // include legend
                false, // tooltips
                false // urls
        );

        chart.setBackgroundPaint(Color.white);

        final XYPlot plot = chart.getXYPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);

        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setTickUnit(new NumberTickUnit(1));
        
        SymbolAxis domainAxis = new SymbolAxis(xAxisLabel, xs);
        domainAxis.setTickUnit(new NumberTickUnit(1));
        domainAxis.setRange(-1, vehicles.size() + 1); 
        plot.setDomainAxis(domainAxis);

        return chart;
    }
    
    
}