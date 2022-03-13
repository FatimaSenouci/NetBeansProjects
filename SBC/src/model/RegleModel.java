/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author hp
 */
public class RegleModel {
    
     private String champ1;
     private String champ2;

    public RegleModel(String champ1, String champ2) {
        this.champ1 = champ1;
        this.champ2 = champ2;
    }
     

    public RegleModel() {
    }
     

    public String getChamp1() {
        return champ1;
    }

    public void setChamp1(String champ1) {
        this.champ1 = champ1;
    }

    public String getChamp2() {
        return champ2;
    }

    public void setChamp2(String champ2) {
        this.champ2 = champ2;
    }
     
}
