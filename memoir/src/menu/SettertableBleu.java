
package menu;

/**
 *
 * @author hp
 */
public class SettertableBleu {
    public String departureT;
    public String destinationT;
     public String  typeT;
     public String  speedT;
       public String  idT;

    public SettertableBleu() {
    }
      

    public SettertableBleu(String departureT, String destinationT, String typeT, String speedT, String idT, String timeT, String levelT) {
        this.departureT = departureT;
        this.destinationT = destinationT;
        this.typeT = typeT;
        this.speedT = speedT;
        this.idT = idT;
        this.timeT = timeT;
        this.levelT = levelT;
    }
      private String timeT;
      private String levelT;
      

    public String getDepartureT() {
        return departureT;
    }

    public void setDepartureT(String departureT) {
        this.departureT = departureT;
    }

    public String getDestinationT() {
        return destinationT;
    }

    public void setDestinationT(String destinationT) {
        this.destinationT = destinationT;
    }

    public String getTypeT() {
        return typeT;
    }

    public void setTypeT(String typeT) {
        this.typeT = typeT;
    }

    public String getSpeedT() {
        return speedT;
    }

    public void setSpeedT(String speedT) {
        this.speedT = speedT;
    }

    public String getIdT() {
        return idT;
    }

    public void setIdT(String idT) {
        this.idT = idT;
    }

    public String getTimeT() {
        return timeT;
    }

    public void setTimeT(String timeT) {
        this.timeT = timeT;
    }

    public String getLevelT() {
        return levelT;
    }

    public void setLevelT(String levelT) {
        this.levelT = levelT;
    }
      
}
