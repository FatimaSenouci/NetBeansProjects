
package follow;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Follow {
        public static void main(String[] args) {
         
      Scanner input=new Scanner(System.in);
        String n=input.nextLine();
          if(Pattern.matches("[abc]+",n)){
              System.out.println("le decodage est ="+decode(code(n))+"\ncode="+code(n));
          }
          else {
              System.out.println("erreur [a,b,c]");
          }
              
          }
    private static String code(String string){
        String after="";
        
        for(char c:string.toCharArray())
            
                 switch (c) {
                case 'a':
                    after+="0";
                    break;
                case 'b':
                    after+="01";
                    break;
                default:
                    after+="11";
                    break;
            }
                  
            
        return after;
    }
      private static String decode(String string ){
          String after="";
          int i=0;
          int number;
      while(i< string.length()){
          if (string.charAt(i)=='0'){
              number =0;
         for(int j=i+1;j<string.length();j++){
             
             if(string.charAt(j)=='0')
                 break;
             else 
                 number++;
         }
          if(number %2==0){
              after+='a';
              i++; }
          else {
              after+='b';
              i+=2;
          }
          }
          else {
              after+="c";
              i+=2;
          }
      }
      return after;
      }
}
             
          
        
      
        
