/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.mooc.test;

import edu.esprit.mooc.dao.classes.ChapitreDao;
import edu.esprit.mooc.entities.Chapitre;
import edu.esprit.mooc.interfaces.IChapitreDao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dell
 */
public class Test {
      public static void main(String[] args) {
          List <Chapitre> li = new ArrayList<>();
           Chapitre st = new Chapitre(15,"mouna","dinari",14);
           IChapitreDao mouna = new ChapitreDao();
           
         // mouna.addChapitre(st);
         // mouna.removeChapitreById(100);
          // System.out.println(mouna.findAll());
          // mouna.findAll();
         // mouna.updateChapitre(st);
        // li=  mouna.findChapitreById(3);
         // System.out.println(li.size()+"");
        //  li.stream().forEach(e->System.out.println(e));
                  Chapitre c = mouna.findChapitreByNom("ajax");

      }
    
}
