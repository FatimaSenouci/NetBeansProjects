
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import menu.TableMenu1;
import menu.VolSetter;


public class DBConnection {
    private static final String USERNAME="root";
    private static final String PASSWORD="";
    private static final String HOST ="127.0.0.1";
    private static final int PORT  = 3306;
    private static final String DB_NAME="aeroport";
     
    public static Connection con;
    
     static {
        try {
            con = DriverManager.getConnection("jdbc:mysql://" + HOST + ":" + PORT + "/" + DB_NAME, USERNAME, PASSWORD);
        } catch (SQLException ex) {
            ex.printStackTrace();
            
        }

    }
    public static int checkLogin(String username,String password){
        
        Connection con=DBConnection.con;
        
        if (con ==null )return -1;
        
        
        String sql="SELECT *FROM controleur WHERE username=? AND password=?";
         try{
         PreparedStatement prest= con.prepareStatement(sql);
         prest.setString(1, username);
         prest.setString(2, password);
         
         
         ResultSet rs = prest.executeQuery();
         
         while (rs.next()){
             return 0;
         }
             
         }catch(SQLException se){
             se.printStackTrace();
         }
        return 1;
    } 
      public void insertPiste( TableMenu1 table) {

        String sql = "INSERT INTO piste(idpiste,type) VALUES (?,?);";
        Connection con = DBConnection.con;
        try {
            PreparedStatement prest = con.prepareStatement(sql);
            prest.setInt(1, table.getTrackidT());
            
            prest.setString(2, table.getTypeidT());
           
          
            prest.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
       public void deletePiste(TableMenu1 table)  {
         String sql = "DELETE FROM piste WHERE idpiste = ?";
         Connection con = DBConnection.con;
        try {
            PreparedStatement prest = con.prepareStatement(sql);
            prest.setInt(1, table.getTrackidT());
            prest.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
      
        
         }
//        public void SaveData( VolSetter table) {
//
//        String sql = "INSERT INTO information(Date,Idpiste,FlightN,PlaneN,Hangar,Control) VALUES (?,?,?,?,?,?);";
//        Connection con = DBConnection.con;
//        try {
//            PreparedStatement prest = con.prepareStatement(sql);
//            prest.setString(1,table.getLblDate3());
//            
//            prest.setString(2, table.getLblTid());
//            prest.setString(3, table.getLblPN());
//            prest.setString(4, table.getLblFN());
//            prest.setString(5, table.getLblHangar());
//            prest.setString(6, table.getLblControl());
//           
//          
//            prest.execute();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//    }

    
     
}