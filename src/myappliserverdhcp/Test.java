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

import java.io.FileInputStream; 
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner; 
import java.util.StringTokenizer; 
import java.util.Vector; 
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame; 
import javax.swing.JScrollPane; 
import javax.swing.JTable; 
import javax.swing.table.DefaultTableModel; 



// Cette classe permet de recuperer les lignes d'un fichier texte et les mettre dans une JTable. 

public class Test extends JFrame{ 
    private static final long    serialVersionUID    = 1802199483736051124L; 
    public ArrayList<Adresse> l; 

    public Test(){ 
        
        DefaultTableModel model = new DefaultTableModel(); 
        
        //for(int i = 1; i < 7; i++)//on place les titres 
            model.addColumn("Adresse_IP " ); 
             model.addColumn("@MAC_Client" ); 
             model.addColumn("Bail" ); 
             model.addColumn("@IP_Passerelle" ); 
            model.addColumn("Column " ); 
          //   model.addColumn("Column " ); 
        
        try { 
            readFile(model);//lecture du fichier 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } 
        
        setContentPane(new JScrollPane(new JTable(model))); 
        setSize(800, 600); 
        setLocationRelativeTo(null); 
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
    } 
    
    public void readFile(DefaultTableModel model) throws Exception{ 
        Scanner sc = new Scanner(new FileInputStream("C:\\Users\\Madickeb Diop\\Desktop\\tableARP.txt"));//on ouvre le fichier pour le lire 
        while(sc.hasNext()){//tant qu'il y a des choses à lire 
            StringTokenizer token = new StringTokenizer(sc.nextLine(), "|#|");//on split une ligne en fonction de | et # pour ne garder que le texte
            System.out.println(token);
            Vector<String> rowData = new Vector<String>(); 
            while(token.hasMoreTokens())//lecture des token et on les mets dans le vecteur 
                rowData.add(token.nextToken()); 
            model.addRow(rowData);//on ajoute la ligne 
        } 
        sc.close();//fini :) 
    } 
    
    public void readLigne() throws FileNotFoundException{
        Scanner sc = new Scanner(new FileInputStream("C:\\Users\\Madickeb Diop\\Desktop\\tableARP.txt"));//on ouvre le fichier pour le lire 
        while(sc.hasNext()){//tant qu'il y a des choses à lire 
            StringTokenizer token= new StringTokenizer(sc.nextLine(), "|#|");//on split une ligne en fonction de | et # pour ne garder que le texte
            System.out.println(token);
            
        } 
        sc.close();//fini :) 
         
        
    }
    
    public static void main(String[] args) { 
        new Test().setVisible(true);
        try {
            new Test().readLigne();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    } 
} 

