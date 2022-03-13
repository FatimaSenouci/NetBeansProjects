/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphe;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.*;
import java.lang.String.*;


public class courbe extends JFrame
{

//d�claration du panel d'affichage des courbes
AffichageCourbe MonAffichage;
AffichageResult MonAffichageResult;

public courbe()
{
this.Initialise();
this.setVisible(true);
}

private void Initialise()
{
//mise en place d'un container
Container Content = this.getContentPane();

//on met la fen�tre en plein �cran
int width = (int)Toolkit.getDefaultToolkit().getScreenSize().width;
int heigh = (int)Toolkit.getDefaultToolkit().getScreenSize().height;
setBounds(0,0,width, heigh);
this.setResizable(false);
//on met en place le menu barre
JMenuBar MenuBar = new JMenuBar();
this.setJMenuBar(MenuBar);
JMenu Menu1 = new JMenu("Fichier");
JMenuItem Fonction = new JMenuItem("Importer une fonction", 2);
JMenuItem Quit = new JMenuItem("Quitter", 2);
MenuBar.add(Menu1);
Menu1.add(Fonction);
Menu1.addSeparator();
Menu1.add(Quit);

JMenu Menu2 = new JMenu("Syst�me");
JMenuItem Nb = new JMenuItem("Param�tres syst�mes", 2);
MenuBar.add(Menu2);
Menu2.add(Nb);

JMenu Menu3 = new JMenu("Param�tres Courbes");
JMenuItem Bornes = new JMenuItem("Bornes", 2);
MenuBar.add(Menu3);
Menu3.add(Bornes);

JMenu Menu4 = new JMenu("Simulation");
JMenuItem Expli = new JMenuItem("M�thode d'Euler explicite", 2);
JMenuItem Impli = new JMenuItem("M�thode d'Euler implicite", 2);
MenuBar.add(Menu4);
Menu4.add(Expli);
Menu4.add(Impli);

//gestion des menu barres
this.addWindowListener( new WindowAdapter(){
@Override
public void windowClosing(WindowEvent e){
setVisible(false);
dispose();
System.exit(0);
}});

Quit.addActionListener( new ActionListener(){
public void actionPerformed(ActionEvent e){
System.exit(0);
}});

Nb.addActionListener( new ActionListener(){
public void actionPerformed(ActionEvent e){
PSysteme();
}});

Bornes.addActionListener( new ActionListener(){
public void actionPerformed(ActionEvent e){
PBornes();
}});

//mise en place du panneau principal
JPanel Affichage = new JPanel();
Affichage.setBorder(new LineBorder(new Color(0, 0, 0)));
Affichage.setBackground(new Color(255, 255, 204));
Affichage.setLayout(null);
Content.add(Affichage);

//initialisation des constantes de dimensionnement "affichage"
int X0 = 20;
int Y0 = 20;
int WidthC = width - 4*X0 - 5;
int HeighC = heigh - (int)(2*heigh/5);

//mise en place du panel
MonAffichage = new AffichageCourbe(X0,Y0,WidthC,HeighC);
Affichage.add(MonAffichage);

//initialisation des constantes de dimensionnement "resultat"
X0 = 20;
Y0 = Y0 + 60 + HeighC;
WidthC = width - (int)(width/5);
HeighC = (int)(2*heigh/5) - 145;

//mise en place du panel d'affichage des r�sultats
MonAffichageResult = new AffichageResult(X0,Y0,WidthC,HeighC);
Affichage.add(MonAffichageResult);
MonAffichageResult.NombrePoints.setText("Nombre de points : "+MonAffichage.NombrePoints);
MonAffichageResult.Bornes.setText("Bornes de Simulation : [ "+MonAffichage.PointA+" - "+MonAffichage.PointB+" ]");

}

private void PSysteme()
{
PSys ParamSys = new PSys(this,true,MonAffichage.NombrePoints);
ParamSys.setLocation(200,200);
ParamSys.show();
MonAffichage.NombrePoints = ParamSys.NombrePoints;
MonAffichageResult.NombrePoints.setText("Nombre de points : "+MonAffichage.NombrePoints);
MonAffichage.MiseAJour();
}

private void PBornes()
{
PBorne ParamBorne = new PBorne(this,true,MonAffichage.PointA,MonAffichage.PointB);
ParamBorne.setLocation(200,200);
ParamBorne.show();
MonAffichage.PointA = ParamBorne.PointA;
MonAffichage.PointB = ParamBorne.PointB;
MonAffichageResult.Bornes.setText("Bornes de Simulation : [ "+MonAffichage.PointA+" - "+MonAffichage.PointB+" ]");
MonAffichage.MiseAJour();
}

}





