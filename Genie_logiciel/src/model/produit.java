
package model;


public class produit {
   
     private String  Type;
    private String Marque;
    private int Prix;
    private int Nombre;
    
        
    public produit( String Type ,String Marque,int Prix,int Nombre){
        
        super();
    
        this.Type = Type;
        this.Marque = Marque;
        this.Prix = Prix;
        this.Nombre= Nombre;
    }
    public produit(){
        
      
    }
    
    
    
    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getMarque() {
        return Marque;
    }

    public void setMarque(String Marque) {
        this.Marque = Marque;
    }

    public int getPrix() {
        return Prix;
    }

    public void setPrix(int Prix) {
        this.Prix = Prix;
    }

    public int getNombre() {
        return Nombre;
    }

    public void setNombre(int Nombre) {
        this.Nombre = Nombre;
    }

    public int getId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  
    
}
