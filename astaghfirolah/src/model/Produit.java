
package model;


public class Produit {
    private int Id;
    private String Type;
    private int Comptité;
    private int Prix;
 
      
    public Produit( int Id,String Type ,int Comptité,int Prix ){
        
        super();
        this.Id=Id;
        this.Type=Type;
        this.Comptité=Comptité;
        this.Prix=Prix;
      
       
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }
    public Produit(){
        
       
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public int getComptité() {
        return Comptité;
    }

    public void setComptité(int Comptité) {
        this.Comptité = Comptité;
    }

    public int getPrix() {
        return Prix;
    }

    public void setPrix(int Prix) {
        this.Prix = Prix;
    }

//    public int getTotale() {
//        return Totale;
//    }
//
//    public void setTotale(int Totale) {
//        this.Totale = Totale;
//    }
   
    
}
