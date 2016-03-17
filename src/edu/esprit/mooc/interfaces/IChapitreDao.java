/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.mooc.interfaces;

import edu.esprit.mooc.entities.Chapitre;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dell
 */
public interface IChapitreDao {
    void addChapitre(Chapitre st);
    void removeChapitreById(int id);
     List<Chapitre> findAll();
         boolean updateChapitre(Chapitre chapitre);
         List<Chapitre> findChapitreById(int id);
             Chapitre findChapitreByNom(String nom);


}
