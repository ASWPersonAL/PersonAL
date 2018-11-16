/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personal;

import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.DatePicker;

import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;

/**
 *
 * @author ASW
 */
public class FXMLDocumentController implements Initializable {
    
    final static String performance = "Performance1";
    
    
       //DatePicker
        
        @FXML
        private Text actiontarget;
        
        @FXML
        private DatePicker datepicker;
        
        @FXML
        protected void handleDatePickerAction(ActionEvent event)
        {
            actiontarget.setText(datepicker.getValue().toString());
        }
    
    @FXML
    private Label label;
    
    
    //@FXML makes a connection to the FXML document.
    
    @FXML
    PieChart chart;
     
    @FXML
    LineChart<Double, Double> graph;
    
      @FXML
    CategoryAxis xAxis;
    
    @FXML
    NumberAxis yAxis;
    
    @FXML
    BarChart<String, Number> bar; 
    
    @FXML
    ListView listPF = new ListView();
    
    private void populatePFList(){
        
        Connection con;
        
    }
  
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
          
    }
    
    @Override
    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        
        //code for a pie chart
   
    ObservableList<PieChart.Data> pieChartData =
            FXCollections.observableArrayList(
            new PieChart.Data("Coding", 60),
            new PieChart.Data("System design", 25),
            new PieChart.Data("Project management", 15));

      chart.setTitle("Work balance");
      chart.setData(pieChartData);
      
      //code for line chart
      
        ObservableList<XYChart.Series<Double, Double>> lineChartData = FXCollections.observableArrayList();
        
        LineChart.Series<Double, Double> series1 = new LineChart.Series<Double, Double>();
        series1.setName("Series 1");
        series1.getData().add(new XYChart.Data<Double, Double>(0.0, 1.0));
        series1.getData().add(new XYChart.Data<Double, Double>(1.2, 1.4));
        series1.getData().add(new XYChart.Data<Double, Double>(2.2, 1.9));
        series1.getData().add(new XYChart.Data<Double, Double>(2.7, 2.3));
        series1.getData().add(new XYChart.Data<Double, Double>(2.9, 0.5));
        
        lineChartData.add(series1);
        
        LineChart.Series<Double, Double> series2 = new LineChart.Series<Double, Double>();
        series2.setName("Series 2");
        series2.getData().add(new XYChart.Data<Double, Double>(0.0, 1.6));
        series2.getData().add(new XYChart.Data<Double, Double>(0.8, 0.4));
        series2.getData().add(new XYChart.Data<Double, Double>(1.4, 2.9));
        series2.getData().add(new XYChart.Data<Double, Double>(2.1, 1.3));
        series2.getData().add(new XYChart.Data<Double, Double>(2.6, 0.9));
        
        lineChartData.add(series2);
        
        graph.setData(lineChartData);
        graph.createSymbolsProperty();
        
        //code for barchart
        
        xAxis.setLabel("Performance");
        xAxis.setTickLabelRotation(90);
        yAxis.setLabel("Percent");
        
        XYChart.Series<String, Number> series3 = new XYChart.Series();
        series3.getData().add(new XYChart.Data(performance, 80));
        
        XYChart.Series<String, Number> series4 = new XYChart.Series();
        series4.getData().add(new XYChart.Data(performance, 20));
        
        bar.getData().add(series3);
        bar.getData().add(series4); 
        
        
    
        
  }    
    
}
