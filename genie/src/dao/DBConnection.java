
package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import model.produit;

public class DBConnection {

    // Information of Database
    private final static String USERNAME = "root";
    private final static String PASSWORD = "";
    private final static String URL = "127.0.0.1";
    private final static String DB_NAME = "genie";
    private final static int PORT = 3306;
    
    // Connection
    public static Connection con;
     ObservableList<produit> produis = FXCollections.observableArrayList();

    
    
    public static Connection getConnection() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://" + URL + ":" + PORT + "/" + DB_NAME, USERNAME, PASSWORD);
        } catch(SQLException se) {
            se.printStackTrace();
        }
        
        if(con != null){
            return con;
        }else{
            return null;
        }
        
    }

    public int insertProduit(produit produit) throws SQLException {
        
        
        String sql = "INSERT INTO produit VALUES(?, ?, ?, ?);";
        con = getConnection();
         int isInsert = 0;
         PreparedStatement prest = con.prepareStatement(sql);
        try {
            
            prest.setInt(1, produit.getId());
            prest.setString(2, produit.getType());
            prest.setInt(3, produit.getComptité());
            prest.setInt(4, produit.getPrix());
            prest.execute();
            isInsert = 1;
            
        } catch (SQLException e) {
              Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("WARNING");
            alert.setHeaderText("!!");
            alert.setContentText(e.getMessage());

            alert.showAndWait();

            e.printStackTrace();
        }finally {
            con.close();
            prest.close();
            
        }
        return isInsert;
        
        
        
        
        
    }

    
     public int deleteProdect(produit produit) throws SQLException {

        PreparedStatement ps = null;
        Connection con = null;
        int isDelete = 0;

        try {
            con = getConnection();
            String sql = "DELETE FROM produit WHERE id = ?";
            ps = con.prepareStatement(sql);           
            ps.setInt(1, produit.getId());  
            ps.executeUpdate();
            
            isDelete = 1;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(produit.class.getName()).log(Level.SEVERE, null, ex);

        }finally{
            con.close();
            ps.close();
        }
        return isDelete;
    }
      public static int checkLogin(String username, String password, boolean isAdmin) throws SQLException {
        Connection con = DBConnection.con;
        if (con == null) {
            return -1;
        }
        String tableName;
        if (isAdmin) {
            tableName = "administrateur";
        } else {
            tableName = "vendeur";
        }

        String sql = "SELECT * FROM " + tableName + " WHERE username=? AND password=? ";
        try {
            PreparedStatement prest = con.prepareCall(sql);
            prest.setString(1, username);
            prest.setString(2, password);
            ResultSet rs = prest.executeQuery();
            while (rs.next()) {
                return 0;
            }

        } catch (SQLException se) {
            se.printStackTrace();
        }
        return 1;
    }
     
     
     
     
     
    }

