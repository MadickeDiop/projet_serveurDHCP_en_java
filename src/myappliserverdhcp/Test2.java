/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myappliserverdhcp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Madickeb Diop
 */
public class Test2 {
    
    ArrayList<Adresse> l=new ArrayList<Adresse>();
    public ArrayList<Adresse> liste(){
        FileReader fr=null;
        try {
            fr = new FileReader("C:\\Users\\Madickeb Diop\\Desktop\\tableARP.txt");
            BufferedReader br=new BufferedReader(fr);
            String c="";
            while(c!=null){
                c=br.readLine();
                System.out.println(c);
                String[] s=c.split(" ");
                l.add(new Adresse(s[0],s[1],s[2],false));
                
                
             
        } 
        }
        catch (Exception ex) {
        
        }
        return l;
        
    }
    
    
    public static void main(String[] a){
        
        ArrayList<Adresse> d=new Test2().liste();
        
        for(int i=0;i<d.size();i++){
            
           System.out.println(d.get(i).getAdd()+" "+d.get(i).getMask()+" "+d.get(i).getPass()+" "+d.get(i).isPrise());
            
        }
        
        
    }
    
}
