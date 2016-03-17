/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.mooc.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class HomepageController implements Initializable  {
    @FXML
    public void handleButtonActtion(ActionEvent event) throws IOException {
     Parent home_page_parent = FXMLLoader.load(getClass().getResource("/edu/esprit/mooc/gui/ajouterChapitre.fxml"));
       Scene home_page_scene = new Scene(home_page_parent);
       Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
       app_stage.setScene(home_page_scene);
       app_stage.show();
       
    }
    @FXML
    public void handleButtonActtion1(ActionEvent event) throws IOException {
     Parent home_page_parent1 = FXMLLoader.load(getClass().getResource("/edu/esprit/mooc/gui/suppressionChapitre.fxml"));
       Scene home_page_scene1 = new Scene(home_page_parent1);
       Stage app_stage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
       app_stage1.setScene(home_page_scene1);
       app_stage1.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
