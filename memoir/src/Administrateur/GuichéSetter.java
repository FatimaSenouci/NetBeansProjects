/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administrateur;

import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;

/**
 *
 * @author hp
 */
class GuichéSetter {
      public String NomG;

    public String getNomG() {
        return NomG;
    }

    public void setNomG(String NomG) {
        this.NomG = NomG;
    }

    public String getPrenomG() {
        return prenomG;
    }

    public void setPrenomG(String prenomG) {
        this.prenomG = prenomG;
    }

    public String getNpassportG() {
        return NpassportG;
    }

    public void setNpassportG(String NpassportG) {
        this.NpassportG = NpassportG;
    }

    public String getNvaliseG() {
        return NvaliseG;
    }

    public void setNvaliseG(String NvaliseG) {
        this.NvaliseG = NvaliseG;
    }

    public String getVilleDrv() {
        return VilleDrv;
    }

    public void setVilleDrv(String VilleDrv) {
        this.VilleDrv = VilleDrv;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String Code) {
        this.Code = Code;
    }
 

    public GuichéSetter(String NomG, String prenomG, String NpassportG, String NvaliseG, String VilleDrv, String Code, String VilleDt, String TypeT) {
        this.NomG = NomG;
        this.prenomG = prenomG;
        this.NpassportG = NpassportG;
        this.NvaliseG = NvaliseG;
        this.VilleDrv = VilleDrv;
        this.Code = Code;
//          this.ClassId = ClassId;
//          this.EtatId = EtatId;
          this.VilleDt = VilleDt;
          this.TypeT = TypeT;
         
    }
    public GuichéSetter(){
        
    }
  public  String NpassportG;
   public String NvaliseG;
   public  String VilleDrv;
     public String  Code;
     public    String prenomG;
      public    String VilleDt; 
//       public    String ClassId; 
//        public    String EtatId; 
         public    String TypeT; 

    public String getVilleDt() {
        return VilleDt;
    }

    public void setVilleDt(String VilleDt) {
        this.VilleDt = VilleDt;
    }

//    public String getClassId() {
//        return ClassId;
//    }
//
//    public void setClassId(String ClassId) {
//        this.ClassId = ClassId;
//    }
//
//    public String getEtatId() {
//        return EtatId;
//    }
//
//    public void setEtatId(String EtatId) {
//        this.EtatId = EtatId;
//    }

    public String getTypeT() {
        return TypeT;
    }

    public void setTypeT(String TypeT) {
        this.TypeT = TypeT;
    }
   
    
}
