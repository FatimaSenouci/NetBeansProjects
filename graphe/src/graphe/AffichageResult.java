/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphe;


import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.lang.String.*;


public class AffichageResult extends JPanel
{

public JLabel NombrePoints;
public JLabel Bornes;

public AffichageResult(int X0 , int Y0 , int Width , int Heigh)
{
setBorder(new LineBorder(new Color(0, 0, 0)));
setBackground(new Color(200,200, 200));
//initialisation dimension
setBounds(X0,Y0,Width,Heigh);
setLayout(null);
Initialisation();
}

private void Initialisation()
{
//mise en place d'un container
NombrePoints = new JLabel("Nombre de points : <>");
Bornes = new JLabel("Bornes de Simulation : [ <> - <> ]");
add(NombrePoints);
add(Bornes);
NombrePoints.setBounds(10,10,800,20);
NombrePoints.setVisible(true);
Bornes.setBounds(10,40,800,20);
Bornes.setVisible(true);

}



}