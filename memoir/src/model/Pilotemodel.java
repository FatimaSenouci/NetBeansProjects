
package model;


public class Pilotemodel {
     private int  idpilot;
     private String  idname;
     private String   idprenom;
     private String  idnaiss;
     private int   idphone;
     private String   idnational;
         
           public Pilotemodel(int idpilot,String idname,String idprenom,String idnaiss,int idphone,String idnational){
        
        super();
        this.idpilot=idpilot;
        this.idname= idname;
        this.idprenom = idprenom;
        this.idnaiss = idnaiss;
        this.idphone = idphone;
         this.idnational =idnational;
       
    }
    public Pilotemodel(){
        
       
    }
     

    public int getIdpilot() {
        return idpilot;
    }

    public void setIdpilot(int idpilot) {
        this.idpilot = idpilot;
    }

    public String getIdname() {
        return idname;
    }

    public void setIdname(String idname) {
        this.idname = idname;
    }

    public String getIdprenom() {
        return idprenom;
    }

    public void setIdprenom(String idprenom) {
        this.idprenom = idprenom;
    }

    public String getIdnaiss() {
        return idnaiss;
    }

    public void setIdnaiss(String idnaiss) {
        this.idnaiss = idnaiss;
    }

    public int getIdphone() {
        return idphone;
    }

    public void setIdphone(int idphone) {
        this.idphone = idphone;
    }

    public String getIdnational() {
        return idnational;
    }

    public void setIdnational(String idnational) {
        this.idnational = idnational;
    }
            
}
