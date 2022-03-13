import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Controle extends JFrame {

	public Controle() {
	setTitle("Contrôle de remplacemet");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	BorderLayout borderLayout1 = new BorderLayout();

	JPanel Pane1 = new JPanel();
	JPanel Pane2 = new JPanel();
	JPanel Pane3 = new JPanel();

	getContentPane().setLayout(borderLayout1);

	add(Pane1,borderLayout1.CENTER);
	add(Pane3,borderLayout1.SOUTH);

	BorderLayout borderLayout11 = new BorderLayout();
	JPanel Pane11 = new JPanel();
	JPanel Pane12 = new JPanel();

	JTextArea AdresseTexte  = new JTextArea();
	Pane1.setLayout(borderLayout11);
	Pane1.add(Pane11,borderLayout1.NORTH);
	Pane1.add(AdresseTexte,borderLayout1.CENTER);
	Pane1.add(Pane12,borderLayout1.SOUTH);

	GridLayout gridLayout1 = new GridLayout(5,1);
	Pane11.setLayout(gridLayout1);

	JLabel NomLab = new JLabel("Nom");
	JLabel PrenomLab = new JLabel("Prénom");
	JLabel AdresseLab = new JLabel("Adresse");
	JLabel SportsLab = new JLabel("Sports");

	JTextField NomText = new JTextField();
	JTextField PrenomText = new JTextField();

	Pane11.add(PrenomLab);   
	Pane11.add(PrenomText);   
	Pane11.add(NomLab);   
	Pane11.add(NomText);   
	Pane11.add(AdresseLab);
	FlowLayout flowLayout1 = new FlowLayout();
	Pane2.setLayout(flowLayout1);

	ButtonGroup grRadio = new ButtonGroup();
	JLabel SexeLab = new JLabel("Sexe");
	JRadioButton HommeRadio = new JRadioButton("Homme");
	JRadioButton FemmeRadio = new JRadioButton("Femme");

	grRadio.add(HommeRadio);
	grRadio.add(FemmeRadio);

	HommeRadio.setSelected(true);

	Pane2.add(SexeLab);
	Pane2.add(FemmeRadio);
	Pane2.add(HommeRadio);

	FlowLayout flowLayout2 = new FlowLayout();
	Pane3.setLayout(flowLayout2);

	JButton OkBouton = new JButton("Valider");    
	JButton EffacerBouton = new JButton("Effacer Tous");    
	JButton AnnulerBouton = new JButton("Annuler");    

	Pane3.add(OkBouton);
	Pane3.add(AnnulerBouton);
	Pane3.add(EffacerBouton);

	JPanel Pane121 = new JPanel();

	GridLayout gridLayout2 = new GridLayout(2,3);
	Pane121.setLayout(gridLayout2);

	JCheckBox TennisBtn = new JCheckBox("Tennis");
	JCheckBox SquashBtn = new JCheckBox("Squash");
	JCheckBox NatationBtn = new JCheckBox("Natation");
	JCheckBox RandonneeBtn = new JCheckBox("Randonnée");
	JCheckBox FootBtn = new JCheckBox("Foot");
	JCheckBox BasketBtn = new JCheckBox("Basket");
	JCheckBox VolleyBtn = new JCheckBox("Volley");
	JCheckBox PetanqueBtn = new JCheckBox("Petanque");

	Pane121.add(TennisBtn);
	Pane121.add(PetanqueBtn);
	Pane121.add(NatationBtn);
	Pane121.add(VolleyBtn);
	Pane121.add(RandonneeBtn);
	Pane121.add(FootBtn);

	GridLayout gridLayout3 = new GridLayout(2,1);
	Pane12.setLayout(gridLayout3);

	Pane12.add(SportsLab);
	Pane12.add(Pane121);
	setVisible(true);
	pack();	   
	}
	public static void main(String[] args) {
	                                               new Controle();
		}
	}  
