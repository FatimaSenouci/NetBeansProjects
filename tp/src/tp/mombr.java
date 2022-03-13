package tp;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;
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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


public class mombr extends JFrame implements ActionListener , DocumentListener  {
	

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//TODO ***************************déclaration******************************************
	  public int c=0;
	  JTextField T1,T2; 
	  JTextArea A1;
	  JRadioButton R1,R2;
	  JCheckBox[] CH1 ;
      JLabel L33,L44;
      JButton ok,annuler;
      JFrame F,G;
      public static boolean I=false;
 //*********************************************************************************
            
 //****************************constructeur*****************************************       
		public mombr(){
			
		     //TODO ******************** Panel P*********************** 
			      BorderLayout B =new BorderLayout();
			      JPanel P =new JPanel();
			      P.setLayout(B);
			      setContentPane(P);
			      
			//TODO ********************* Panel (ok +annuler)***********
                  ok = new JButton("ok");
                  ok.setEnabled(false); //désactiver la button ok
                  annuler = new JButton("Annuler");
              
                  FlowLayout F1 = new FlowLayout();
                  JPanel P1 = new JPanel();
                  P1.setLayout(F1);
           //TODO ********la fonction de la button Annuler************   
          	
  			     annuler.addActionListener(e->{
  			    	 
  				      T1.setText("");
  				      T2.setText("");
  				      A1.setText("");
  				
  				      R1.setSelected(true);
  				      ok.setEnabled(false);
  				      I =false;
  				
  				      for(int i=0;i<9;i++){
  					     CH1[i].setSelected(false);}});
  			         
  			//*********************************************************	
  			     
  		
  			            
  			//TODO *********la fonction de la button OK****************            
  			            
  			   ok.addActionListener(e ->{
  				
  		        String t1 = T1.getText();
				boolean t=true;
				 //*******le contrôle des champs si elles sont vide ou leur contenue != lettres
				
				       if(!T1.getText().isEmpty()){
				          if(!t1.matches("[a-zA-Z]+")) {
					 JOptionPane.showMessageDialog(this, "introduire le nom que avec des alphabets");
					   t = false;
					   return;}}
					
			    String T3 = T2.getText();
				       if(!T2.getText().isEmpty()){
				          if(!T3.matches("[a-zA-Z]+")) {
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
				    String type = "\n" ;
					   int i =1;
						   for(JCheckBox F : CH1) {
						        if(F.isSelected()) {
							      type += "       "+i+ "- " +F.getText()+" \n";
							       i++;}}
						        
						
					
				    String nom=" ";
				      if(R1.isSelected()){
				            nom ="Homme";
				 
				            JOptionPane.showMessageDialog(this, 
		                                  "Nom: "+T1.getText()+"\n"
                                          +"Prenom: "+T2.getText()+"\n"
	                                      +"Adresse:"+A1.getText()+"\n"
                                          +"Sexe:"+nom+"\n"+"Sport:"+type);
                              return;}
				
				
				      else{
					        nom="Femme";  
					        JOptionPane.showMessageDialog(this, 
							              "Nom: "+T1.getText()+"\n"
					                      +"Prenom: "+T2.getText()+"\n"
						                  +"Adresse:"+A1.getText()+"\n"
					                      +"Sexe:"+nom+"\n"+"Sport:"+type);}} });
					
			  
  			  //****************************************************************************  
  			
              
  			 
              P1.add(ok);
              P1.add(annuler);
              
              P.add(P1,BorderLayout.SOUTH);
              
              //TODO le contenue de centre de panel P
                 BorderLayout B1 = new BorderLayout();
                 JPanel P2 =new JPanel();
                 P2.setLayout(B1);
                 
                 JLabel L1 =new JLabel("Nom");
                 T1 = new JTextField();
                 T1.getDocument().addDocumentListener(this);
                 T1.addKeyListener(new KeyListener() {
					
					@Override
					public void keyTyped(KeyEvent e) {
					  char c=e.getKeyChar();
					if ((!Character.isAlphabetic(c))|| c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE){
					       e.consume();
					  }// TextField T1 accecpt que des alphabets
						
					}
					
					@Override
					public void keyReleased(KeyEvent e) {
						
					}
					
					@Override
					public void keyPressed(KeyEvent e) {
						
					}
				
                	 
                });
 	             JLabel L2 = new JLabel("Prenom");
 	             T2 = new JTextField();
 	             T2.getDocument().addDocumentListener(this);
 	             T2.addKeyListener(new KeyListener() {
					
					@Override
					public void keyTyped(KeyEvent s) {
						  char c=s.getKeyChar();
							if ((!Character.isAlphabetic(c))|| c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE){
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
 	             JLabel L3 =new JLabel("adresse");
 	             A1 = new JTextArea(5,5);
 	             A1.getDocument().addDocumentListener(this);
 	             
 	             GridLayout D1 = new GridLayout(5,1);//line colone
 	             JPanel P3 = new JPanel();
 	             P3.setLayout(D1);
 	             
 	             P3.add(L1);
 	             P3.add(T1);
 	             P3.add(L2);
 	             P3.add(T2);
 	             P3.add(L3);
 	           
 	             P2.add(P3,BorderLayout.NORTH);
 	             P2.add(A1,BorderLayout.CENTER);
 	             
 	             JLabel L4 = new JLabel("Sexe");
 	             R1 = new JRadioButton("Homme");
 	             R2 = new JRadioButton("Femme");
 	             ButtonGroup G1 =new ButtonGroup();
 	             R1.setSelected(true);
 	             G1.add(R1);
 	             G1.add(R2);
 	             
 	             FlowLayout F2 =new FlowLayout();
 	             JPanel P4 = new JPanel();
 	             P4.setLayout(F2);
 	             
 	             P4.add(L4);
 	             P4.add(R1);
 	             P4.add(R2);
 	             
 	             P2.add(P4,BorderLayout.SOUTH);
 	             
 	             
 	             
 	             //TODO Panel Sport
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
 	               
 	                
 	               for(int i=0;i<9;i++){
	                	CH1[i].addItemListener(new ItemListener() {
							
	                		@Override
	                		public void itemStateChanged(ItemEvent e) {
	                				if(e.getStateChange() == ItemEvent.SELECTED){
	                				  I=true; 
	                				  ScaneTextField();
	                					 } 
	                				
	                		
	                		}    
	                		
	                	});
	                				
	                				
	                					
	                		
	                		
 	               }
						   
							
					   
					
							
						
						
	                		 
	                	
	                	
 	               
 	                GridLayout D2 = new GridLayout(9,1); // line colone
 	                JPanel P5 = new JPanel();
 	                P5.setLayout(D2);
 	                
 	             
 	               for(int i=0 ; i<9 ; i++){
 	            	   P5.add(CH1[i]);
 	               }
 	               P5.setBorder(BorderFactory.createTitledBorder("Sports"));
	
	    	       P.add(P5,BorderLayout.EAST);
	    	       P.add(P2,BorderLayout.CENTER);
	 
	    	       
	    	     
	    	       
	    	       //TODO instancier la fenetre
		     	      setTitle("Boîte de saisie");
		     	       setLocationRelativeTo(null);
		     	       setResizable(true);
		     	       setSize(500,600);
		     	       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    	       pack(); }
	    	
	 
	    	       
	    	

		@Override
		public void changedUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			
		}




		@Override
		public void insertUpdate(DocumentEvent e) {
			ScaneTextField();
		
		}




		@Override
		public void removeUpdate(DocumentEvent e) {
	
			ScaneTextField();
		
		}
	
		
	

	public void ScaneTextField(){
		
		 boolean T=true;
		
		if(I==false ||T1.getText().length() == 0 || T2.getText().length() == 0 || A1.getText().length() == 0 ){
			T =false;
			ok.setEnabled(T);}
		
		
		else {  ok.setEnabled(true); }
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
	
		
	}
	

	
	
		
	  
	  
		
		

	public static void main(String[] args) {
		mombr F1=new mombr();
		
		   //TODO visibilité 
		    F1.setVisible(true);
		    

	}}