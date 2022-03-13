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
public class guicherLoad {
    
private String Bnom;
private String Bprenom;
private String ComboEtat1;
private String ComboClass1;
private String NbValise;
private String Vdarrive;
private String Vdepart;
private String Bpassport;
private String DateD1;
private String DateR1;

    public guicherLoad() {
    }

    public guicherLoad(String Bnom, String Bprenom, String ComboEtat1, String ComboClass1, String NbValise, String Vdarrive, String Vdepart, String Bpassport, String DateD1, String DateR1) {
        this.Bnom = Bnom;
        this.Bprenom = Bprenom;
        this.ComboEtat1 = ComboEtat1;
        this.ComboClass1 = ComboClass1;
        this.NbValise = NbValise;
        this.Vdarrive = Vdarrive;
        this.Vdepart = Vdepart;
        this.Bpassport = Bpassport;
        this.DateD1 = DateD1;
        this.DateR1 = DateR1;
    }

    public String getBnom() {
        return Bnom;
    }

    public void setBnom(String Bnom) {
        this.Bnom = Bnom;
    }

    public String getBprenom() {
        return Bprenom;
    }

    public void setBprenom(String Bprenom) {
        this.Bprenom = Bprenom;
    }

    public String getComboEtat1() {
        return ComboEtat1;
    }

    public void setComboEtat1(String ComboEtat1) {
        this.ComboEtat1 = ComboEtat1;
    }

    public String getComboClass1() {
        return ComboClass1;
    }

    public void setComboClass1(String ComboClass1) {
        this.ComboClass1 = ComboClass1;
    }

    public String getNbValise() {
        return NbValise;
    }

    public void setNbValise(String NbValise) {
        this.NbValise = NbValise;
    }

    public String getVdarrive() {
        return Vdarrive;
    }

    public void setVdarrive(String Vdarrive) {
        this.Vdarrive = Vdarrive;
    }

    public String getVdepart() {
        return Vdepart;
    }

    public void setVdepart(String Vdepart) {
        this.Vdepart = Vdepart;
    }

    public String getBpassport() {
        return Bpassport;
    }

    public void setBpassport(String Bpassport) {
        this.Bpassport = Bpassport;
    }

    public String getDateD1() {
        return DateD1;
    }

    public void setDateD1(String DateD1) {
        this.DateD1 = DateD1;
    }

    public String getDateR1() {
        return DateR1;
    }

    public void setDateR1(String DateR1) {
        this.DateR1 = DateR1;
    }

    
}
