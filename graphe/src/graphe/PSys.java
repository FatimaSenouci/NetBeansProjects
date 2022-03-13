/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphe;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.JDialog;

public class PSys extends JDialog
{

private JTextField TextNombrePoints;
public int NombrePoints;


public PSys(JFrame parent,boolean modal,int NbPoints)
{
super(parent, modal);
NombrePoints = NbPoints;
Container contentPane = this.getContentPane();
JPanel panel1 = new JPanel();
panel1.setLayout(new FlowLayout(FlowLayout.CENTER));
contentPane.add(panel1, BorderLayout.SOUTH);
JPanel panel3 = new JPanel();
panel3.setLayout(new FlowLayout(FlowLayout.CENTER));
contentPane.add(panel3, BorderLayout.CENTER);
TextNombrePoints = new JTextField(""+NombrePoints,8);
panel3.add(TextNombrePoints);
JButton okButton = new JButton("OK");
panel1.add(okButton);
JButton cancelButton = new JButton("Cancel");
panel1.add(cancelButton);

setTitle("Gestion des param�tres syst�mes");
pack();


cancelButton.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent event)
{
dispose();
setVisible(false);
}
});

okButton.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent event)
{
NombrePoints = Integer.parseInt(TextNombrePoints.getText());
if( NombrePoints > 1000 || NombrePoints < 5 )
{
TextNombrePoints.setText("500");
return;
}
dispose();
setVisible(false);
}
});

}




}
