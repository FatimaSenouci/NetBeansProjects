
package menu;


public class TableMenu1 {
     private int trackidT;
     private String typeidT;

    public TableMenu1(int trackidT, String typeidT) {
        
        super();
        this.trackidT = trackidT;
        this.typeidT = typeidT;
    }
public TableMenu1(){
    
}
   
    public int getTrackidT() {
        return trackidT;
    }

    public void setTrackidT(int trackidT) {
        this.trackidT = trackidT;
    }

    public String getTypeidT() {
        return typeidT;
    }

    public void setTypeidT(String typeidT) {
        this.typeidT = typeidT;
    }
}
