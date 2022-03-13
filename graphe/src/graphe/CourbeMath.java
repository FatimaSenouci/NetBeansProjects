/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphe;

public class CourbeMath
{
public double MesPointsY[];
public double MesPointsX[];
public int NombrePoints;
private double Pas;
private double PointA;
private double PointB;
private fonction MaFonction;


public CourbeMath(int Nb , double A , double B)
{
NombrePoints = Nb;
MaFonction = new fonction();
PointA = A;
PointB = B;
Discretisation();
CalculPoints();
}

private void Discretisation()
{
Pas = (PointB - PointA ) / NombrePoints;
}

private void CalculPoints()
{
MesPointsY = new double[NombrePoints];
MesPointsX = new double[NombrePoints];

for(int i = 0 ; i < NombrePoints ; i++)
{
MesPointsX[i] = PointA+(i*Pas);
MesPointsY[i] = MaFonction.ValeurY(PointA+(i*Pas));
}
}

public double YMax()
{
double MonMax = MesPointsY[0];
for(int i = 1 ; i < NombrePoints ; i++) if( MesPointsY[i] > MonMax ) MonMax = MesPointsY[i];
return MonMax;
}

public double YMin()
{
double MonMin = MesPointsY[0];
for(int i = 1 ; i < NombrePoints ; i++) if( MesPointsY[i] < MonMin ) MonMin = MesPointsY[i];
return MonMin;
}

}
