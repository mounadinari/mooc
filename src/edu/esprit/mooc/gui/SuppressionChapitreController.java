/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.mooc.gui;

import edu.esprit.mooc.dao.classes.ChapitreDao;
import edu.esprit.mooc.entities.Chapitre;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import static javafx.scene.input.KeyCode.P;
import javafx.scene.layout.Pane;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class SuppressionChapitreController implements Initializable {

    @FXML
    ListView showPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setChapitrePane();
    }

    public void setChapitrePane() {
        ChapitreDao hd = new ChapitreDao();
        List<Chapitre> listchapitre = hd.findAll();
        ObservableList<Pane> panes = FXCollections.observableArrayList();
        for (int i = 0; i < listchapitre.size(); i++) {
            panes.add(getChapitreInPane(listchapitre.get(i)));
        }
        showPane.setItems(panes);
        showPane.setSelectionModel(null);
    }

    public Pane getChapitreInPane(Chapitre P) {
        ChapitreDao chapitre = new ChapitreDao();
        Pane pane = new Pane();

        Label nom = new Label("Nom : " + P.getNom());
        nom.setLayoutX(5);
        nom.setLayoutY(5);

        Label description = new Label("Description : " + P.getDescription());
        description.setLayoutX(350);
        description.setLayoutY(5);

        Label idC = new Label("Cours_id : " + P.getId_cours());
        idC.setLayoutX(550);
        idC.setLayoutY(5);
        Button remove = new Button("Supprimer");
        remove.setLayoutX(950);
        remove.setLayoutY(5);
        remove.getStyleClass().add("btn-danger");

        Button update = new Button("Modifier");
        update.setLayoutX(1050);
        update.setLayoutY(5);
        update.getStyleClass().add("btn-danger");

        remove.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                chapitre.removeChapitreById(P.getId());
                setChapitrePane();
            }

        });
        update.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                System.out.println("mouna");
                setEditchapitrePane(P);

            }
        });
        pane.getChildren().addAll(nom, description, idC, remove, update);
        pane.setStyle("-fx-border-style: dotted; -fx-border-radius: 5px; -fx-padding: 5px; -fx-font-size: 16px;");

        return pane;
    }

    public void setEditchapitrePane(Chapitre c) {
        ObservableList<Pane> panes = FXCollections.observableArrayList();
        panes.add(modifPane(c));
        showPane.setItems(panes);
        showPane.setSelectionModel(null);
    }

    public Pane modifPane(Chapitre c) {
        ChapitreDao crDAO = new ChapitreDao();
        Pane pane = new Pane();

        Label nom = new Label("Nom du chapitre");
        nom.setLayoutX(50);
        nom.setLayoutY(50);

        TextField nomP = new TextField(c.getNom());
        nomP.setPromptText("Nom du chapitre . . .");
        nomP.setLayoutX(200);
        nomP.setLayoutY(50);

        Label description = new Label("Description");
        description.setLayoutX(50);
        description.setLayoutY(150);

        TextField descriptionP = new TextField(String.valueOf(c.getDescription()));
        descriptionP.setPromptText("Nouvelle Description. . .");
        descriptionP.setLayoutX(200);
        descriptionP.setLayoutY(150);

        Label idC = new Label("Cours_id");
        idC.setLayoutX(50);
        idC.setLayoutY(200);

        TextField idX = new TextField(String.valueOf(c.getId_cours()));
        idX.setPromptText("Nouveau Cours_id . . .");
        idX.setLayoutX(200);
        idX.setLayoutY(200);

        Button edit = new Button("Modifier");
        edit.getStyleClass().add("btn-success");
        edit.setLayoutX(200);
        edit.setLayoutY(500);

        TextField si = new TextField(c.getNom());
        si.setPrefWidth(80);
        si.setPrefHeight(40);
        si.setLayoutX(200);
        si.setLayoutY(500);

        Label info = new Label();
        info.setLayoutX(200);
        info.setLayoutY(20);

        edit.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                Chapitre c = new Chapitre();

                c.setId(crDAO.findChapitreByNom(si.getText()).getId());
                c.setNom(nomP.getText());
                c.setDescription(descriptionP.getText());
                c.setId_cours(Integer.getInteger(idC.getText()));
//                c.setId(crDAO.findChapitreByNom(si.getText()).getId());

                crDAO.updateChapitre(c);

                System.out.println(c.toString());

                if (crDAO.updateChapitre(c)) {
                    System.out.println("succes");
                    info.setText("Modification Efféctué!");
                    info.getStyleClass().add("label-success");
                }

            }
        });

        pane.getChildren().addAll(nom, nomP, description, descriptionP, idC, idX,si, edit, info);

        pane.setStyle("-fx-font-size: 18px;");

        return pane;
    }

}
