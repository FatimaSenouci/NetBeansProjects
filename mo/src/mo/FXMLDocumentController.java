/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private ListView<String > liste;
    @FXML
     private ListView<String > liste2;
    @FXML
	private TextField f1; 
	
	
	@FXML
	private TextField f2; 
	
	
//*****************************************************

	
	@FXML
	private TextField r1; 
	@FXML
	private TextField r11; 
	
	
	@FXML
	private TextField r2; 
	
	@FXML
	private TextField r22; 
	
	
	@FXML
	private TextField r3; 
	
	@FXML
	private TextField r33;



//*****************************************************

	String[][] regle = new String[15][6];
	String[] fais= new String[15];
   String[] trace= new String[15];


	
	int number=1;
	int number1=1;
        int number2=1;
       
        






   // TableColumn<?, ?> i =1; 
    @FXML
    private TextField f3;
    @FXML
    private TextField f4;
    @FXML
    private TextField r4;
    @FXML
    private TextField r5;
    @FXML
    private TextField r44;
    @FXML
    private TextField r55;
    @FXML
    private TextField r6;
    @FXML
    private TextField r66;
    @FXML
    private TextField f5;
    @FXML
    private TextField f6;
    @FXML
    private ListView<tracibilité> tracibilité;
    @FXML
	public void add() throws IOException

	{    	
		

		
	
	
 		
	     if( f1.getText() != null && !f1.getText().equals("")) 
	    	 
		 fais[1]= f1.getText();
	
	 
	
		 
	 	
	     if(f2.getText() != null && !f2.getText().equals("")) 
	    	 
	      fais[2]= f2.getText(); 
	     
	
	     
	 	
	     if(f3.getText() != null && !f3.getText().equals("")) 
	    	 
		 fais[3]= f3.getText();  
             
              if(f4.getText() != null && !f4.getText().equals("")) 
	    	 
		 fais[4]= f4.getText(); 
              
              
               if(f5.getText() != null && !f5.getText().equals("")) 
	    	 
		 fais[5]= f5.getText();  
               
               
                if(f6.getText() != null && !f6.getText().equals("")) 
	    	 
		 fais[6]= f6.getText();  
	     
	 	
	   
	     
	     
	     f1.setText(null);
	     f2.setText(null);
	     f3.setText(null);
             f4.setText(null);
	     f5.setText(null);
	     f6.setText(null);
	     
	     
	     
	     JOptionPane.showMessageDialog(null, "Fait ajouté!");
    	 
	
	}
	   
//*************************************************************************************************

  
	     


    @FXML
    public void afficher() throws IOException
	     
	     {   
	    	 
	    	int number=7;
	
			     	     
			    	 
	    	 liste.getItems().clear();
	    	 
	    	 int j= 1;
	    	 
	    	
	    	 
	    	 while (j < number)
	    	 { 
	    	if (fais[j]!=null)
	    	 liste.getItems().add(fais[j]);
	    	 j++;}
	    	 
	    	 
	    	 
	    	 
	    	
	     }
    @FXML
    public void add2() throws IOException

	{    	
		
		
	
    if(r1.getText()!=null && r11.getText()!=null) 
    	
    	
    {	regle[1][1]=r1.getText();
        regle[1][2]=r11.getText();}
	
    if(r2.getText()!=null && r22.getText()!=null) 
   	 
    {   	regle[2][1]=r2.getText();
                regle[2][2]=r22.getText();}
	
    if(r3.getText()!=null && r33.getText()!=null) 
   	 
      	{     regle[3][1]=r3.getText();
              regle[3][2]=r33.getText(); }
     if(r4.getText()!=null && r44.getText()!=null) 
   	 
      	{     regle[4][1]=r4.getText();
              regle[4][2]=r44.getText(); }
      if(r5.getText()!=null && r55.getText()!=null) 
   	 
      	{     regle[5][1]=r5.getText();
              regle[5][2]=r55.getText(); }
       if(r6.getText()!=null && r66.getText()!=null) 
   	 
      	{     regle[6][1]=r6.getText();
              regle[6][2]=r66.getText(); }
	
  

    
 
    r1.setText(null);
    r11.setText(null);
    r2.setText(null);
    r22.setText(null);
    r3.setText(null);
    r33.setText(null);
     r4.setText(null);
    r44.setText(null);
    r5.setText(null);
    r55.setText(null);
    r6.setText(null);
    r66.setText(null);
    
    
    

  
    
    JOptionPane.showMessageDialog(null, "Règle ajoutée!");
	 
    
  
 
	}


//*******************************************************************************

    @FXML
    public void afficher2() {
		

		
	number1=7;	

liste2.getItems().clear();

for(int j=1; j< number1;j++)

{
if (!regle[j][2].equals("") && !regle[j][1].equals(""))
liste2.getItems().add(regle[j][1]+" -----> "+ regle[j][2]);
}



		
	}




	




	
		
public void compter(){ 
	
               int i=1;
	     int k=1; // le nombre de fais

		
	     
	      while(fais[k]!=null && k<=10) 
	     
	       
			
		  	 k++;


         number=k-1; 



	
	      
	      
	         while(regle[i][1]!=null && i<=10) 
	     
	      { 
			
		   	 i++;}


         number1=i-1; }
	      
	      
	      
	
	
	
	
	
	
	
	
	
	
	
	
	//****************************Find a fact********************************************************************
	

	
     // parcourir la base des faits si elle trouve un fait donnÃ© --> return true. sinon false



	boolean Find_Fact( String x)
	
	{
		
		boolean flag=false; 
		int i=1;
		
		
		
		while (i<= number && flag ==false && x!= null)
		
			{if(x.equals(fais[i])) 
			  flag=true; 
			 i++;
			
			}
			
			if (flag==true)
				
				return true; 
			
			else return false;
		

	}
        void add_array (String x) {
	
	     int i=1;
             while(fais[i]!=null && i<=10) 
	     
	      {   i++;}
	   
	     fais[i]= x;
	  
	     number++;
	     
		
	}
	
	
	
	
	
	
	
	
	
	@FXML
	private TextField but;  
	
	@FXML
	private Label l1;  

	//****************************Find a fact********************************************************************
	

    @FXML
	 public void  recherche () 
	
	{
		

		 
	     String goal= but.getText();
	     
	   
	     if (!but.getText().equals(""))
	    	 
	     {
	     
	
	     int i=1;
		 
		 if (!Find_Fact(goal))
			 
		 {
		    
			 
			 while(!Find_Fact(goal) && i<=number)
				 
			 {	 for (int j=1; j<=number1;j++)
				
					 if (fais[i].equals(regle[j][1]) && !Find_Fact(regle[j][2]) )
			         add_array(regle[j][2]); 
			 
			    
			 
		 	 i++;
			
			 }
			 
			 
		
			 
			 if (Find_Fact(goal))
				 
				 
			 
		 	  l1.setText("But Atteint ! :) ");
			    
			 
			 
			 
			
			 else
				 
				 

	
		 	  l1.setText("But non  Atteint ! :( ");
		
			 
		 }
		 
		 
		 else
		 
		 
		 
	 	  l1.setText("But Atteint ! :) " );
		 
	     }
	     
	     
	     
	     
	     else 
	    	 
	    	 
	     l1.setText("SpÃ©cifier un but!");
             
             
           
	
		
		
	}
         
	



		//*************************************************************************************************	
	    
	   
	
	




  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Tracibilité(ActionEvent event) {
//        int i=1;
//        for(i=1  i<=7  i++){if (but=r1[i]  )} 

//if(f1.equals(r1)){tracibilité[1]="X";}
//if (but.equals(r1) && !but.equals(r11) )
//			       
//
//tracibilité.getItems().equals("X");
//		number2=7;	
//           String x="XX";
//	    	 tracibilité.getItems().clear();
//	    	
//	    	 int j= 1;
//	     
//	    	 while (j < number2)
//	    	 { 
//	    	if (but.equals(r11))
//	    	 
//                     System.out.println(tracibilité+x);
//                     
//	    	}
		       


    }
    
}
