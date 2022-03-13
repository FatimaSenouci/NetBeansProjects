

package Controleur;

/**
 *
 * @author hp
 */
public class Seterjaune {
   public String departurT;
           public String  DestinationT;
           public String  TypeT;
                  public String   SpeedT;
                  public String   IdT;

    public Seterjaune(String departurT, String DestinationT, String TypeT, String SpeedT, String IdT) {
        this.departurT = departurT;
        this.DestinationT = DestinationT;
        this.TypeT = TypeT;
        this.SpeedT = SpeedT;
        this.IdT = IdT;
    }

    public Seterjaune() {
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
