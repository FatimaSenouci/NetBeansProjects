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
public class stripload {
    private String departurT;
          private String   DestinationT;
    private String  TypeT;
           private String  SpeedT;
            private String  IdT;

    public stripload() {
    }

    public stripload(String departurT, String DestinationT, String TypeT, String SpeedT, String IdT) {
        this.departurT = departurT;
        this.DestinationT = DestinationT;
        this.TypeT = TypeT;
        this.SpeedT = SpeedT;
        this.IdT = IdT;
    }
            

    public String getDeparturT() {
        return departurT;
    }

    public void setDeparturT(String departurT) {
        this.departurT = departurT;
    }

    public String getDestinationT() {
        return DestinationT;
    }

    public void setDestinationT(String DestinationT) {
        this.DestinationT = DestinationT;
    }

    public String getTypeT() {
        return TypeT;
    }

    public void setTypeT(String TypeT) {
        this.TypeT = TypeT;
    }

    public String getSpeedT() {
        return SpeedT;
    }

    public void setSpeedT(String SpeedT) {
        this.SpeedT = SpeedT;
    }

    public String getIdT() {
        return IdT;
    }

    public void setIdT(String IdT) {
        this.IdT = IdT;
    }
            
}
