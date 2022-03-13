import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class SaisieMembre extends JFrame {
	/*****************************************************************************************************/	String Adresse ;		   
	   String Nom ;
	   String Prenom ;
       int sexe;
	   int[] sports = new int[9];
	   boolean sportIsSelected;

	   String numSportif;	   
	   
	   
	   JRadioButton HommeRadio;
	   JRadioButton FemmeRadio;

	   JTextField NomText;
	   JTextField PrenomText;
	   JTextArea AdresseTexte;
	   JCheckBox TennisBtn;
	   JCheckBox SquashBtn;
	   JCheckBox NatationBtn;
	   JCheckBox AthletismeBtn;
	   JCheckBox RandonneeBtn;
	   JCheckBox FootBtn;
	   JCheckBox BasketBtn;
	   JCheckBox VolleyBtn;
	   JCheckBox PetanqueBtn;
	   String Query;
/*****************************************************************************************************/	   
	public SaisieMembre() {
	//TODO Titre de la fenetre
	setTitle("Boîte de saisie");
	//TODO un click sur la croix entraine la fermeture de la fenêtre
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	//TODO paneau pricipal ********************************************************* 
	BorderLayout borderLayout1 = new BorderLayout();
	   JPanel Pane1 = new JPanel();
	   JPanel Pane2 = new JPanel();
	   JPanel Pane3 = new JPanel();
            JPanel Pane4 = new JPanel();
	   JPanel Pane5 = new JPanel();

	getContentPane().setLayout(borderLayout1);
	   add(Pane1,borderLayout1.CENTER);
	   add(Pane2,borderLayout1.EAST);
	   add(Pane3,borderLayout1.SOUTH);

	 //TODO paneau pricipal/paneau Centre *******************************************
		BorderLayout borderLayout11 = new BorderLayout();
		   JPanel Pane11 = new JPanel();
		   JPanel Pane12 = new JPanel();
                   
                   BorderLayout borderLayout22 = new BorderLayout();
		   JPanel Pane21 = new JPanel();
		   JPanel Pane22 = new JPanel();
           
		   AdresseTexte  = new JTextArea();

		   
		   Pane1.setLayout(borderLayout11);
		   Pane1.add(Pane11,borderLayout1.NORTH);
		   Pane1.add(AdresseTexte,borderLayout1.CENTER);
		   Pane1.add(Pane12,borderLayout1.SOUTH);
	 
    //TODO paneau pricipal/paneau Centre/paneau Nord *********************************************************************
        GridLayout gridLayout1 = new GridLayout(5,1);
 	    Pane11.setLayout(gridLayout1);
  	
 	   JLabel NomLab = new JLabel("Nom");
 	   JLabel PrenomLab = new JLabel("Prénom");
 	   JLabel AdresseLab = new JLabel("Adresse");

 	   NomText = new JTextField();
 	   PrenomText = new JTextField();

 	   Pane11.add(NomLab);   
 		Pane11.add(NomText);   
 		Pane11.add(PrenomLab);   
 		Pane11.add(PrenomText);   
 		Pane11.add(AdresseLab);
 	
    //TODO paneau pricipal/paneau Centre/paneau Sud *********************************************************************
		
FlowLayout flowLayout1 = new FlowLayout();
Pane12.setLayout(flowLayout1);

JLabel SexeLab = new JLabel("Sexe");
HommeRadio = new JRadioButton("Homme");
FemmeRadio = new JRadioButton("Femme");

ButtonGroup grRadio = new ButtonGroup();
grRadio.add(HommeRadio);
grRadio.add(FemmeRadio);

FemmeRadio.setSelected(true);

Pane12.add(SexeLab);
Pane12.add(HommeRadio);
Pane12.add(FemmeRadio);

//TODO paneau pricipal/paneau Sud *******************************************
FlowLayout flowLayout2 = new FlowLayout();
Pane3.setLayout(flowLayout2);
	
JButton OkBouton = new JButton("OK");    
JButton AnnulerBouton = new JButton("Annuler");    
Pane3.add(OkBouton);
Pane3.add(AnnulerBouton);

//TODO paneau pricipal/paneau East *******************************************
GridLayout gridLayout2 = new GridLayout(9,1);
Pane2.setLayout(gridLayout2);

TennisBtn = new JCheckBox("Tennis");
TennisBtn.setMnemonic('N');
SquashBtn = new JCheckBox("Squash");
NatationBtn = new JCheckBox("Natation");
AthletismeBtn = new JCheckBox("Athlétisme");
RandonneeBtn = new JCheckBox("Randonnée");
FootBtn = new JCheckBox("Foot");
BasketBtn = new JCheckBox("Basket");
VolleyBtn = new JCheckBox("Volley");
PetanqueBtn = new JCheckBox("Petanque");


Pane2.add(TennisBtn);
Pane2.add(SquashBtn);
Pane2.add(NatationBtn);
Pane2.add(AthletismeBtn);
Pane2.add(RandonneeBtn);
Pane2.add(FootBtn);
Pane2.add(BasketBtn);
Pane2.add(VolleyBtn);
Pane2.add(PetanqueBtn);

//TODO grouper les élements de l'interface ************************************************************** 


Border EtchedBorderLowered = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
Pane1.setBorder(EtchedBorderLowered);

Border titledBorder = BorderFactory.createTitledBorder("Sports");
Pane2.setBorder(titledBorder);


/********** ajouter un filtre à la zone de texte Nom pour empêcher la saisie des chiffres *********/

NomText.addKeyListener(new KeyListener() {
	
	public void keyTyped(KeyEvent e) {
	                                      }
	
	public void keyReleased(KeyEvent e) {
            
            NomText.setText(OnlyChar(NomText.getText()));
                                      		String s = NomText.getText();
		                                    int lng = s.length();
		                                    char c = s.charAt(lng-1);
		                                    
		                                    if(c=='0' || c=='1' || c=='2' || c=='3' || c=='4' || c=='5' || c=='6' || c=='7' || c=='8' || c=='9' ){ 
		                                    	                                                                                                  NomText.setText(s.substring(0,lng-1));
		                                                                                                                                          }
	                                       }
	
	public void keyPressed(KeyEvent e) {
	                                       }
});


/********** ajouter un filtre à la zone de texte Prenom pour empêcher la saisie des chiffres *********/
PrenomText.addKeyListener(new KeyListener() {
	
	public void keyTyped(KeyEvent e) { 
	                                     }
	
	public void keyReleased(KeyEvent e) {
		                                   
		PrenomText.setText(OnlyChar(PrenomText.getText()));
		                                   
		                                 }
	
	public void keyPressed(KeyEvent e) {
            
	                                      }
});

/*********************** Sauvegarder les données dans la base de données MySql ***************/
OkBouton.addActionListener(new ActionListener() {
	boolean t=false;
	public void actionPerformed(ActionEvent e) {

		Recuperer_Les_Donnees();
		Sauvegarder_Les_Donnees_Dans_La_Base_De_Donnees();
	                                                           }
});

/********************* Vider le formulaire   *****************************************/
AnnulerBouton.addActionListener(new ActionListener() { 
	
	public void actionPerformed(ActionEvent e) {
		Effacer_Les_Donnees();
	}
});
//TODO Rendre Visible la fenêtre 
    pack();	   
	setVisible(true);
}
	/************* Méthode permet d'éffacer toutes les informations du formulaire ********/ 

	public void Effacer_Les_Donnees(){
		NomText.setText("");
		PrenomText.setText("");
		AdresseTexte.setText("");		   

		HommeRadio.setSelected(true);
        
		TennisBtn.setSelected(false);
        SquashBtn.setSelected(false);
        NatationBtn.setSelected(false);
        AthletismeBtn.setSelected(false);
        RandonneeBtn.setSelected(false);
        FootBtn.setSelected(false);
        BasketBtn.setSelected(false);
        VolleyBtn.setSelected(false);
        PetanqueBtn.setSelected(false);
	                                       }
		/************* Méthode permet de récuperer les informations du formulaire dans les variables ********/ 

		public void Recuperer_Les_Donnees(){
		
		Nom = NomText.getText();
		Prenom = PrenomText.getText();
		Adresse = AdresseTexte.getText();		   

		if(HommeRadio.isSelected())sexe=1; else sexe = 0;
        
		if(TennisBtn.isSelected())sports[0]=1; else sports[0]=0;
        if(SquashBtn.isSelected())sports[1]=1; else sports[1]=0;
        if(NatationBtn.isSelected())sports[2]=1; else sports[2]=0;
        if(AthletismeBtn.isSelected())sports[3]=1; else sports[3]=0;
        if(RandonneeBtn.isSelected())sports[4]=1; else sports[4]=0;
        if(FootBtn.isSelected())sports[5]=1; else sports[5]=0;
        if(BasketBtn.isSelected())sports[6]=1; else sports[6]=0;
        if(VolleyBtn.isSelected())sports[7]=1; else sports[7]=0;
        if(PetanqueBtn.isSelected())sports[8]=1; else sports[8]=0;

        		
	}
	/****************** la méthode qui vérifier que tous les champs sont remplis ***************************************************/
public boolean Tous_Est_Bon(){
boolean filtre = false;
JOptionPane d = new JOptionPane();
	// TODO Vérifier si l'utilisateur a sélectionné au moins un sport
    sportIsSelected = false;
    for(int i=0;i<9;i++)if(sports[i]==1){
    	                                  sportIsSelected=true;
    	                                  break;
                                           }  
	// TODO Message d'erreur quand l'tuilisateur laisse la zone Nom vide
	if(Nom.trim().equals("")){	
	                          d.showMessageDialog( this, "Vous devriez fournir un nom !!", "Nom manquant", JOptionPane.WARNING_MESSAGE);
	                    }else 
	                    	// TODO Message d'erreur quand l'tuilisateur laisse la zone Prenom vide
	                    	if(Prenom.trim().equals("")){	
	                		                              d.showMessageDialog( this, "Vous devriez fournir un prenom !!", "Prenom manquant", JOptionPane.WARNING_MESSAGE);
	                		                    }else  if(Adresse.trim().equals("")){
	            		                		                                     d.showMessageDialog( this, "Vous devriez fournir une Adresse !!","Adresse manquant", JOptionPane.WARNING_MESSAGE);
	          		                		                    }else 
	          		                		                  	// TODO Message d'erreur quand l'tuilisateur ne selectionne aucun sport
	          		                		                    	if(!sportIsSelected){
		                                                                                    d.showMessageDialog( this, "Vous devriez selectionner aumoins un sport !!","Sport manquant", JOptionPane.WARNING_MESSAGE);
	                                                                                        }else  
                                                                                            
	                            	          		                		                  	// TODO si tous est en ordre 
	                                                                                        	filtre = true;
           
                     return  filtre;
                     
                     
                     
                                 }
/****************** la méthode qui sauvegarde les informations dans la base de données ********************************/
public void Sauvegarder_Les_Donnees_Dans_La_Base_De_Donnees(){
if(Tous_Est_Bon()){

		 }
	}
/************* *******************************************/
String OnlyChar(String s){
	String t="";
	for(int i=0;i<s.length();i++){
		if((s.charAt(i)>='a'&&s.charAt(i)<='z')||(s.charAt(i)>='A'&&s.charAt(i)<='Z')) t=t+s.charAt(i);
		                        }
		

         return t;
	
	}

/********************************************************/

// la méthode main permet de démarrer l'application
public static void main(String[] args) {

	SaisieMembre SM = new SaisieMembre();
        
         SM.setVisible(true);
	}
}
