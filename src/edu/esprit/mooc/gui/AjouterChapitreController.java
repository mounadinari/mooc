/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.mooc.gui;

import edu.esprit.mooc.dao.classes.ChapitreDao;
import edu.esprit.mooc.entities.Chapitre;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class AjouterChapitreController implements Initializable {

    @FXML
    private TextField titre1;
    @FXML
    private TextArea description1;
    @FXML
    private Label idCours;
    @FXML
    private Button add;
    @FXML
    private ImageView image;
    @FXML
    private Label titre;
    @FXML
    private Label description;
   
    public void AjouterChapitre(ActionEvent event) {
        Chapitre h = new Chapitre();
        ChapitreDao hd = new ChapitreDao();

        h.setNom(titre1.getText());
        h.setDescription(description1.getText().toString());
       //  h.setId_cours(Integer.parseInt(idCours.getText())); 
          h.setId_cours(Integer.getInteger(idCours.getText()));


        hd.addChapitre(h);

    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    //  @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
