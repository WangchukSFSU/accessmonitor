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
    public JFreeChart createPersonChart(Map<String, Integer> vehicles, String xAxisLabel) {
        
        final XYSeries series1 = new XYSeries("Person Access");
        String[] xs = new String[vehicles.size()];
        //double[] ds = new double[vehicles.size()];
        int count = 0;
        for (String key : vehicles.keySet()) {
            xs[count] = key;
            //ds[count] = vehicles.get(key).doubleValue();
            series1.add(count, vehicles.get(key));
            count++;
        }
        final XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series1);
        //HistogramDataset dataset = new HistogramDataset();
        //dataset.addSeries("S1", ds, vehicles.size());
        //double[] dd = {2,3,4,5,8};
        //dataset.addSeries("S1", dd, 5);
        
        final JFreeChart chart = ChartFactory.createHistogram(
                "Person Access Counts", // chart title
                "Person Access Property", // x axis label
                "Counts", // y axis label
                dataset, // data
                PlotOrientation.VERTICAL,
                false, // include legend
                false, // tooltips
                false // urls
        );

        // NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...
        chart.setBackgroundPaint(Color.white);

        // get a reference to the plot for further customisation...
        final XYPlot plot = chart.getXYPlot();
        //final CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);

        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setTickUnit(new NumberTickUnit(1));
        
        //CategoryAxis domainAxis = plot.getDomainAxis();
        //domainAxis.setLabel(xAxisLabel);
        SymbolAxis domainAxis = new SymbolAxis(xAxisLabel, xs);
        domainAxis.setTickUnit(new NumberTickUnit(1));
        domainAxis.setRange(-1, vehicles.size() + 1); 
        plot.setDomainAxis(domainAxis);

        return chart;
    }
    
    // old method, won't use
    public JFreeChart createChart(final XYDataset dataset) {
        
     // create the chart...
        final JFreeChart chart = ChartFactory.createXYLineChart(
                "Trace Access", // chart title
                "X", // x axis label
                "Y", // y axis label
                dataset, // data
                PlotOrientation.VERTICAL,
                true, // include legend
                true, // tooltips
                false // urls
        );

        // NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...
        chart.setBackgroundPaint(Color.white);

        // get a reference to the plot for further customisation...
        final XYPlot plot = chart.getXYPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);

        final XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesLinesVisible(0, false);
        renderer.setSeriesShapesVisible(1, false);
        plot.setRenderer(renderer);

       // final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        // rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        String[] grade = new String[5];
        grade[0] = "Person 0";
        grade[1] = "Person 1";
        grade[2] = "Person 2";
        grade[3] = "Person 3";
        grade[4] = "Person 4";
        SymbolAxis rangeAxis = new SymbolAxis("Words", grade);
        rangeAxis.setTickUnit(new NumberTickUnit(1));
        rangeAxis.setRange(0, grade.length);
        plot.setDomainAxis(rangeAxis);

        String[] xgrade = new String[5];
        xgrade[0] = "Date 0";
        xgrade[1] = "Date 1";
        xgrade[2] = "Date 2";
        xgrade[3] = "Date 3";
        xgrade[4] = "Date 4";
        SymbolAxis rangeAxisx = new SymbolAxis("Words", xgrade);
        rangeAxisx.setTickUnit(new NumberTickUnit(1));
        rangeAxisx.setRange(0, grade.length); 
        plot.setRangeAxis(rangeAxisx);
        

        return chart;
        
    }
    
    public XYDataset createDataset() {
        
        final XYSeries series1 = new XYSeries("Person Access");
        
        //series1.add(0.0, 0.0);
        
        final XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series1);
        // dataset.addSeries(series2);
        // dataset.addSeries(series3);
        
        return dataset;
        
    }
    
    public XYDataset createDataset(Map vehicles) {
        
        final XYSeries series1 = new XYSeries("Person Access");
        // AccessMonitorManageController AA = new
        // AccessMonitorManageController();
        
        if (vehicles.isEmpty()) {
            series1.add(0.0, 0.0);
        }
        
        if (!vehicles.isEmpty()) {
            series1.add(2, 1);
            series1.add(5, 6);
            
            
        }
        final XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series1);
        // dataset.addSeries(series2);
        // dataset.addSeries(series3);
        
        return dataset;
        
    }
    
}