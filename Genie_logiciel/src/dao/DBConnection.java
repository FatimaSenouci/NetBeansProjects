
package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.produit;


public class DBConnection {
    
    // Information of Database
    private final static String USERNAME = "root";
    private final static String PASSWORD = "";
    private final static String URL = "127.0.0.1";
    private final static String DB_NAME = "gl";
    private final static int PORT = 3306;
    
    // Connection
    public static Connection con;

    
    
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

    public void insertproduit(produit produit) {
        
        
        String sql = "INSERT INTO produit VALUES(?, ?, ?, ?, ?);";
        con = getConnection();
        try {
            PreparedStatement prest = con.prepareStatement(sql);
            prest.setInt(1, produit.getId());
            prest.setString(2, produit.getType());
            prest.setString(3, produit.getMarque());
            prest.setInt(4, produit.getPrix());
            prest.setInt(5, produit.getNombre());
            
            prest.execute();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

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
