package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;
import model.Pistemodel;
import model.Avionmodel;
import model.Message;
import model.Pilotemodel;
import model.Stripmodel;
import model.TechnecienModel;
import model.Volmodel;
import model.reservation;
import model.strip2model;

public class DBConnection {

    // Information of Database
    private final static String USERNAME = "root";
    private final static String PASSWORD = "";
    private final static String URL = "127.0.0.1";
    private final static int PORT = 3306;
    private final static String DB_NAME = "aeroport";

    // Connection
    // ObservableList<pistes> produis = FXCollections.observableArrayList();
    public static Connection con;

    static {
        try {
            con = DriverManager.getConnection("jdbc:mysql://" + URL + ":" + PORT + "/" + DB_NAME, USERNAME, PASSWORD);
        } catch (SQLException se) {
            se.printStackTrace();
        }

    }

    public static int checkLogin(String username, String password, boolean isAdmin) throws SQLException {
        Connection con = DBConnection.con;
        if (con == null) {
            return -1;
        }
        String tableName;
        if (isAdmin) {
            tableName = "admin";
        } else {
            tableName = "controleur";
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

    public void insertPiste(Pistemodel pistes) {

        String sql = "INSERT INTO piste VALUES(?, ?, ?);";
        Connection con = DBConnection.con;
        try {
            PreparedStatement prest = con.prepareStatement(sql);
            prest.setInt(1, pistes.getIdpiste());
            prest.setString(2, pistes.getType());
            prest.setInt(3, pistes.getNombre());

            prest.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    
         public void deletePiste(Pistemodel pistes)  {
         String sql = "DELETE FROM piste WHERE idpiste = ?";
         Connection con = DBConnection.con;
        try {
            PreparedStatement prest = con.prepareStatement(sql);
            prest.setInt(1, pistes.getIdpiste());  
            prest.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
      
        
         }
        
    public void insertAvion(Avionmodel avions) {

        String sql = "INSERT INTO avion VALUES(?, ?, ?);";
        Connection con = DBConnection.con;
        try {
            PreparedStatement prest = con.prepareStatement(sql);
            prest.setInt(1, avions.getIdavion());
            prest.setString(2, avions.getNom_avion());
            prest.setInt(3, avions.getCapacité());

            prest.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
        public void insertVol(Volmodel vols) {

        String sql = "INSERT INTO vol VALUES(?, ?, ?, ?, ?);";
        Connection con = DBConnection.con;
        try {
            PreparedStatement prest = con.prepareStatement(sql);
            prest.setInt(1, vols.getIdvol());
//            prest.setString(2, ((TextField)Calendar.getAvailableCalendarTypes()));
//            prest.setString(2, vols.getDdd());
            prest.setString(2, vols.getDdd());
            prest.setString(3, vols.getHdd());
            prest.setString(4, vols.getDda());
            prest.setString(5, vols.getHda());

            prest.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
          public void insertPilote(Pilotemodel pilots) {

        String sql = "INSERT INTO pilote VALUES(?, ?, ?, ?, ?, ?);";
        Connection con = DBConnection.con;
        try {
            PreparedStatement prest = con.prepareStatement(sql);
            prest.setInt(1, pilots.getIdpilot());
            prest.setString(2, pilots.getIdname());
            prest.setString(3, pilots.getIdprenom());
            prest.setString(4, pilots.getIdnaiss());
            prest.setInt(5, pilots.getIdphone());
            prest.setString(6, pilots.getIdnational());

            prest.execute();
             
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
            public void deletePilote(Pilotemodel pilots) {

        String sql = "DELETE FROM pilote WHERE idpilote = ?;";
        Connection con = DBConnection.con;
        try {
            PreparedStatement prest = con.prepareStatement(sql);
            prest.setInt(1, pilots.getIdpilot());
           prest.executeUpdate();

           
             
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
             public void insertTechnecien(TechnecienModel techs) {

        String sql = "INSERT INTO technicien VALUES(?,?,?,?,?);";
        Connection con = DBConnection.con;
        try {
            PreparedStatement prest = con.prepareStatement(sql);
            prest.setInt(1,techs.getIdtech());
            prest.setString(2,techs.getFirstname());
            prest.setString(3,techs.getName());
            prest.setString(4,techs.getNaiss());
            prest.setInt(5,techs.getPhone());

            prest.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
                public void deleteTechnecien(TechnecienModel techs) {

        String sql = "DELETE FROM technicien WHERE idtech = ?;";
        Connection con = DBConnection.con;
        try {
            PreparedStatement prest = con.prepareStatement(sql);
            prest.setInt(1,techs.getIdtech());
          
         prest.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
           
    public void deleteAvion(Avionmodel avions) {

       String sql = "DELETE FROM avion WHERE idavion = ?";
        Connection con = DBConnection.con;
        try {
            PreparedStatement prest = con.prepareStatement(sql);
            prest.setInt(1, avions.getIdavion());
        

            prest.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
     public void insertStrip(Stripmodel strips) {

        String sql = "INSERT INTO stripb VALUES(?, ?, ?, ?, ?, ?, ?);";
        Connection con = DBConnection.con;
        try {
            PreparedStatement prest = con.prepareStatement(sql);
           
            prest.setString(1, strips.getId1());
            prest.setString(2, strips.getId2());
            prest.setString(3, strips.getId3());
            prest.setString(4, strips.getId4());
            prest.setString(5, strips.getId5());
            prest.setString(6, strips.getId6());
            prest.setString(7, strips.getId7());

            prest.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
          public void insertStrip2(strip2model strips) {

        String sql = "INSERT INTO strip2 VALUES(?, ?, ?, ?, ?, ?);";
        Connection con = DBConnection.con;
        try {
            PreparedStatement prest = con.prepareStatement(sql);
           
            prest.setString(1, strips.getId1());
            prest.setString(2, strips.getId2());
            prest.setString(3, strips.getId3());
            prest.setString(4, strips.getId4());
            prest.setString(5, strips.getId5());
            prest.setString(6, strips.getId6());
           

            prest.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
     
     public void insertMessage(Message message) {

        String sql = "INSERT INTO messages VALUES(?, ?, ?, ?, ?);";
        Connection con = DBConnection.con;
        try {
            PreparedStatement prest = con.prepareStatement(sql);
           
        
            prest.setString(1,null );
            prest.setInt(2, message.getId_sender());
            prest.setInt(3, message.getId_receiver());
            prest.setString(4, message.getMessage());
            prest.setDate(5, message.getDate());

            prest.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
      public void insertReserve(reservation reserve) {

        String sql = "INSERT INTO reservation VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        Connection con = DBConnection.con;
        try {
            PreparedStatement prest = con.prepareStatement(sql);
           
            prest.setString(1, reserve.getBnom());
            prest.setString(2, reserve.getBprenom());
            prest.setString(3, reserve.getComboEtat1());
            prest.setString(4, reserve.getComboClass1());
            prest.setString(5, reserve.getNbValise());
            prest.setString(6, reserve.getVdarrive());
           prest.setString(7, reserve.getVdepart());
          
            prest.setString(8, reserve.getBpassport());
            prest.setString(9, reserve.getDateD1());
              prest.setString(10, reserve.getDateR1());
           

            prest.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
        public void updatePiste(Pistemodel piste) {

        String sql = "UPDATE `piste` SET `idpiste`=?,`type`=?,`nombre`=? WHERE `idpiste`=?;";
        Connection con = DBConnection.con;
        try {
            PreparedStatement prest = con.prepareStatement(sql);
           
    
        prest.setInt(1, piste.getIdpiste());
            prest.setString(2, piste.getType());
           
             prest.setInt(3, piste.getNombre());
          
          prest.setInt(4, piste.getIdpiste());
          
           

            prest.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
           public void updateAvion(Avionmodel avions) {

        String sql = "UPDATE `avion` SET `idavion`=?,`nom_avion`=?,`capacité`=? WHERE `idavion`=?;";
        Connection con = DBConnection.con;
        try {
            PreparedStatement prest = con.prepareStatement(sql);
            prest.setInt(1, avions.getIdavion());
            prest.setString(2, avions.getNom_avion());
            prest.setInt(3, avions.getCapacité());

            prest.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
               public void updateVol(Volmodel vols) {

        String sql = "UPDATE `vol` SET `idvol`=?,`ddd`=?,`hdd`=?,`dda`=?,`hda`=? WHERE `idvol`=?;";
        Connection con = DBConnection.con;
        try {
            PreparedStatement prest = con.prepareStatement(sql);
            prest.setInt(1, vols.getIdvol());
//            prest.setString(2, ((TextField)Calendar.getAvailableCalendarTypes()));
//            prest.setString(2, vols.getDdd());
            prest.setString(2, vols.getDdd());
            prest.setString(3, vols.getHdd());
            prest.setString(4, vols.getDda());
            prest.setString(5, vols.getHda());

//            prest.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
                  public void updatePilote(Pilotemodel pilots) {

        String sql = "UPDATE `pilote` SET `idpilote`=?,`nom`=?,`prenom`=?,`ddn`=?,`telephone`=?,`nationalité`=? WHERE `idpilote`=?;";
        Connection con = DBConnection.con;
        try {
            PreparedStatement prest = con.prepareStatement(sql);
            prest.setInt(1, pilots.getIdpilot());
            prest.setString(2, pilots.getIdname());
            prest.setString(3, pilots.getIdprenom());
            prest.setString(4, pilots.getIdnaiss());
            prest.setInt(5, pilots.getIdphone());
            prest.setString(6, pilots.getIdnational());

            prest.execute();
             
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
      public void updateTechnecien(TechnecienModel techs) {

        String sql = "UPDATE `technicien` SET `idtech`=?,`nom`=?,`prenom`=?,`ddn`=?,`telephone`=? WHERE `idtech`=?;";
        Connection con = DBConnection.con;
        try {
            PreparedStatement prest = con.prepareStatement(sql);
            prest.setInt(1,techs.getIdtech());
            prest.setString(2,techs.getFirstname());
            prest.setString(3,techs.getName());
            prest.setString(4,techs.getNaiss());
            prest.setInt(5,techs.getPhone());

            prest.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }   
      
      

}
