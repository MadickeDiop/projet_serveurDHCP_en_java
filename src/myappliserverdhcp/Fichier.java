/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myappliserverdhcp;




import java.io.*;
import java.util.*;
 
 
public class Fichier {
 
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
		String fichier ="C:\\Users\\Madickeb Diop\\Desktop\\fichier.txt";
 
         String str,ligne="",S;
         int ctr = 0;
 
         try
         {     
            BufferedReader br = new BufferedReader(new FileReader(fichier));
 
            //lecture du fichier texte 
            try
            {     
                
                System.out.println("Entrer le nom de l'@ip");
                Scanner sc =new Scanner(System.in);
                      S=sc.nextLine();
 
               while ((ligne = br.readLine()) != null)
               {
               //if (str.equals(S)){
                   
                  if (ligne.startsWith(S))
                  {   
                     //System.out.println(ligne);
                     // on a la ligne >> 1e@ip : 192.168.1.2
                      
                      
                     int index = ligne.indexOf(":");
                     String adressip = ligne.substring(index +2);
                     System.out.println(adressip);
                     ctr++;
                  } 
                  
                  
                  
               }
 
               if(ctr == 0)
               {
                  System.out.println("erreur: pas de ligne adresse ip :");
               }
            } 
            finally
            {
            // dans tous les cas, on ferme nos flux
               br.close();
            }
         }
            catch (IOException e)
            {
               System.out.println(e.toString());
            }
                
                
                
                


        }
}