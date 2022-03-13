package bd7.models;

public class Person {
    private int id;
    private String nom;
    private String prenom;
    private String dateNaiss;
    private int promo;
    
    public int getId() {
        return id;
    }

    
    public Person(int id , String name ,String prenom,String ddn,int pro){
        
        super();
        this.id=id;
        this.nom = name;
        this.prenom = prenom;
        this.dateNaiss = ddn;
        this.promo = pro;
    }
    public Person(){
        
       ;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDateNaiss() {
        return dateNaiss;
    }

    public void setDateNaiss(String dateNaiss) {
        this.dateNaiss = dateNaiss;
    }

    public int getPromo() {
        return promo;
    }

    public void setPromo(int promo) {
        this.promo = promo;
    }
    
}
