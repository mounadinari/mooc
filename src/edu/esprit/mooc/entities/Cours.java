/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.mooc.entities;

import java.util.Date;

/**
 *
 * @author Dell
 */
public class Cours {
     private int id;
    private String titre;
     private String description;
     private int etat;
     private Date DateDebut;
     private Date DateFin;
     private String difficulte;

    public Cours(int id, String titre, String description, int etat, Date DateDebut, Date DateFin, String difficulte) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.etat = etat;
        this.DateDebut = DateDebut;
        this.DateFin = DateFin;
        this.difficulte = difficulte;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public Date getDateDebut() {
        return DateDebut;
    }

    public void setDateDebut(Date DateDebut) {
        this.DateDebut = DateDebut;
    }

    public Date getDateFin() {
        return DateFin;
    }

    public void setDateFin(Date DatFin) {
        this.DateFin = DateFin;
    }

    public String getDifficulte() {
        return difficulte;
    }

    public void setDifficulte(String difficulte) {
        this.difficulte = difficulte;
    }

    @Override
    public String toString() {
        return "Cours{" + "id_Cours=" + id + ",Titre=" + titre + ", etat=" + etat + ", DateDebutt=" + DateDebut + ", DateFin=" + DateFin + ", diffuclte=" + difficulte +'}';
    }
    
     
     
}
