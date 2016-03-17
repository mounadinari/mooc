/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.mooc.entities;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Dell
 */
public class Chapitre {
      private int id;
      private String nom;
      private String description;
      private int cours_id;

    public Chapitre(int id, String nom, String description, int cours_id) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.cours_id = cours_id;
    }

    public Chapitre() {
       
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId_cours() {
        return cours_id;
    }

    public void setId_cours(int id_cours) {
        this.cours_id = cours_id;
    }

    @Override
    public String toString() {
        return "Chapitre{" + "id=" + id + ", nom=" + nom + ", description=" + description + ", id_cours=" + cours_id + '}';
    }

    
   

      
}
