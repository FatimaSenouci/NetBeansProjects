
package test;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;

public class Test extends JFrame{
   
	//***************************déclaration******************************************
	  public int c=0;
	  JTextField T1,T2; 
	  JPanel P,P1,P2,P3,P4,P5,P6,P7,P8,P9,P10,P11;
	  JTextArea A1;
	  JRadioButton R1,R2;
	  JCheckBox[] CH1 ;
      JLabel L1,L2,L3,L4,L5,L6,L7,L8;
      JButton ok,annuler;
      JFrame F,G;
      public static boolean A=false;
      public static int r=0;
      ItemEvent a,e;
      public boolean T=false, HH=true,TT=true;
      JComboBox C,C1,C2;
//*********************************************************************************
           
//****************************constructeur*****************************************       
		public Test(){
			 setSize(200,300);
      setLocationRelativeTo(null);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       // setResizable(true);
      setVisible(true);
     // setTitle("Boite de saisie");
		     //TODO ******************** Panel P*********************** 
			      BorderLayout B =new BorderLayout();
			      P =new JPanel();
			      P.setLayout(B);
			      setContentPane(P);
			      
			//TODO ********************* Panel (ok +annuler)***********
                 ok = new JButton("ok");
                 ok.setEnabled(false); //désactiver la button ok
                 annuler = new JButton("Annuler");
                 annuler.setEnabled(false);
                 FlowLayout F1 = new FlowLayout();
                 P1 = new JPanel();
                 P1.setLayout(F1);
          //TODO ********la fonction de la button Annuler************   
         	
 			     annuler.addActionListener(e->{
 			    	 
 				      T1.setText("");
 				      T2.setText("");
 				      A1.setText("");
 				
 				      R1.setSelected(true);
 				      ok.setEnabled(false);
 				      C.setSelectedItem(" ");
 				      C1.setSelectedItem(" ");
 				      C2.setSelectedItem(" ");
 				      for(int i=0;i<9;i++){
 					     CH1[i].setSelected(false);}});
 			         
 			//*********************************************************	
 			     
 		
 			            
 			//TODO *********la fonction de la button OK****************            
 			            
 			   ok.addActionListener(e ->{
 				
 		        String t1 = T1.getText();
				boolean t=true;
				 //*******le contrôle des champs si elles sont vide ou leur contenue != lettres
				
				       if(!T1.getText().isEmpty()){
				          if(!t1.matches("[a-zA-Z]+") & !T1.getText().contains(" ")) {
					 JOptionPane.showMessageDialog(this, "introduire le nom que avec des alphabets");
					   t = false;
					   return;}}
					
			    String T3 = T2.getText();
				       if(!T2.getText().isEmpty()){
				          if(!T3.matches("[a-zA-Z]+") & !T3.contains(" ")) {
					JOptionPane.showMessageDialog(this, "introduire le prenom que avec des alphabets");
					  t = false;
					  return;}}
				
				
				if(T1.getText().isEmpty()) {
					JOptionPane.showMessageDialog(this, "introduire votre nom");
					t=false;
					return ;
				}
				if(T2.getText().isEmpty()) {
					JOptionPane.showMessageDialog(this, "introduire votre prenom");
					t=false;
					return ;
				}
				if(A1.getText().isEmpty()) {
					JOptionPane.showMessageDialog(this, "introduire votre adresse");
					t=false;
					return ;}
			//**************************************************************************	
				
			//TODO ********vérifier la selectionne des sports*******************************
				
				int c=0;
			         for(int i=0;i<9;i++){
				          if(!CH1[i].isSelected()) {c++;} }
			    if(c == 9){
		  		   JOptionPane.showMessageDialog(this, "selectionnée au moins un type de sport");
		  		          t=false;
		     	          return ;}
			    
		    //******************************************************************************	    
 			
			    if(t == true){
			    	Object q= C.getSelectedItem();
			    	Object j=C1.getSelectedItem();
			    	Object jj=C2.getSelectedItem();
				    String type = "\n" ;
					   int i =1;
						   for(JCheckBox F : CH1) {
						        if(F.isSelected()) {
							      type += "       "+"                              "
						           +"-     " +F.getText()+" \n";
							       i++;}}
						        
						
					
				    String nom=" ";
				      if(R1.isSelected()){
				            nom ="Homme";
				 
				            JOptionPane.showMessageDialog(this,"Nouveau membre ajouté :"+"\n" 
		                                 +"Nom"+"                         :"+T1.getText()+"\n"
                                         +"Prenom"+"                   :"+T2.getText()+"\n"
                                         +"Date de naissance :"+q+"-"+j+" "+jj+"\n"
                                         +"Sexe"+"                       :"+nom+"\n"
	                                     +"Adresse"+"                   :"+A1.getText()+"\n"
                                         
	                                     +"Sport sélectionnés:"+type);
                             return;}
				
				
				      else{
					        nom="Femme";  
					        JOptionPane.showMessageDialog(this,"Nouveau membre ajouté :"+"\n" 
					        		+"Nom"+"                         :"+T1.getText()+"\n"
                                    +"Prenom"+"                   :"+T2.getText()+"\n"
                                    +"Date de naissance :"+q+"-"+j+" "+jj+"\n"
                                    +"Sexe"+"                       :"+nom+"\n"
                                    +"Adresse"+"                   :"+A1.getText()+"\n"
                                    
                                    +"Sport sélectionnés:"+type);}} });
					
			  
 			  //****************************************************************************  
 			
             
 			 
             P1.add(ok);
             P1.add(annuler);
             
             P.add(P1,BorderLayout.SOUTH);
             
             //TODO le contenue de centre de panel P
                GridLayout GR1 = new GridLayout(1,2);
                P7 = new JPanel();
                P7.setLayout(GR1);
                
                GridLayout GR2 = new GridLayout(1,2);
                P8 = new JPanel();
                P8.setLayout(GR2);
                
                L5 =new JLabel("Date de Naissance");
                L6=new JLabel("Jour");
                L7 =new JLabel("Mois");
                L8 =new JLabel("Année");
                
                P8.add(L6);
                P8.add(L7);
                
                P7.add(P8);
                P7.add(L8);
                
                //Les jours
                C =new JComboBox();
                
               C.addItem(" ");
               C.addItem("Aucun");
                
                for(int i=1;i<=31;i++){
                	
                	C.addItem(i);
                	
                }
                
                
                
                
//                C.addActionListener((ActionListener) this);
				
					
				
              
               
                //Les Mois
                C1 = new JComboBox();
                
                C1.addItem(" ");
                C1.addItem("Janvier");
                C1.addItem("Février");
                C1.addItem("Mars");
                C1.addItem("Avril");
                C1.addItem("Mai");
                C1.addItem("Juin");
                C1.addItem("Juillet");
                C1.addItem("Août");
                C1.addItem("Septembre");
                C1.addItem("Octobre");
                C1.addItem("Novembre");
                C1.addItem("Décembre");
                C1.addItem("Aucun");
                
           //     C1.addActionListener((ActionListener) this);
					
				
          
                
                //Les années
                C2 =new JComboBox();
                int z=1950;
                C2.addItem(" ");
                for(int i=0;i<70;i++){
                	C2.addItem(z);
                	z++;
                }
                
            //   C2.addActionListener((ActionListener) this);
                
                GridLayout GR3 = new GridLayout(1,2);
                P9 = new JPanel();
                P9.setLayout(GR3);
                
                for(int i=0;i<31;i++){
                P9.add(C);}
                
                P9.add(C1);
                
                GridLayout GR4= new GridLayout(1,2);
                P10 = new JPanel();
                P10.setLayout(GR4);
                
                P10.add(P9);
                P10.add(C2);
                
                L1 =new JLabel("Nom");
                T1 = new JTextField();
              //  T1.getDocument().addDocumentListener((DocumentListener) this);
                T1.addKeyListener(new KeyListener() {
					
					public void keyTyped(KeyEvent e) {
					  char c=e.getKeyChar();
					if ((!Character.isAlphabetic(c) & (!Character.isSpaceChar(c)))||c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE){
					       e.consume();
					  }// TextField T1 accecpt que des alphabets
						
					}
					
					@Override
					public void keyReleased(KeyEvent e) {
						
					}
					
					@Override
					public void keyPressed(KeyEvent e) {
						
					}

//                                  @Override
//                                  public void keyTyped(KeyEvent e) {
//                                      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//                                  }
//
//                                  @Override
//                                  public void keyPressed(KeyEvent e) {
//                                      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//                                  }
//
//                                  @Override
//                                  public void keyReleased(KeyEvent e) {
//                                      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//                                  }
				
               	 
               });
	             L2 = new JLabel("Prenom");
	             T2 = new JTextField();
	        //     T2.getDocument().addDocumentListener((DocumentListener) this);
	             T2.addKeyListener(new KeyListener() {
					
					@Override
					public void keyTyped(KeyEvent s) {
						  char c=s.getKeyChar();
							if ((!Character.isAlphabetic(c) & (!Character.isSpaceChar(c)))||c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE){
							       s.consume();
							  }
						
					}
					
					@Override
					public void keyReleased(KeyEvent arg0) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void keyPressed(KeyEvent arg0) {
						// TODO Auto-generated method stub
						
					}
				});
	             
	             
     //TODO *************************Panel(NOM + Prenom + adresse)*******************************
	             
	             L3 =new JLabel("adresse");
	             A1 = new JTextArea(5,5);
	          //   A1.getDocument().addDocumentListener((DocumentListener) this);
	             
	       
	             
	 //***********************************************************************************************
	             
	//TODO ******************************Panel(sexe + homme + femmme)*********************************             
	             L4 = new JLabel("Sexe");
	             R1 = new JRadioButton("Homme");
	             R2 = new JRadioButton("Femme");
	            // R2.addItemListener((ItemListener) this);
	             ButtonGroup G1 =new ButtonGroup();
	             R1.setSelected(true);
	             G1.add(R1);
	             G1.add(R2);
	             
	             FlowLayout F2 =new FlowLayout();
	             P4 = new JPanel();
	             P4.setLayout(F2);
	             F2.setAlignment(FlowLayout.LEFT);
	             
	             
	             P4.add(L4);
	             P4.add(R1);
	             P4.add(R2);
	              
	          GridLayout GR = new GridLayout(10,1);
	           P6= new JPanel();
	           P6.setLayout(GR);  
	             
	             
	             P6.add(L1);
	             P6.add(T1);
	             P6.add(L2);
	             P6.add(T2);
	             P6.add(L5);
	             P6.add(P7);
	             P6.add(P10);
	             P6.add(P4);
	             P6.add(L3);
	             P6.add(A1);
	      P6.setBorder(BorderFactory.createTitledBorder(""));       
	      P.add(P6,BorderLayout.CENTER);      
	 //*********************************************************************************************
	             
	//TODO **************************Panel (Sports) ************************************************             
	             
	                 CH1 = new JCheckBox[9];
	                for(int i=0;i<9;i++){
	                	CH1[i] = new JCheckBox();
	                }
	                CH1[0].setText("Tennis");
	                CH1[1].setText("Squach");
	                CH1[2].setText("Natation");
	                CH1[3].setText("Athlétisme");
	                CH1[4].setText("Randoonnée");
	                CH1[5].setText("Foot");
	                CH1[6].setText("Basket");
	                CH1[7].setText("Volley");
	                CH1[8].setText("Petanque");
	               
	                
	          for(int i=0; i<9;i++){  
	        	  
	        	//     CH1[i].addItemListener((ItemListener) this);   
	        	  
	        	  
	          }
	                				
	                GridLayout D2 = new GridLayout(9,1); // line colone
	                P5 = new JPanel();
	                P5.setLayout(D2);
	                
	             
	               for(int i=0 ; i<9 ; i++){
	            	   P5.add(CH1[i]);
	               }
	               P5.setBorder(BorderFactory.createTitledBorder("Sports"));
	
	    	       P.add(P5,BorderLayout.EAST);
	    	       
	 
	  //**********************************************************************************************  	       
	    	     
	    	       
     //TODO ****************************instancier la fenetre***************************************
	    	       
	    	       
		     	       setTitle("Boîte de saisie");
		     	       setSize(500,500);
		     	       setResizable(true);
		     	       setLocationRelativeTo(null);
		     	       setResizable(true);
		     	       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		     	       pack();
		     	       
		     	       
		    	       }
	    	
	//**************************la fin de consructeur ***********************************************
		
	    	       
	  //TODO DocumentListener pour JTextField   	

		public void changedUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void insertUpdate(DocumentEvent e) {
			ScaneTextField();
			itemStateChanged(a);}

		public void removeUpdate(DocumentEvent e) {
			ScaneTextField();
			
			itemStateChanged(a);}
       
       
	
		
   public boolean ScanJTFPannuler(){
   	
   	if(T1.getText().length() != 0 ||  T2.getText().length() != 0 ||A1.getText().length() != 0){
   	return true;}
   	
   	else{ return false;}}	
   
   
   public boolean ScanJCHBPannuler(){
   	
		int z=0;
	    for(int i=0;i<9;i++){
	    	if(CH1[i].isSelected()){
	    		z++;}}
	    
	if( z != 0){  return true;}    
		
	else{  return false; }}
		
	
	
	public boolean ScaneTextField(){
		
	     if(T1.getText().length() == 0 ||  T2.getText().length() == 0 ||A1.getText().length() == 0 ){
			return false;
			}
		
        else{ return true; }}
	
	
	public boolean ScaneJcheckBox(){
		
		int t=0;
	    for(int i=0;i<9;i++){
	    	if(CH1[i].isSelected()){
	    		t++;}}
	    
	if( t != 0){  return true;}    
		
	else{  return false;}}
	
//TODO method pour les JRadioButon	
  public  boolean ScanJRadioButon(){
	   if(R2.isSelected()){return true;}
	   else{return false;}
	  
  }
 
	

	//TODO ItemListener pour JcheckBox			
	public void itemStateChanged(ItemEvent e) {
       if(ScaneTextField() &  ScaneJcheckBox() & C.getSelectedItem() !=" " &
          C1.getSelectedItem() !=" " & C2.getSelectedItem() !=" "){  
       	
       	ok.setEnabled(true);
       }
       else {  ok.setEnabled(false);                  }
       
      
      if(ScanJTFPannuler() ||  ScanJCHBPannuler() || C.getSelectedItem() !=" " ||
         C1.getSelectedItem() !=" " || C2.getSelectedItem() !=" " || ScanJRadioButon() ) { annuler.setEnabled(true);}
      
      else {  if(!R2.isSelected()) {  annuler.setEnabled(false);     } 
      
      }
      
   
    	

    }

		
		
	
	
   
	public boolean Jour31(){
		if(C1.getSelectedItem() == "Janvier" || C1.getSelectedItem() == "Mars" ||
		   C1.getSelectedItem() == "Mai" || C1.getSelectedItem() == "Juillet" ||
		   C1.getSelectedItem() == "Aôut" || C1.getSelectedItem() == "Octobre" ||
		   C1.getSelectedItem() == "Decembre"){
			return true;
			
		}
		else{ return false;}
	}
	
	public boolean Jour30(){
		if(C1.getSelectedItem() == "Avril" || C1.getSelectedItem() == "Juin" ||
		 C1.getSelectedItem() == "Septembre" || C1.getSelectedItem() == "Novembre"	)
		{ return true;}
		else{return false;}	
	}
	
	public boolean Jour29(){
		if(C1.getSelectedItem() == "Février"){return true;}
		else{return false;}
	}
//TODO method pour les ComboBox
public void actionPerformed(ActionEvent arg0) {
	itemStateChanged(a);
	
	Object QS = 29;
	Object N= 30;   
	Object T=31;
    Object A ="Aucun";
	  	if(C1.getSelectedItem() == A){
	  		C.setSelectedItem(A);
	  	}
	  	
	
	Object B = "Février" ; 	
   if(C1.getSelectedItem() == B){
	  
	 if(C.getItemCount() == 33){
	 C.setSelectedItem(" "); 
	   C.removeItem(N);
	   C.removeItem(T);
	   }
	if(C.getItemCount() == 32){
		C.setSelectedItem(" ");
		C.removeItem(N);
	}
	 
	}
	      
   
  
   else{  
	   Object Q= "Avril"; 
	   Object DDD= "Juin";
	   Object EEE = "Septembre";
	   Object FFF = "Novembre";
	   int aaa=0;
	   
    if(C1.getSelectedItem() == Q || C1.getSelectedItem()== DDD ||
 	       C1.getSelectedItem() == EEE || C1.getSelectedItem() == FFF){
    	   
    	if(C.getItemCount() == 33){ C.setSelectedItem(" ");
    		                        C.removeItem(T);
    		                        }
        else { if(C.getItemCount() == 31){
        	C.addItem(N);
        	}}         
         
    	
    } 
    	   	   
    
    
    else{
    	 Object I="Janvier" ;
         Object O="Mars";
         Object P="Mai"; 
         Object S="Juillet";
         Object SS = "Août";
         Object FF= "Octobre";
         Object K="Décembre";
     
    if(C1.getSelectedItem() == I ||C1.getSelectedItem() == O ||
      C1.getSelectedItem() == P || C1.getSelectedItem() == S ||
      C1.getSelectedItem() == SS || C1.getSelectedItem() == FF
       || C1.getSelectedItem() == K){
    	
    	
    	 if(C.getItemCount() == 32){  
             C.addItem(T);
             return;    
    	 }
    	 else{
    	     
    		  if(C.getItemCount() == 31){
    		                              C.addItem(N);
    		                              C.addItem(T);
    		                              return;                             
    		  }}}
    	
    		
    	
    	
    		  
    		}}}
   


    public static void main(String[] args) {
       Test T=new Test();
       T.setVisible(true);
     
      
    }

  
}
