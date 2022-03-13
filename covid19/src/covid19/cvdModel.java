/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package covid19;

/**
 *
 * @author hp
 */
public class cvdModel {

    public cvdModel(int idNumber, int idwilaya, int IdPercentage) {
        this.idNumber = idNumber;
        this.idwilaya = idwilaya;
        this.IdPercentage = IdPercentage;
    }

    public cvdModel() {
    }
     private int idNumber;
     private int idwilaya;
      private int IdPercentage;

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public int getIdwilaya() {
        return idwilaya;
    }

    public void setIdwilaya(int idwilaya) {
        this.idwilaya = idwilaya;
    }

   

    public int getIdPercentage() {
        return IdPercentage;
    }

    public void setIdPercentage(int IdPercentage) {
        this.IdPercentage = IdPercentage;
    }
    
}
