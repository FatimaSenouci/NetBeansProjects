
package model;
public class produit {
    private int id;
    private String type;
     private int comptité;
        private int prix;
    
    
   
    
    public produit(int id ,String type,int comptité,int prix){
        
        super();
        this.id=id;
        this.type = type;
        this.comptité=comptité ;
 
        this.prix = prix;
    }
    public produit(){
        
       
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getComptité() {
        return comptité;
    }

    public void setComptité(int comptité) {
        this.comptité = comptité;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }
 
        
}
