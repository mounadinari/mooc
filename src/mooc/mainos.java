/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mooc;

import java.awt.Insets;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Dell
 */
public class mainos extends Application {

    Button btn1, btn2;
    Label lbl1, lbl2;
    FlowPane fp1, fp2;
    Stage stage;
    Scene scene1, scene2;

    @Override
    public void start(Stage stage) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("/edu/esprit/mooc/gui/Homepage.fxml"));
          Scene scene = new Scene(root);
          stage.setScene(scene);
          stage.show();


     
    
        stage.setTitle("Hello World!");
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

   

}
