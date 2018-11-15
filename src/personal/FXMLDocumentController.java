/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personal;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;

import javafx.scene.control.Label;

/**
 *
 * @author ASW
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    
    
    //@FXML makes a connection to the FXML document.
    
    @FXML
    PieChart chart;
     
    
    
  
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
        

    
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //code for a pie chart
   
    ObservableList<PieChart.Data> pieChartData =
            FXCollections.observableArrayList(
            new PieChart.Data("Coding", 60),
            new PieChart.Data("System design", 25),
            new PieChart.Data("Project management", 15));

      chart.setTitle("Work balance");
      chart.setData(pieChartData);
         
    }    
    
}
