/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.mooc.gui;

import edu.esprit.mooc.dao.classes.ChapitreDao;
import edu.esprit.mooc.entities.Chapitre;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class ListeChapitresController implements Initializable {

    @FXML
    ListView chapitrelist;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ChapitreDao hd = new ChapitreDao();
        ObservableList<Pane> panes = FXCollections.observableArrayList();
        List<Chapitre> listchapitre = hd.findAll();

        for (int i = 0; i < listchapitre.size(); i++) {

            panes.add(loadOneChapitre(listchapitre.get(i)));

            chapitrelist.setItems(panes);
            chapitrelist.setSelectionModel(null);
        }
    }

    private Pane loadOneChapitre(Chapitre P) {

        ChapitreDao DAO = new ChapitreDao();

        Pane pane = new Pane();
        Image img= new Image("/edu/esprit/mooc/gui/1.jpg") ;

       ImageView imageView = new ImageView(img);

        // Pane Size
        pane.setMaxSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);
        pane.setPrefWidth(422);
        pane.setPrefHeight(114);
        String style = "-fx-padding: 8 15 15 15;\n"
                + "    -fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\n"
                + "    -fx-background-radius: 8;\n"
                + "    -fx-font-weight: bold;\n"
                + "    -fx-font-size: 1.1em;";
        pane.setStyle(style);
        pane.setId("pane_oneHotel");

        // ImageView Proprieties
        imageView.setFitHeight(65);
        imageView.setFitWidth(65);

       imageView.setLayoutX(14);
        imageView.setLayoutY(7);
     // setPicture(img, imageView);
        

        Label nom = new Label("Nom : " + P.getNom());
        nom.setLayoutX(5);
        nom.setLayoutY(5);
        
        Label description = new Label("Description : " + P.getDescription());
        description.setLayoutX(350);
        description.setLayoutY(5);

        Label idC = new Label("Cours_id : " + P.getId_cours());
        idC.setLayoutX(550);
        idC.setLayoutY(5);

        pane.getChildren().addAll(nom, description, idC);
                pane.getChildren().add(imageView);


        return pane;

    }
}
