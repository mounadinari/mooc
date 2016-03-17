/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.mooc.dao.classes;

import edu.esprit.mooc.entities.Chapitre;
import edu.esprit.mooc.interfaces.IChapitreDao;
import edu.esprit.mooc.util.MyConnexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataSource;

/**
 *
 * @author Dell
 */
public class ChapitreDao implements IChapitreDao {

    private Connection cnx;

    public ChapitreDao() {
        cnx = MyConnexion.getInstance();
    }

    @Override
    public void addChapitre(Chapitre st) {

        String requete = "insert into chapitre (id,nom,description,cours_id) values (?,?,?,?)";
        try {
            PreparedStatement ps = cnx.prepareStatement(requete);
            ps.setInt(1, st.getId());
            ps.setString(2, st.getNom());
            ps.setString(3, st.getDescription());
            ps.setInt(4, st.getId_cours());
            ps.executeUpdate();
            System.out.println("Ajout effectué avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de l'insertion " + ex.getMessage());
        }
    }

    @Override
    public void removeChapitreById(int id) {
        String requete = "delete from chapitre where id=?";
        try {
            PreparedStatement ps = cnx.prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Chapitre supprimé");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
    }

    @Override
    public List<Chapitre> findAll() {
        List<Chapitre> listechapitre = new ArrayList<>();
        String requete = "select * from chapitre";
        try {
            Statement statement = cnx
                    .createStatement();
                    
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                Chapitre chapitre = new Chapitre();
                chapitre.setId(resultat.getInt(1));
                chapitre.setNom(resultat.getString(2));
                chapitre.setDescription(resultat.getString(3));
                chapitre.setId_cours(resultat.getInt(4));
                listechapitre.add(chapitre);
                for (Chapitre elem : listechapitre) {
                    System.out.println(elem);
                }
            }
            return listechapitre;

        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des chapitres " + ex.getMessage());
            return null;
        }
    }

    public boolean updateChapitre(Chapitre chapitre) {
        String requete = "update chapitre set nom=?,description=?,cours_id=? where id=?";
        try {

            PreparedStatement ps = cnx.prepareStatement(requete);

            ps.setString(1, chapitre.getNom());
            ps.setString(2, chapitre.getDescription());
            ps.setInt(3, chapitre.getId_cours());
            ps.setInt(4, chapitre.getId());

            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");

            return true;
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
            return false;
        }
    }

    @Override
    public List<Chapitre> findChapitreById(int id) {
        List<Chapitre> listechapitre = new ArrayList<>();
        Chapitre chapitre = new Chapitre();
        String requete = "select * from chapitre where id=?";
        try {
            PreparedStatement ps = cnx.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                chapitre.setId(resultat.getInt(1));
                chapitre.setNom(resultat.getString(2));
                chapitre.setDescription(resultat.getString(3));
                chapitre.setId_cours(resultat.getInt(4));
                listechapitre.add(chapitre);
            }
            return listechapitre;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du depot " + ex.getMessage());
            return null;
        }
    }
public Chapitre findChapitreByNom(String nom) {
        Chapitre chapitre = new Chapitre();
        String requete = "select * from chapitre where nom=?";
        try {
            PreparedStatement ps = cnx.prepareStatement(requete);
            ps.setString(1, nom);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                chapitre.setId(resultat.getInt(1));
                chapitre.setNom(resultat.getString(2));
            }
            return chapitre;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du chapitre " + ex.getMessage());
            return null;
        }
    }
}
