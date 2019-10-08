/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myappliserverdhcp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

/**
 *
 * @author Madickeb Diop
 */
public class EffacerUneLigne {
    
    public static void main(String args[]) throws FileNotFoundException, IOException { 
        Vector monVector = new Vector(); 
        File f = new File("C:\\Users\\Madickeb Diop\\Desktop\\monfichier.txt"); 
        BufferedReader B = new BufferedReader(new FileReader(f)); 
        String ligne = B.readLine(); 
        while (ligne != null){ 
            monVector.addElement(ligne); 
            ligne = B.readLine(); 
        } 
        int numeroLigne = 0;
        monVector.removeElementAt(numeroLigne); 
        PrintWriter P = new PrintWriter (new FileWriter(f)); 
        for (int i = 0; i < monVector.size(); i++){ 
            P.println(monVector.get(i)); 
        } 
        System.out.println(" la ligne "+numeroLigne+"a été supprimé");
        P.close(); 
    } 
    
    
    
}
