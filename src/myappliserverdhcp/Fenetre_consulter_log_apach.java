/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myappliserverdhcp;

/**
 *
 * @author Madickeb Diop
 */


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Fenetre_consulter_log_apach extends JFrame implements ActionListener {
private JPanel pano1 = new JPanel();
private JLabel labconsulterapach;
private JLabel lablien;
private JTextArea consulterapach;
private JButton afficher;
private JTextField jtextfield;
String lien;
String ligne;
Liste l;
public Fenetre_consulter_log_apach() throws IOException{
        this.l = new Liste();
setSize(500,250);
setTitle("afficher log apach");
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLocationRelativeTo(null);
build();
setVisible(true);
}
public void build () throws IOException{
pano1.setLayout(new FlowLayout());
//getContentPane().add(pano,BorderLayout.EAST);
GridBagConstraints c = new GridBagConstraints();
lablien = new JLabel("donner le chemin");
c.gridx = 0;
c.gridy = 0;
pano1.add(lablien,c);
jtextfield = new JTextField();
c.gridx = 1;
c.gridy = 0;
pano1.add(jtextfield,c);
jtextfield.setColumns(30);
labconsulterapach = new JLabel("voici log apach");
c.gridx = 0;
c.gridy = 1;
pano1.add(labconsulterapach,c);
consulterapach = new JTextArea(5,40);
c.gridx = 0;
c.gridy = 2;
pano1.add(consulterapach,c);
afficher = new JButton("afficher");
c.gridx = 0;
c.gridy = 3;
pano1.add(afficher,c);
afficher.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent e){
lien = jtextfield.getText();
BufferedReader entree = null;
    try {
        entree = new BufferedReader (new FileReader(lien));
    } catch (FileNotFoundException ex) {
        Logger.getLogger(Fenetre_consulter_log_apach.class.getName()).log(Level.SEVERE, null, ex);
    }
do {
    try {
        ligne = entree.readLine();
    } catch (IOException ex) {
        Logger.getLogger(Fenetre_consulter_log_apach.class.getName()).log(Level.SEVERE, null, ex);
    }
if (ligne != null)
System.out.println(ligne);
}
while(ligne != null);
    try {
        entree.close();
    } catch (IOException ex) {
        Logger.getLogger(Fenetre_consulter_log_apach.class.getName()).log(Level.SEVERE, null, ex);
    }
System.out.println("*** fin du fichier ***");
}
});
add(pano1);
}
public static void main(String[] args) throws IOException {
new Fenetre_consulter_log_apach();
}

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

