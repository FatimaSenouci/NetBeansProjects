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
public class loadpiste {
   private int  idpisteT;
           private String typeT;
            private int  nombreT;

    public loadpiste(int idpisteT, String typeT, int nombreT) {
        this.idpisteT = idpisteT;
        this.typeT = typeT;
        this.nombreT = nombreT;
    }

    public loadpiste() {
    }
            

    public int getIdpisteT() {
        return idpisteT;
    }

    public void setIdpisteT(int idpisteT) {
        this.idpisteT = idpisteT;
    }

    public String getTypeT() {
        return typeT;
    }

    public void setTypeT(String typeT) {
        this.typeT = typeT;
    }

    public int getNombreT() {
        return nombreT;
    }

    public void setNombreT(int nombreT) {
        this.nombreT = nombreT;
    }
    
}
