
package model;

/**
 *
 * @author hp
 */
public class TechnecienModel {
    private int idtech ;
    private String firstname;
    private String name;
    private String naiss;
    private int phone;
    
     public TechnecienModel(int idtech,String firstname,String name,String naiss,int phone){
        
        super();
        this.idtech=idtech;
        this.firstname= firstname;
        this.name = name;
        this.naiss = naiss;
        this.phone = phone;
         
       
    }
    public TechnecienModel(){
        
       
    }

    public int getIdtech() {
        return idtech;
    }

    public void setIdtech(int idtech) {
        this.idtech = idtech;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNaiss() {
        return naiss;
    }

    public void setNaiss(String naiss) {
        this.naiss = naiss;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
    
    
}
