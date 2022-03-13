
package compil5;

import static compil5.Compil5.mot;
import java.util.Scanner;

public class Compil5 {
    static String mot;
    static int c1,c2;
    static boolean compt_a,compt_b,compt_c;
   
    // La premiere regle 
    static void compt(String mot){
    for(int i=0;i<mot.length();i++){  if (mot.charAt(i)=='a'){
            c1++;
            
        }
        if (mot.charAt(i)=='b'){
            c2++;
           
        }
    
    }

    }
        static void milieu(String mot){
    for(int i=0;i<mot.length();i++){  if (mot.charAt(i)=='a'){
          compt_a=true;
            
        }else
     compt_a=false;
    
        if (mot.charAt(i)=='b'){
             compt_b=true;
        }else compt_b=false;
        if (mot.charAt(i)=='c'){
             compt_c=true;
        }else compt_c=false;
        
    }

    }
    
    static void regleune(){
    if(c1%2==0 & c2%2!=0){
       
                System.out.println("le mot appartient a la premiere regle");}

  
                System.out.println("le mot n'appartient pas a la premiere regle");
                  compt(mot);
    }
  
          //regledeux
     static void regledeux(){
       
      
         if( c1%2==0){if((compt_a=true) & (compt_b=true) & (compt_c=true)){
                   System.out.println("le mot appartient a la deuxieme regle");
         }
                  System.out.println("le mot n'appartient  pas a la deuxieme regle"); 
     }
     
     
     
     
     }
         
        
              
     
    
    
    
    
  
    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
System.out.println("tapez votre mot");
mot=sc.next();

    }
    
}
