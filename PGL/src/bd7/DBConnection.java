package bd7;

import bd7.models.Person;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnection {

    // Information of Database
    private final static String USERNAME = "root";
    private final static String PASSWORD = "";
    private final static String URL = "127.0.0.1";
    private final static String DB_NAME = "faculté";
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

    public void insertPerson(Person person) {
        
        
        String sql = "INSERT INTO etudiant VALUES(?, ?, ?, ?, ?);";
        con = getConnection();
        try {
            PreparedStatement prest = con.prepareStatement(sql);
            prest.setInt(1, person.getId());
            prest.setString(2, person.getNom());
            prest.setString(3, person.getPrenom());
            prest.setString(4, person.getDateNaiss());
            prest.setInt(5, person.getPromo());
            
            prest.execute();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
