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


public class AffichageCourbe extends JPanel implements MouseListener, MouseMotionListener
{

public int NombrePoints = 500;
public double PointA = -10.0;
public double PointB = 10.0;
private CourbeMath MaCourbe;
private int PointX[];
private int PointY[];
private int PointCurseur = 0;
private int XMaxRPixel;
private int XMinPixel;
private int YMaxRPixel;
private int YMinPixel;


public AffichageCourbe(int X0 , int Y0 , int Width , int Heigh)
{
addMouseListener(this);
addMouseMotionListener(this);
//initialisation des variables de dimensions
XMinPixel = X0;
YMinPixel = Y0;
XMaxRPixel = Width;
YMaxRPixel = Heigh;

setBorder(new LineBorder(new Color(0, 0, 0)));
setBackground(new Color(200, 200, 200));
setBounds(XMinPixel,YMinPixel,XMaxRPixel+XMinPixel+20,YMaxRPixel+YMinPixel+20);
MaCourbe = new CourbeMath(NombrePoints,PointA,PointB);
MiseEnValeur();
}

@Override
public void paintComponent( Graphics MonGraph )
{
super.paintComponent(MonGraph);
Afficher(MonGraph);
}

private void Afficher(Graphics MonGraph)
{
//m�thodes qui affiche les donn�es sur le panneau
MonGraph.setColor(new Color(51, 0, 255));
MonGraph.drawPolyline(PointX,PointY,NombrePoints);
MonGraph.setColor(new Color(0,150,0));
MonGraph.drawLine(PointX[PointCurseur],YMinPixel-20,PointX[PointCurseur],YMaxRPixel+YMinPixel+20);
MonGraph.drawLine(XMinPixel-20,PointY[PointCurseur],XMaxRPixel+YMinPixel+20,PointY[PointCurseur]);
MonGraph.drawString("("+MaCourbe.MesPointsX[PointCurseur]+";"+ MaCourbe.MesPointsY[PointCurseur]+")",PointX[PointCurseur]+10,PointY[PointCurseur]-11);

}

public void MiseAJour()
{
PointCurseur = 0;
MaCourbe = new CourbeMath(NombrePoints,PointA,PointB);
MiseEnValeur();
repaint();
}

private void MiseEnValeur()
{
PointX = new int[NombrePoints];
PointY = new int[NombrePoints];
for( int i = 0 ; i < NombrePoints ; i++)
{
PointX[i] = (int)(XMinPixel + ((i*XMaxRPixel) / (NombrePoints-1)));
PointY[i] = (int)( ( MaCourbe.YMax() - MaCourbe.MesPointsY[i] ) * YMaxRPixel / ( MaCourbe.YMax() - MaCourbe.YMin() ) ) + YMinPixel;
}
}

public void mousePressed(MouseEvent e)
{
PointCurseur = RecherchePointCurseur(e.getX());
repaint();
}

public void mouseDragged(MouseEvent e)
{
PointCurseur = RecherchePointCurseur(e.getX());
repaint();
}

public void mouseClicked(MouseEvent e){}

public void mouseReleased(MouseEvent e){}

public void mouseEntered(MouseEvent e){}

public void mouseExited(MouseEvent e){}

public void mouseMoved(MouseEvent e){}



private int RecherchePointCurseur( int MonPointX )
{
for( int i = 0 ; i < NombrePoints ; i++) if( PointX[i] >= MonPointX ) return i;
return NombrePoints-1;
}
}