/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

/**
 *
 * @author ASW
 * Version Control with GitHub organization.
 * I want to test GitHUb version control.
 */
public class PersonAL extends Application {
    
 
    @Override
    public void start(Stage stage) throws Exception {
        
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        final CategoryAxis xAxis = new CategoryAxis(); 
        final NumberAxis yAxis = new NumberAxis();
        
        final LineChart<String,Number> bc = 
                new LineChart<String,Number>(xAxis, yAxis);
        bc.setTitle("Peak FLow");
        xAxis.setLabel("Measurement Date");
        yAxis.setLabel("Peak Flow values");
        
        XYChart.Series series10 = new XYChart.Series();
      
        
         Connection con;
        try{
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/fifi", "fifi", "fifi");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM FIFI.PEAKFLOW");
            //FETCH FIRST 3 ROWS ONLY");

            while(rs.next())
            {
                series10.getData().add(new XYChart.Data<String,Number>(rs.getDate(3).toString(),rs.getInt(2)));
            }
        }
        catch (SQLException ex){
            Logger.getLogger(PersonAL.class.getName()).log(Level.SEVERE, null, ex);
        }
               
        //Scene scene = new Scene(root);
        Scene scene = new Scene(bc,800,600);
        bc.getData().add(series10);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
